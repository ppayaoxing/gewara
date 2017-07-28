/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.Config;
import com.gewara.bean.BlackIp;
import com.gewara.bean.BlackMatcher;
import com.gewara.untrans.AttackTestService;
import com.gewara.untrans.monitor.ConfigCenter;
import com.gewara.untrans.monitor.ConfigTrigger;
import com.gewara.util.DateUtil;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.GewaLogger;
import com.gewara.util.HttpResult;
import com.gewara.util.HttpUtils;
import com.gewara.util.JsonUtils;
import com.gewara.util.MonitorUtil;
import com.gewara.util.TimerHelper;
import com.gewara.util.WebLogger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class AttackTestServiceImpl implements AttackTestService, InitializingBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private Set<String> whiteList = new CopyOnWriteArraySet();
	private Map<String, BlackMatcher> blackMap = new ConcurrentHashMap(1000, 0.75F, 32);
	private Map<String, BlackMatcher> blackMap2 = new ConcurrentHashMap(1000, 0.75F, 32);
	private Map<String, String> urlConfigMap = new ConcurrentHashMap();
	private boolean disabled = false;
	private int recieveTimes = 0;
	private Timestamp blackChangeTime = new Timestamp(System.currentTimeMillis());
	private boolean loadDataFromMonitor = true;
	@Autowired(required = false)
	private ConfigCenter configCenter;
	private String monitorPath = MonitorUtil.getMonitorPath();

	public void setMonitorPath(String monitorPath) {
		this.monitorPath = monitorPath;
	}

	public void resetBlack() {
		TimerHelper.TIMER.schedule(new AttackTestServiceImpl.ResetBlackTimerTask(), 60000L);
	}

	public void resetUrlConfig() {
		TimerHelper.TIMER.schedule(new AttackTestServiceImpl.UrlConfigTask(), 120000L);
	}

	public String getRegScript(String urlKey) {
		return (String) this.urlConfigMap.get(urlKey);
	}

	public void resetWhite() {
		TimerHelper.TIMER.schedule(new AttackTestServiceImpl.ResetWhiteTimerTask(), 60000L);
	}

	public boolean checkBlackReq(String ip, String uri) {
		return !GewaIpConfig.isGewaInnerIp(ip) && !GewaIpConfig.isOfficeIp(ip) && !this.disabled
				&& !this.whiteList.contains(ip) ? this.isBlack(ip, uri) : false;
	}

	private int addBlack(String ip, String uri, int disableMin) {
		if (StringUtils.countMatches(ip, ".") == 3) {
			this.addBlackMin(this.blackMap, ip, uri, disableMin);
		} else {
			this.addBlackMin(this.blackMap2, ip, uri, disableMin);
		}

		return this.blackMap2.size() + this.blackMap.size();
	}

	private void addBlackMin(Map<String, BlackMatcher> map, String ip, String uri, int disableMin) {
		long time = System.currentTimeMillis() + (long) disableMin * 60000L;
		BlackMatcher matcher = (BlackMatcher) map.get(ip);
		if (matcher != null) {
			Long ipReleaseTime = matcher.get();
			if (ipReleaseTime != null) {
				time = ipReleaseTime.longValue() + (long) disableMin * 60000L;
			}
		} else {
			matcher = new BlackMatcher(ip);
			map.put(ip, matcher);
		}

		matcher.put(uri, Long.valueOf(time));
	}

	private void addBlackByTime(String ip, String uri, Long releaseTime) {
		BlackMatcher matcher;
		if (StringUtils.countMatches(ip, ".") == 3) {
			matcher = (BlackMatcher) this.blackMap.get(ip);
			if (matcher == null) {
				matcher = new BlackMatcher(ip);
				this.blackMap.put(ip, matcher);
			}

			matcher.put(uri, releaseTime);
		} else {
			matcher = (BlackMatcher) this.blackMap2.get(ip);
			if (matcher == null) {
				matcher = new BlackMatcher(ip);
				this.blackMap2.put(ip, matcher);
			}

			matcher.put(uri, releaseTime);
		}

	}

	private void delBlack(String ip, String url) {
		BlackMatcher matcher;
		if (StringUtils.countMatches(ip, ".") == 3) {
			matcher = (BlackMatcher) this.blackMap.get(ip);
			if (matcher != null) {
				matcher.remove(url);
				if (matcher.isEmpty()) {
					this.blackMap.remove(ip);
				}
			}
		} else {
			matcher = (BlackMatcher) this.blackMap2.get(ip);
			if (matcher != null) {
				matcher.remove(url);
				if (matcher.isEmpty()) {
					this.blackMap2.remove(ip);
				}
			}
		}

	}

	private boolean isBlack(String ip, String uri) {
		BlackMatcher matcher = (BlackMatcher) this.blackMap.get(ip);
		if (matcher == null) {
			int cur = ip.indexOf(46);
			int idx2 = ip.indexOf(46, cur + 1);
			int time = ip.indexOf(46, idx2 + 1);
			matcher = (BlackMatcher) this.blackMap2.get(StringUtils.substring(ip, 0, time));
		}

		if (matcher == null) {
			return false;
		} else {
			long cur1 = System.currentTimeMillis();
			Long time1 = matcher.gainReleaseTime(uri);
			if (time1 == null || time1.longValue() < cur1) {
				time1 = matcher.gainReleaseTime("ALL");
			}

			return time1 != null && time1.longValue() > cur1;
		}
	}

	private List<BlackIp> getNewBlackList() {
		if (this.recieveTimes % 100 == 0) {
			this.dbLogger.warn("attackReceive");
		}

		++this.recieveTimes;
		HashMap reqParams = new HashMap();
		reqParams.put("systemId", Config.SYSTEMID);
		reqParams.put("updatetime", DateUtil.formatTimestamp(this.blackChangeTime));
		HttpResult black = HttpUtils.postUrlAsString(this.monitorPath + "/inner/ip/black/getNewBlackList.xhtml",
				reqParams);
		if (black.isSuccess()) {
			List blackList = JsonUtils.readJsonToObjectList(BlackIp.class, black.getResponse());
			return blackList;
		} else {
			return new ArrayList();
		}
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public void afterPropertiesSet() throws Exception {
		if (this.configCenter != null) {
			this.resetBlack();
			this.resetWhite();
			this.resetUrlConfig();
			this.configCenter.registerGlobal("attack.black.change", new AttackTestServiceImpl.BlackIpWatcher(null));
			this.configCenter.registerGlobal("attack.white.change", new AttackTestServiceImpl.WhiteIpWatcher(null));
			this.configCenter.registerGlobal("attack.uri.change." + Config.SYSTEMID.toLowerCase(),
					new AttackTestServiceImpl.URLConfigChangeWatcher(null));
			this.configCenter.register(Config.SYSTEMID, "realBlack", new ConfigTrigger() {
				public void refreshCurrent(String newConfig) {
					String[] pair = StringUtils.split(newConfig, ":");
					if (pair != null && pair.length >= 2) {
						String uri = null;
						if (pair.length == 3) {
							uri = pair[2];
						}

						AttackTestServiceImpl.this.addBlack(pair[0], uri, Integer.valueOf(pair[1]).intValue());
					}

				}
			});
		}

	}

	public void addRealBlack(String ip, String uri, int disableMin) {
		if (this.configCenter != null) {
			String data = ip + ":" + disableMin;
			if (StringUtils.isNotBlank(uri)) {
				data = data + ":" + uri;
			}

			this.configCenter.refresh(Config.SYSTEMID, "realBlack", data);
		}

	}

	public Map<String, BlackMatcher> getBlackMap() {
		return this.blackMap;
	}

	public boolean isDisabled() {
		return this.disabled;
	}

	public List<String> getWhiteList() {
		return new ArrayList(this.whiteList);
	}

	public Map<String, BlackMatcher> getBlackMap2() {
		return this.blackMap2;
	}

	public void refreshBlack() {
		this.configCenter.refreshGlobal("attack.black.change");
	}

	public void refreshWhite(String ips, String action) {
		String value = action + ":" + ips;
		this.configCenter.refreshGlobal("attack.white.change", value);
	}

	public void setLoadDataFromMonitor(boolean loadDataFromMonitor) {
		this.loadDataFromMonitor = loadDataFromMonitor;
	}

	private class URLConfigChangeWatcher implements ConfigTrigger {
		private URLConfigChangeWatcher() {
		}

		public void refreshCurrent(String newConfig) {
			if (!StringUtils.isBlank(newConfig)) {
				HashMap reqParams = new HashMap();
				reqParams.put("systemId", Config.SYSTEMID);
				HttpResult result = HttpUtils.postUrlAsString(
						AttackTestServiceImpl.this.monitorPath + "/inner/url/config/get.xhtml", reqParams);
				if (!result.isSuccess()) {
					AttackTestServiceImpl.this.dbLogger
							.error("the request occured error when get url config, msg : " + result.getMsg());
				} else {
					String responseText = result.getResponse();
					if (StringUtils.equals(responseText, "error")) {
						AttackTestServiceImpl.this.dbLogger.error("the response of get rl config is error");
					} else {
						if (!StringUtils.isBlank(responseText)) {
							List configList = JsonUtils.readJsonToObjectList(AttackTestServiceImpl.UrlConfig.class,
									responseText);
							AttackTestServiceImpl.this.dbLogger
									.warn(Config.SYSTEMID + " change url config from monitor");
							Iterator arg5 = configList.iterator();

							while (arg5.hasNext()) {
								AttackTestServiceImpl.UrlConfig config = (AttackTestServiceImpl.UrlConfig) arg5.next();
								AttackTestServiceImpl.this.urlConfigMap.put(config.getUrl(), config.getRegScript());
							}
						}

					}
				}
			}
		}
	}

	private class WhiteIpWatcher implements ConfigTrigger {
		private WhiteIpWatcher() {
		}

		public void refreshCurrent(String newConfig) {
			List ipList;
			if (StringUtils.startsWith(newConfig, "add:")) {
				ipList = Arrays.asList(StringUtils.split(newConfig.substring(4), ","));
				AttackTestServiceImpl.this.whiteList.addAll(ipList);
			} else if (StringUtils.startsWith(newConfig, "delete:")) {
				ipList = Arrays.asList(StringUtils.split(newConfig.substring(7), ","));
				AttackTestServiceImpl.this.whiteList.removeAll(ipList);
			}

		}
	}

	private class BlackIpWatcher implements ConfigTrigger {
		private BlackIpWatcher() {
		}

		public void refreshCurrent(String newConfig) {
			List blackList = AttackTestServiceImpl.this.getNewBlackList();
			if (!blackList.isEmpty()) {
				Iterator arg2 = blackList.iterator();

				while (true) {
					while (arg2.hasNext()) {
						BlackIp black = (BlackIp) arg2.next();
						if (black.getStatus().equals("activated")) {
							AttackTestServiceImpl.this.addBlackByTime(black.getIp(), black.getAccessUrl(),
									Long.valueOf(black.getReleaseTime().getTime()));
						} else if (black.getStatus().equals("deactivated") || black.getStatus().equals("deleted")) {
							AttackTestServiceImpl.this.delBlack(black.getIp(), black.getAccessUrl());
						}
					}

					AttackTestServiceImpl.this.blackChangeTime = new Timestamp(System.currentTimeMillis());
					break;
				}
			}

		}
	}

	class ResetWhiteTimerTask implements Runnable {
		public void run() {
			boolean reset = false;

			try {
				HttpResult e = HttpUtils
						.getUrlAsString(AttackTestServiceImpl.this.monitorPath + "/inner/ip/white/getAll.xhtml");
				if (e.isSuccess()) {
					String responseText = e.getResponse();
					if (!StringUtils.equals(responseText, "error")) {
						if (StringUtils.isNotBlank(responseText)) {
							List wIPList = JsonUtils.readJsonToObjectList(String.class, responseText);
							if (wIPList != null && !wIPList.isEmpty()) {
								AttackTestServiceImpl.this.whiteList.addAll(wIPList);
								reset = true;
							}
						}
					} else {
						AttackTestServiceImpl.this.dbLogger.error("the response of get all white ip is error");
					}
				} else {
					AttackTestServiceImpl.this.dbLogger
							.error("the request occured error when get all white ip, msg : " + e.getMsg());
				}
			} catch (Exception arg7) {
				AttackTestServiceImpl.this.dbLogger.error("", arg7);
			} finally {
				if (!reset && !GewaIpConfig.isLocalIp(Config.getServerIp())
						&& AttackTestServiceImpl.this.loadDataFromMonitor) {
					TimerHelper.TIMER.schedule(AttackTestServiceImpl.this.new ResetWhiteTimerTask(), 30000L);
				}

			}

		}
	}

	class ResetBlackTimerTask implements Runnable {
		public void run() {
			boolean reset = false;

			try {
				HashMap params = new HashMap();
				params.put("systemId", Config.SYSTEMID);
				HttpResult result = HttpUtils
						.getUrlAsString(AttackTestServiceImpl.this.monitorPath + "/inner/ip/blackList.xhtml", params);
				if (!result.isSuccess()) {
					AttackTestServiceImpl.this.dbLogger
							.error("the request occured error when get all black ip, msg : " + result.getMsg());
					return;
				}

				String responseText = result.getResponse();
				if (StringUtils.equals(responseText, "error")) {
					AttackTestServiceImpl.this.dbLogger.error("the response of get all black ip is error");
					return;
				}

				if (StringUtils.isBlank(responseText)) {
					AttackTestServiceImpl.this.blackMap.clear();
					AttackTestServiceImpl.this.blackMap2.clear();
				} else {
					List blackList = JsonUtils.readJsonToObjectList(BlackIp.class, responseText);
					if (blackList != null) {
						Iterator arg5 = blackList.iterator();

						while (arg5.hasNext()) {
							BlackIp black = (BlackIp) arg5.next();
							AttackTestServiceImpl.this.addBlackByTime(black.getIp(), black.getAccessUrl(),
									Long.valueOf(black.getReleaseTime().getTime()));
						}
					}
				}

				reset = true;
			} finally {
				if (!reset && !GewaIpConfig.isLocalIp(Config.getServerIp())
						&& AttackTestServiceImpl.this.loadDataFromMonitor) {
					TimerHelper.TIMER.schedule(AttackTestServiceImpl.this.new ResetBlackTimerTask(), 30000L);
				}

			}

		}
	}

	static class UrlConfig {
		private String url;
		private String regScript;

		public String getUrl() {
			return this.url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getRegScript() {
			return this.regScript;
		}

		public void setRegScript(String regScript) {
			this.regScript = regScript;
		}
	}

	class UrlConfigTask implements Runnable {
		public void run() {
			if (!GewaIpConfig.isLocalIp(Config.getServerIp())) {
				HashMap reqParams = new HashMap();
				reqParams.put("systemId", Config.SYSTEMID);
				HttpResult result = HttpUtils.postUrlAsString(
						AttackTestServiceImpl.this.monitorPath + "/inner/url/config/get.xhtml", reqParams);
				if (!result.isSuccess() && AttackTestServiceImpl.this.loadDataFromMonitor) {
					AttackTestServiceImpl.this.dbLogger
							.error("the request occured error when get url config, msg : " + result.getMsg());
					TimerHelper.TIMER.schedule(AttackTestServiceImpl.this.new UrlConfigTask(), 60000L);
					return;
				}

				String responseText = result.getResponse();
				if (StringUtils.equals(responseText, "error")) {
					AttackTestServiceImpl.this.dbLogger.error("the response of get url config is error");
					return;
				}

				if (!StringUtils.isBlank(responseText)) {
					List configList = JsonUtils.readJsonToObjectList(AttackTestServiceImpl.UrlConfig.class,
							responseText);
					Iterator arg4 = configList.iterator();

					while (arg4.hasNext()) {
						AttackTestServiceImpl.UrlConfig config = (AttackTestServiceImpl.UrlConfig) arg4.next();
						AttackTestServiceImpl.this.dbLogger.warn(Config.SYSTEMID + " init url config from monitor");
						AttackTestServiceImpl.this.urlConfigMap.put(config.getUrl(), config.getRegScript());
					}
				}
			}

		}
	}
}
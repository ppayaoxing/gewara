package com.gewara.untrans.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.WebUtils;

import com.gewara.Config;
import com.gewara.bean.BlackIp;
import com.gewara.bean.BlackMatcher;
import com.gewara.constant.AttackConstant;
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

/**
 * @author <a href="mailto:acerge@163.com">gebiao(acerge)</a>
 * @since 2007-9-28下午02:05:17
 */
public class AttackTestServiceImpl implements AttackTestService, InitializingBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	private Set<String> whiteList = new CopyOnWriteArraySet();	//白名单
	private Map<String, BlackMatcher> blackMap = new ConcurrentHashMap<String, BlackMatcher>(1000, 0.75f, 32);	//黑名单
	private Map<String, BlackMatcher> blackMap2 = new ConcurrentHashMap<String, BlackMatcher>(1000, 0.75f, 32);	//黑名单2,网段
	private Map<String/*url*/, String /*regScript*/> urlConfigMap = new ConcurrentHashMap<String, String>();
	private boolean disabled = false;
	private int recieveTimes = 0;	//黑名单变化次数
	private Timestamp blackChangeTime = new Timestamp(System.currentTimeMillis());
	private boolean loadDataFromMonitor = true;
	@Autowired(required=false)
	private ConfigCenter configCenter;

	private String monitorPath = MonitorUtil.getMonitorPath();
	public void setMonitorPath(String monitorPath) {
		this.monitorPath = monitorPath;
	}
	@Override
	public void resetBlack() {
		TimerHelper.TIMER.schedule(new ResetBlackTimerTask(), 60000);
	}
	
	public void resetUrlConfig(){
		TimerHelper.TIMER.schedule(new UrlConfigTask(), 120000);
	}
	
	class UrlConfigTask implements Runnable{
		@Override
		public void run() {
			if(!GewaIpConfig.isLocalIp(Config.getServerIp())){
				Map<String, String> reqParams = new HashMap<String, String>();
				reqParams.put("systemId", Config.SYSTEMID);
				HttpResult result = HttpUtils.postUrlAsString(monitorPath + AttackConstant.URI_GET_URL_CONFIG, reqParams);
				if(!result.isSuccess() && loadDataFromMonitor){
					dbLogger.error("the request occured error when get url config, msg : " + result.getMsg());
					TimerHelper.TIMER.schedule(new UrlConfigTask(), 60000);
					return;
				}
				String responseText = result.getResponse();
				if(StringUtils.equals(responseText, "error")){
					dbLogger.error("the response of get url config is error");
					return;
				}
				if(!StringUtils.isBlank(responseText)){
					List<UrlConfig> configList = JsonUtils.readJsonToObjectList(UrlConfig.class, responseText);
					for(UrlConfig config : configList){
						dbLogger.warn(Config.SYSTEMID + " init url config from monitor");
						urlConfigMap.put(config.getUrl(), config.getRegScript());
					}
				}
			}		
		}
	}
	
	static class UrlConfig{
		private String url;
		private String regScript;
		
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getRegScript() {
			return regScript;
		}
		public void setRegScript(String regScript) {
			this.regScript = regScript;
		}
		
	}
	@Override
	public String getRegScript(String urlKey){
		return this.urlConfigMap.get(urlKey);
	}
	
	class ResetBlackTimerTask implements Runnable{
		@Override
		public void run() {
			boolean reset = false;
			try{
				Map<String, String> params = new HashMap<String, String>();
				params.put("systemId", Config.SYSTEMID);
				HttpResult result = HttpUtils.getUrlAsString(monitorPath  + AttackConstant.URI_GET_BLACKLIST, params);
				if(!result.isSuccess()){
					dbLogger.error("the request occured error when get all black ip, msg : " + result.getMsg());
					return;
				}
				String responseText = result.getResponse();
				if(StringUtils.equals(responseText, "error")){
					dbLogger.error("the response of get all black ip is error");
					return;
				}
				if(StringUtils.isBlank(responseText)){
					blackMap.clear();
					blackMap2.clear();
				}else{
					List<BlackIp> blackList = JsonUtils.readJsonToObjectList(BlackIp.class, responseText);
					if(blackList!=null){
						for (BlackIp black: blackList) {
							addBlackByTime(black.getIp(), black.getAccessUrl(), black.getReleaseTime().getTime());
						}
					}
				}
				reset = true;
			}finally{
				if(!reset && !GewaIpConfig.isLocalIp(Config.getServerIp()) && loadDataFromMonitor){
					TimerHelper.TIMER.schedule(new ResetBlackTimerTask(), 30000);
				}
			}
		}		
	}
	
	@Override
	public void resetWhite() {
		TimerHelper.TIMER.schedule(new ResetWhiteTimerTask(), 60000);
	}
	
	class ResetWhiteTimerTask implements Runnable{
		@Override
		public void run() {
			boolean reset = false;
			try{
				HttpResult result = HttpUtils.getUrlAsString(monitorPath + AttackConstant.URI_GET_ALLWHITE);
				if(result.isSuccess()){
					String responseText = result.getResponse();
					if(!StringUtils.equals(responseText, "error")){
						if(StringUtils.isNotBlank(responseText)){
							List<String> wIPList = JsonUtils.readJsonToObjectList(String.class, responseText);
							if(wIPList != null && !wIPList.isEmpty()){
								whiteList.addAll(wIPList);
								reset = true;
							}
						}
					}else{
						dbLogger.error("the response of get all white ip is error");
					}				
				}else{
					dbLogger.error("the request occured error when get all white ip, msg : " + result.getMsg());
				}
			} catch (Exception e) {
				dbLogger.error("", e);
			}finally{
				if(!reset && !GewaIpConfig.isLocalIp(Config.getServerIp()) && loadDataFromMonitor){//失败规划下次，但测试环境不用
					TimerHelper.TIMER.schedule(new ResetWhiteTimerTask(), 30000);
				}
			}
		}
	}
	
	@Override
	public boolean checkBlackReq(String ip, String uri){
		if(GewaIpConfig.isGewaInnerIp(ip) || GewaIpConfig.isOfficeIp(ip) || disabled || whiteList.contains(ip)){
			return false;
		}else{
			return isBlack(ip, uri);
		}
	}
	/**
	 * @param ip
	 * @param uri
	 * @param disableMin 禁用分钟
	 * @return
	 */
	private int addBlack(String ip, String uri, int disableMin){
		if(StringUtils.countMatches(ip, ".")==3){
			addBlackMin(blackMap, ip, uri, disableMin);
		}else{
			addBlackMin(blackMap2, ip, uri, disableMin);
		}
		return blackMap2.size() + blackMap.size();
	}
	private void addBlackMin(Map<String, BlackMatcher> map, String ip, String uri, int disableMin){
		long time = System.currentTimeMillis() + disableMin * DateUtil.m_minute;
		BlackMatcher matcher = map.get(ip);
		if(matcher != null){
			Long ipReleaseTime = matcher.get();
			if(ipReleaseTime != null){
				time = ipReleaseTime + disableMin * DateUtil.m_minute;
			}			
		}else{
			matcher = new BlackMatcher(ip);
			map.put(ip, matcher);
		}		
		matcher.put(uri, time);
	}
	
	private void addBlackByTime(String ip, String uri, Long releaseTime){
		if(StringUtils.countMatches(ip, ".")==3){
			BlackMatcher matcher = blackMap.get(ip);
			if(matcher == null){
				matcher = new BlackMatcher(ip);
				blackMap.put(ip, matcher);			
			}
			matcher.put(uri, releaseTime);
		}else{
			BlackMatcher matcher = blackMap2.get(ip);
			if(matcher == null){
				matcher = new BlackMatcher(ip);
				blackMap2.put(ip, matcher);			
			}	
			matcher.put(uri, releaseTime);
		}
	}
	
	private void delBlack(String ip, String url){
		if(StringUtils.countMatches(ip, ".")==3){
			BlackMatcher matcher = blackMap.get(ip);
			if(matcher != null){
				matcher.remove(url);
				if(matcher.isEmpty()){
					blackMap.remove(ip);
				}	
			}
		}else{
			BlackMatcher matcher = blackMap2.get(ip);
			if(matcher != null){
				matcher.remove(url);
				if(matcher.isEmpty()){
					blackMap2.remove(ip);
				}			
			}
		}
	}
	
	private boolean isBlack(String ip, String uri){
		BlackMatcher matcher = blackMap.get(ip);
		if(matcher ==null){//查看网段
			int idx1 = ip.indexOf('.');
			int idx2 = ip.indexOf('.', idx1+1);
			int idx3 = ip.indexOf('.', idx2+1);
			matcher = blackMap2.get(StringUtils.substring(ip, 0, idx3));
		}
		if(matcher==null) return false;
		long cur = System.currentTimeMillis();
		Long time = matcher.gainReleaseTime(uri);
		if(time==null || time < cur){
			time = matcher.gainReleaseTime(AttackConstant.ACCESS_URL_ALL);//整个IP拦截 
		}
		return time!=null && time > cur;
	}
		
	private class BlackIpWatcher implements ConfigTrigger{
		@Override
		public void refreshCurrent(String newConfig) {
			List<BlackIp> blackList = getNewBlackList();
			if(!blackList.isEmpty()){
				for(BlackIp black: blackList){
					if(black.getStatus().equals(AttackConstant.STATUS_ACTIVATED)){
						addBlackByTime(black.getIp(), black.getAccessUrl(), black.getReleaseTime().getTime());
					}else if(black.getStatus().equals(AttackConstant.STATUS_DEACTIVATED) || black.getStatus().equals(AttackConstant.STATUS_DELETED)){
						delBlack(black.getIp(), black.getAccessUrl());
					}
				}
				blackChangeTime = new Timestamp(System.currentTimeMillis());
			}
		}
	}
	private class WhiteIpWatcher implements ConfigTrigger{
		@Override
		public void refreshCurrent(String newConfig) {
			//白名单直接从config读取
			if(StringUtils.startsWith(newConfig, "add:")){
				List<String> ipList = Arrays.asList(StringUtils.split(newConfig.substring(4), ","));
				whiteList.addAll(ipList);
			}else if(StringUtils.startsWith(newConfig, "delete:")){
				List<String> ipList = Arrays.asList(StringUtils.split(newConfig.substring(7), ","));
				whiteList.removeAll(ipList);
			}
		}
	}
	
	/**
	 * 黑名单从API获取最新的
	 * @return
	 */
	private List<BlackIp> getNewBlackList() {
		if(recieveTimes%100==0){
			dbLogger.warn("attackReceive");
		}
		recieveTimes ++;
		Map<String, String> reqParams = new HashMap<String, String>();
		reqParams.put("systemId", Config.SYSTEMID);
		reqParams.put("updatetime", DateUtil.formatTimestamp(blackChangeTime));
		HttpResult black = HttpUtils.postUrlAsString(monitorPath + AttackConstant.URI_GET_CHANGED_BLACK, reqParams);
		if(black.isSuccess()){
			List<BlackIp> blackList = JsonUtils.readJsonToObjectList(BlackIp.class, black.getResponse());
			return blackList;
		}
		return new ArrayList<BlackIp>();
	}

	private class URLConfigChangeWatcher implements ConfigTrigger{
		@Override
		public void refreshCurrent(String newConfig) {
			if(StringUtils.isBlank(newConfig)){
				return;
			}
			Map<String, String> reqParams = new HashMap<String, String>();
			reqParams.put("systemId", Config.SYSTEMID);
			HttpResult result = HttpUtils.postUrlAsString(monitorPath + AttackConstant.URI_GET_URL_CONFIG, reqParams);
			if(!result.isSuccess()){
				dbLogger.error("the request occured error when get url config, msg : " + result.getMsg());
				return;
			}
			String responseText = result.getResponse();
			if(StringUtils.equals(responseText, "error")){
				dbLogger.error("the response of get rl config is error");
				return;
			}
			if(!StringUtils.isBlank(responseText)){
				List<UrlConfig> configList = JsonUtils.readJsonToObjectList(UrlConfig.class, responseText);
				dbLogger.warn(Config.SYSTEMID + " change url config from monitor");
				for(UrlConfig config : configList){
					urlConfigMap.put(config.getUrl(), config.getRegScript());
				}
			}
		}
	}
	
	
	@Override
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		if(configCenter!=null){
			resetBlack();
			resetWhite();
			resetUrlConfig();

			configCenter.registerGlobal(AttackConstant.CHANGE_BLACK, new BlackIpWatcher());
			configCenter.registerGlobal(AttackConstant.CHANGE_WHITE, new WhiteIpWatcher());
			configCenter.registerGlobal(AttackConstant.CHANGE_URI+Config.SYSTEMID.toLowerCase(), new URLConfigChangeWatcher());
			configCenter.register(Config.SYSTEMID, "realBlack", new ConfigTrigger(){
				@Override
				public void refreshCurrent(String newConfig) {
					String[] pair = StringUtils.split(newConfig, ":");
					if(pair!=null && pair.length>=2){
						String uri = null;
						if(pair.length == 3){
							uri = pair[2];
						}
						addBlack(pair[0], uri, Integer.valueOf(pair[1]));
					}
				}
			});
		}
	}
	
	@Override
	public void addRealBlack(String ip, String uri, int disableMin) {
		if(configCenter!=null){
			String data = ip + ":" + disableMin;
			if(StringUtils.isNotBlank(uri)){
				data += ":" + uri;
			}
			configCenter.refresh(Config.SYSTEMID, "realBlack", data);
		}
	}
	
	@Override
	public Map<String, BlackMatcher> getBlackMap() {
		return blackMap;
	}
	
	@Override
	public boolean isDisabled() {
		return disabled;
	}
	
	@Override
	public List<String> getWhiteList() {
		return new ArrayList<String>(whiteList);
	}
	@Override
	public Map<String, BlackMatcher> getBlackMap2() {
		return blackMap2;
	}

	@Override
	public void refreshBlack() {
		configCenter.refreshGlobal(AttackConstant.CHANGE_BLACK);
	}

	@Override
	public void refreshWhite(String ips, String action) {
		String value = action + ":" + ips;
		configCenter.refreshGlobal(AttackConstant.CHANGE_WHITE, value);
	}

	public void setLoadDataFromMonitor(boolean loadDataFromMonitor) {
		this.loadDataFromMonitor = loadDataFromMonitor;
	}

}

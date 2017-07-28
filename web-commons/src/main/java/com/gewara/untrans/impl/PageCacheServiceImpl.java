/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.Config;
import com.gewara.json.PageView;
import com.gewara.support.ErrorCode;
import com.gewara.untrans.LockCallback;
import com.gewara.untrans.LockService;
import com.gewara.untrans.PageCacheProcessor;
import com.gewara.untrans.PageCacheService;
import com.gewara.untrans.PageParams;
import com.gewara.untrans.monitor.MonitorService;
import com.gewara.untrans.monitor.MonitorService.EXCEPTION_TAG;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.DateUtil;
import com.gewara.util.Debugger;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.GewaLogger;
import com.gewara.util.HttpResult;
import com.gewara.util.HttpUtils;
import com.gewara.util.JsonUtils;
import com.gewara.util.WebLogger;
import com.gewara.web.support.ResourceStatsUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.spy.memcached.MemcachedClient;
import org.apache.commons.lang.StringUtils;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PageCacheServiceImpl implements PageCacheService, InitializingBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private String KEY_HIT = "hitCount";
	private String KEY_MIS = "misCount";
	private String KEY_PUT = "putCount";
	private String KEY_ERR = "errCount";
	private String KEY_REPEAT = "repeatCount";
	private String KEY_IGNORE = "ignoreCount";
	private int threadPoolSize = 10;
	private boolean enableCache = true;
	private ThreadPoolExecutor executor;
	private Map<String, Long> successMap = new ConcurrentHashMap(2000, 24.0F);
	@Autowired
	@Qualifier("lockService")
	private LockService lockService;
	@Autowired
	@Qualifier("config")
	protected Config config;
	@Autowired
	private PageCacheProcessor processor;
	private MemcachedClient memcachedClient;
	private Map<String, Long> recentPageUrl = new ConcurrentHashMap(20000, 0.75F, 200);
	private String keyPre;
	private Map<String, Integer> cacheMinMap = new ConcurrentHashMap();
	private Integer defaultMin = Integer.valueOf(10);
	private MonitorService monitorService;

	public void setEnableCache(boolean enableCache) {
		this.enableCache = enableCache;
	}

	public int getThreadPoolSize() {
		return this.threadPoolSize;
	}

	public void setThreadPoolSize(int threadPoolSize) {
		this.threadPoolSize = threadPoolSize;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public void setMemcachedClient(MemcachedClient memcachedClient) {
		this.memcachedClient = memcachedClient;
	}

	public void setMonitorService(MonitorService monitorService) {
		this.monitorService = monitorService;
	}

	public Integer getCacheMin(String pageUrl) {
		Integer min = (Integer) this.cacheMinMap.get(pageUrl);
		if (min == null) {
			min = this.defaultMin;
			this.cacheMinMap.put(pageUrl, this.defaultMin);
		}

		return min;
	}

	public Map<String, Integer> getCacheMinMap() {
		return this.cacheMinMap;
	}

	public void refreashCacheMin(String pageUrl, Integer minute) {
		Integer min = (Integer) this.cacheMinMap.get(pageUrl);
		if (min != null) {
			this.cacheMinMap.put(pageUrl, minute);
		}

	}

	public PageView getPageView(HttpServletRequest request, String pageUrl, PageParams pageParams, String citycode) {
		Integer cacheMin = this.getCacheMin(pageUrl);
		if (cacheMin.intValue() <= 0) {
			return null;
		} else if (request != null && StringUtils.isNotBlank(request.getParameter("CLEARPAGE"))
				&& this.processor.canClear(request)) {
			this.clearPageView(pageUrl, pageParams, citycode);
			return null;
		} else {
			Long cached = (Long) this.memcachedClient.get(this.getExistsKey(pageUrl, pageParams, citycode));
			Long cur = Long.valueOf(System.currentTimeMillis());
			boolean update = false;
			PageView pv = null;
			String userAgent;
			if (cached != null) {
				if (cached.longValue() < cur.longValue() - 60000L) {
					update = true;
				}

				userAgent = (String) this.memcachedClient.get(this.getContentKey(pageUrl, pageParams, citycode));
				if (userAgent != null) {
					pv = new PageView(cached, userAgent);
				}
			} else {
				update = true;
			}

			if (update && request != null) {
				userAgent = request.getHeader("User-Agent");
				if (!StringUtils.containsIgnoreCase(userAgent, "bot")
						&& !StringUtils.containsIgnoreCase(userAgent, "spid")) {
					String ip = BaseWebUtils.getRemoteIp(request);
					this.sendMsg(pageUrl, pageParams, citycode, cur, cacheMin.intValue(), ip);
				}
			}

			if (pv != null) {
				this.updateCount(this.KEY_HIT);
			} else {
				this.updateCount(this.KEY_MIS);
			}

			return pv;
		}
	}

	private void sendMsg(String pageUrl, PageParams pageParams, String citycode, Long cur, int cacheMin, String ip) {
		String key = this.getExistsKey(pageUrl, pageParams, citycode);
		Map tmpMap = this.recentPageUrl;
		Long last = (Long) tmpMap.get(key);
		if (last == null || last.longValue() + 30000L <= cur.longValue()) {
			if (tmpMap.size() > 20000) {
				this.recentPageUrl = new ConcurrentHashMap(20000, 0.75F, 200);
				this.dbLogger.warn("clearRecentPageUrl:" + this.recentPageUrl.size());
			}

			tmpMap.put(key, cur);
			HashMap params = new HashMap();
			params.put("pageUrl", pageUrl);
			params.put("citycode", citycode);
			params.put("cacheMin", "" + cacheMin);
			params.put("ip", ip);
			params.put("reqParams", JsonUtils.writeMapToJson(pageParams.getParams()));
			if (!pageParams.getReqCookies().isEmpty()) {
				params.put("reqCookie", JsonUtils.writeObjectToJson(pageParams.getReqCookies()));
			}

			this.processor.sendMsgToDst(params);
		}
	}

	public PageView getPageView(String pageUrl, PageParams pageParams, String citycode, String ip) {
		boolean update = false;
		Long cached = (Long) this.memcachedClient.get(this.getExistsKey(pageUrl, pageParams, citycode));
		Long cur = Long.valueOf(System.currentTimeMillis());
		PageView pv = null;
		if (cached != null) {
			if (cached.longValue() < cur.longValue() - 60000L) {
				update = true;
			}

			String cacheMin = (String) this.memcachedClient.get(this.getContentKey(pageUrl, pageParams, citycode));
			if (cacheMin != null) {
				pv = new PageView(cached, cacheMin);
			}
		} else {
			update = true;
		}

		if (update) {
			Integer cacheMin1 = this.getCacheMin(pageUrl);
			this.sendMsg(pageUrl, pageParams, citycode, cur, cacheMin1.intValue(), ip);
		}

		if (pv != null) {
			this.updateCount(this.KEY_HIT);
		} else {
			this.updateCount(this.KEY_MIS);
		}

		return pv;
	}

	public boolean refreshPageView(String pageUrl, PageParams pageParams, String citycode) {
		Integer cacheMin = this.getCacheMin(pageUrl);
		HashMap params = new HashMap();
		params.putAll(pageParams.getParams());
		params.put("notUseCache", "true");
		ArrayList coolieList = new ArrayList();
		if (StringUtils.isNotBlank(citycode) || !pageParams.getReqCookies().isEmpty()) {
			BasicClientCookie path = null;
			if (StringUtils.isNotBlank(citycode)) {
				path = new BasicClientCookie("citycode", citycode);
				path.setVersion(0);
				path.setDomain(this.getDomain(pageUrl));
				path.setPath("/");
				path.setExpiryDate(DateUtil.addDay(new Date(), 1));
				coolieList.add(path);
			}

			if (!pageParams.getReqCookies().isEmpty()) {
				Map result = pageParams.getReqCookies();
				Iterator msg = result.keySet().iterator();

				while (msg.hasNext()) {
					String name = (String) msg.next();
					String[] pair = (String[]) result.get(name);
					path = new BasicClientCookie(name, pair[1]);
					path.setVersion(0);
					path.setDomain(this.getDomain(pageUrl));
					path.setPath(pair[0]);
					path.setExpiryDate(DateUtil.addDay(new Date(), 1));
					coolieList.add(path);
				}
			}
		}

		String path1 = this.getFullPath(pageUrl);
		HttpResult result1 = HttpUtils.getUrlAsString(path1, params, coolieList);
		if (result1.isSuccess()) {
			this.memcachedClient.set(this.getExistsKey(pageUrl, pageParams, citycode), 7200,
					Long.valueOf(System.currentTimeMillis() + 60000L * (long) cacheMin.intValue()));
			this.memcachedClient.set(this.getContentKey(pageUrl, pageParams, citycode), 7200, result1.getResponse());
			this.updateCount(this.KEY_PUT);
			return true;
		} else {
			this.updateCount(this.KEY_ERR);
			if (this.monitorService != null) {
				String msg1 = ", HttpResult:" + result1.getStatus();
				if (Debugger.isDebugEnabled("pageCache")) {
					this.dbLogger.warn(result1.getResponse());
				}

				this.monitorService.logException(EXCEPTION_TAG.SERVICE, "pageCacheService.refreshPageView",
						"获取页面缓存错误:" + path1 + msg1, (Throwable) null, params);
			} else {
				this.dbLogger.warn("获取页面缓存错误, url：[" + path1 + "],params:" + params.toString() + ",returnResult:"
						+ result1.getStatus() + ",response:" + result1.getResponse());
			}

			return false;
		}
	}

	protected String getDomain(String pageUrl) {
		return this.config.getString("domain");
	}

	protected String getFullPath(String pageUrl) {
		return this.config.getAbsPath() + this.config.getBasePath() + pageUrl;
	}

	public void updatePageView(String pageUrl, PageParams pageParams, String citycode, String content) {
		Integer cacheMin = this.getCacheMin(pageUrl);
		this.updateCount(this.KEY_PUT);
		this.memcachedClient.set(this.getExistsKey(pageUrl, pageParams, citycode), 7200,
				Long.valueOf(System.currentTimeMillis() + 60000L * (long) cacheMin.intValue()));
		this.memcachedClient.set(this.getContentKey(pageUrl, pageParams, citycode), 7200, content);
	}

	public void clearPageView(String pageUrl, PageParams pageParams, String citycode) {
		String key = this.getExistsKey(pageUrl, pageParams, citycode);
		this.successMap.remove(key);
		this.memcachedClient.delete(key);
		this.memcachedClient.delete(this.getContentKey(pageUrl, pageParams, citycode));
	}

	private String getExistsKey(String pageUrl, PageParams pageParams, String citycode) {
		int paramHash = pageParams.gainParamsHash();
		String key = pageUrl + paramHash;
		String result = this.keyPre + "K" + key + "CITYCODE" + citycode;
		result = StringUtils.deleteWhitespace(result);
		return result;
	}

	private String getContentKey(String pageUrl, PageParams pageParams, String citycode) {
		int paramHash = pageParams.gainParamsHash();
		String key = pageUrl + paramHash;
		String result = this.keyPre + "P" + key + "CITYCODE" + citycode;
		result = StringUtils.deleteWhitespace(result);
		return result;
	}

	public void afterPropertiesSet() throws Exception {
		ArrayBlockingQueue taskQueue = new ArrayBlockingQueue(30);
		this.executor = new ThreadPoolExecutor(this.threadPoolSize, this.threadPoolSize, 0L, TimeUnit.SECONDS,
				taskQueue);
		this.executor.allowCoreThreadTimeOut(false);
		this.executor.setRejectedExecutionHandler(new CallerRunsPolicy());
		Long cur = Long.valueOf(System.currentTimeMillis());
		ResourceStatsUtil.getPageCacheStats().register(this.KEY_HIT, cur.longValue());
		ResourceStatsUtil.getPageCacheStats().register(this.KEY_MIS, cur.longValue());
		ResourceStatsUtil.getPageCacheStats().register(this.KEY_ERR, cur.longValue());
		ResourceStatsUtil.getPageCacheStats().register(this.KEY_PUT, cur.longValue());
		ResourceStatsUtil.getPageCacheStats().register(this.KEY_REPEAT, cur.longValue());
		ResourceStatsUtil.getPageCacheStats().register(this.KEY_IGNORE, cur.longValue());
		this.refreshKeyVersion();
		if (StringUtils.equals("true", this.config.getString("disablePageCache"))) {
			this.enableCache = false;
		}

	}

	private void updateCount(String key) {
		ResourceStatsUtil.getPageCacheStats().incrementCount(key);
	}

	public String refreshKeyVersion() {
		this.keyPre = this.processor.getKeyPre();
		return this.keyPre;
	}

	public boolean isUseCache(HttpServletRequest request) {
		if (!this.enableCache) {
			return false;
		} else if (StringUtils.isBlank(request.getParameter("notUseCache"))) {
			return true;
		} else {
			String ip = BaseWebUtils.getRemoteIp(request);
			return !GewaIpConfig.isGewaInnerIp(ip) && !GewaIpConfig.isOfficeIp(ip);
		}
	}

	public boolean isUpdated(String pageUrl, String citycode, Long cur, PageParams pageParams) {
		Long cached = (Long) this.memcachedClient.get(this.getExistsKey(pageUrl, pageParams, citycode));
		return cached != null && cached.longValue() > cur.longValue() + 60000L;
	}

	public void processPageView(final String pageUrl, final Map<String, String> params,
			final Map<String, String[]> cookieMap, final String citycode) {
		this.executor.execute(new Runnable() {
			public void run() {
				final PageParams pparam = new PageParams();
				Iterator key = params.keySet().iterator();

				final String city;
				while (key.hasNext()) {
					city = (String) key.next();
					pparam.addSingleString(city, (String) params.get(city));
				}

				if (cookieMap != null) {
					key = cookieMap.keySet().iterator();

					while (key.hasNext()) {
						city = (String) key.next();
						pparam.addCookie(city, ((String[]) cookieMap.get(city))[0],
								((String[]) cookieMap.get(city))[1]);
					}
				}

				final String key1 = PageCacheServiceImpl.this.getExistsKey(pageUrl, pparam, citycode);
				city = citycode;
				final String page = pageUrl;
				Long last = (Long) PageCacheServiceImpl.this.successMap.get(key1);
				if (last != null && last.longValue() + 300000L > System.currentTimeMillis()) {
					PageCacheServiceImpl.this.updateCount(PageCacheServiceImpl.this.KEY_REPEAT);
				} else {
					String lockKey = "ppv" + Math.abs(key1.hashCode() % 1000);
					ErrorCode result = PageCacheServiceImpl.this.lockService.tryDoWithWriteLock(lockKey,
							new LockCallback() {
								public Boolean processWithInLock() {
									boolean refreshed = PageCacheServiceImpl.this.refreshPageView(page, pparam, city);
									if (!refreshed) {
										PageCacheServiceImpl.this.dbLogger.error("获取缓存失败！");
										return Boolean.valueOf(false);
									} else {
										if (PageCacheServiceImpl.this.successMap.size() > '썐') {
											PageCacheServiceImpl.this.successMap = new ConcurrentHashMap();
										}

										PageCacheServiceImpl.this.successMap.put(key1,
												Long.valueOf(System.currentTimeMillis()));
										return Boolean.valueOf(true);
									}
								}
							});
					if (!result.isSuccess()) {
						PageCacheServiceImpl.this.updateCount(PageCacheServiceImpl.this.KEY_IGNORE);
					}
				}

			}
		});
	}

	public void setPageCacheHeader(boolean outerAllow, HttpServletRequest request, HttpServletResponse response) {
		if (outerAllow && this.isUseCache(request)) {
			Integer cacheMin = this.getCacheMin(request.getRequestURI());
			Integer maxage = Integer.valueOf(60 * cacheMin.intValue());
			Long lastModifyTime = Long.valueOf(System.currentTimeMillis());
			Long expireTime = Long.valueOf(System.currentTimeMillis() + (long) (maxage.intValue() * 1000));
			response.addHeader("Cache-Control", "max-age=" + maxage);
			response.setDateHeader("Last-Modified", lastModifyTime.longValue());
			response.setDateHeader("Expires", expireTime.longValue());
		}

	}
}
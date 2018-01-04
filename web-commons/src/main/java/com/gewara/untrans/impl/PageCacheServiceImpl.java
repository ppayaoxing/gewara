package com.gewara.untrans.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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

import net.spy.memcached.MemcachedClient;
public class PageCacheServiceImpl implements PageCacheService, InitializingBean{
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	private String KEY_HIT = "hitCount";
	private String KEY_MIS = "misCount";
	private String KEY_PUT = "putCount";
	private String KEY_ERR = "errCount";
	private String KEY_REPEAT = "repeatCount";
	private String KEY_IGNORE = "ignoreCount";
	
	
	
	private int threadPoolSize = 10;
	private boolean enableCache = true;
	
	@Override
	public void setEnableCache(boolean enableCache) {
		this.enableCache = enableCache;
	}

	public int getThreadPoolSize() {
		return threadPoolSize;
	}


	public void setThreadPoolSize(int threadPoolSize) {
		this.threadPoolSize = threadPoolSize;
	}
	private ThreadPoolExecutor executor;
	private Map<String, Long> successMap = new ConcurrentHashMap<String, Long>(2000, 24);
	@Autowired@Qualifier("lockService")
	private LockService lockService;

	@Autowired@Qualifier("config")
	protected Config config;
	public void setConfig(Config config) {
		this.config = config;
	}
	
	@Autowired
	private PageCacheProcessor processor;
	
	private MemcachedClient memcachedClient;
	public void setMemcachedClient(MemcachedClient memcachedClient) {
		this.memcachedClient = memcachedClient;
	}
	private Map<String, Long> recentPageUrl = new ConcurrentHashMap<String, Long>(20000, 0.75f, 200);
	private String keyPre;
	private Map<String, Integer> cacheMinMap = new ConcurrentHashMap<String, Integer>();
	private Integer defaultMin = 10;
	
	private MonitorService monitorService;
	public void setMonitorService(MonitorService monitorService) {
		this.monitorService = monitorService;
	}


	@Override
	public Integer getCacheMin(String pageUrl){
		Integer min = cacheMinMap.get(pageUrl);
		if(min==null) {
			min = defaultMin;
			cacheMinMap.put(pageUrl, defaultMin);
		}
		return min;
	}
	
	
	@Override
	public Map<String, Integer> getCacheMinMap() {
		return cacheMinMap;
	}
	@Override
	public void refreashCacheMin(String pageUrl, Integer minute){
		Integer min = cacheMinMap.get(pageUrl);
		if(min != null) {
            cacheMinMap.put(pageUrl, minute);
        }
	}
	@Override
	public PageView getPageView(HttpServletRequest request, String pageUrl, PageParams pageParams, String citycode) {
		Integer cacheMin = getCacheMin(pageUrl);
		if(cacheMin <= 0) {
            return null;
        }
		
		if(request!=null && StringUtils.isNotBlank(request.getParameter("CLEARPAGE"))){
			if(processor.canClear(request)){
				clearPageView(pageUrl, pageParams, citycode);
				return null;
			}
		}
		Long cached = (Long) memcachedClient.get(getExistsKey(pageUrl, pageParams, citycode));
		Long cur = System.currentTimeMillis();
		boolean update = false;
		PageView pv = null;
		if(cached!=null){
			if(cached < cur - DateUtil.m_minute) {
                update = true; //1锟斤拷锟接硷拷锟斤拷锟斤拷锟节ｏ拷锟斤拷要锟斤拷锟斤拷
            }
			String content = (String)memcachedClient.get(getContentKey(pageUrl, pageParams, citycode));
			if(content!=null){
				pv = new PageView(cached, content);
			}
		}else{
			update = true;
		}
		if(update && request!=null){
			String userAgent = request.getHeader("User-Agent");
			if(!StringUtils.containsIgnoreCase(userAgent, "bot")&& 
					!StringUtils.containsIgnoreCase(userAgent, "spid")){//锟斤拷锟斤拷锟剿ｏ拷锟斤拷锟斤拷锟斤拷锟斤拷
				String ip = BaseWebUtils.getRemoteIp(request);
				sendMsg(pageUrl, pageParams, citycode, cur, cacheMin, ip);
			}
		}
		if(pv!=null){
			updateCount(KEY_HIT);
		}else{
			updateCount(KEY_MIS);
		}
		return pv;
	}
	private void sendMsg(String pageUrl, PageParams pageParams, String citycode, Long cur, int cacheMin, String ip){
		String key = getExistsKey(pageUrl, pageParams, citycode);
		Map<String, Long> tmpMap = recentPageUrl;
		Long last = tmpMap.get(key);
		if(last != null && last + DateUtil.m_minute/2 > cur) {
            return;//30锟斤拷锟节ｏ拷锟斤拷锟截革拷锟斤拷锟斤拷
        }
		if(tmpMap.size() > 20000) {
			recentPageUrl = new ConcurrentHashMap<String, Long>(20000, 0.75f, 200);
			dbLogger.warn("clearRecentPageUrl:" + recentPageUrl.size());
		}
		tmpMap.put(key, cur);
		Map<String, String> params = new HashMap<String, String>();
		params.put("pageUrl", pageUrl);
		params.put("citycode", citycode);
		params.put("cacheMin", ""+cacheMin);
		params.put("ip", ip);
		params.put("reqParams", JsonUtils.writeMapToJson(pageParams.getParams()));
		if(!pageParams.getReqCookies().isEmpty()){
			params.put("reqCookie", JsonUtils.writeObjectToJson(pageParams.getReqCookies()));
		}
		processor.sendMsgToDst(params);

	}
	@Override
	public PageView getPageView(String pageUrl, PageParams pageParams, String citycode, String ip) {
		boolean update = false;
		Long cached = (Long) memcachedClient.get(getExistsKey(pageUrl, pageParams, citycode));
		Long cur = System.currentTimeMillis();
		PageView pv = null;
		if(cached!=null){
			if(cached < cur - DateUtil.m_minute) {
                update = true; //1锟斤拷锟接硷拷锟斤拷锟斤拷锟节ｏ拷锟斤拷要锟斤拷锟斤拷
            }
			String content = (String)memcachedClient.get(getContentKey(pageUrl, pageParams, citycode));
			if(content!=null){
				pv = new PageView(cached, content);
			}
		}else{
			update = true;
		}
		if(update){
			Integer cacheMin = getCacheMin(pageUrl);
			sendMsg(pageUrl, pageParams, citycode, cur, cacheMin, ip);
		}
		if(pv!=null){
			updateCount(KEY_HIT);
		}else{
			updateCount(KEY_MIS);
		}
		return pv;
	}

	@Override
	public boolean refreshPageView(String pageUrl, PageParams pageParams, String citycode){
		Integer cacheMin = getCacheMin(pageUrl);
		Map<String, String> params = new HashMap<String, String>();
		params.putAll(pageParams.getParams());
		params.put(NOT_USE_CACHE_KEY, "true");
		List<BasicClientCookie> coolieList = new ArrayList<BasicClientCookie>();
		if(StringUtils.isNotBlank(citycode) || !pageParams.getReqCookies().isEmpty()){
			BasicClientCookie cookie = null;
			if(StringUtils.isNotBlank(citycode)){
				cookie = new BasicClientCookie("citycode", citycode);
				cookie.setVersion(0);
				cookie.setDomain(getDomain(pageUrl));
				cookie.setPath("/");
				cookie.setExpiryDate(DateUtil.addDay(new Date(), 1));
				coolieList.add(cookie);
			}
			if(!pageParams.getReqCookies().isEmpty()){
				Map<String, String[]> cookies = pageParams.getReqCookies();
				for(String name: cookies.keySet()){
					String[] pair = cookies.get(name);
					cookie = new BasicClientCookie(name, pair[1]);
					cookie.setVersion(0);
					cookie.setDomain(getDomain(pageUrl));
					cookie.setPath(pair[0]);
					cookie.setExpiryDate(DateUtil.addDay(new Date(), 1));
					coolieList.add(cookie);
				}
			}
		}
		String path = getFullPath(pageUrl);
		HttpResult result = HttpUtils.getUrlAsString(path, params, coolieList);
		if(result.isSuccess()){//锟斤拷效锟斤拷锟斤拷
			memcachedClient.set(getExistsKey(pageUrl, pageParams, citycode), 60 * 120, System.currentTimeMillis() + DateUtil.m_minute*cacheMin);
			memcachedClient.set(getContentKey(pageUrl, pageParams, citycode), 60 * 120, result.getResponse());
			updateCount(KEY_PUT);
			return true;
		}else{
			updateCount(KEY_ERR);
			if(monitorService!=null){
				String msg = ", HttpResult:" + result.getStatus();
				if(Debugger.isDebugEnabled("pageCache")){
					dbLogger.warn(result.getResponse());
				}
				monitorService.logException(EXCEPTION_TAG.SERVICE, "pageCacheService.refreshPageView", "锟斤拷取页锟芥缓锟斤拷锟斤拷锟�:" + path + msg, null, params);
			}else{
				dbLogger.warn("锟斤拷取页锟芥缓锟斤拷锟斤拷锟�, url锟斤拷[" + path + "],params:" + params.toString() + ",returnResult:" + result.getStatus() + ",response:" + result.getResponse());
			}
		}
		return false;
	}
	protected String getDomain(String pageUrl){
		return config.getString("domain");
	}
	protected String getFullPath(String pageUrl){
		return config.getAbsPath() + config.getBasePath() + pageUrl;
	}
	@Override
	public void updatePageView(String pageUrl, PageParams pageParams, String citycode, String content){
		Integer cacheMin = getCacheMin(pageUrl);
		updateCount(KEY_PUT);
		memcachedClient.set(getExistsKey(pageUrl, pageParams, citycode), 60*120, System.currentTimeMillis()+DateUtil.m_minute*cacheMin);
		memcachedClient.set(getContentKey(pageUrl, pageParams, citycode), 60*120, content);
	}

	@Override
	public void clearPageView(String pageUrl, PageParams pageParams, String citycode) {
		String key = getExistsKey(pageUrl, pageParams, citycode);
		successMap.remove(key);
		memcachedClient.delete(key);
		memcachedClient.delete(getContentKey(pageUrl, pageParams, citycode));
	}
	
	private String getExistsKey(String pageUrl, PageParams pageParams, String citycode){
		int paramHash = pageParams.gainParamsHash();
		String key = pageUrl + paramHash;
		String result = keyPre + "K" + key + "CITYCODE" + citycode;
		result = StringUtils.deleteWhitespace(result);
		return result;
	}
	private String getContentKey(String pageUrl, PageParams pageParams, String citycode){
		int paramHash = pageParams.gainParamsHash();
		String key = pageUrl + paramHash;
		String result = keyPre + "P" + key + "CITYCODE" + citycode;
		result = StringUtils.deleteWhitespace(result);
		return result;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		BlockingQueue<Runnable> taskQueue = new ArrayBlockingQueue<Runnable>(30);
		executor = new ThreadPoolExecutor(threadPoolSize, threadPoolSize, 0L, TimeUnit.SECONDS, taskQueue);
		executor.allowCoreThreadTimeOut(false);
		//锟斤拷锟斤拷锟斤拷锟斤到30锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷JMS锟斤拷息
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		Long cur = System.currentTimeMillis();
		ResourceStatsUtil.getPageCacheStats().register(KEY_HIT, cur);
		ResourceStatsUtil.getPageCacheStats().register(KEY_MIS, cur);
		ResourceStatsUtil.getPageCacheStats().register(KEY_ERR, cur);
		ResourceStatsUtil.getPageCacheStats().register(KEY_PUT, cur);
		ResourceStatsUtil.getPageCacheStats().register(KEY_REPEAT, cur);
		ResourceStatsUtil.getPageCacheStats().register(KEY_IGNORE, cur);
		refreshKeyVersion();
		if(StringUtils.equals("true", config.getString("disablePageCache"))){
			//锟截憋拷页锟芥缓锟斤拷
			enableCache = false;
		}
	}
	private void updateCount(String key){
		ResourceStatsUtil.getPageCacheStats().incrementCount(key);
	}
	@Override
	public String refreshKeyVersion() {
		keyPre = processor.getKeyPre();
		return keyPre;
	}

	@Override
	public boolean isUseCache(HttpServletRequest request) {
		if(!enableCache) {
            return false;
        }
		//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟竭硷拷
		if(StringUtils.isBlank(request.getParameter(NOT_USE_CACHE_KEY))) {
			return true ;
		}
		String ip = BaseWebUtils.getRemoteIp(request);
		//NOT_USE_CACHE_KEY只锟斤拷锟斤拷诓锟絀P锟斤拷效
		return !(GewaIpConfig.isGewaInnerIp(ip) || GewaIpConfig.isOfficeIp(ip));
	}

	@Override
	public boolean isUpdated(String pageUrl, String citycode, Long cur, PageParams pageParams) {
		Long cached = (Long) memcachedClient.get(getExistsKey(pageUrl, pageParams, citycode));
		return cached!=null && cached > cur + DateUtil.m_minute;
	}

	@Override
	public void processPageView(final String pageUrl, final Map<String, String> params, final Map<String, String[]> cookieMap, final String citycode){
		executor.execute(new Runnable(){
			@Override
			public void run() {
				final PageParams pparam = new PageParams();
				for(String pkey:params.keySet()){
					pparam.addSingleString(pkey, params.get(pkey));
				}
				if(cookieMap!=null){
					for(String cookieName: cookieMap.keySet()){
						pparam.addCookie(cookieName, cookieMap.get(cookieName)[0], cookieMap.get(cookieName)[1]);	
					}
					
				}
				final String key = getExistsKey(pageUrl, pparam, citycode);
				final String city = citycode;
				final String page = pageUrl;
				Long last = successMap.get(key);
				if(last!=null && last+DateUtil.m_minute*5 > System.currentTimeMillis()){//5锟斤拷锟斤拷锟节成癸拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
					updateCount(KEY_REPEAT);
				}else{
					String lockKey = "ppv" + Math.abs(key.hashCode()%1000);
					ErrorCode<Boolean> result = lockService.tryDoWithWriteLock(lockKey, new LockCallback<Boolean>(){
						@Override
						public Boolean processWithInLock() {
							
							boolean refreshed = refreshPageView(page, pparam, city);
							if(!refreshed) {
								dbLogger.error("锟斤拷取锟斤拷锟斤拷失锟杰ｏ拷");
								return false;
							}else{
								if(successMap.size()>50000){
									successMap = new ConcurrentHashMap<String, Long>();
								}
								successMap.put(key, System.currentTimeMillis());
								return true;
							}
						}
					});
					if(!result.isSuccess()){
						updateCount(KEY_IGNORE);
					}
				}
			}
		});
	}

	@Override
	public void setPageCacheHeader(boolean outerAllow, HttpServletRequest request, HttpServletResponse response) {
		if(outerAllow && isUseCache(request)){
			Integer cacheMin = getCacheMin(request.getRequestURI());
			Integer maxage = 60 * cacheMin;
			Long lastModifyTime = System.currentTimeMillis();
			Long expireTime = System.currentTimeMillis() + maxage * 1000;
			response.addHeader("Cache-Control", "max-age=" + maxage);
			response.setDateHeader("Last-Modified", lastModifyTime);
			response.setDateHeader("Expires", expireTime);
		}
	}
}

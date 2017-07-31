package com.gewara.untrans.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.gewara.Config;
import com.gewara.untrans.CacheCenterService;
import com.gewara.untrans.CacheService;
import com.gewara.untrans.monitor.ConfigCenter;
import com.gewara.untrans.monitor.ConfigTrigger;
import com.gewara.util.DateUtil;
import com.gewara.util.ServiceCacheHelper;

public class CacheCenterServiceImpl implements CacheCenterService, InitializingBean{
	public static final String KEY_CLEAR_SERVICE_CACHE = "clearServiceCache";
	private Map<String/*serviceName*/, ServiceCacheHelperImpl> helperMap = new ConcurrentHashMap<String, ServiceCacheHelperImpl>();
	private CacheService cacheService;
	public void setCacheService(CacheService cacheService) {
		this.cacheService = cacheService;
	}
	@Autowired@Qualifier("configCenter")
	private ConfigCenter configCenter;
	private boolean defalutLocal;
	//~~~~~~~~~~~~~~~~~~~~service layer cache manager~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	@Override
	public ServiceCacheHelper getLocalServiceCacheHelper(Class clazz){
		String serviceName = clazz.getSimpleName();
		return getLocalServiceCacheHelperByName(serviceName);
	}
	/**
	 * @param serviceName from class.getSimpleName()
	 * @return
	 */
	@Override
	public ServiceCacheHelper getLocalServiceCacheHelperByName(String serviceName){
		ServiceCacheHelperImpl helper = null;
		helper = new ServiceCacheHelperImpl(serviceName, new LocalCacheTools(100000, cacheService));
		configCenter.register(Config.SYSTEMID, serviceName, new ClearCacheTrigger(helper));
		helperMap.put(serviceName, helper);
		return helper;
	}
	@Override
	public ServiceCacheHelper getServiceCacheHelper(Class clazz){
		String serviceName = clazz.getSimpleName();
		return getServiceCacheHelperByName(serviceName);
	}
	/**
	 * @param serviceName from class.getSimpleName()
	 * @return
	 */
	@Override
	public ServiceCacheHelper getServiceCacheHelperByName (String serviceName){
		ServiceCacheHelperImpl helper = null;
		if(defalutLocal){
			helper = new ServiceCacheHelperImpl(serviceName, new LocalCacheTools(100000, cacheService));
			configCenter.register(Config.SYSTEMID, serviceName, new ClearCacheTrigger(helper), 2);
		}else{
			helper = new ServiceCacheHelperImpl(serviceName, cacheService);
		}
		
		helperMap.put(serviceName, helper);
		return helper;
	}
	@Override
	public Map<String/*serviceName*/, ServiceCacheHelper> getHelperMap(){
		return new HashMap<String/*serviceName*/, ServiceCacheHelper>(helperMap);
	}
	

	@Override
	public void clearCache(Class clazz, String ukey, Object... params) {
		String serviceName = clazz.getSimpleName();
		clearCacheByName(serviceName, ukey, params);
	}
	@Override
	public void clearCacheByName(String serviceName, String ukey, Object... params) {

		ServiceCacheHelperImpl helper = helperMap.get(serviceName);
		if(helper!=null){
			String key = ServiceCacheHelperImpl.buildKey(ukey, params);
			if(helper.isLocal()){
				configCenter.refresh(Config.SYSTEMID, serviceName, key);
			}else{
				helper.clearCache(key);
			}
		}
	}
	public class ClearCacheTrigger implements ConfigTrigger{
		private ServiceCacheHelperImpl helper;
		public ClearCacheTrigger(ServiceCacheHelperImpl cacheHelper){
			this.helper = cacheHelper;
		}
		@Override
		public void refreshCurrent(String newConfig) {
			helper.clearCache(newConfig);
		}
	}

	@Override
	public void startClear(String clazzName){
		configCenter.refresh(Config.SYSTEMID, KEY_CLEAR_SERVICE_CACHE, clazzName + "@" + DateUtil.getCurFullTimestampStr());
	}
	public void setDefalutLocal(boolean defalutLocal) {
		this.defalutLocal = defalutLocal;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		configCenter.register(Config.SYSTEMID, KEY_CLEAR_SERVICE_CACHE, new ConfigTrigger(){
			@Override
			public void refreshCurrent(String newConfig) {
				String[] pair = StringUtils.split(newConfig, "@");
				ServiceCacheHelperImpl helper = helperMap.get(pair[0]);
				if(helper!=null){
					helper.startClear();
				}
			}
		}, 4);
	}
	 
}

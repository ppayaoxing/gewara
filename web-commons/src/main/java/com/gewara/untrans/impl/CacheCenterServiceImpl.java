/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.Config;
import com.gewara.untrans.CacheCenterService;
import com.gewara.untrans.CacheService;
import com.gewara.untrans.impl.LocalCacheTools;
import com.gewara.untrans.impl.ServiceCacheHelperImpl;
import com.gewara.untrans.monitor.ConfigCenter;
import com.gewara.untrans.monitor.ConfigTrigger;
import com.gewara.util.DateUtil;
import com.gewara.util.ServiceCacheHelper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CacheCenterServiceImpl implements CacheCenterService, InitializingBean {
	public static final String KEY_CLEAR_SERVICE_CACHE = "clearServiceCache";
	private Map<String, ServiceCacheHelperImpl> helperMap = new ConcurrentHashMap();
	private CacheService cacheService;
	@Autowired
	@Qualifier("configCenter")
	private ConfigCenter configCenter;
	private boolean defalutLocal;

	public void setCacheService(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	public ServiceCacheHelper getLocalServiceCacheHelper(Class clazz) {
		String serviceName = clazz.getSimpleName();
		return this.getLocalServiceCacheHelperByName(serviceName);
	}

	public ServiceCacheHelper getLocalServiceCacheHelperByName(String serviceName) {
		ServiceCacheHelperImpl helper = null;
		helper = new ServiceCacheHelperImpl(serviceName, new LocalCacheTools(100000, this.cacheService));
		this.configCenter.register(Config.SYSTEMID, serviceName, new CacheCenterServiceImpl.ClearCacheTrigger(helper));
		this.helperMap.put(serviceName, helper);
		return helper;
	}

	public ServiceCacheHelper getServiceCacheHelper(Class clazz) {
		String serviceName = clazz.getSimpleName();
		return this.getServiceCacheHelperByName(serviceName);
	}

	public ServiceCacheHelper getServiceCacheHelperByName(String serviceName) {
		ServiceCacheHelperImpl helper = null;
		if (this.defalutLocal) {
			helper = new ServiceCacheHelperImpl(serviceName, new LocalCacheTools(100000, this.cacheService));
			this.configCenter.register(Config.SYSTEMID, serviceName,
					new CacheCenterServiceImpl.ClearCacheTrigger(helper), 2);
		} else {
			helper = new ServiceCacheHelperImpl(serviceName, this.cacheService);
		}

		this.helperMap.put(serviceName, helper);
		return helper;
	}

	public Map<String, ServiceCacheHelper> getHelperMap() {
		return new HashMap(this.helperMap);
	}

	public void clearCache(Class clazz, String ukey, Object... params) {
		String serviceName = clazz.getSimpleName();
		this.clearCacheByName(serviceName, ukey, params);
	}

	public void clearCacheByName(String serviceName, String ukey, Object... params) {
		ServiceCacheHelperImpl helper = (ServiceCacheHelperImpl) this.helperMap.get(serviceName);
		if (helper != null) {
			String key = ServiceCacheHelperImpl.buildKey(ukey, params);
			if (helper.isLocal()) {
				this.configCenter.refresh(Config.SYSTEMID, serviceName, key);
			} else {
				helper.clearCache(key);
			}
		}

	}

	public void startClear(String clazzName) {
		this.configCenter.refresh(Config.SYSTEMID, "clearServiceCache",
				clazzName + "@" + DateUtil.getCurFullTimestampStr());
	}

	public void setDefalutLocal(boolean defalutLocal) {
		this.defalutLocal = defalutLocal;
	}

	public void afterPropertiesSet() throws Exception {
		this.configCenter.register(Config.SYSTEMID, "clearServiceCache", new ConfigTrigger() {
			public void refreshCurrent(String newConfig) {
				String[] pair = StringUtils.split(newConfig, "@");
				ServiceCacheHelperImpl helper = (ServiceCacheHelperImpl) CacheCenterServiceImpl.this.helperMap
						.get(pair[0]);
				if (helper != null) {
					helper.startClear();
				}

			}
		}, 4);
	}

	public class ClearCacheTrigger implements ConfigTrigger {
		private ServiceCacheHelperImpl helper;

		public ClearCacheTrigger(ServiceCacheHelperImpl cacheHelper) {
			this.helper = cacheHelper;
		}

		public void refreshCurrent(String newConfig) {
			this.helper.clearCache(newConfig);
		}
	}
}
package com.gewara.untrans;

import java.util.Map;

import com.gewara.util.ServiceCacheHelper;

public interface CacheCenterService {
	/**
	 * @param clazz service class
	 * @return
	 */
	ServiceCacheHelper getServiceCacheHelper(Class clazz);
	/**
	 * @param serviceName from clazz.getSimpleName()
	 * @return
	 */
	ServiceCacheHelper getServiceCacheHelperByName(String serviceName);
	/**
	 * @param clazz service class
	 * @return
	 */
	ServiceCacheHelper getLocalServiceCacheHelper(Class clazz);
	/**
	 * @param serviceName from clazz.getSimpleName()
	 * @return
	 */
	ServiceCacheHelper getLocalServiceCacheHelperByName(String serviceName);
	Map<String, ServiceCacheHelper> getHelperMap();
	/**
	 * @param clazz service class
	 * @param ukey
	 * @param params
	 */
	void clearCache(Class clazz, String ukey, Object...params);
	/**
	 * @param serviceName from clazz.getSimpleName()
	 * @param ukey
	 * @param params
	 */
	void clearCacheByName(String serviceName, String ukey, Object...params);
	void startClear(String clazzName);
}

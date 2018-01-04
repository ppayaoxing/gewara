package com.gewara.util;

import java.util.Map;

/**
 * Service鏂规硶缂撳瓨锛屾瘡涓猄ervice涓�涓�
 * @author gebiao(ge.biao@gewara.com)
 * @since Nov 5, 2013 10:25:21 PM
 */
public interface ServiceCacheHelper {
	public Map getStats();
	public Map getAndResetStats();
	public boolean isLocal();
	
	/**
	 * 涓嶉渶瑕佸悓姝�
	 * @param key
	 * @param call
	 * @param cacheSeconds:缂撳瓨鏃堕棿
	 * @return
	 */
	public <T> T cacheCall(Integer cacheSeconds, CachableCall<T> call, String ukey, Object...params);
	public <T> T cacheCallRefresh(Integer cacheSeconds, CachableCall<T> call, String ukey, boolean forceRefresh, Object...params);
	public void updateCache(Object value, Integer cacheSeconds, String ukey, Object...params);
}

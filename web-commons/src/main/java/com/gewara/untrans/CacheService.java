package com.gewara.untrans;

import java.util.Collection;
import java.util.Map;

import com.gewara.model.BaseObject;
import com.gewara.support.CachePair;

public interface CacheService extends CacheTools {
	// 鍥哄畾鍖哄煙
	String REGION_TENMIN = "tenMin";
	String REGION_ONEHOUR = "oneHour";
	String REGION_LOGINAUTH = "loginAuth"; // 2hour
	String REGION_SERVICE = "service"; // 12 hour
	String REGION_FIVEDAY = "fiveDay"; // 5day
	String REGION_LOGINKEY = "loginKey";

	/**
	 * @param claszz
	 * @param key
	 * @param mpid
	 */
	<T extends BaseObject> void cleanUkey(Class<T> claszz, String key, Long mpid);
	<T extends BaseObject> void cleanUkey(Class<T> claszz, String key, String ukey);

	/**
	 * @function 澶氫釜key
	 */
	Map<String, Object> getBulk(String regionName, Collection<String> keys);

	/**
	 * 浣跨敤鐙珛鐨勮秴鏃舵椂闂�
	 * 
	 * @param regionName
	 * @param key
	 * @param value
	 * @param timeoutSecond
	 *            瓒呮椂绉掓暟
	 */
	void set(String regionName, String key, Object value, int timeoutSecond);

	/**
	 * 鐩存帴鏇存柊缂撳瓨
	 */
	void updateValue(String regionName, String key, String newvalue);

	void refreshVersion();

	Integer getCacheTime(String region);

	/**
	 * 澧炲姞璁℃暟锛岄潪鍘熷瓙鎿嶄綔
	 * 
	 * @param key
	 * @param by
	 *            娣诲姞鍊�
	 * @param defvalue
	 *            榛樿鍊�
	 * @return
	 */
	int incr(String regionName, String key, int by, int defvalue);

	/**
	 * 鍘熷瓙鍔�
	 * 
	 * @param regionName
	 * @param key
	 * @param by
	 *            澧炲姞
	 * @param def
	 *            榛樿鍊�
	 * @return the new value, or -1 if we were unable to increment or add
	 */
	int incrementAndGet(String regionName, String key, int by, int def);

	CachePair getCachePair(String regionName, String key);

	/**
	 * @param regionName
	 * @param key
	 * @param version
	 * @param value
	 * @param expSeconds
	 * @return
	 */
	boolean setCachePair(String regionName, String key, long version, Object value, int expSeconds);

	void add(String regionName, String key, Object value, int expSeconds);

	/**
	 * 鍘熷瓙鍑�
	 * 
	 * @param regionName
	 * @param key
	 * @param by
	 * @param def
	 *            the default value (if the counter does not exist)
	 * @return the new value, or -1 if we were unable to decrement or add
	 */
	int decrAndGet(String regionName, String key, int by, int def);

	/**
	 * 鍘熷瓙鍔�
	 * 
	 * @param regionName
	 * @param key
	 * @param by
	 * @param def
	 * @param exp
	 *            瓒呮椂鏃堕棿,绉�
	 * @return
	 */
	int incrementAndGet(String regionName, String key, int by, int def, int exp);
	void refreshVersion(Map<String, String> regionVersion);
}

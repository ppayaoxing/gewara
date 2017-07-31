package com.gewara.untrans.redis;

import java.util.List;

public interface RedisShardingService {

	/**
	 * 获取redis中缓存的对象
	 * @param key not blank
	 * @param clazz not null
	 * @return null or obj,如果缓存不存在，则返回的对象中属性值为null
	 */
	<T> T getHashMapCache(String key, Class<T> clazz);

	/**
	 * 将对象存入redis中
	 * @param key not blank
	 * @param obj not null
	 */
	<T> void putHashMapCache4All(String key, T obj);

	/**
	 * 将对象的一个属性存入redis中，新增或覆盖值
	 * @param key not blank
	 * @param fieldName not blank
	 * @param fieldValue
	 */
	void putHashMapCache(String key, String fieldName, Object fieldValue);

	/**
	 * 将对象集加入redis list中, 对应{@link #pollQueueData(String)}
	 * @param key not null
	 * @param objs null empty
	 */
	<T> void putQueueCache4All(String key, List<T> objs);

	/**
	 * 获取redis list中的对象, 对应{@link #putQueueCache4All(String, List)}
	 * @param key
	 * @return list为空，返回null
	 */
	<T> T pollQueueData(String key);

	/**
	 * 将key value对存入缓存中, 对应{@link #getCache(String)}
	 * @param key not blank
	 * @param value not blank
	 */
	void putCache(String key, String value);

	/**
	 * 根据key获取缓存值, 对应{@link #putCache(String, String)}
	 * @param key
	 * @return key为空或者value不存在时返回null
	 */
	String getCache(String key);
	/**
	 * 将对象存入redis中,当且仅当key不存在时
	 * @param key not blank
	 * @param obj not null
	 * @return 如果key存在则返回false
	 */
	<T> Boolean putHashMapCache4AllNotExist(String key, T obj);
	/**
	 * 根据key删除缓存值
	 * @param key
	 */
	void delCache(String key);
	/**
	 * 设置key缓存过期时间
	 * @param key
	 * @param seconds 秒
	 */
	void expireCache(String key,int seconds);
}

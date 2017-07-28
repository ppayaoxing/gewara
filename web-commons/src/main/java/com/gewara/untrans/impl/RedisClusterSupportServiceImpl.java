/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.support.concurrent.AtomicCounter;
import com.gewara.support.serializer.HessianRedisSerializer;
import com.gewara.untrans.RedisSupportService;
import com.gewara.untrans.impl.RedisClusterAtomicCounter;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.support.collections.DefaultRedisList;
import org.springframework.data.redis.support.collections.DefaultRedisMap;

public class RedisClusterSupportServiceImpl<E> implements RedisSupportService<E>, InitializingBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private ConcurrentHashMap<String, BlockingQueue<E>> queueMap = new ConcurrentHashMap(64);
	private ConcurrentHashMap<String, DefaultRedisMap<String, Object>> redisMapCache = new ConcurrentHashMap(64);
	private RedisTemplate<String, E> redisTemplate;

	public void setRedisTemplate(RedisTemplate<String, E> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public BlockingQueue<E> getRedisQueue(String key) {
		BlockingQueue queue = (BlockingQueue) this.queueMap.get(key);
		if (queue == null) {
			this.queueMap.put(key, new DefaultRedisList(key, this.redisTemplate));
			queue = (BlockingQueue) this.queueMap.get(key);
		}

		return queue;
	}

	public AtomicCounter getRedisAtomicCounter(String key) {
		return new RedisClusterAtomicCounter(key, this.redisTemplate.getConnectionFactory());
	}

	public DefaultRedisMap<String, Object> getRedisHash(String key) {
		DefaultRedisMap redisMap = (DefaultRedisMap) this.redisMapCache.get(key);
		if (redisMap == null) {
			this.redisMapCache.put(key, new DefaultRedisMap(key, this.redisTemplate));
			redisMap = (DefaultRedisMap) this.redisMapCache.get(key);
		}

		return redisMap;
	}

	public void afterPropertiesSet() throws Exception {
		if (this.redisTemplate == null) {
			throw new IllegalArgumentException("需要配置redisTemplate");
		} else {
			this.redisTemplate.setKeySerializer(new StringRedisSerializer());
			this.redisTemplate.setValueSerializer(new HessianRedisSerializer());
			this.redisTemplate.setHashKeySerializer(new StringRedisSerializer());
			this.redisTemplate.setHashValueSerializer(new HessianRedisSerializer());
			this.dbLogger.warn("init ok!");
		}
	}
}
package com.gewara.untrans.impl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.support.collections.DefaultRedisList;
import org.springframework.data.redis.support.collections.DefaultRedisMap;

import com.gewara.support.concurrent.AtomicCounter;
import com.gewara.support.serializer.HessianRedisSerializer;
import com.gewara.untrans.RedisSupportService;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

/**
 * 主从redis，可切换<br>
 * 默认使用主redis提供实现
 * @author quzhuping
 * @param <E>
 */
public class RedisClusterSupportServiceImpl<E> implements RedisSupportService<E>, InitializingBean{
private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	
	private ConcurrentHashMap<String, BlockingQueue<E>> queueMap = new ConcurrentHashMap<>(64);
	private ConcurrentHashMap<String, DefaultRedisMap<String, Object>> redisMapCache = new ConcurrentHashMap<>(64);

	private RedisTemplate<String, E> redisTemplate;
	public void setRedisTemplate(RedisTemplate<String, E> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	@Override
	public BlockingQueue<E> getRedisQueue(String key){
		BlockingQueue<E> queue = queueMap.get(key);
		if(queue == null){
			queueMap.put(key, new DefaultRedisList<>(key, redisTemplate));
			queue = queueMap.get(key);
		}
		return queue;
	}

	@Override
	public AtomicCounter getRedisAtomicCounter(String key) {
		return new RedisClusterAtomicCounter(key, redisTemplate.getConnectionFactory());
	}

	
	@Override
	public DefaultRedisMap<String, Object> getRedisHash(String key){
		DefaultRedisMap redisMap = redisMapCache.get(key);
		if(redisMap == null){
			redisMapCache.put(key, new DefaultRedisMap<String, Object>(key, redisTemplate));
			redisMap = redisMapCache.get(key);
		}
		return redisMap;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(redisTemplate == null){
			throw new IllegalArgumentException("需要配置redisTemplate");
		}
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new HessianRedisSerializer<>());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new HessianRedisSerializer<>());
		dbLogger.warn("init ok!");
	}
}

package com.gewara.untrans.impl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.support.collections.DefaultRedisList;
import org.springframework.data.redis.support.collections.DefaultRedisMap;

import com.gewara.constant.ZkConfigTag;
import com.gewara.support.concurrent.AtomicCounter;
import com.gewara.support.serializer.HessianRedisSerializer;
import com.gewara.untrans.RedisSupportService;
import com.gewara.untrans.monitor.ConfigCenter;
import com.gewara.untrans.monitor.ConfigTrigger;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

/**
 * 主从redis，可切换<br>
 * 默认使用主redis提供实现
 * @author quzhuping
 * @param <E>
 */
public class RedisSupportServiceImpl<E> implements RedisSupportService<E>, ConfigTrigger, InitializingBean{
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	
	private ConcurrentHashMap<String, BlockingQueue<E>> queueMap = new ConcurrentHashMap<>(64);
	private ConcurrentHashMap<String, DefaultRedisMap<String, Object>> redisMapCache = new ConcurrentHashMap<>(64);
	
	@Autowired
	private ConfigCenter configCenter;
	private AtomicBoolean useMaster = new AtomicBoolean(true);
	
	//主redis
	private RedisTemplate<String, E> redisTemplate;
	public void setRedisTemplate(RedisTemplate<String, E> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	//从redis
	private RedisTemplate<String, E> redisTemplateBack;
	public void setRedisTemplateBack(RedisTemplate<String, E> redisTemplateBack) {
		this.redisTemplateBack = redisTemplateBack;
	}

	private RedisTemplate<String, E> curTemplate;
	
	@Override
	public BlockingQueue<E> getRedisQueue(String key){
		BlockingQueue<E> queue = queueMap.get(key);
		if(queue == null){
			queueMap.put(key, new DefaultRedisList<>(key, curTemplate));
			queue = queueMap.get(key);
		}
		return queue;
	}

	@Override
	public AtomicCounter getRedisAtomicCounter(String key) {
		return new RedisAtomicCounter(key, redisTemplate.getConnectionFactory(), redisTemplateBack.getConnectionFactory());
	}

	
	@Override
	public DefaultRedisMap<String, Object> getRedisHash(String key){
		DefaultRedisMap redisMap = redisMapCache.get(key);
		if(redisMap == null){
			redisMapCache.put(key, new DefaultRedisMap<String, Object>(key, curTemplate));
			redisMap = redisMapCache.get(key);
		}
		return redisMap;
	}
	
	@Override
	public void refreshCurrent(String newConfig) {
		if(useMaster.get()){
			dbLogger.warn("切换redis从服务节点");
			useMaster.set(false);
			RedisAtomicCounter.useMaster = false;
			curTemplate = redisTemplateBack;//切换到从redis
		}else{
			dbLogger.warn("切换redis主服务节点");
			useMaster.set(true);
			RedisAtomicCounter.useMaster = true;
			curTemplate = redisTemplate;//切换到主redis
		}
		queueMap = new ConcurrentHashMap<>(64);
		redisMapCache = new ConcurrentHashMap<>(64);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(redisTemplate == null || redisTemplateBack == null){
			throw new IllegalArgumentException("需要配置主从redisTemplate");
		}
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplateBack.setKeySerializer(new StringRedisSerializer());
		
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new HessianRedisSerializer<>());

		redisTemplateBack.setHashKeySerializer(new StringRedisSerializer());
		redisTemplateBack.setHashValueSerializer(new HessianRedisSerializer<>());
		if(useMaster.get()){
			curTemplate = redisTemplate;
		}else{
			curTemplate = redisTemplateBack;
		}
		
		configCenter.registerGlobal(ZkConfigTag.KEY_GLOBAL_REDISURI, this);
	}
}

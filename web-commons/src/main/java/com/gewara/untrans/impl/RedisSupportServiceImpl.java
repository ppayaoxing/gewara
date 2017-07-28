/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.support.concurrent.AtomicCounter;
import com.gewara.support.serializer.HessianRedisSerializer;
import com.gewara.untrans.RedisSupportService;
import com.gewara.untrans.impl.RedisAtomicCounter;
import com.gewara.untrans.monitor.ConfigCenter;
import com.gewara.untrans.monitor.ConfigTrigger;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.support.collections.DefaultRedisList;
import org.springframework.data.redis.support.collections.DefaultRedisMap;

public class RedisSupportServiceImpl<E> implements RedisSupportService<E>, ConfigTrigger, InitializingBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private ConcurrentHashMap<String, BlockingQueue<E>> queueMap = new ConcurrentHashMap(64);
	private ConcurrentHashMap<String, DefaultRedisMap<String, Object>> redisMapCache = new ConcurrentHashMap(64);
	@Autowired
	private ConfigCenter configCenter;
	private AtomicBoolean useMaster = new AtomicBoolean(true);
	private RedisTemplate<String, E> redisTemplate;
	private RedisTemplate<String, E> redisTemplateBack;
	private RedisTemplate<String, E> curTemplate;

	public void setRedisTemplate(RedisTemplate<String, E> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void setRedisTemplateBack(RedisTemplate<String, E> redisTemplateBack) {
		this.redisTemplateBack = redisTemplateBack;
	}

	public BlockingQueue<E> getRedisQueue(String key) {
		BlockingQueue queue = (BlockingQueue) this.queueMap.get(key);
		if (queue == null) {
			this.queueMap.put(key, new DefaultRedisList(key, this.curTemplate));
			queue = (BlockingQueue) this.queueMap.get(key);
		}

		return queue;
	}

	public AtomicCounter getRedisAtomicCounter(String key) {
		return new RedisAtomicCounter(key, this.redisTemplate.getConnectionFactory(),
				this.redisTemplateBack.getConnectionFactory());
	}

	public DefaultRedisMap<String, Object> getRedisHash(String key) {
		DefaultRedisMap redisMap = (DefaultRedisMap) this.redisMapCache.get(key);
		if (redisMap == null) {
			this.redisMapCache.put(key, new DefaultRedisMap(key, this.curTemplate));
			redisMap = (DefaultRedisMap) this.redisMapCache.get(key);
		}

		return redisMap;
	}

	public void refreshCurrent(String newConfig) {
		if (this.useMaster.get()) {
			this.dbLogger.warn("切换redis从服务节点");
			this.useMaster.set(false);
			RedisAtomicCounter.useMaster = false;
			this.curTemplate = this.redisTemplateBack;
		} else {
			this.dbLogger.warn("切换redis主服务节点");
			this.useMaster.set(true);
			RedisAtomicCounter.useMaster = true;
			this.curTemplate = this.redisTemplate;
		}

		this.queueMap = new ConcurrentHashMap(64);
		this.redisMapCache = new ConcurrentHashMap(64);
	}

	public void afterPropertiesSet() throws Exception {
		if (this.redisTemplate != null && this.redisTemplateBack != null) {
			this.redisTemplate.setKeySerializer(new StringRedisSerializer());
			this.redisTemplateBack.setKeySerializer(new StringRedisSerializer());
			this.redisTemplate.setHashKeySerializer(new StringRedisSerializer());
			this.redisTemplate.setHashValueSerializer(new HessianRedisSerializer());
			this.redisTemplateBack.setHashKeySerializer(new StringRedisSerializer());
			this.redisTemplateBack.setHashValueSerializer(new HessianRedisSerializer());
			if (this.useMaster.get()) {
				this.curTemplate = this.redisTemplate;
			} else {
				this.curTemplate = this.redisTemplateBack;
			}

			this.configCenter.registerGlobal("key_redis_uri", this);
		} else {
			throw new IllegalArgumentException("需要配置主从redisTemplate");
		}
	}
}
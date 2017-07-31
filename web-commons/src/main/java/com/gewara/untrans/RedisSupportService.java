package com.gewara.untrans;

import java.util.concurrent.BlockingQueue;

import org.springframework.data.redis.support.collections.DefaultRedisMap;

import com.gewara.support.concurrent.AtomicCounter;

/**
 * redis支持服务类
 * <br>基于spring-redis封装
 * @author quzhuping
 *
 * @param <E>
 */
public interface RedisSupportService<E> {

	/**
	 * 获取基于redis list实现的queue，<b>已经缓存到本地cache</b>
	 * <br>使用.poll()方法获取头部数据
	 * <br>使用.offer(E)
	 * @param key
	 * @return
	 */
	BlockingQueue<E> getRedisQueue(String key);
	
	/**
	 * 获取基于redis string 实现的atomicCounter
	 * @param key
	 * @return
	 */
	AtomicCounter getRedisAtomicCounter(String key);

	/**
	 * 获取redisMap，<b>已经缓存到本地cache</b>
	 * @param key
	 * @return
	 */
	DefaultRedisMap<String, Object> getRedisHash(String key);

}

package com.gewara.untrans.impl;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

import com.gewara.support.concurrent.AtomicCounter;

public class RedisAtomicCounter implements AtomicCounter {
	public static boolean useMaster = true;
	private RedisAtomicLong atomic1;
	private RedisAtomicLong atomic2;
	
	public RedisAtomicCounter(String key, RedisConnectionFactory masterFactory, RedisConnectionFactory backFactory){
		atomic1 = new RedisAtomicLong(key, masterFactory);
		atomic2 = new RedisAtomicLong(key, backFactory);
	}
	
	private RedisAtomicLong getRedisAtomicLong(){
		if(useMaster){
			return atomic1;
		}
		return atomic2;
	}
	
	@Override
	public long get() {
		return getRedisAtomicLong().get();
	}

	@Override
	public void set(long newValue) {
		getRedisAtomicLong().set(newValue);
	}

	@Override
	public long getAndAdd(long delta) {
		return getRedisAtomicLong().getAndAdd(delta);
	}

	@Override
	public long getAndDecrement() {
		return getRedisAtomicLong().getAndDecrement();
	}

	@Override
	public long getAndIncrement() {
		return getRedisAtomicLong().getAndIncrement();
	}

	@Override
	public long getAndSet(long newValue) {
		return getRedisAtomicLong().getAndSet(newValue);
	}

	@Override
	public long incrementAndGet() {
		return getRedisAtomicLong().incrementAndGet();
	}

}

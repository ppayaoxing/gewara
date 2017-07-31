package com.gewara.untrans.impl;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

import com.gewara.support.concurrent.AtomicCounter;

public class RedisClusterAtomicCounter implements AtomicCounter {
	private RedisAtomicLong atomic;
	
	public RedisClusterAtomicCounter(String key, RedisConnectionFactory masterFactory){
		atomic = new RedisAtomicLong(key, masterFactory);
	}
	
	@Override
	public long get() {
		return atomic.get();
	}

	@Override
	public void set(long newValue) {
		atomic.set(newValue);
	}

	@Override
	public long getAndAdd(long delta) {
		return atomic.getAndAdd(delta);
	}

	@Override
	public long getAndDecrement() {
		return atomic.getAndDecrement();
	}

	@Override
	public long getAndIncrement() {
		return atomic.getAndIncrement();
	}

	@Override
	public long getAndSet(long newValue) {
		return atomic.getAndSet(newValue);
	}

	@Override
	public long incrementAndGet() {
		return atomic.incrementAndGet();
	}

}

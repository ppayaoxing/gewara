/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.support.concurrent.AtomicCounter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

public class RedisAtomicCounter implements AtomicCounter {
	public static boolean useMaster = true;
	private RedisAtomicLong atomic1;
	private RedisAtomicLong atomic2;

	public RedisAtomicCounter(String key, RedisConnectionFactory masterFactory, RedisConnectionFactory backFactory) {
		this.atomic1 = new RedisAtomicLong(key, masterFactory);
		this.atomic2 = new RedisAtomicLong(key, backFactory);
	}

	private RedisAtomicLong getRedisAtomicLong() {
		return useMaster ? this.atomic1 : this.atomic2;
	}

	public long get() {
		return this.getRedisAtomicLong().get();
	}

	public void set(long newValue) {
		this.getRedisAtomicLong().set(newValue);
	}

	public long getAndAdd(long delta) {
		return this.getRedisAtomicLong().getAndAdd(delta);
	}

	public long getAndDecrement() {
		return this.getRedisAtomicLong().getAndDecrement();
	}

	public long getAndIncrement() {
		return this.getRedisAtomicLong().getAndIncrement();
	}

	public long getAndSet(long newValue) {
		return this.getRedisAtomicLong().getAndSet(newValue);
	}

	public long incrementAndGet() {
		return this.getRedisAtomicLong().incrementAndGet();
	}
}
/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.support.concurrent.AtomicCounter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

public class RedisClusterAtomicCounter implements AtomicCounter {
	private RedisAtomicLong atomic;

	public RedisClusterAtomicCounter(String key, RedisConnectionFactory masterFactory) {
		this.atomic = new RedisAtomicLong(key, masterFactory);
	}

	public long get() {
		return this.atomic.get();
	}

	public void set(long newValue) {
		this.atomic.set(newValue);
	}

	public long getAndAdd(long delta) {
		return this.atomic.getAndAdd(delta);
	}

	public long getAndDecrement() {
		return this.atomic.getAndDecrement();
	}

	public long getAndIncrement() {
		return this.atomic.getAndIncrement();
	}

	public long getAndSet(long newValue) {
		return this.atomic.getAndSet(newValue);
	}

	public long incrementAndGet() {
		return this.atomic.incrementAndGet();
	}
}
/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.support.concurrent.AtomicCounter;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class AtomicCounter4RedisSharded implements AtomicCounter {
	private ShardedJedisPool pool;
	private String key;

	public AtomicCounter4RedisSharded(String key, ShardedJedisPool pool) {
		this(key, pool, 0L);
	}

	public AtomicCounter4RedisSharded(String key, ShardedJedisPool pool, long initValue) {
		Assert.hasText(key, "key not blank");
		Assert.notNull(pool, "shardedJedisPool must not null");
		this.key = key;
		this.pool = pool;
		if (initValue == 0L) {
			if (this.get() == 0L) {
				this.set(0L);
			}
		} else {
			this.set(initValue);
		}

	}

	public long get() {
		ShardedJedis jedis = null;

		long arg2;
		try {
			jedis = this.pool.getResource();
			String rv = jedis.get(this.key);
			if (StringUtils.isBlank(rv)) {
				arg2 = 0L;
				return arg2;
			}

			arg2 = Long.valueOf(rv).longValue();
		} finally {
			if (jedis != null) {
				jedis.close();
			}

		}

		return arg2;
	}

	public void set(long newValue) {
		ShardedJedis jedis = null;

		try {
			jedis = this.pool.getResource();
			jedis.set(this.key, String.valueOf(newValue));
		} finally {
			if (jedis != null) {
				jedis.close();
			}

		}

	}

	public long getAndAdd(long delta) {
		ShardedJedis jedis = null;

		long arg3;
		try {
			jedis = this.pool.getResource();
			arg3 = jedis.incrBy(this.key, delta).longValue() - delta;
		} finally {
			if (jedis != null) {
				jedis.close();
			}

		}

		return arg3;
	}

	public long getAndDecrement() {
		ShardedJedis jedis = null;

		long arg1;
		try {
			jedis = this.pool.getResource();
			arg1 = jedis.decr(this.key).longValue() + 1L;
		} finally {
			if (jedis != null) {
				jedis.close();
			}

		}

		return arg1;
	}

	public long getAndIncrement() {
		ShardedJedis jedis = null;

		long arg1;
		try {
			jedis = this.pool.getResource();
			arg1 = jedis.incr(this.key).longValue() - 1L;
		} finally {
			if (jedis != null) {
				jedis.close();
			}

		}

		return arg1;
	}

	public long getAndSet(long newValue) {
		ShardedJedis jedis = null;

		long arg3;
		try {
			jedis = this.pool.getResource();
			arg3 = Long.valueOf(jedis.getSet(this.key, String.valueOf(newValue))).longValue();
		} finally {
			if (jedis != null) {
				jedis.close();
			}

		}

		return arg3;
	}

	public long incrementAndGet() {
		ShardedJedis jedis = null;

		long arg1;
		try {
			jedis = this.pool.getResource();
			arg1 = jedis.incr(this.key).longValue();
		} finally {
			if (jedis != null) {
				jedis.close();
			}

		}

		return arg1;
	}
}
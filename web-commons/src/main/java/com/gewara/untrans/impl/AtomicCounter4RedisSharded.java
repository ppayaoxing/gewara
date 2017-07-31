package com.gewara.untrans.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

import com.gewara.support.concurrent.AtomicCounter;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class AtomicCounter4RedisSharded implements AtomicCounter {
	private ShardedJedisPool pool;
	private String key;
	
	public AtomicCounter4RedisSharded(String key, ShardedJedisPool pool){
		this(key, pool, 0);
	}
	
	public AtomicCounter4RedisSharded(String key, ShardedJedisPool pool, long initValue){
		Assert.hasText(key, "key not blank");
		Assert.notNull(pool, "shardedJedisPool must not null");	
		this.key = key;
		this.pool = pool;
		if(initValue == 0){
			if(this.get() == 0L){
				set(0);
			}
		}else{
			set(initValue);
		}
	}
	
	@Override
	public long get() {
		ShardedJedis jedis = null;
		try{
			jedis = pool.getResource();
			String rv = jedis.get(key);
			if(StringUtils.isBlank(rv)){
				return 0;
			}
			return Long.valueOf(rv);
		}finally{
			if(jedis != null){
				jedis.close();
			}
		}
	}

	@Override
	public void set(long newValue) {
		ShardedJedis jedis = null;
		try{
			jedis = pool.getResource();
			jedis.set(key, String.valueOf(newValue));
		}finally{
			if(jedis != null){
				jedis.close();
			}
		}
	}

	@Override
	public long getAndAdd(long delta) {
		ShardedJedis jedis = null;
		try{
			jedis = pool.getResource();
			return jedis.incrBy(key, delta) - delta;
		}finally{
			if(jedis != null){
				jedis.close();
			}
		}
	}

	@Override
	public long getAndDecrement() {
		ShardedJedis jedis = null;
		try{
			jedis = pool.getResource();
			return jedis.decr(key) + 1;
		}finally{
			if(jedis != null){
				jedis.close();
			}
		}
	}

	@Override
	public long getAndIncrement() {
		ShardedJedis jedis = null;
		try{
			jedis = pool.getResource();
			return jedis.incr(key) -1L;
		}finally{
			if(jedis != null){
				jedis.close();
			}
		}
	}

	@Override
	public long getAndSet(long newValue) {
		ShardedJedis jedis = null;
		try{
			jedis = pool.getResource();
			return Long.valueOf(jedis.getSet(key, String.valueOf(newValue)));
		}finally{
			if(jedis != null){
				jedis.close();
			}
		}
	}

	@Override
	public long incrementAndGet() {
		ShardedJedis jedis = null;
		try{
			jedis = pool.getResource();
			return jedis.incr(key);
		}finally{
			if(jedis != null){
				jedis.close();
			}
		}
	}

}

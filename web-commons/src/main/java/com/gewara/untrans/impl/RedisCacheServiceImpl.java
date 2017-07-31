package com.gewara.untrans.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.gewara.support.CachePair;
import com.gewara.support.TraceErrorException;
import com.gewara.support.serializer.HessianRedisSerializer;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * 基于sharded jedis实现的cache<br>
 * Object类型的value使用HessianSerializer,其对应的key使用string serializer
 * @author quzhuping
 */
public class RedisCacheServiceImpl extends AbstractCacheService {

	@Autowired
	private ShardedJedisPool pool;
	
	private StringRedisSerializer stringSerializer = new StringRedisSerializer();
	private HessianRedisSerializer hessianSerializer = new HessianRedisSerializer<>();
	
	@Override
	public Map<String, Object> getBulk(String regionName, Collection<String> keys) {
		getRegionTime(regionName);
		if(keys==null || keys.isEmpty()) return null;
		Map<String, String> keyMap = new HashMap<String, String>();
		for(String key : keys){
			String newkey = getRealKey(regionName, key);
			keyMap.put(newkey, key);
		}
		ShardedJedis jedis = null;
		try{
			Map<String, Object> returnMap = new HashMap<String, Object>();
			jedis = pool.getResource();
			for(String realKey : keyMap.keySet()){
				Object value = hessianSerializer.deserialize(jedis.get(stringSerializer.serialize(realKey)));
				returnMap.put(keyMap.get(realKey), value);
			}
			return returnMap;
		}catch (Exception e) {
			dbLogger.warn(regionName+ ":" +keys, e);
		}finally{
			if(jedis != null){
				jedis.close();
			}
		}
		return null;
	}

	@Override
	public void set(String regionName, String key, Object value, int timeoutSecond) {
		if(StringUtils.isBlank(key) || value==null) return;
		key = getRealKey(regionName, key);
		
		ShardedJedis jedis = null;
		try{
			jedis = pool.getResource();
			jedis.setex(stringSerializer.serialize(key), timeoutSecond, hessianSerializer.serialize(value));
		}catch(Exception e){
			dbLogger.warn(regionName+ ":" +key, e);
		}finally{
			if(jedis != null){
				jedis.close();
			}
		}

	}

	/**
	 * 原子加操作<br>
	 * 由于redis的特殊性，def入参在该方法中无效，def值为0
	 * <br>如果使用非零默认值，参考使用{@link AtomicCounter4RedisSharded}
	 */
	@Override
	public int incrementAndGet(String regionName, String key, int by, int def) {
		int expSeconds = getRegionTime(regionName);
		return incrementAndGet(regionName, key, by, def, expSeconds);
	}

	@Override
	public CachePair getCachePair(String regionName, String key) {
		throw new TraceErrorException("redis cache not support!!!");
	}

	@Override
	public boolean setCachePair(String regionName, String key, long version, Object value, int expSeconds) {
		throw new TraceErrorException("redis cache not support!!!");
	}

	@Override
	public void add(String regionName, String key, Object value, int expSeconds) {
		if(StringUtils.isBlank(key) || value==null) return;
		key = getRealKey(regionName, key);
		
		ShardedJedis jedis = null;
		try{
			jedis = pool.getResource();
			jedis.setex(stringSerializer.serialize(key), expSeconds, hessianSerializer.serialize(value));
		}catch(Exception e){
			dbLogger.warn(regionName+ ":" +key, e);
		}finally{
			if(jedis != null){
				jedis.close();
			}
		}

	}

	/**
	 * 原子减操作<br>
	 * 由于redis的特殊性，def入参在该方法中无效，def值为0
	 * <br>如果使用非零默认值，参考使用{@link AtomicCounter4RedisSharded}
	 */
	@Override
	public int decrAndGet(String regionName, String key, int by, int def) {
		if(StringUtils.isNotBlank(key)){
			key = getRealKey(regionName, key);
			ShardedJedis jedis = null;
			try{
				jedis = pool.getResource();
				return jedis.decrBy(key, by).intValue();
			}catch(Exception e){
				dbLogger.warn(regionName+ ":" +key, e);
			}finally{
				if(jedis != null){
					jedis.close();
				}
			}
		}
		return -1;
	}

	/**
	 * 原子加操作<br>
	 * 由于redis的特殊性，def参数在该方法中无效，def值为0
	 * <br>如果使用非零默认值，参考使用{@link AtomicCounter4RedisSharded}
	 */
	@Override
	public int incrementAndGet(String regionName, String key, int by, int def, int exp) {
		if(StringUtils.isNotBlank(key)){
			ShardedJedis jedis = null;
			try{
				key = getRealKey(regionName, key);
				jedis = pool.getResource();
				int rv = jedis.incrBy(key, by).intValue();
				jedis.expire(key, exp);
				return rv;
			}catch(Exception e){
				dbLogger.warn(regionName+ ":" +key, e);
			}finally{
				if(jedis != null){
					jedis.close();
				}
			}
		}
		return -1;
	}

	@Override
	public Object get(String regionName, String key) {
		getRegionTime(regionName);
		if(StringUtils.isBlank(key)){
			return null;
		}
		key = getRealKey(regionName, key);
		
		ShardedJedis jedis = null;
		try{
			jedis = pool.getResource();
			return hessianSerializer.deserialize(jedis.get(stringSerializer.serialize(key)));
		}catch(Exception e){
			dbLogger.warn(regionName+ ":" +key, e);
		}finally{
			if(jedis != null){
				jedis.close();
			}
		}
		return null;
	}

	@Override
	public void set(String regionName, String key, Object value) {
		Integer expSeconds = getRegionTime(regionName);
		set(regionName, key, value, expSeconds);
	}

	@Override
	public void remove(String regionName, String key) {
		if(StringUtils.isNotBlank(key)){
			key = getRealKey(regionName, key);
			ShardedJedis jedis = null;
			try{
				jedis = pool.getResource();
				jedis.del(stringSerializer.serialize(key));
			}catch(Exception e){
				dbLogger.warn(regionName+ ":" +key, e);
			}finally{
				if(jedis != null){
					jedis.close();
				}
			}
		}
	}

	@Override
	public boolean isLocal() {
		return false;
	}

}

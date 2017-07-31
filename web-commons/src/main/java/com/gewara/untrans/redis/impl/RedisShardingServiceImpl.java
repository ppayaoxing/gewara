package com.gewara.untrans.redis.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.gewara.dubbo.bytecode.NoSuchPropertyException;
import com.gewara.dubbo.bytecode.Wrapper;
import com.gewara.support.serializer.HessianRedisSerializer;
import com.gewara.untrans.redis.RedisShardingService;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisShardingServiceImpl implements RedisShardingService{
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	
	@Autowired
	private ShardedJedisPool pool;
	
	private StringRedisSerializer stringSerializer = new StringRedisSerializer();
	private HessianRedisSerializer hessianSerializer = new HessianRedisSerializer<>();
	
	@Override
	public <T> T getHashMapCache(String key, Class<T> clazz){
		if(StringUtils.isBlank(key) || clazz.isPrimitive()){
			return null;
		}
		ShardedJedis jedis = null;
		T rv = null;
		try{
			rv = clazz.newInstance();
			Wrapper srcWrapper = Wrapper.getWrapper(clazz);
			jedis = pool.getResource();
			Map<byte[], byte[]> objMap = jedis.hgetAll(stringSerializer.serialize(key));		
			for(Entry<byte[], byte[]> entry : objMap.entrySet()){
				String pk = stringSerializer.deserialize(entry.getKey());
				try{
					srcWrapper.setPropertyValue(rv, pk, hessianSerializer.deserialize(entry.getValue()));
				}catch(NoSuchPropertyException nspe){
					dbLogger.error(nspe, 5);
				}
			}
		} catch (Exception e) {
			dbLogger.error(e, 10);
		} finally{
			if(jedis != null){
				jedis.close();
			}
		}
		return rv;
	}
	
	@Override
	public <T> void putHashMapCache4All(String key, T obj){
		if(StringUtils.isNotBlank(key) && obj != null){
			ShardedJedis jedis = null;
			try{
				jedis = pool.getResource();
				jedis.hmset(stringSerializer.serialize(key), getObjMap(obj));
			}finally{
				if(jedis != null){
					jedis.close();
				}
			}
		}
	}
	
	@Override
	public void putHashMapCache(String key, String fieldName, Object fieldValue){
		if(StringUtils.isNotBlank(key) && StringUtils.isNotBlank(fieldName)){
			ShardedJedis jedis = null;
			try{
				jedis = pool.getResource();
				jedis.hset(stringSerializer.serialize(key), stringSerializer.serialize(fieldName), hessianSerializer.serialize(fieldValue));
			}finally{
				if(jedis != null){
					jedis.close();
				}
			}
		}
	}
	
	private <T> Map<byte[], byte[]> getObjMap(T obj){
		Map<byte[], byte[]> map = new HashMap<byte[], byte[]>();
		Wrapper srcWrapper = Wrapper.getWrapper(obj.getClass());
		String[] propStrArr = srcWrapper.getWritePropertyNames();
		for(String propStr : propStrArr){
			map.put(stringSerializer.serialize(propStr), hessianSerializer.serialize(srcWrapper.getPropertyValue(obj, propStr)));
		}
		return map;
	}
	
	@Override
	public <T> void putQueueCache4All(String key , List<T> objs){
		if(StringUtils.isNotBlank(key) && objs != null && !objs.isEmpty()){
			ShardedJedis jedis = null;
			try{
				jedis = pool.getResource();
				byte[] kb = stringSerializer.serialize(key);
				byte[][] objarr = new byte[objs.size()][];
				for(int i=0; i<objarr.length; i++){
					objarr[i] = hessianSerializer.serialize(objs.get(i));
				}
				jedis.lpush(kb, objarr);
			}finally{
				if(jedis != null){
					jedis.close();
				}
			}
		}
	}
	
	@Override
	public <T> T pollQueueData(String key){
		if(StringUtils.isNotBlank(key)){
			ShardedJedis jedis = null;
			try{
				jedis = pool.getResource();
				byte[] kb = stringSerializer.serialize(key);
				return (T) hessianSerializer.deserialize(jedis.rpop(kb));
			}finally{
				if(jedis != null){
					jedis.close();
				}
			}
		}
		return null;
	}
	
	@Override
	public void putCache(String key, String value){
		if(StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)){
			ShardedJedis jedis = null;
			try{
				jedis = pool.getResource();
				jedis.set(key, value);
			}finally{
				if(jedis != null){
					jedis.close();
				}
			}
		}
	}
	
	@Override
	public String getCache(String key){
		if(StringUtils.isNotBlank(key)){
			ShardedJedis jedis = null;
			try{
				jedis = pool.getResource();
				return jedis.get(key);
			}finally{
				if(jedis != null){
					jedis.close();
				}
			}
		}
		return null;
	}

	
	@Override
	public <T> Boolean putHashMapCache4AllNotExist(String key, T obj) {
		if(StringUtils.isNotBlank(key) && obj != null){
			ShardedJedis jedis = null;
			try{
				jedis = pool.getResource();
				if(!jedis.exists(key)){
					jedis.hmset(stringSerializer.serialize(key), getObjMap(obj));
					return true;
				}
			}finally{
				if(jedis != null){
					jedis.close();
				}
			}
		}
		return false;
	}

	@Override
	public void delCache(String key) {
		if(StringUtils.isNotBlank(key)){
			ShardedJedis jedis = null;
			try{
				jedis = pool.getResource();
				jedis.del(key);
			}finally{
				if(jedis != null){
					jedis.close();
				}
			}
		}
	}

	@Override
	public void expireCache(String key, int seconds) {
		if(StringUtils.isNotBlank(key) && seconds>0){
			ShardedJedis jedis = null;
			try{
				jedis = pool.getResource();
				jedis.expire(key, seconds);
			}finally{
				if(jedis != null){
					jedis.close();
				}
			}
		}
	}
	
}

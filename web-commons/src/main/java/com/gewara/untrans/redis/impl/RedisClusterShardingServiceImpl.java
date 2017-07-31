package com.gewara.untrans.redis.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.gewara.dubbo.bytecode.NoSuchPropertyException;
import com.gewara.dubbo.bytecode.Wrapper;
import com.gewara.support.serializer.HessianRedisSerializer;
import com.gewara.untrans.redis.RedisShardingService;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

public class RedisClusterShardingServiceImpl implements RedisShardingService{
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	
	private RedisConnectionFactory redisConnectionFactory;
	public void setRedisConnectionFactory(RedisConnectionFactory redisConnectionFactory){
		this.redisConnectionFactory = redisConnectionFactory;
	}
	
	private StringRedisSerializer stringSerializer = new StringRedisSerializer();
	private HessianRedisSerializer hessianSerializer = new HessianRedisSerializer<>();
	
	@Override
	public <T> T getHashMapCache(String key, Class<T> clazz){
		if(StringUtils.isBlank(key) || clazz.isPrimitive()){
			return null;
		}
		T rv = null;
		try{
			rv = clazz.newInstance();
			Wrapper srcWrapper = Wrapper.getWrapper(clazz);
			RedisClusterConnection clusterConn = redisConnectionFactory.getClusterConnection();
			Map<byte[], byte[]> objMap = clusterConn.hGetAll(stringSerializer.serialize(key));		
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
		}
		return rv;
	}
	
	@Override
	public <T> void putHashMapCache4All(String key, T obj){
		if(StringUtils.isNotBlank(key) && obj != null){
			try{
				RedisClusterConnection clusterConn = redisConnectionFactory.getClusterConnection();
				clusterConn.hMSet(stringSerializer.serialize(key), getObjMap(obj));
			}catch (Exception e) {
				dbLogger.error(e, 10);
			}
		}
	}
	
	@Override
	public void putHashMapCache(String key, String fieldName, Object fieldValue){
		if(StringUtils.isNotBlank(key) && StringUtils.isNotBlank(fieldName)){
			try{
				RedisClusterConnection clusterConn = redisConnectionFactory.getClusterConnection();
				clusterConn.hSet(stringSerializer.serialize(key), stringSerializer.serialize(fieldName), hessianSerializer.serialize(fieldValue));
			}catch (Exception e) {
				dbLogger.error(e, 10);
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
			try{
				byte[] kb = stringSerializer.serialize(key);
				byte[][] objarr = new byte[objs.size()][];
				for(int i=0; i<objarr.length; i++){
					objarr[i] = hessianSerializer.serialize(objs.get(i));
				}
				RedisClusterConnection clusterConn = redisConnectionFactory.getClusterConnection();
				clusterConn.lPush(kb, objarr);
			}catch (Exception e) {
				dbLogger.error(e, 10);
			}
		}
	}
	
	@Override
	public <T> T pollQueueData(String key){
		if(StringUtils.isNotBlank(key)){
			try{
				RedisClusterConnection clusterConn = redisConnectionFactory.getClusterConnection();
				byte[] kb = stringSerializer.serialize(key);
				return (T) hessianSerializer.deserialize(clusterConn.rPop(kb));
			}catch (Exception e) {
				dbLogger.error(e, 10);
			}
		}
		return null;
	}
	
	@Override
	public void putCache(String key, String value){
		if(StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)){
			try{
				RedisClusterConnection clusterConn = redisConnectionFactory.getClusterConnection();
				clusterConn.set(stringSerializer.serialize(key), stringSerializer.serialize(value));
			}catch (Exception e) {
				dbLogger.error(e, 10);
			}
		}
	}
	
	@Override
	public String getCache(String key){
		if(StringUtils.isNotBlank(key)){
			try{
				RedisClusterConnection clusterConn = redisConnectionFactory.getClusterConnection();
				return stringSerializer.deserialize(clusterConn.get(stringSerializer.serialize(key)));
			}catch (Exception e) {
				dbLogger.error(e, 10);
			}
		}
		return null;
	}

	
	@Override
	public <T> Boolean putHashMapCache4AllNotExist(String key, T obj) {
		if(StringUtils.isNotBlank(key) && obj != null){
			try{
				byte[] keybytes = stringSerializer.serialize(key);
				RedisClusterConnection clusterConn = redisConnectionFactory.getClusterConnection();
				if(!clusterConn.exists(keybytes)){
					clusterConn.hMSet(stringSerializer.serialize(key), getObjMap(obj));
					return true;
				}
			}catch (Exception e) {
				dbLogger.error(e, 10);
			}
		}
		return false;
	}

	@Override
	public void delCache(String key) {
		if(StringUtils.isNotBlank(key)){
			try{
				RedisClusterConnection clusterConn = redisConnectionFactory.getClusterConnection();
				clusterConn.del(stringSerializer.serialize(key));
			}catch (Exception e) {
				dbLogger.error(e, 10);
			}
		}
	}

	@Override
	public void expireCache(String key, int seconds) {
		if(StringUtils.isNotBlank(key) && seconds>0){
			try{
				RedisClusterConnection clusterConn = redisConnectionFactory.getClusterConnection();
				clusterConn.expire(stringSerializer.serialize(key), seconds);
			}catch (Exception e) {
				dbLogger.error(e, 10);
			}
		}
	}
	
}

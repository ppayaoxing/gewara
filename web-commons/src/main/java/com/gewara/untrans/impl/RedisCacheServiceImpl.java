package com.gewara.untrans.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.gewara.model.BaseObject;
import com.gewara.support.CachePair;
import com.gewara.support.TraceErrorException;
import com.gewara.support.serializer.HessianRedisSerializer;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * 锟斤拷锟斤拷sharded jedis实锟街碉拷cache<br>
 * Object锟斤拷锟酵碉拷value使锟斤拷HessianSerializer,锟斤拷锟接︼拷锟絢ey使锟斤拷string serializer
 * 
 * @author quzhuping
 */
public class RedisCacheServiceImpl extends AbstractCacheService {

	@Autowired
	private ShardedJedisPool pool;

	private StringRedisSerializer stringSerializer = new StringRedisSerializer();
	private HessianRedisSerializer hessianSerializer = new HessianRedisSerializer<>();

	/**
	 * @param claszz
	 * @param key
	 * @param mpid
	 */
	@Override
    public <T extends BaseObject> void cleanUkey(Class<T> claszz, String key, Long mpid) {
	}

	@Override
	public Map<String, Object> getBulk(String regionName, Collection<String> keys) {
		getRegionTime(regionName);
		if (keys == null || keys.isEmpty()) {
            return null;
        }
		Map<String, String> keyMap = new HashMap<String, String>();
		for (String key : keys) {
			String newkey = getRealKey(regionName, key);
			keyMap.put(newkey, key);
		}
		ShardedJedis jedis = null;
		try {
			Map<String, Object> returnMap = new HashMap<String, Object>();
			jedis = pool.getResource();
			for (String realKey : keyMap.keySet()) {
				Object value = hessianSerializer.deserialize(jedis.get(stringSerializer.serialize(realKey)));
				returnMap.put(keyMap.get(realKey), value);
			}
			return returnMap;
		} catch (Exception e) {
			dbLogger.warn(regionName + ":" + keys, e);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		return null;
	}

	@Override
	public void set(String regionName, String key, Object value, int timeoutSecond) {
		if (StringUtils.isBlank(key) || value == null) {
            return;
        }
		key = getRealKey(regionName, key);

		ShardedJedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.setex(stringSerializer.serialize(key), timeoutSecond, hessianSerializer.serialize(value));
		} catch (Exception e) {
			dbLogger.warn(regionName + ":" + key, e);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}

	}

	/**
	 * 原锟接加诧拷锟斤拷<br>
	 * 锟斤拷锟斤拷redis锟斤拷锟斤拷锟斤拷锟皆ｏ拷def锟斤拷锟斤拷诟梅锟斤拷锟斤拷锟斤拷锟叫э拷锟絛ef值为0 <br>
	 * 锟斤拷锟绞癸拷梅锟斤拷锟侥拷锟街碉拷锟斤拷慰锟绞癸拷锟絳@link AtomicCounter4RedisSharded}
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
		if (StringUtils.isBlank(key) || value == null) {
            return;
        }
		key = getRealKey(regionName, key);

		ShardedJedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.setex(stringSerializer.serialize(key), expSeconds, hessianSerializer.serialize(value));
		} catch (Exception e) {
			dbLogger.warn(regionName + ":" + key, e);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}

	}

	/**
	 * 原锟接硷拷锟斤拷锟斤拷<br>
	 * 锟斤拷锟斤拷redis锟斤拷锟斤拷锟斤拷锟皆ｏ拷def锟斤拷锟斤拷诟梅锟斤拷锟斤拷锟斤拷锟叫э拷锟絛ef值为0 <br>
	 * 锟斤拷锟绞癸拷梅锟斤拷锟侥拷锟街碉拷锟斤拷慰锟绞癸拷锟絳@link AtomicCounter4RedisSharded}
	 */
	@Override
	public int decrAndGet(String regionName, String key, int by, int def) {
		if (StringUtils.isNotBlank(key)) {
			key = getRealKey(regionName, key);
			ShardedJedis jedis = null;
			try {
				jedis = pool.getResource();
				return jedis.decrBy(key, by).intValue();
			} catch (Exception e) {
				dbLogger.warn(regionName + ":" + key, e);
			} finally {
				if (jedis != null) {
					jedis.close();
				}
			}
		}
		return -1;
	}

	/**
	 * 原锟接加诧拷锟斤拷<br>
	 * 锟斤拷锟斤拷redis锟斤拷锟斤拷锟斤拷锟皆ｏ拷def锟斤拷锟斤拷锟节该凤拷锟斤拷锟斤拷锟斤拷效锟斤拷def值为0 <br>
	 * 锟斤拷锟绞癸拷梅锟斤拷锟侥拷锟街碉拷锟斤拷慰锟绞癸拷锟絳@link AtomicCounter4RedisSharded}
	 */
	@Override
	public int incrementAndGet(String regionName, String key, int by, int def, int exp) {
		if (StringUtils.isNotBlank(key)) {
			ShardedJedis jedis = null;
			try {
				key = getRealKey(regionName, key);
				jedis = pool.getResource();
				int rv = jedis.incrBy(key, by).intValue();
				jedis.expire(key, exp);
				return rv;
			} catch (Exception e) {
				dbLogger.warn(regionName + ":" + key, e);
			} finally {
				if (jedis != null) {
					jedis.close();
				}
			}
		}
		return -1;
	}

	@Override
	public Object get(String regionName, String key) {
		getRegionTime(regionName);
		if (StringUtils.isBlank(key)) {
			return null;
		}
		key = getRealKey(regionName, key);

		ShardedJedis jedis = null;
		try {
			jedis = pool.getResource();
			return hessianSerializer.deserialize(jedis.get(stringSerializer.serialize(key)));
		} catch (Exception e) {
			dbLogger.warn(regionName + ":" + key, e);
		} finally {
			if (jedis != null) {
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
		if (StringUtils.isNotBlank(key)) {
			key = getRealKey(regionName, key);
			ShardedJedis jedis = null;
			try {
				jedis = pool.getResource();
				jedis.del(stringSerializer.serialize(key));
			} catch (Exception e) {
				dbLogger.warn(regionName + ":" + key, e);
			} finally {
				if (jedis != null) {
					jedis.close();
				}
			}
		}
	}

	@Override
	public boolean isLocal() {
		return false;
	}

	@Override
	public <T extends BaseObject> void cleanUkey(Class<T> claszz, String key, String ukey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refreshVersion(Map<String, String> regionVersion) {
		// TODO Auto-generated method stub
		
	}

}

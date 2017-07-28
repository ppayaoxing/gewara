/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.support.CachePair;
import com.gewara.support.TraceErrorException;
import com.gewara.support.serializer.HessianRedisSerializer;
import com.gewara.untrans.impl.AbstractCacheService;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.StringRedisSerializer;

public class RedisClusterCacheServiceImpl extends AbstractCacheService {
	private RedisConnectionFactory redisConnectionFactory;
	private StringRedisSerializer stringSerializer = new StringRedisSerializer();
	private HessianRedisSerializer hessianSerializer = new HessianRedisSerializer();

	public void setRedisConnectionFactory(RedisConnectionFactory redisConnectionFactory) {
		this.redisConnectionFactory = redisConnectionFactory;
	}

	public Map<String, Object> getBulk(String regionName, Collection<String> keys) {
		this.getRegionTime(regionName);
		if (keys != null && !keys.isEmpty()) {
			HashMap keyMap = new HashMap();
			Iterator e = keys.iterator();

			while (e.hasNext()) {
				String returnMap = (String) e.next();
				String newkey = this.getRealKey(regionName, returnMap);
				keyMap.put(newkey, returnMap);
			}

			try {
				RedisClusterConnection e1 = this.redisConnectionFactory.getClusterConnection();
				HashMap returnMap1 = new HashMap();
				Iterator newkey1 = keyMap.keySet().iterator();

				while (newkey1.hasNext()) {
					String realKey = (String) newkey1.next();
					Object value = this.hessianSerializer.deserialize(e1.get(this.stringSerializer.serialize(realKey)));
					returnMap1.put(keyMap.get(realKey), value);
				}

				return returnMap1;
			} catch (Exception arg8) {
				this.dbLogger.warn(regionName + ":" + keys, arg8);
				return null;
			}
		} else {
			return null;
		}
	}

	public void set(String regionName, String key, Object value, int timeoutSecond) {
		if (!StringUtils.isBlank(key) && value != null) {
			key = this.getRealKey(regionName, key);

			try {
				RedisClusterConnection e = this.redisConnectionFactory.getClusterConnection();
				e.setEx(this.stringSerializer.serialize(key), (long) timeoutSecond,
						this.hessianSerializer.serialize(value));
			} catch (Exception arg5) {
				this.dbLogger.warn(regionName + ":" + key, arg5);
			}

		}
	}

	public int incrementAndGet(String regionName, String key, int by, int def) {
		int expSeconds = this.getRegionTime(regionName).intValue();
		return this.incrementAndGet(regionName, key, by, def, expSeconds);
	}

	public CachePair getCachePair(String regionName, String key) {
		throw new TraceErrorException("redis cache not support!!!");
	}

	public boolean setCachePair(String regionName, String key, long version, Object value, int expSeconds) {
		throw new TraceErrorException("redis cache not support!!!");
	}

	public void add(String regionName, String key, Object value, int expSeconds) {
		if (!StringUtils.isBlank(key) && value != null) {
			key = this.getRealKey(regionName, key);

			try {
				RedisClusterConnection e = this.redisConnectionFactory.getClusterConnection();
				e.setEx(this.stringSerializer.serialize(key), (long) expSeconds,
						this.hessianSerializer.serialize(value));
			} catch (Exception arg5) {
				this.dbLogger.warn(regionName + ":" + key, arg5);
			}

		}
	}

	public int decrAndGet(String regionName, String key, int by, int def) {
		if (StringUtils.isNotBlank(key)) {
			key = this.getRealKey(regionName, key);

			try {
				RedisClusterConnection e = this.redisConnectionFactory.getClusterConnection();
				return e.decrBy(this.stringSerializer.serialize(key), (long) by).intValue();
			} catch (Exception arg5) {
				this.dbLogger.warn(regionName + ":" + key, arg5);
			}
		}

		return -1;
	}

	public int incrementAndGet(String regionName, String key, int by, int def, int exp) {
		if (StringUtils.isNotBlank(key)) {
			try {
				RedisClusterConnection e = this.redisConnectionFactory.getClusterConnection();
				key = this.getRealKey(regionName, key);
				byte[] keybytes = this.stringSerializer.serialize(key);
				int rv = e.incrBy(keybytes, (long) by).intValue();
				e.expire(keybytes, (long) exp);
				return rv;
			} catch (Exception arg8) {
				this.dbLogger.warn(regionName + ":" + key, arg8);
			}
		}

		return -1;
	}

	public Object get(String regionName, String key) {
		this.getRegionTime(regionName);
		if (StringUtils.isBlank(key)) {
			return null;
		} else {
			key = this.getRealKey(regionName, key);

			try {
				RedisClusterConnection e = this.redisConnectionFactory.getClusterConnection();
				return this.hessianSerializer.deserialize(e.get(this.stringSerializer.serialize(key)));
			} catch (Exception arg3) {
				this.dbLogger.warn(regionName + ":" + key, arg3);
				return null;
			}
		}
	}

	public void set(String regionName, String key, Object value) {
		Integer expSeconds = this.getRegionTime(regionName);
		this.set(regionName, key, value, expSeconds.intValue());
	}

	public void remove(String regionName, String key) {
		if (StringUtils.isNotBlank(key)) {
			key = this.getRealKey(regionName, key);

			try {
				RedisClusterConnection e = this.redisConnectionFactory.getClusterConnection();
				e.del(new byte[][]{this.stringSerializer.serialize(key)});
			} catch (Exception arg3) {
				this.dbLogger.warn(regionName + ":" + key, arg3);
			}
		}

	}

	public boolean isLocal() {
		return false;
	}
}
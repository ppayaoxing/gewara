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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisCacheServiceImpl extends AbstractCacheService {
	@Autowired
	private ShardedJedisPool pool;
	private StringRedisSerializer stringSerializer = new StringRedisSerializer();
	private HessianRedisSerializer hessianSerializer = new HessianRedisSerializer();

	public Map<String, Object> getBulk(String regionName, Collection<String> keys) {
		this.getRegionTime(regionName);
		if (keys != null && !keys.isEmpty()) {
			HashMap keyMap = new HashMap();
			Iterator jedis = keys.iterator();

			while (jedis.hasNext()) {
				String e = (String) jedis.next();
				String newkey = this.getRealKey(regionName, e);
				keyMap.put(newkey, e);
			}

			ShardedJedis jedis1 = null;

			try {
				HashMap e1 = new HashMap();
				jedis1 = this.pool.getResource();
				Iterator newkey1 = keyMap.keySet().iterator();

				while (newkey1.hasNext()) {
					String realKey = (String) newkey1.next();
					Object value = this.hessianSerializer
							.deserialize(jedis1.get(this.stringSerializer.serialize(realKey)));
					e1.put(keyMap.get(realKey), value);
				}

				HashMap newkey2 = e1;
				return newkey2;
			} catch (Exception arg11) {
				this.dbLogger.warn(regionName + ":" + keys, arg11);
			} finally {
				if (jedis1 != null) {
					jedis1.close();
				}

			}

			return null;
		} else {
			return null;
		}
	}

	public void set(String regionName, String key, Object value, int timeoutSecond) {
		if (!StringUtils.isBlank(key) && value != null) {
			key = this.getRealKey(regionName, key);
			ShardedJedis jedis = null;

			try {
				jedis = this.pool.getResource();
				jedis.setex(this.stringSerializer.serialize(key), timeoutSecond,
						this.hessianSerializer.serialize(value));
			} catch (Exception arg9) {
				this.dbLogger.warn(regionName + ":" + key, arg9);
			} finally {
				if (jedis != null) {
					jedis.close();
				}

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
			ShardedJedis jedis = null;

			try {
				jedis = this.pool.getResource();
				jedis.setex(this.stringSerializer.serialize(key), expSeconds, this.hessianSerializer.serialize(value));
			} catch (Exception arg9) {
				this.dbLogger.warn(regionName + ":" + key, arg9);
			} finally {
				if (jedis != null) {
					jedis.close();
				}

			}

		}
	}

	public int decrAndGet(String regionName, String key, int by, int def) {
		if (StringUtils.isNotBlank(key)) {
			key = this.getRealKey(regionName, key);
			ShardedJedis jedis = null;

			int e;
			try {
				jedis = this.pool.getResource();
				e = jedis.decrBy(key, (long) by).intValue();
			} catch (Exception arg9) {
				this.dbLogger.warn(regionName + ":" + key, arg9);
				return -1;
			} finally {
				if (jedis != null) {
					jedis.close();
				}

			}

			return e;
		} else {
			return -1;
		}
	}

	public int incrementAndGet(String regionName, String key, int by, int def, int exp) {
		if (StringUtils.isNotBlank(key)) {
			ShardedJedis jedis = null;

			int arg7;
			try {
				key = this.getRealKey(regionName, key);
				jedis = this.pool.getResource();
				int e = jedis.incrBy(key, (long) by).intValue();
				jedis.expire(key, exp);
				arg7 = e;
			} catch (Exception arg11) {
				this.dbLogger.warn(regionName + ":" + key, arg11);
				return -1;
			} finally {
				if (jedis != null) {
					jedis.close();
				}

			}

			return arg7;
		} else {
			return -1;
		}
	}

	public Object get(String regionName, String key) {
		this.getRegionTime(regionName);
		if (StringUtils.isBlank(key)) {
			return null;
		} else {
			key = this.getRealKey(regionName, key);
			ShardedJedis jedis = null;

			try {
				jedis = this.pool.getResource();
				Object e = this.hessianSerializer.deserialize(jedis.get(this.stringSerializer.serialize(key)));
				return e;
			} catch (Exception arg7) {
				this.dbLogger.warn(regionName + ":" + key, arg7);
			} finally {
				if (jedis != null) {
					jedis.close();
				}

			}

			return null;
		}
	}

	public void set(String regionName, String key, Object value) {
		Integer expSeconds = this.getRegionTime(regionName);
		this.set(regionName, key, value, expSeconds.intValue());
	}

	public void remove(String regionName, String key) {
		if (StringUtils.isNotBlank(key)) {
			key = this.getRealKey(regionName, key);
			ShardedJedis jedis = null;

			try {
				jedis = this.pool.getResource();
				jedis.del(this.stringSerializer.serialize(key));
			} catch (Exception arg7) {
				this.dbLogger.warn(regionName + ":" + key, arg7);
			} finally {
				if (jedis != null) {
					jedis.close();
				}

			}
		}

	}

	public boolean isLocal() {
		return false;
	}
}
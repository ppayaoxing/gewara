/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.redis.impl;

import com.gewara.dubbo.bytecode.NoSuchPropertyException;
import com.gewara.dubbo.bytecode.Wrapper;
import com.gewara.support.serializer.HessianRedisSerializer;
import com.gewara.untrans.redis.RedisShardingService;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisShardingServiceImpl implements RedisShardingService {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	@Autowired
	private ShardedJedisPool pool;
	private StringRedisSerializer stringSerializer = new StringRedisSerializer();
	private HessianRedisSerializer hessianSerializer = new HessianRedisSerializer();

	public <T> T getHashMapCache(String key, Class<T> clazz) {
		if (!StringUtils.isBlank(key) && !clazz.isPrimitive()) {
			ShardedJedis jedis = null;
			Object rv = null;

			try {
				rv = clazz.newInstance();
				Wrapper e = Wrapper.getWrapper(clazz);
				jedis = this.pool.getResource();
				Map objMap = jedis.hgetAll(this.stringSerializer.serialize(key));
				Iterator arg6 = objMap.entrySet().iterator();

				while (arg6.hasNext()) {
					Entry entry = (Entry) arg6.next();
					String pk = this.stringSerializer.deserialize((byte[]) entry.getKey());

					try {
						e.setPropertyValue(rv, pk, this.hessianSerializer.deserialize((byte[]) entry.getValue()));
					} catch (NoSuchPropertyException arg14) {
						this.dbLogger.error(arg14, 5);
					}
				}
			} catch (Exception arg15) {
				this.dbLogger.error(arg15, 10);
			} finally {
				if (jedis != null) {
					jedis.close();
				}

			}

			return rv;
		} else {
			return null;
		}
	}

	public <T> void putHashMapCache4All(String key, T obj) {
		if (StringUtils.isNotBlank(key) && obj != null) {
			ShardedJedis jedis = null;

			try {
				jedis = this.pool.getResource();
				jedis.hmset(this.stringSerializer.serialize(key), this.getObjMap(obj));
			} finally {
				if (jedis != null) {
					jedis.close();
				}

			}
		}

	}

	public void putHashMapCache(String key, String fieldName, Object fieldValue) {
		if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(fieldName)) {
			ShardedJedis jedis = null;

			try {
				jedis = this.pool.getResource();
				jedis.hset(this.stringSerializer.serialize(key), this.stringSerializer.serialize(fieldName),
						this.hessianSerializer.serialize(fieldValue));
			} finally {
				if (jedis != null) {
					jedis.close();
				}

			}
		}

	}

	private <T> Map<byte[], byte[]> getObjMap(T obj) {
		HashMap map = new HashMap();
		Wrapper srcWrapper = Wrapper.getWrapper(obj.getClass());
		String[] propStrArr = srcWrapper.getWritePropertyNames();
		String[] arg4 = propStrArr;
		int arg5 = propStrArr.length;

		for (int arg6 = 0; arg6 < arg5; ++arg6) {
			String propStr = arg4[arg6];
			map.put(this.stringSerializer.serialize(propStr),
					this.hessianSerializer.serialize(srcWrapper.getPropertyValue(obj, propStr)));
		}

		return map;
	}

	public <T> void putQueueCache4All(String key, List<T> objs) {
		if (StringUtils.isNotBlank(key) && objs != null && !objs.isEmpty()) {
			ShardedJedis jedis = null;

			try {
				jedis = this.pool.getResource();
				byte[] kb = this.stringSerializer.serialize(key);
				byte[][] objarr = new byte[objs.size()][];

				for (int i = 0; i < objarr.length; ++i) {
					objarr[i] = this.hessianSerializer.serialize(objs.get(i));
				}

				jedis.lpush(kb, objarr);
			} finally {
				if (jedis != null) {
					jedis.close();
				}

			}
		}

	}

	public <T> T pollQueueData(String key) {
		if (StringUtils.isNotBlank(key)) {
			ShardedJedis jedis = null;

			Object arg3;
			try {
				jedis = this.pool.getResource();
				byte[] kb = this.stringSerializer.serialize(key);
				arg3 = this.hessianSerializer.deserialize(jedis.rpop(kb));
			} finally {
				if (jedis != null) {
					jedis.close();
				}

			}

			return arg3;
		} else {
			return null;
		}
	}

	public void putCache(String key, String value) {
		if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
			ShardedJedis jedis = null;

			try {
				jedis = this.pool.getResource();
				jedis.set(key, value);
			} finally {
				if (jedis != null) {
					jedis.close();
				}

			}
		}

	}

	public String getCache(String key) {
		if (StringUtils.isNotBlank(key)) {
			ShardedJedis jedis = null;

			String arg2;
			try {
				jedis = this.pool.getResource();
				arg2 = jedis.get(key);
			} finally {
				if (jedis != null) {
					jedis.close();
				}

			}

			return arg2;
		} else {
			return null;
		}
	}

	public <T> Boolean putHashMapCache4AllNotExist(String key, T obj) {
		if (StringUtils.isNotBlank(key) && obj != null) {
			ShardedJedis jedis = null;

			try {
				jedis = this.pool.getResource();
				if (!jedis.exists(key).booleanValue()) {
					jedis.hmset(this.stringSerializer.serialize(key), this.getObjMap(obj));
					Boolean arg3 = Boolean.valueOf(true);
					return arg3;
				}
			} finally {
				if (jedis != null) {
					jedis.close();
				}

			}
		}

		return Boolean.valueOf(false);
	}

	public void delCache(String key) {
		if (StringUtils.isNotBlank(key)) {
			ShardedJedis jedis = null;

			try {
				jedis = this.pool.getResource();
				jedis.del(key);
			} finally {
				if (jedis != null) {
					jedis.close();
				}

			}
		}

	}

	public void expireCache(String key, int seconds) {
		if (StringUtils.isNotBlank(key) && seconds > 0) {
			ShardedJedis jedis = null;

			try {
				jedis = this.pool.getResource();
				jedis.expire(key, seconds);
			} finally {
				if (jedis != null) {
					jedis.close();
				}

			}
		}

	}
}
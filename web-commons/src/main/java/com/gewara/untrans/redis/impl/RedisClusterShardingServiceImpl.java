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
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.StringRedisSerializer;

public class RedisClusterShardingServiceImpl implements RedisShardingService {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private RedisConnectionFactory redisConnectionFactory;
	private StringRedisSerializer stringSerializer = new StringRedisSerializer();
	private HessianRedisSerializer hessianSerializer = new HessianRedisSerializer();

	public void setRedisConnectionFactory(RedisConnectionFactory redisConnectionFactory) {
		this.redisConnectionFactory = redisConnectionFactory;
	}

	public <T> T getHashMapCache(String key, Class<T> clazz) {
		if (!StringUtils.isBlank(key) && !clazz.isPrimitive()) {
			Object rv = null;

			try {
				rv = clazz.newInstance();
				Wrapper e = Wrapper.getWrapper(clazz);
				RedisClusterConnection clusterConn = this.redisConnectionFactory.getClusterConnection();
				Map objMap = clusterConn.hGetAll(this.stringSerializer.serialize(key));
				Iterator arg6 = objMap.entrySet().iterator();

				while (arg6.hasNext()) {
					Entry entry = (Entry) arg6.next();
					String pk = this.stringSerializer.deserialize((byte[]) entry.getKey());

					try {
						e.setPropertyValue(rv, pk, this.hessianSerializer.deserialize((byte[]) entry.getValue()));
					} catch (NoSuchPropertyException arg10) {
						this.dbLogger.error(arg10, 5);
					}
				}
			} catch (Exception arg11) {
				this.dbLogger.error(arg11, 10);
			}

			return rv;
		} else {
			return null;
		}
	}

	public <T> void putHashMapCache4All(String key, T obj) {
		if (StringUtils.isNotBlank(key) && obj != null) {
			try {
				RedisClusterConnection e = this.redisConnectionFactory.getClusterConnection();
				e.hMSet(this.stringSerializer.serialize(key), this.getObjMap(obj));
			} catch (Exception arg3) {
				this.dbLogger.error(arg3, 10);
			}
		}

	}

	public void putHashMapCache(String key, String fieldName, Object fieldValue) {
		if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(fieldName)) {
			try {
				RedisClusterConnection e = this.redisConnectionFactory.getClusterConnection();
				e.hSet(this.stringSerializer.serialize(key), this.stringSerializer.serialize(fieldName),
						this.hessianSerializer.serialize(fieldValue));
			} catch (Exception arg4) {
				this.dbLogger.error(arg4, 10);
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
			try {
				byte[] e = this.stringSerializer.serialize(key);
				byte[][] objarr = new byte[objs.size()][];

				for (int clusterConn = 0; clusterConn < objarr.length; ++clusterConn) {
					objarr[clusterConn] = this.hessianSerializer.serialize(objs.get(clusterConn));
				}

				RedisClusterConnection arg6 = this.redisConnectionFactory.getClusterConnection();
				arg6.lPush(e, objarr);
			} catch (Exception arg5) {
				this.dbLogger.error(arg5, 10);
			}
		}

	}

	public <T> T pollQueueData(String key) {
		if (StringUtils.isNotBlank(key)) {
			try {
				RedisClusterConnection e = this.redisConnectionFactory.getClusterConnection();
				byte[] kb = this.stringSerializer.serialize(key);
				return this.hessianSerializer.deserialize(e.rPop(kb));
			} catch (Exception arg3) {
				this.dbLogger.error(arg3, 10);
			}
		}

		return null;
	}

	public void putCache(String key, String value) {
		if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
			try {
				RedisClusterConnection e = this.redisConnectionFactory.getClusterConnection();
				e.set(this.stringSerializer.serialize(key), this.stringSerializer.serialize(value));
			} catch (Exception arg3) {
				this.dbLogger.error(arg3, 10);
			}
		}

	}

	public String getCache(String key) {
		if (StringUtils.isNotBlank(key)) {
			try {
				RedisClusterConnection e = this.redisConnectionFactory.getClusterConnection();
				return this.stringSerializer.deserialize(e.get(this.stringSerializer.serialize(key)));
			} catch (Exception arg2) {
				this.dbLogger.error(arg2, 10);
			}
		}

		return null;
	}

	public <T> Boolean putHashMapCache4AllNotExist(String key, T obj) {
		if (StringUtils.isNotBlank(key) && obj != null) {
			try {
				byte[] e = this.stringSerializer.serialize(key);
				RedisClusterConnection clusterConn = this.redisConnectionFactory.getClusterConnection();
				if (!clusterConn.exists(e).booleanValue()) {
					clusterConn.hMSet(this.stringSerializer.serialize(key), this.getObjMap(obj));
					return Boolean.valueOf(true);
				}
			} catch (Exception arg4) {
				this.dbLogger.error(arg4, 10);
			}
		}

		return Boolean.valueOf(false);
	}

	public void delCache(String key) {
		if (StringUtils.isNotBlank(key)) {
			try {
				RedisClusterConnection e = this.redisConnectionFactory.getClusterConnection();
				e.del(new byte[][]{this.stringSerializer.serialize(key)});
			} catch (Exception arg2) {
				this.dbLogger.error(arg2, 10);
			}
		}

	}

	public void expireCache(String key, int seconds) {
		if (StringUtils.isNotBlank(key) && seconds > 0) {
			try {
				RedisClusterConnection e = this.redisConnectionFactory.getClusterConnection();
				e.expire(this.stringSerializer.serialize(key), (long) seconds);
			} catch (Exception arg3) {
				this.dbLogger.error(arg3, 10);
			}
		}

	}
}
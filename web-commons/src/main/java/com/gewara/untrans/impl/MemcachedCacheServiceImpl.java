/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.support.CachePair;
import com.gewara.untrans.impl.AbstractCacheService;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.spy.memcached.CASResponse;
import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemcachedCacheServiceImpl extends AbstractCacheService {
	@Autowired
	@Qualifier("memcachedClient")
	private MemcachedClient memcachedClient;

	public void set(String regionName, String key, Object value) {
		Integer expSeconds = this.getRegionTime(regionName);
		this.set(regionName, key, value, expSeconds.intValue());
	}

	public void set(String regionName, String key, Object value, int expSeconds) {
		if (!StringUtils.isBlank(key) && value != null) {
			key = this.getRealKey(regionName, key);

			try {
				this.memcachedClient.set(key, expSeconds, value);
			} catch (Exception arg5) {
				this.dbLogger.warn(regionName + ":" + key, arg5);
			}

		}
	}

	public Object get(String regionName, String key) {
		this.getRegionTime(regionName);
		if (StringUtils.isBlank(key)) {
			return null;
		} else {
			key = this.getRealKey(regionName, key);

			try {
				return this.memcachedClient.get(key);
			} catch (Exception arg3) {
				this.dbLogger.warn(regionName + ":" + key, arg3);
				return null;
			}
		}
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
				Map e1 = this.memcachedClient.getBulk(keyMap.keySet());
				HashMap returnMap1 = new HashMap();
				Iterator newkey2 = e1.keySet().iterator();

				while (newkey2.hasNext()) {
					String newkey1 = (String) newkey2.next();
					returnMap1.put(keyMap.get(newkey1), e1.get(newkey1));
				}

				return returnMap1;
			} catch (Exception arg7) {
				this.dbLogger.warn(regionName + ":" + keys, arg7);
				return null;
			}
		} else {
			return null;
		}
	}

	public void remove(String regionName, String key) {
		if (StringUtils.isNotBlank(key)) {
			key = this.getRealKey(regionName, key);
			this.memcachedClient.delete(key).getStatus().isSuccess();
		}

	}

	public int incrementAndGet(String regionName, String key, int by, int def) {
		Integer expSeconds = this.getRegionTime(regionName);
		return this.incrementAndGet(regionName, key, by, def, expSeconds.intValue());
	}

	public int incrementAndGet(String regionName, String key, int by, int def, int exp) {
		if (StringUtils.isNotBlank(key)) {
			try {
				key = this.getRealKey(regionName, key);
				return (int) this.memcachedClient.incr(key, by, (long) def, exp);
			} catch (Exception arg6) {
				this.dbLogger.warn("", arg6);
			}
		}

		return -1;
	}

	public int decrAndGet(String regionName, String key, int by, int def) {
		if (StringUtils.isNotBlank(key)) {
			key = this.getRealKey(regionName, key);
			return (int) this.memcachedClient.decr(key, by, (long) def);
		} else {
			return -1;
		}
	}

	public CachePair getCachePair(String regionName, String key) {
		if (StringUtils.isBlank(key)) {
			return null;
		} else {
			try {
				key = this.getRealKey(regionName, key);
				CASValue e = this.memcachedClient.gets(key);
				if (e != null) {
					CachePair pair = new CachePair();
					pair.setValue(e.getValue());
					pair.setVersion(Long.valueOf(e.getCas()));
					return pair;
				}
			} catch (Exception arg4) {
				this.dbLogger.warn("", arg4);
			}

			return null;
		}
	}

	public boolean setCachePair(String regionName, String key, long version, Object value, int expSeconds) {
		if (!StringUtils.isBlank(key) && value != null) {
			key = this.getRealKey(regionName, key);

			try {
				CASResponse e = this.memcachedClient.cas(key, version, expSeconds, value);
				return e == CASResponse.OK;
			} catch (Exception arg7) {
				this.dbLogger.warn("", arg7);
				return false;
			}
		} else {
			return false;
		}
	}

	public void add(String regionName, String key, Object value, int expSeconds) {
		if (!StringUtils.isBlank(key) && value != null) {
			key = this.getRealKey(regionName, key);

			try {
				this.memcachedClient.add(key, expSeconds, value);
			} catch (Exception arg5) {
				this.dbLogger.warn("", arg5);
			}

		}
	}

	public boolean isLocal() {
		return false;
	}
}
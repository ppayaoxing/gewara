/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.Config;
import com.gewara.support.TraceErrorException;
import com.gewara.untrans.CacheConfigure;
import com.gewara.untrans.CacheService;
import com.gewara.util.Assert;
import com.gewara.util.GewaLogger;
import com.gewara.util.StringUtil;
import com.gewara.util.WebLogger;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;

public abstract class AbstractCacheService implements CacheService, InitializingBean {
	protected final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	protected Map<String, String> regionVersion = new HashMap();
	protected CacheConfigure cacheConfigure;
	protected Map<String, Integer> regionTimeMap = new HashMap();

	public void setRegionTimeMap(Map<String, Integer> regionTimeMap) {
		this.regionTimeMap = regionTimeMap;
	}

	public void setCacheConfigure(CacheConfigure cacheConfigure) {
		this.cacheConfigure = cacheConfigure;
	}

	protected String getRealKey(String regionName, String key) {
		String result = this.getKeyPre(regionName) + key;
		if (result.length() > 50) {
			if (result.length() > 128) {
				this.dbLogger.warn("keyTooLong2Md5:" + result);
			}

			result = Config.SYSTEMID + "md5" + StringUtil.md5(result);
		}

		return result;
	}

	protected String getKeyPre(String regionName) {
		return regionName + StringUtils.defaultIfBlank((String) this.regionVersion.get(regionName), ":") + "@"
				+ Config.SYSTEMID;
	}

	protected Integer getRegionTime(String regionName) {
		Integer time = this.getCacheTime(regionName);
		if (time == null) {
			throw new TraceErrorException("region error!");
		} else {
			return time;
		}
	}

	public void updateValue(String regionName, String key, String newvalue) {
		Object value = this.get(regionName, key);
		if (value != null) {
			this.set(regionName, key, newvalue);
		}
	}

	public void refreshVersion() {
		this.regionVersion = this.cacheConfigure.getRegionVersion();
	}

	public void afterPropertiesSet() throws Exception {
		Assert.notNull(this.cacheConfigure);
		this.refreshVersion();
		Assert.notNull(this.regionTimeMap);
		if (!this.regionTimeMap.containsKey("loginAuth")) {
			this.regionTimeMap.put("loginAuth", Integer.valueOf(7200));
		}

		this.regionTimeMap.put("tenMin", Integer.valueOf(600));
		this.regionTimeMap.put("oneHour", Integer.valueOf(3600));
		this.regionTimeMap.put("service", Integer.valueOf('ꣀ'));
		this.regionTimeMap.put("fiveDay", Integer.valueOf(432000));
	}

	public Integer getCacheTime(String regionName) {
		return (Integer) this.regionTimeMap.get(regionName);
	}

	public int incr(String regionName, String key, int by, int defvalue) {
		if (StringUtils.isNotBlank(key)) {
			Integer result = (Integer) this.get(regionName, key);
			if (result == null) {
				result = Integer.valueOf(defvalue);
			} else {
				result = Integer.valueOf(result.intValue() + by);
			}

			this.set(regionName, key, result);
			return result.intValue();
		} else {
			return 0;
		}
	}
}
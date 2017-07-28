/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.untrans.CacheService;
import com.gewara.untrans.CacheTools;
import com.gewara.util.Gcache;
import com.gewara.util.StringUtil;
import java.util.concurrent.atomic.AtomicInteger;

public class LocalCacheTools implements CacheTools {
	private Gcache<String, Object> cachedUkeyMap;
	private CacheService cacheService;
	private AtomicInteger remoteHit = new AtomicInteger(0);

	public LocalCacheTools(int maxnum, CacheService cacheService) {
		this.cachedUkeyMap = new Gcache((long) maxnum);
		this.cacheService = cacheService;
	}

	private String getRealKey(String regionName, String key) {
		String result = regionName + key;
		if (result.length() > 128) {
			result = "md5" + StringUtil.md5(key);
		}

		return result;
	}

	public Object get(String regionName, String key) {
		String realKey = this.getRealKey(regionName, key);
		Object result = this.cachedUkeyMap.getIfPresent(realKey);
		if (result == null) {
			result = this.cacheService.get(regionName, key);
			if (result != null) {
				this.remoteHit.incrementAndGet();
				this.cachedUkeyMap.put(realKey, result);
			}
		}

		return result;
	}

	public void set(String regionName, String key, Object value) {
		this.cachedUkeyMap.put(this.getRealKey(regionName, key), value);
		this.cacheService.set(regionName, key, value);
	}

	public void remove(String regionName, String key) {
		this.cachedUkeyMap.invalidate(this.getRealKey(regionName, key));
		this.cacheService.remove(regionName, key);
	}

	public boolean isLocal() {
		return true;
	}

	public int getRemoteHit() {
		return this.remoteHit.get();
	}
}
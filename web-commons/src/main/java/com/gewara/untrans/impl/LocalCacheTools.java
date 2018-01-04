package com.gewara.untrans.impl;

import java.util.concurrent.atomic.AtomicInteger;

import com.gewara.untrans.CacheService;
import com.gewara.untrans.CacheTools;
import com.gewara.util.Gcache;
import com.gewara.util.StringUtil;

/**
 * @author ge.biao
 * 浣跨敤鏈湴缂撳瓨鍋氫竴灞備唬鐞嗭紝浣跨敤闆嗕腑缂撳瓨鍋氭暟鎹鐑�
 */
public class LocalCacheTools implements CacheTools{
	private Gcache<String/*key*/, Object> cachedUkeyMap;
	private CacheService cacheService;
	private AtomicInteger remoteHit = new AtomicInteger(0);
	public LocalCacheTools(int maxnum, CacheService cacheService){
		cachedUkeyMap = new Gcache<String, Object>(maxnum);
		this.cacheService = cacheService;
	}
	
	private String getRealKey(String regionName, String key){
		String result = regionName + key;
		if(result.length()>128){
			result = "md5" + StringUtil.md5(key);
		}
		return result;
	}


	@Override
    public Object get(String regionName, String key) {
		String realKey = getRealKey(regionName, key);
		Object result = cachedUkeyMap.getIfPresent(realKey);
		if(result == null){
			result = cacheService.get(regionName, key);
			if(result!=null){
				remoteHit.incrementAndGet();
				cachedUkeyMap.put(realKey, result);
			}
		}
		return result;
	}

	@Override
    public void set(String regionName, String key, Object value) {
		cachedUkeyMap.put(getRealKey(regionName, key), value);
		cacheService.set(regionName, key, value);
	}

	@Override
    public void remove(String regionName, String key) {
		cachedUkeyMap.invalidate(getRealKey(regionName, key));
		cacheService.remove(regionName, key);
	}

	@Override
	public boolean isLocal() {
		return true;
	}

	public int getRemoteHit() {
		return remoteHit.get();
	}

}

package com.gewara.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gewara.untrans.CacheService;

/**
 * TODO 待定
 * 
 * @author sunder
 * 
 */
@Service
public class CachableServiceHelper {

	// public ? cacheCall(String key, int secondsTwentymin, CachableCall<?
	// extends BaseObject> cachableCall);

	@Autowired
	private CacheService cacheService;
	private String serviceName; // service 名称
	private String dispatchServiceName; // 调度service名

	/**
	 * 清除缓存
	 * 
	 * @param key
	 */
	public void clearCache(String key) {
		// TODO 待定
		cacheService.remove(dispatchServiceName, key);
	}

	/**
	 * 获取缓存
	 * 
	 * @param key
	 * @param secondsTwentymin
	 * @param cachableCall
	 * @return
	 */
	public <T> T cacheCall(String key, int secondsTwentymin, CachableCall<T> cachableCall) {
		// TODO 待定
		T t = cachableCall.call();
		cacheService.add(serviceName, key, t, secondsTwentymin);
		return t;
	}

	public CachableServiceHelper(String serviceName, String dispatchServiceName, CacheService cacheService) {
		super();
		this.cacheService = cacheService;
		this.serviceName = serviceName;
		this.dispatchServiceName = dispatchServiceName;
	}

	public CachableServiceHelper() {
		super();
	}

	public CacheService getCacheService() {
		return cacheService;
	}

	public String getServiceName() {
		return serviceName;
	}

	public String getDispatchServiceName() {
		return dispatchServiceName;
	}

	public void setCacheService(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public void setDispatchServiceName(String dispatchServiceName) {
		this.dispatchServiceName = dispatchServiceName;
	}

	//
	// List<T extends BaseObject> cacheCall(String key, int secondsOpenseat,
	// CachableCall<List<T extends BaseObject>> cachableCall);
	//
	// List<OpenSeat> cacheCall(String key, int secondsOpenseat,
	// CachableCall<List<OpenSeat>> cachableCall);

}

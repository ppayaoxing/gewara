package com.gewara.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gewara.untrans.CacheService;

/**
 * TODO 寰呭畾
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
	private String serviceName; // service 鍚嶇О
	private String dispatchServiceName; // 璋冨害service鍚�

	/**
	 * 娓呴櫎缂撳瓨
	 * 
	 * @param key
	 */
	public void clearCache(String key) {
		// TODO 寰呭畾
		cacheService.remove(dispatchServiceName, key);
	}

	/**
	 * 鑾峰彇缂撳瓨
	 * 
	 * @param key
	 * @param secondsTwentymin
	 * @param cachableCall
	 * @return
	 */
	public <T> T cacheCall(String key, int secondsTwentymin, CachableCall<T> cachableCall) {
		// TODO 寰呭畾
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

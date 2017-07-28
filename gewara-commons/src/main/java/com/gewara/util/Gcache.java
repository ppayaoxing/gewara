/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.support.LocalCachable;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheStats;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Gcache<K, V> implements Cache<K, V>, Serializable {
	private static final long serialVersionUID = -231460062536441961L;
	private long starttime = System.currentTimeMillis();
	private Cache<K, V> cache;
	private CacheStats startCacheStats;

	public Gcache(long maxinumSize) {
		int concurrency = Math.min(64, Math.max(16, (int) (maxinumSize / 1000L)));
		this.cache = CacheBuilder.newBuilder().maximumSize(maxinumSize).concurrencyLevel(concurrency).recordStats()
				.build();
		this.startCacheStats = this.cache.stats();
	}

	public Gcache(long maxinumSize, long duration, TimeUnit unit) {
		int concurrency = Math.min(64, Math.max(16, (int) (maxinumSize / 1000L)));
		this.cache = CacheBuilder.newBuilder().maximumSize(maxinumSize).concurrencyLevel(concurrency)
				.expireAfterWrite(duration, unit).recordStats().build();
		this.startCacheStats = this.cache.stats();
	}

	public V getIfPresent(Object key) {
		return this.cache.getIfPresent(key);
	}

	public V get(K key, Callable<? extends V> valueLoader) throws ExecutionException {
		throw new UnsupportedOperationException();
	}

	public ImmutableMap getAllPresent(Iterable keys) {
		return this.cache.getAllPresent(keys);
	}

	public void put(K key, V value) {
		if (value instanceof LocalCachable) {
			((LocalCachable) value).fix2Cache();
		}

		this.cache.put(key, value);
	}

	public void putAll(Map<? extends K, ? extends V> m) {
		Iterator arg1 = m.entrySet().iterator();

		while (arg1.hasNext()) {
			Entry entry = (Entry) arg1.next();
			if (entry.getValue() != null && entry.getValue() instanceof LocalCachable) {
				((LocalCachable) entry.getValue()).fix2Cache();
			}
		}

		this.cache.putAll(m);
	}

	public void invalidate(Object key) {
		this.cache.invalidate(key);
	}

	public void invalidateAll(Iterable<?> keys) {
		this.cache.invalidateAll(keys);
	}

	public void invalidateAll() {
		this.cache.invalidateAll();
	}

	public long size() {
		return this.cache.size();
	}

	public CacheStats stats() {
		return this.cache.stats();
	}

	public ConcurrentMap<K, V> asMap() {
		return this.cache.asMap();
	}

	public void cleanUp() {
		this.cache.cleanUp();
	}

	public long getStarttime() {
		return this.starttime;
	}

	public CacheStats getStartCacheStats() {
		return this.startCacheStats;
	}

	public void resetCacheStats(CacheStats cacheStats) {
		this.startCacheStats = cacheStats;
		this.starttime = System.currentTimeMillis();
	}
}
/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.support.CacheElement;
import com.gewara.support.GewaExecutorThreadFactory;
import com.gewara.untrans.CacheTools;
import com.gewara.untrans.impl.LocalCacheTools;
import com.gewara.util.CachableCall;
import com.gewara.util.DateUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.ServiceCacheHelper;
import com.gewara.util.WebLogger;
import com.gewara.web.support.ResourceStatsUtil;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ServiceCacheHelperImpl implements ServiceCacheHelper {
	private GewaLogger dbLogger;
	private String serviceName;
	private int maxKeyCount;
	private String keyPre;
	private long validtime;
	private WriteLock[] lockList;
	private ThreadPoolExecutor executor;
	private Long starttime;
	private AtomicInteger hit;
	private AtomicInteger miss;
	private AtomicInteger expireHit;
	private CacheTools cacheTools;

	public boolean isLocal() {
		return this.cacheTools.isLocal();
	}

	public ServiceCacheHelperImpl(Class service, CacheTools cacheTools) {
		this(service.getSimpleName(), cacheTools);
	}

	public ServiceCacheHelperImpl(String classSimpleName, CacheTools cacheTools) {
		this.dbLogger = WebLogger.getLogger(this.getClass());
		this.maxKeyCount = 131072;
		this.validtime = System.currentTimeMillis() - 86400000L;
		this.lockList = new WriteLock[this.maxKeyCount];
		this.starttime = Long.valueOf(System.currentTimeMillis());
		this.hit = new AtomicInteger(0);
		this.miss = new AtomicInteger(0);
		this.expireHit = new AtomicInteger(0);
		this.cacheTools = cacheTools;
		this.serviceName = classSimpleName;
		this.keyPre = this.serviceName;

		for (int taskQueue = 0; taskQueue < this.maxKeyCount; ++taskQueue) {
			this.lockList[taskQueue] = (new ReentrantReadWriteLock()).writeLock();
		}

		LinkedBlockingQueue arg3 = new LinkedBlockingQueue();
		this.executor = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.SECONDS, arg3,
				new GewaExecutorThreadFactory("CachableServiceHelper-" + this.serviceName));
		this.executor.allowCoreThreadTimeOut(false);
		ResourceStatsUtil.addServiceCacheHelper(this);
	}

	public void replaceCacheTools(CacheTools tools) {
		this.cacheTools = tools;
	}

	private void updateMiss() {
		this.miss.incrementAndGet();
	}

	private void updateHit() {
		this.hit.incrementAndGet();
	}

	private void updateExpireHit() {
		this.expireHit.incrementAndGet();
	}

	public Map getStats() {
		int h = this.hit.get();
		int m = this.miss.get();
		int e = this.expireHit.get();
		if (h + m + e > 10) {
			long t = System.currentTimeMillis();
			LinkedHashMap stats = new LinkedHashMap();
			stats.put("hit", Integer.valueOf(h));
			stats.put("miss", Integer.valueOf(m));
			stats.put("expireHit", Integer.valueOf(e));
			stats.put("service", this.serviceName);
			stats.put("starttime", new Timestamp(this.starttime.longValue()));
			stats.put("endtime", new Timestamp(t));
			if (this.cacheTools instanceof LocalCacheTools) {
				stats.put("remoteHit", Integer.valueOf(((LocalCacheTools) this.cacheTools).getRemoteHit()));
			}

			return stats;
		} else {
			return null;
		}
	}

	public Map getAndResetStats() {
		int h = this.hit.get();
		int m = this.miss.get();
		int e = this.expireHit.get();
		long t = System.currentTimeMillis();
		if (h + m + e <= 1000 && t - this.starttime.longValue() <= 3600000L) {
			return null;
		} else {
			HashMap stats = new HashMap();
			stats.put("hit", Integer.valueOf(h));
			stats.put("miss", Integer.valueOf(m));
			stats.put("expireHit", Integer.valueOf(e));
			stats.put("service", this.serviceName);
			stats.put("starttime", new Timestamp(this.starttime.longValue()));
			stats.put("endtime", new Timestamp(t));
			this.hit.addAndGet(-h);
			this.miss.addAndGet(-m);
			this.expireHit.addAndGet(-e);
			this.starttime = Long.valueOf(t);
			return stats;
		}
	}

	public <T> T cacheCall(Integer cacheSeconds, CachableCall<T> call, String ukey, Object... params) {
		String key = buildKey(ukey, params);
		CacheElement result = (CacheElement) this.cacheTools.get("service", this.getCacheKey(key));
		if (result == null) {
			result = this.sychCall(key, call, cacheSeconds, false);
		} else if (result.getValidtime().longValue() >= System.currentTimeMillis()
				&& result.getUpdatetime().longValue() >= this.validtime) {
			this.updateHit();
		} else {
			this.executor.execute(new ServiceCacheHelperImpl.AsynchCallTask(key, cacheSeconds, call, false));
			this.updateExpireHit();
		}

		return result == null ? null : result.getValue();
	}

	public <T> T cacheCallRefresh(Integer cacheSeconds, CachableCall<T> call, String ukey, boolean forceRefresh,
			Object... params) {
		String key = buildKey(ukey, params);
		CacheElement result = (CacheElement) this.cacheTools.get("service", this.getCacheKey(key));
		if (result == null) {
			result = this.sychCall(key, call, cacheSeconds, false);
		} else if (result.getValidtime().longValue() >= System.currentTimeMillis() && !forceRefresh
				&& result.getUpdatetime() != null && result.getUpdatetime().longValue() >= this.validtime) {
			this.updateHit();
		} else {
			this.executor.execute(new ServiceCacheHelperImpl.AsynchCallTask(key, cacheSeconds, call, forceRefresh));
			this.updateExpireHit();
		}

		return result == null ? null : result.getValue();
	}

	private <T> CacheElement<T> sychCall(String key, CachableCall<T> call, Integer cacheSeconds, boolean forceRefresh) {
		WriteLock lock = this.lockList[this.getLockKey(key)];
		CacheElement result = null;
		boolean locked = false;

		try {
			try {
				locked = lock.tryLock(15L, TimeUnit.SECONDS);
				if (!forceRefresh) {
					result = (CacheElement) this.cacheTools.get("service", this.getCacheKey(key));
					if (result != null && result.getValidtime().longValue() > System.currentTimeMillis()
							&& result.getUpdatetime().longValue() > this.validtime) {
						this.updateHit();
						CacheElement e1 = result;
						return e1;
					}
				}

				this.updateMiss();
				Object e = call.call();
				if (e != null) {
					result = new CacheElement(e, cacheSeconds);
					this.cacheTools.set("service", this.getCacheKey(key), result);
					return result;
				}
			} catch (InterruptedException arg11) {
				this.dbLogger.warn(arg11, 20);
			}

			return result;
		} finally {
			if (locked) {
				lock.unlock();
			}

		}
	}

	public static String buildKey(String ukey, Object... params) {
		String key = ukey;
		Object[] arg2 = params;
		int arg3 = params.length;

		for (int arg4 = 0; arg4 < arg3; ++arg4) {
			Object p = arg2[arg4];
			String v = null;
			if (p != null) {
				if (p instanceof Timestamp) {
					v = DateUtil.format((Timestamp) p, "yyyyMMddHHmmss");
				} else if (p instanceof Date) {
					v = DateUtil.format((Date) p, "yyyyMMdd");
				} else {
					v = "" + p;
				}
			}

			key = key + v + "|";
		}

		return key;
	}

	public void updateCache(Object value, Integer cacheSeconds, String ukey, Object... params) {
		String key = buildKey(ukey, params);
		CacheElement result = new CacheElement(value, cacheSeconds);
		this.cacheTools.set("service", this.getCacheKey(key), result);
	}

	public void clearCache(String key) {
		this.cacheTools.remove("service", this.getCacheKey(key));
	}

	private String getCacheKey(String key) {
		return this.keyPre + key + "X";
	}

	private int getLockKey(String key) {
		int cont = Math.abs(key.hashCode());
		if (cont < 0) {
			cont = Math.abs(cont + 1);
		}

		return cont % this.maxKeyCount;
	}

	public String getKeyPre() {
		return this.keyPre;
	}

	public void setKeyPre(String keyPre) {
		this.keyPre = keyPre;
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public void startClear() {
		this.validtime = System.currentTimeMillis();
	}

	public Timestamp getStarttime() {
		return new Timestamp(this.starttime.longValue());
	}

	public Timestamp getValidtime() {
		return new Timestamp(this.validtime);
	}

	public Integer getHit() {
		return Integer.valueOf(this.hit.get());
	}

	public Integer getMiss() {
		return Integer.valueOf(this.miss.get());
	}

	public Integer getExpireHit() {
		return Integer.valueOf(this.expireHit.get());
	}

	private class AsynchCallTask<S> implements Runnable {
		private String key;
		private Integer cacheSeconds;
		private CachableCall<S> call;
		private boolean forceRefresh;

		public AsynchCallTask(String arg0, Integer key, CachableCall<S> cacheSeconds, boolean call) {
			this.forceRefresh = forceRefresh;
			this.key = key;
			this.cacheSeconds = cacheSeconds;
			this.call = call;
		}

		public void run() {
			try {
				ServiceCacheHelperImpl.this.sychCall(this.key, this.call, this.cacheSeconds, this.forceRefresh);
			} catch (Throwable arg1) {
				ServiceCacheHelperImpl.this.dbLogger.warn(arg1, 100);
			}

		}
	}
}
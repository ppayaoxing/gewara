package com.gewara.untrans.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import com.gewara.support.CacheElement;
import com.gewara.support.GewaExecutorThreadFactory;
import com.gewara.untrans.CacheService;
import com.gewara.untrans.CacheTools;
import com.gewara.util.CachableCall;
import com.gewara.util.DateUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.ServiceCacheHelper;
import com.gewara.util.WebLogger;
import com.gewara.web.support.ResourceStatsUtil;

/**
 * Service�������棬ÿ��Serviceһ��
 * @author gebiao(ge.biao@gewara.com)
 * @since Nov 5, 2013 10:25:21 PM
 */
public class ServiceCacheHelperImpl implements ServiceCacheHelper {
	private GewaLogger dbLogger = WebLogger.getLogger(getClass());
	//private CacheService cacheService;
	private String serviceName;
	private int maxKeyCount = 131072;//2^18,128k
	private String keyPre;
	private long validtime = System.currentTimeMillis() - DateUtil.m_day;//��Чʱ�䣬��������������
	private WriteLock[] lockList = new WriteLock[maxKeyCount];
	//��������pre
	//private Map<String, String> ukeyMap = new ConcurrentHashMap<String, String>();
	private ThreadPoolExecutor executor/*�첽�����߳�*/;
	private Long starttime = System.currentTimeMillis();
	private AtomicInteger hit = new AtomicInteger(0);
	private AtomicInteger miss = new AtomicInteger(0);
	private AtomicInteger expireHit = new AtomicInteger(0);
	private CacheTools cacheTools;
	@Override
	public boolean isLocal() {
		return cacheTools.isLocal();
	}

	public ServiceCacheHelperImpl(Class service, CacheTools cacheTools){
		this(service.getSimpleName(), cacheTools);
	}
	public ServiceCacheHelperImpl(String classSimpleName, CacheTools cacheTools){
		this.cacheTools = cacheTools;
		this.serviceName = classSimpleName;
		this.keyPre = serviceName;
		for(int i=0; i< maxKeyCount; i++){
			lockList[i] = new ReentrantReadWriteLock().writeLock();
		}
		BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<Runnable>();
		executor = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.SECONDS, taskQueue, new GewaExecutorThreadFactory("CachableServiceHelper-"+serviceName));
		executor.allowCoreThreadTimeOut(false);
		ResourceStatsUtil.addServiceCacheHelper(this);
	}
	public void replaceCacheTools(CacheTools tools){
		this.cacheTools = tools;
	}
	
	private void updateMiss(){
		miss.incrementAndGet();
	}
	private void updateHit(){
		hit.incrementAndGet();
	}
	private void updateExpireHit(){
		expireHit.incrementAndGet();
	}
	@Override
    public Map getStats(){
		int h = hit.get();
		int m = miss.get();
		int e = expireHit.get();
		if(h + m + e > 10){
			long t = System.currentTimeMillis();
			Map stats = new LinkedHashMap();
			stats.put("hit", h);
			stats.put("miss", m);
			stats.put("expireHit", e);
			stats.put("service", serviceName);
			stats.put("starttime", new Timestamp(starttime));
			stats.put("endtime", new Timestamp(t));
			if(cacheTools instanceof LocalCacheTools){
				stats.put("remoteHit", ((LocalCacheTools)cacheTools).getRemoteHit());
			}
			return stats;
		}
		return null;
	}
	@Override
    public Map getAndResetStats(){
		int h = hit.get();
		int m = miss.get();
		int e = expireHit.get();
		long t = System.currentTimeMillis();
		if(h + m + e > 1000 || t - starttime>DateUtil.m_hour){
			Map stats = new HashMap();
			stats.put("hit", h);
			stats.put("miss", m);
			stats.put("expireHit", e);
			stats.put("service", serviceName);
			stats.put("starttime", new Timestamp(starttime));
			stats.put("endtime", new Timestamp(t));

			hit.addAndGet(-h);
			miss.addAndGet(-m);
			expireHit.addAndGet(-e);
			starttime = t;

			return stats;
		}
		return null;
	}
	
	/**
	 * ����Ҫͬ��
	 * @param key
	 * @param call
	 * @param cacheSeconds:����ʱ��
	 * @return
	 */
	@Override
    public <T> T cacheCall(Integer cacheSeconds, CachableCall<T> call, String ukey, Object...params) {
		String key = buildKey(ukey, params);
		CacheElement<T> result = (CacheElement<T>) cacheTools.get(CacheService.REGION_SERVICE, getCacheKey(key));
		if(result==null){//�ǿս��
			result = sychCall(key, call, cacheSeconds, false);
		}else{
			if(result.getValidtime() < System.currentTimeMillis() || result.getUpdatetime() < validtime){
				//�����첽���£����Ƿ����ϵ�ֵ
				executor.execute(new AsynchCallTask(key, cacheSeconds, call, false) );
				updateExpireHit();
			}else{
				updateHit();
			}
		}
		return result==null ? null:result.getValue();
	}
	@Override
    public <T> T cacheCallRefresh(Integer cacheSeconds, CachableCall<T> call, String ukey, boolean forceRefresh, Object...params) {
		String key = buildKey(ukey, params);
		CacheElement<T> result = (CacheElement<T>) cacheTools.get(CacheService.REGION_SERVICE, getCacheKey(key));
		if(result==null){//�ǿս��
			result = sychCall(key, call, cacheSeconds, false);
		}else{
			if(result.getValidtime() < System.currentTimeMillis() || forceRefresh || result.getUpdatetime()==null || result.getUpdatetime() < validtime){
				//�����첽���£����Ƿ����ϵ�ֵ
				executor.execute(new AsynchCallTask(key, cacheSeconds, call, forceRefresh) );
				updateExpireHit();
			}else{
				updateHit();
			}
		}
		return result==null ? null:result.getValue();
	}
	private <T> CacheElement<T> sychCall(String key, CachableCall<T> call, Integer cacheSeconds, boolean forceRefresh){
		WriteLock lock = lockList[getLockKey(key)];
		CacheElement<T> result = null;
		boolean locked = false;
		try{
			//�����Ƿ�������������ִ�У��˴�ֻ���ô�����������̵ȴ�һ���
			locked = lock.tryLock(15, TimeUnit.SECONDS);
			if(!forceRefresh){
				//�ٴμ��
				result = (CacheElement<T>) cacheTools.get(CacheService.REGION_SERVICE, getCacheKey(key));
				if(result!=null){
					if(result.getValidtime() > System.currentTimeMillis() && result.getUpdatetime() > validtime){
						updateHit();
						return result;
					}
				}
			}
			updateMiss();
			T value = call.call();
			if(value != null){
				result = new CacheElement(value, cacheSeconds);
				cacheTools.set(CacheService.REGION_SERVICE, getCacheKey(key), result);
			}
		} catch (InterruptedException e) {
			dbLogger.warn(e, 20);
		}finally{
			if(locked){
				lock.unlock();
			}
		}
		return result;
	}
	
	public static String buildKey(String ukey, Object... params){
		String key = ukey;
		for(Object p:params){
			String v = null;
			if(p!=null){
				if(p instanceof Timestamp) {
                    v = DateUtil.format((Timestamp) p, "yyyyMMddHHmmss");
                } else if(p instanceof Date) {
                    v = DateUtil.format((Date) p, "yyyyMMdd");
                } else {
                    v = "" + p;
                }
			}
			key += v + "|" ;
		}
		return key;
	}
	@Override
    public void updateCache(Object value, Integer cacheSeconds, String ukey, Object...params){
		String key = buildKey(ukey, params);
		CacheElement result =  new CacheElement(value, cacheSeconds);
		cacheTools.set(CacheService.REGION_SERVICE, getCacheKey(key), result);
	}
	
	public void clearCache(String key){
		cacheTools.remove(CacheService.REGION_SERVICE, getCacheKey(key));
	}
	
	private String getCacheKey(String key){
		return keyPre + key + "X";
	}
	
	private int getLockKey(String key){
		int cont = Math.abs(key.hashCode());
		if(cont <0){
			cont = Math.abs(cont+1);
		}
		return cont % maxKeyCount;
	}
	
	private class AsynchCallTask<S> implements Runnable {
		private String key;
		private Integer cacheSeconds;
		private CachableCall<S> call;
		private boolean forceRefresh;
		public AsynchCallTask(String key, Integer cacheSeconds, CachableCall<S> call, boolean forceRefresh){
			this.forceRefresh = forceRefresh;
			this.key = key;
			this.cacheSeconds = cacheSeconds;
			this.call = call;
		}
		@Override
		public void run() {
			try{
				sychCall(key, call, cacheSeconds, forceRefresh);
			}catch(Throwable e){
				dbLogger.warn(e, 100);
			}
		}
	}

	public String getKeyPre() {
		return keyPre;
	}
	public void setKeyPre(String keyPre) {
		this.keyPre = keyPre;
	}

	public String getServiceName() {
		return serviceName;
	}

	/**
	 * �������ĸ���ʱ��С�ڴ�ʱ�䣬�����¸���
	 * @param validtime
	 */
	public void startClear() {
		this.validtime = System.currentTimeMillis();
	}

	public Timestamp getStarttime() {
		return new Timestamp(starttime);
	}
	public Timestamp getValidtime(){
		return new Timestamp(validtime);
	}

	public Integer getHit() {
		return hit.get();
	}

	public Integer getMiss() {
		return miss.get();
	}

	public Integer getExpireHit() {
		return expireHit.get();
	}


}

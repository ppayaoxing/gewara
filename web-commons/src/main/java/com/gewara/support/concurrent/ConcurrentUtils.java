package com.gewara.support.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

import com.gewara.support.ErrorCode;
import com.gewara.support.TraceErrorException;
import com.gewara.untrans.LockCallback;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

public class ConcurrentUtils {
	private static final transient GewaLogger dbLogger = WebLogger.getLogger(ConcurrentUtils.class);
	private static Map<String, Semaphore> semaphoreMap = new ConcurrentHashMap<String, Semaphore>();
	private static LockTool localLockTool = new LocalLockTool();

	public static void registerSemaphore(String key, int count) {
		Semaphore sem = new Semaphore(count);
		semaphoreMap.put(key, sem);
	}

	public static <T> ErrorCode<T> doWithSemaphore(String key, int timeoutSecond, LockCallback<T> lc) {
		Semaphore sem = semaphoreMap.get(key);
		if (sem == null) {
			throw new TraceErrorException("without semphore!");
		}
		boolean lock = false;
		try {
			lock = sem.tryAcquire(timeoutSecond, TimeUnit.SECONDS);
			T result = lc.processWithInLock();
			return ErrorCode.getSuccessReturn(result);
		} catch (Exception e) {
			dbLogger.warn(e, 10);
		} finally {
			if (lock) {
				sem.release();
			}
		}
		return ErrorCode.getFailure("lockFailure");
	}

	/**
	 * 锟睫凤拷锟斤拷锟斤拷锟绞敝憋拷雍锟斤拷锟�
	 * @param lockKey
	 * @param lc
	 */
	public static <T> ErrorCode<T> tryDoWithLocalWriteLock(String lockKey, LockCallback<T> lc) {
		Lock lock = localLockTool.getLock(lockKey);
		return tryDoWithLock(lc, lock);
	}

	/**
	 * 使锟矫憋拷锟斤拷Lock
	 * @param lockKey
	 * @param lc
	 */
	public static <T> ErrorCode<T> doWithLocalWriteLock(String lockKey, LockCallback<T> lc) {
		Lock lock = localLockTool.getLock(lockKey);
		return doWithLock(lc, lock);
	}

	/**
	 * 60 min 锟斤拷时
	 * @param lc
	 * @param lock
	 * @return
	 */
	public static <T> ErrorCode<T> doWithLock(LockCallback<T> lc, Lock lock){
		return doWithLock(lc, 60 * 60, lock);
	}
	/**
	 * @param lc
	 * @param waitSeconds 锟斤拷时时锟斤拷
	 * @param lock
	 * @return
	 */
	public static <T> ErrorCode<T> doWithLock(LockCallback<T> lc, int waitSeconds, Lock lock) {
		boolean locked = false;
		T retval = null;
		try{
			try {
				locked = lock.tryLock(waitSeconds, TimeUnit.SECONDS);
				if(locked){
					retval = lc.processWithInLock();	
				}
			} catch (Throwable e){
				dbLogger.warn("", e);
			}
		}finally{
			try{
				if(locked){
					lock.unlock();
				}
			}catch(Throwable e){
				dbLogger.warn("", e);
			}
		}
		if(locked) {
            return ErrorCode.getSuccessReturn(retval);
        }
		return ErrorCode.getFailure("lockFailure, locked:" + locked);
	}
	
	public static <T> ErrorCode<T> tryDoWithLock(LockCallback<T> lc, Lock lock) {
		boolean locked = false;
		T retval = null;
		try{
			try {
				locked = lock.tryLock();
				if(locked){
					retval = lc.processWithInLock();	
				}
			} catch (Exception e){
				dbLogger.warn("", e);
			}
		}finally{
			try{
				if(locked){
					lock.unlock();
				}
			}catch(Exception e){
				dbLogger.warn("", e);
			}
		}
		if(locked) {
            return ErrorCode.getSuccessReturn(retval);
        }
		return ErrorCode.getFailure("lockFailure");
	}



}

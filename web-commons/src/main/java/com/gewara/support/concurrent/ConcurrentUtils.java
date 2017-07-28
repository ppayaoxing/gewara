/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support.concurrent;

import com.gewara.support.ErrorCode;
import com.gewara.support.TraceErrorException;
import com.gewara.support.concurrent.LocalLockTool;
import com.gewara.support.concurrent.LockTool;
import com.gewara.untrans.LockCallback;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class ConcurrentUtils {
	private static final transient GewaLogger dbLogger = WebLogger.getLogger(ConcurrentUtils.class);
	private static Map<String, Semaphore> semaphoreMap = new ConcurrentHashMap();
	private static LockTool localLockTool = new LocalLockTool();

	public static void registerSemaphore(String key, int count) {
		Semaphore sem = new Semaphore(count);
		semaphoreMap.put(key, sem);
	}

	public static <T> ErrorCode<T> doWithSemaphore(String key, int timeoutSecond, LockCallback<T> lc) {
		Semaphore sem = (Semaphore) semaphoreMap.get(key);
		if (sem == null) {
			throw new TraceErrorException("without semphore!");
		} else {
			boolean lock = false;

			try {
				lock = sem.tryAcquire((long) timeoutSecond, TimeUnit.SECONDS);
				Object e = lc.processWithInLock();
				ErrorCode arg5 = ErrorCode.getSuccessReturn(e);
				return arg5;
			} catch (Exception arg9) {
				dbLogger.warn(arg9, 10);
			} finally {
				if (lock) {
					sem.release();
				}

			}

			return ErrorCode.getFailure("lockFailure");
		}
	}

	public static <T> ErrorCode<T> tryDoWithLocalWriteLock(String lockKey, LockCallback<T> lc) {
		Lock lock = localLockTool.getLock(lockKey);
		return tryDoWithLock(lc, lock);
	}

	public static <T> ErrorCode<T> doWithLocalWriteLock(String lockKey, LockCallback<T> lc) {
		Lock lock = localLockTool.getLock(lockKey);
		return doWithLock(lc, lock);
	}

	public static <T> ErrorCode<T> doWithLock(LockCallback<T> lc, Lock lock) {
		return doWithLock(lc, 3600, lock);
	}

	public static <T> ErrorCode<T> doWithLock(LockCallback<T> lc, int waitSeconds, Lock lock) {
		boolean locked = false;
		Object retval = null;

		try {
			locked = lock.tryLock((long) waitSeconds, TimeUnit.SECONDS);
			if (locked) {
				retval = lc.processWithInLock();
			}
		} catch (Throwable arg12) {
			dbLogger.warn("", arg12);
		} finally {
			try {
				if (locked) {
					lock.unlock();
				}
			} catch (Throwable arg11) {
				dbLogger.warn("", arg11);
			}

		}

		return locked ? ErrorCode.getSuccessReturn(retval) : ErrorCode.getFailure("lockFailure, locked:" + locked);
	}

	public static <T> ErrorCode<T> tryDoWithLock(LockCallback<T> lc, Lock lock) {
		boolean locked = false;
		Object retval = null;

		try {
			locked = lock.tryLock();
			if (locked) {
				retval = lc.processWithInLock();
			}
		} catch (Exception arg11) {
			dbLogger.warn("", arg11);
		} finally {
			try {
				if (locked) {
					lock.unlock();
				}
			} catch (Exception arg10) {
				dbLogger.warn("", arg10);
			}

		}

		return locked ? ErrorCode.getSuccessReturn(retval) : ErrorCode.getFailure("lockFailure");
	}
}
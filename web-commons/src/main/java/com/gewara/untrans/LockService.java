package com.gewara.untrans;

import com.gewara.support.ErrorCode;


public interface LockService {
	/**
	 * @param lockKey
	 * @param lc
	 * @return
	 */
	<T> ErrorCode<T> doWithWriteLock(String lockKey, LockCallback<T> lc);
	/**
	 * @param lockKey
	 * @param waitSeconds 等待时间，小于 0 表示一直等待
	 * @param lc
	 * @return
	 */
	<T> ErrorCode<T> doWithWriteLock(String lockKey, int waitSeconds, LockCallback<T> lc);
	/**
	 * 无法获得锁时直接忽略
	 * @param lockKey
	 * @param lc
	 */
	<T> ErrorCode<T> tryDoWithWriteLock(String lockKey, LockCallback<T> lc);

}

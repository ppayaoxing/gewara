package com.gewara.untrans.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

import org.apache.commons.lang.StringUtils;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.gewara.Config;
import com.gewara.support.ErrorCode;
import com.gewara.support.concurrent.AtomicCounter;
import com.gewara.support.concurrent.ConcurrentUtils;
import com.gewara.support.concurrent.LocalLockTool;
import com.gewara.support.concurrent.LockTool;
import com.gewara.untrans.LockCallback;
import com.gewara.untrans.LockService;
import com.gewara.untrans.monitor.ZookeeperService;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

public class ZookeeperLockServiceImpl implements LockService, InitializingBean {

	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());

	private static String LOCK_NODE_NAME = "zklocks";

	@Autowired
	private ZookeeperService keeperService;

	private LockTool localLockTool;

	private Integer locks = 100;

	private Map<Integer, String> lockMap;

	public ZookeeperLockServiceImpl() {
	}

	public ZookeeperLockServiceImpl(ZookeeperService keeperService) {
		this.keeperService = keeperService;
	}

	public ZookeeperLockServiceImpl(ZookeeperService keeperService, Integer locks) {
		this.keeperService = keeperService;
		this.locks = locks;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		init();
	}

	public void init() {
		lockMap = new ConcurrentHashMap<Integer, String>(locks);
		initLockMap();
		localLockTool = new LocalLockTool();
	}

	/**
	 * TODO ´ý¶¨
	 */
	@Override
	public AtomicCounter getAtomicCounter(String ticketTradeNO) {
		// TODO
		return null;
	}

	@Override
	public <T> ErrorCode<T> doWithWriteLock(final String lockKey, final LockCallback<T> lc) {
		return doWithWriteLock(lockKey, 60 * 2, lc);
	}

	@Override
	public <T> ErrorCode<T> doWithWriteLock(final String lockKey, final int waitSeconds, final LockCallback<T> lc) {
		Lock localLock = localLockTool.getLock(lockKey);
		LockCallback<ErrorCode<T>> myCallback = new LockCallback<ErrorCode<T>>() {

			@Override
			public ErrorCode<T> processWithInLock() {
				boolean haslock = false;
				T retval = null;
				InterProcessMutex mutex = createMutex(lockKey);
				try {
					try {
						haslock = mutex.acquire(waitSeconds, TimeUnit.SECONDS);
						if (haslock) {
							retval = lc.processWithInLock();
						}
					} catch (Throwable e) {
						dbLogger.warn("", e);
					}
				} finally {
					try {
						if (haslock) {
							mutex.release();
						}
					} catch (Throwable e) {
						dbLogger.warn("", e);
					}
				}
				if (haslock)
					return ErrorCode.getSuccessReturn(retval);
				return ErrorCode.getFailure("zkLockFailure,haslock:" + haslock);
			}

		};
		ErrorCode<ErrorCode<T>> code = ConcurrentUtils.doWithLock(myCallback, waitSeconds, localLock);
		if (code.isSuccess()) {
			return code.getRetval();
		}
		return ErrorCode.getFailure(code.getMsg());
	}

	@Override
	public <T> ErrorCode<T> tryDoWithWriteLock(final String lockKey, final LockCallback<T> lc) {
		Lock localLock = localLockTool.getLock(lockKey);
		LockCallback<ErrorCode<T>> myCallback = new LockCallback<ErrorCode<T>>() {

			@Override
			public ErrorCode<T> processWithInLock() {
				boolean haslock = false;
				InterProcessMutex mutex = createMutex(lockKey);
				T retval = null;
				try {
					try {
						haslock = mutex.acquire(5, TimeUnit.MILLISECONDS);
						if (haslock) {
							retval = lc.processWithInLock();
						}
					} catch (Exception e) {
						dbLogger.warn("", e);
					}
				} finally {
					try {
						if (haslock) {
							mutex.release();
						}
					} catch (Exception e) {
						dbLogger.warn("", e);
					}
				}
				if (haslock)
					return ErrorCode.getSuccessReturn(retval);
				return ErrorCode.getFailure("lockFailure");
			}

		};

		ErrorCode<ErrorCode<T>> code = ConcurrentUtils.tryDoWithLock(myCallback, localLock);
		if (code.isSuccess()) {
			return code.getRetval();
		}
		return ErrorCode.getFailure(code.getMsg());
	}

	private void initLockMap() {
		String basepath = "/config/" + Config.SYSTEMID + "/" + LOCK_NODE_NAME;

		for (int i = 0; i < locks; i++) {
			String lockPath = basepath + "/lock" + StringUtils.leftPad(i + "", 5, "0");
			lockMap.put(i, lockPath);
		}
	}

	public void setLocks(Integer locks) {
		this.locks = locks;
	}

	private InterProcessMutex createMutex(String lockKey) {
		int lockIndex = lockKey.hashCode() % locks;
		InterProcessMutex mutex = keeperService.createInterProcessMutex(lockMap.get(Math.abs(lockIndex)));
		return mutex;
	}

}

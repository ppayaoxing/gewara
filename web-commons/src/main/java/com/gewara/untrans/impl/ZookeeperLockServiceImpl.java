/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.Config;
import com.gewara.support.ErrorCode;
import com.gewara.support.concurrent.ConcurrentUtils;
import com.gewara.support.concurrent.LocalLockTool;
import com.gewara.support.concurrent.LockTool;
import com.gewara.untrans.LockCallback;
import com.gewara.untrans.LockService;
import com.gewara.untrans.monitor.ZookeeperService;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import org.apache.commons.lang.StringUtils;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class ZookeeperLockServiceImpl implements LockService, InitializingBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private static String LOCK_NODE_NAME = "zklocks";
	@Autowired
	private ZookeeperService keeperService;
	private LockTool localLockTool;
	private Integer locks = Integer.valueOf(100);
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

	public void afterPropertiesSet() throws Exception {
		this.init();
	}

	public void init() {
		this.lockMap = new ConcurrentHashMap(this.locks.intValue());
		this.initLockMap();
		this.localLockTool = new LocalLockTool();
	}

	public <T> ErrorCode<T> doWithWriteLock(String lockKey, LockCallback<T> lc) {
		return this.doWithWriteLock(lockKey, 120, lc);
	}

	public <T> ErrorCode<T> doWithWriteLock(final String lockKey, final int waitSeconds, final LockCallback<T> lc) {
		Lock localLock = this.localLockTool.getLock(lockKey);
		LockCallback myCallback = new LockCallback() {
			public ErrorCode<T> processWithInLock() {
				boolean haslock = false;
				Object retval = null;
				InterProcessMutex mutex = ZookeeperLockServiceImpl.this.createMutex(lockKey);

				try {
					haslock = mutex.acquire((long) waitSeconds, TimeUnit.SECONDS);
					if (haslock) {
						retval = lc.processWithInLock();
					}
				} catch (Throwable arg11) {
					ZookeeperLockServiceImpl.this.dbLogger.warn("", arg11);
				} finally {
					try {
						if (haslock) {
							mutex.release();
						}
					} catch (Throwable arg10) {
						ZookeeperLockServiceImpl.this.dbLogger.warn("", arg10);
					}

				}

				return haslock
						? ErrorCode.getSuccessReturn(retval)
						: ErrorCode.getFailure("zkLockFailure,haslock:" + haslock);
			}
		};
		ErrorCode code = ConcurrentUtils.doWithLock(myCallback, waitSeconds, localLock);
		return code.isSuccess() ? (ErrorCode) code.getRetval() : ErrorCode.getFailure(code.getMsg());
	}

	public <T> ErrorCode<T> tryDoWithWriteLock(final String lockKey, final LockCallback<T> lc) {
		Lock localLock = this.localLockTool.getLock(lockKey);
		LockCallback myCallback = new LockCallback() {
			public ErrorCode<T> processWithInLock() {
				boolean haslock = false;
				InterProcessMutex mutex = ZookeeperLockServiceImpl.this.createMutex(lockKey);
				Object retval = null;

				try {
					haslock = mutex.acquire(5L, TimeUnit.MILLISECONDS);
					if (haslock) {
						retval = lc.processWithInLock();
					}
				} catch (Exception arg11) {
					ZookeeperLockServiceImpl.this.dbLogger.warn("", arg11);
				} finally {
					try {
						if (haslock) {
							mutex.release();
						}
					} catch (Exception arg10) {
						ZookeeperLockServiceImpl.this.dbLogger.warn("", arg10);
					}

				}

				return haslock ? ErrorCode.getSuccessReturn(retval) : ErrorCode.getFailure("lockFailure");
			}
		};
		ErrorCode code = ConcurrentUtils.tryDoWithLock(myCallback, localLock);
		return code.isSuccess() ? (ErrorCode) code.getRetval() : ErrorCode.getFailure(code.getMsg());
	}

	private void initLockMap() {
		String basepath = "/config/" + Config.SYSTEMID + "/" + LOCK_NODE_NAME;

		for (int i = 0; i < this.locks.intValue(); ++i) {
			String lockPath = basepath + "/lock" + StringUtils.leftPad(i + "", 5, "0");
			this.lockMap.put(Integer.valueOf(i), lockPath);
		}

	}

	public void setLocks(Integer locks) {
		this.locks = locks;
	}

	private InterProcessMutex createMutex(String lockKey) {
		int lockIndex = lockKey.hashCode() % this.locks.intValue();
		InterProcessMutex mutex = this.keeperService
				.createInterProcessMutex((String) this.lockMap.get(Integer.valueOf(Math.abs(lockIndex))));
		return mutex;
	}
}
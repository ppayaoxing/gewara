/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support.concurrent;

import com.gewara.support.concurrent.AtomicCounter;
import com.gewara.support.concurrent.LocalCounter;
import com.gewara.support.concurrent.LockTool;
import com.gewara.util.Gcache;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LocalLockTool implements LockTool {
	private int lockCount = 32;
	private ReentrantLock[] glockArr;
	private Gcache<String, ReentrantLock> lockMap;
	private ConcurrentHashMap<String, BlockingQueue<Object>> queueMap;

	public LocalLockTool() {
		this.glockArr = new ReentrantLock[this.lockCount];
		this.lockMap = new Gcache(100000L);
		this.queueMap = new ConcurrentHashMap();

		for (int i = 0; i < this.lockCount; ++i) {
			this.glockArr[i] = new ReentrantLock();
		}

	}

	public Lock getLock(String lockKey) {
		ReentrantLock lock = (ReentrantLock) this.lockMap.getIfPresent(lockKey);
		if (lock == null) {
			ReentrantLock glock = this.glockArr[Math.abs(lockKey.hashCode()) % this.lockCount];

			try {
				glock.lock();
				lock = (ReentrantLock) this.lockMap.getIfPresent(lockKey);
				if (lock == null) {
					lock = new ReentrantLock();
					this.lockMap.put(lockKey, lock);
				}
			} finally {
				glock.unlock();
			}
		}

		return lock;
	}

	public AtomicCounter getAtomicCounter(String key) {
		return new LocalCounter();
	}

	public BlockingQueue<Object> getBlockQueue(String key) {
		BlockingQueue queue = (BlockingQueue) this.queueMap.get(key);
		if (queue == null) {
			LinkedBlockingQueue queue1 = new LinkedBlockingQueue();
			this.queueMap.put(key, queue1);
		}

		return (BlockingQueue) this.queueMap.get(key);
	}

	public void removeAtomicCounter(String key) {
	}

	public void removeBlockQueue(String key) {
		this.queueMap.remove(key);
	}

	public void removeLock(String key) {
	}
}
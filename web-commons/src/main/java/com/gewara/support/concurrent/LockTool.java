package com.gewara.support.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;

public interface LockTool{
	void removeLock(String key);
	void removeBlockQueue(String key);
	BlockingQueue<Object> getBlockQueue(String key);
	Lock getLock(String lockKey);
	AtomicCounter getAtomicCounter(String key);
	void removeAtomicCounter(String key);
}

package com.gewara.support.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.gewara.util.Gcache;

public class LocalLockTool implements LockTool{
	private int lockCount = 32;
	private ReentrantLock[] glockArr = new ReentrantLock[lockCount];
	
	
	private Gcache<String, ReentrantLock> lockMap = new Gcache<String, ReentrantLock>(100000);
	private ConcurrentHashMap<String, BlockingQueue<Object>> queueMap = new ConcurrentHashMap<String, BlockingQueue<Object>>();
	
	public LocalLockTool(){
		for(int i = 0; i < lockCount; i++){
			glockArr[i] = new ReentrantLock();
		}
	}
	
	@Override
	public Lock getLock(String lockKey) {
		ReentrantLock lock = lockMap.getIfPresent(lockKey);
		if(lock==null){
			ReentrantLock glock = glockArr[Math.abs(lockKey.hashCode()) % lockCount];
			try{
				glock.lock();
				lock = lockMap.getIfPresent(lockKey);
				if(lock == null){
					lock = new ReentrantLock();
					lockMap.put(lockKey, lock);
				}
			}finally{
				glock.unlock();
			}
		}
		return lock;
	}
	
	@Override
	public AtomicCounter getAtomicCounter(String key) {
		return new LocalCounter();
		
	}
	@Override
	public BlockingQueue<Object> getBlockQueue(String key) {
		BlockingQueue<Object> queue = queueMap.get(key);
		if(queue==null){
			queue = new LinkedBlockingQueue();
			queueMap.put(key, queue);
		}
		return queueMap.get(key);
	}
	@Override
	public void removeAtomicCounter(String key) {
		
	}
	@Override
	public void removeBlockQueue(String key) {
		queueMap.remove(key);
	}
	@Override
	public void removeLock(String key) {
		
	}
}
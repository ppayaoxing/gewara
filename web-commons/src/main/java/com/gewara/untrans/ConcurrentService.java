package com.gewara.untrans;

import java.util.concurrent.BlockingQueue;

import com.gewara.support.concurrent.AtomicCounter;

public interface ConcurrentService {
	/**
	 * 获取全局计数器
	 * @param key
	 * @return
	 */
	AtomicCounter getAtomicCounter(String key);
	/**
	 * 获取cluster计数器（如果支持）
	 * @param key
	 * @return
	 */
	AtomicCounter getLocalAtomicCounter(String key);
	/**
	 * 获取clusterQueue（如果支持）
	 * @param key
	 * @return
	 */
	BlockingQueue<Object> getBlockQueue(String key);
	void unregisterBlockQueue(String key);

}

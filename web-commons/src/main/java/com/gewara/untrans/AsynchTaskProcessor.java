package com.gewara.untrans;

public interface AsynchTaskProcessor<T extends AsynchTask> {
	void processTask(T task);
	/**
	 * 锁的大致个数，锁重用
	 * @param maxLock
	 */
	int getLockSize();
}

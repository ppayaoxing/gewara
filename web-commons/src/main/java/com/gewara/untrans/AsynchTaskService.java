package com.gewara.untrans;

import java.util.Map;

/**
 * 异步执行请求
 * 
 * @author gebiao(ge.biao@gewara.com)
 * @since Jul 4, 2012 11:00:25 AM
 */
public interface AsynchTaskService {
	void addTask(AsynchTask task);
	/**
	 * 等待waitTimeSecond秒或凑齐minCount才一起执行
	 * @param task
	 * @param waitTimeSecond
	 * @param minCount
	 */
	void addTask(AsynchTask task, int waitTimeSecond, int minCount);

	void cancleTask(String taskUkey);

	void registerTaskProcessor(String tasktype, AsynchTaskProcessor processor);

	int getExecutorActiveCount();

	Map<String, Integer> getTaskQueueMap();
	int getQueueSize();
}

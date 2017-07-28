/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

import com.gewara.untrans.AsynchTask;
import com.gewara.untrans.AsynchTaskProcessor;
import java.util.Map;

public interface AsynchTaskService {
	void addTask(AsynchTask arg0);

	void addTask(AsynchTask arg0, int arg1, int arg2);

	void cancleTask(String arg0);

	void registerTaskProcessor(String arg0, AsynchTaskProcessor arg1);

	int getExecutorActiveCount();

	Map<String, Integer> getTaskQueueMap();

	int getQueueSize();
}
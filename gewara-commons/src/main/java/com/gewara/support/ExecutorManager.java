/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.support;

import com.gewara.util.GewaLogger;
import com.gewara.util.HttpUtils;
import com.gewara.util.LoggerUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class ExecutorManager {
	private static final transient GewaLogger dbLogger = LoggerUtils.getLogger(HttpUtils.class);
	private static Map<String, ThreadPoolExecutor> executorMap = new HashMap();

	public static void registerExecutor(String name, ThreadPoolExecutor executor) {
		executorMap.put(name, executor);
	}

	public static void waitComplete(int totalWait) {
		Iterator arg0 = executorMap.entrySet().iterator();

		while (arg0.hasNext()) {
			for (Entry entry = (Entry) arg0.next(); totalWait > 0
					&& ((ThreadPoolExecutor) entry.getValue()).getActiveCount() > 0; --totalWait) {
				try {
					Thread.sleep(1000L);
					dbLogger.warn("wait:" + (String) entry.getKey() + " to complete!" + totalWait);
				} catch (InterruptedException arg3) {
					;
				}
			}
		}

	}
}
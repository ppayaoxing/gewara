/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.support;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class GewaExecutorThreadFactory implements ThreadFactory {
	static final AtomicInteger poolNumber = new AtomicInteger(1);
	final ThreadGroup group;
	final AtomicInteger threadNumber = new AtomicInteger(1);
	final String namePrefix;

	public GewaExecutorThreadFactory(String prefix) {
		SecurityManager s = System.getSecurityManager();
		this.group = s != null ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
		this.namePrefix = prefix + poolNumber.getAndIncrement() + "-thread-";
	}

	public Thread newThread(Runnable r) {
		Thread t = new Thread(this.group, r, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
		if (t.isDaemon()) {
			t.setDaemon(false);
		}

		if (t.getPriority() != 5) {
			t.setPriority(5);
		}

		return t;
	}
}
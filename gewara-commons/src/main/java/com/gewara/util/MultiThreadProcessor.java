/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.support.GewaExecutorThreadFactory;
import com.gewara.util.GewaLogger;
import com.gewara.util.LoggerUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadProcessor {
	private static final GewaLogger logger = LoggerUtils.getLogger(MultiThreadProcessor.class);
	private ExecutorService executorService;

	public MultiThreadProcessor(int threadSize, String threadNamePre) {
		threadSize = Math.max(threadSize, 32);
		this.executorService = Executors.newFixedThreadPool(threadSize, new GewaExecutorThreadFactory(threadNamePre));
	}

	public long[] execute(Runnable[] taskList, Long maxwait, TimeUnit unit) {
		CountDownLatch cdl = new CountDownLatch(taskList.length);
		AtomicInteger counter = new AtomicInteger(0);
		Runnable[] arg5 = taskList;
		int arg6 = taskList.length;

		for (int arg7 = 0; arg7 < arg6; ++arg7) {
			Runnable task = arg5[arg7];
			this.executorService.execute(new MultiThreadProcessor.Worker(task, cdl, counter));
		}

		try {
			cdl.await(maxwait.longValue(), unit);
		} catch (Exception arg9) {
			;
		}

		return new long[] { (long) counter.get(), cdl.getCount() };
	}

	private static class Worker implements Runnable {
		private Runnable task;
		private CountDownLatch cdl;
		private AtomicInteger counter;

		public Worker(Runnable task, CountDownLatch cdl, AtomicInteger counter) {
			this.task = task;
			this.cdl = cdl;
			this.counter = counter;
		}

		public void run() {
			try {
				this.task.run();
				this.counter.incrementAndGet();
			} catch (Throwable arg4) {
				MultiThreadProcessor.logger.warn(arg4, 50);
			} finally {
				this.cdl.countDown();
			}

		}
	}
}
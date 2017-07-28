/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.util;

import com.gewara.support.GewaExecutorThreadFactory;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public enum TimerHelper {
	TIMER;

	private static final transient GewaLogger dbLogger = WebLogger.getLogger(TimerHelper.class);
	private ScheduledExecutorService scheduler;

	private TimerHelper() {
		if (GewaIpConfig.isDevServer()) {
			this.scheduler = Executors.newScheduledThreadPool(10, new GewaExecutorThreadFactory("GewaGlobalScheduler"));
		} else {
			this.scheduler = Executors.newScheduledThreadPool(50, new GewaExecutorThreadFactory("GewaGlobalScheduler"));
		}

	}

	public void schedule(Runnable task, long delay) {
		this.scheduler.schedule(new TimerHelper.DelegateTask(task), delay, TimeUnit.MILLISECONDS);
	}

	public void schedule(Runnable task, Date time) {
		this.scheduler.schedule(new TimerHelper.DelegateTask(task), time.getTime() - System.currentTimeMillis(),
				TimeUnit.MILLISECONDS);
	}

	public void scheduleWithFixedDelay(Runnable task, long delay, long period) {
		this.scheduler.scheduleWithFixedDelay(new TimerHelper.DelegateTask(task), delay, period, TimeUnit.MILLISECONDS);
	}

	public void scheduleWithFixedDelay(Runnable task, Date firstTime, long period) {
		this.scheduler.scheduleWithFixedDelay(new TimerHelper.DelegateTask(task),
				firstTime.getTime() - System.currentTimeMillis(), period, TimeUnit.MILLISECONDS);
	}

	public void scheduleAtFixedRate(Runnable task, long delay, long period) {
		this.scheduler.scheduleAtFixedRate(new TimerHelper.DelegateTask(task), delay, period, TimeUnit.MILLISECONDS);
	}

	public void scheduleAtFixedRate(Runnable task, Date firstTime, long period) {
		this.scheduler.scheduleAtFixedRate(new TimerHelper.DelegateTask(task),
				firstTime.getTime() - System.currentTimeMillis(), period, TimeUnit.MILLISECONDS);
	}

	private class DelegateTask implements Runnable {
		private Runnable task;

		DelegateTask(Runnable task) {
			this.task = task;
		}

		public void run() {
			try {
				this.task.run();
			} catch (Throwable arg1) {
				TimerHelper.dbLogger.warn(arg1, 100);
			}

		}
	}
}
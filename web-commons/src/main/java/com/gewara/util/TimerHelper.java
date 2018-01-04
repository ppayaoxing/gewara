package com.gewara.util;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.gewara.support.GewaExecutorThreadFactory;


public enum TimerHelper {
	TIMER;
	
	private static final transient GewaLogger dbLogger = WebLogger.getLogger(TimerHelper.class);
	private ScheduledExecutorService scheduler;

	private TimerHelper(){
		if(GewaIpConfig.isDevServer()){
			scheduler = Executors.newScheduledThreadPool(10, new GewaExecutorThreadFactory("GewaGlobalScheduler"));
		}else{
			scheduler = Executors.newScheduledThreadPool(50, new GewaExecutorThreadFactory("GewaGlobalScheduler"));
		}
	}
	
	public void schedule(Runnable task, long delay){
		scheduler.schedule(new DelegateTask(task), delay, TimeUnit.MILLISECONDS);
	}
	
	public void schedule(Runnable task, Date time){
		scheduler.schedule(new DelegateTask(task), time.getTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	}
	
	/**
	 * 姣忔鎵ц瀹屾垚鍚庯紝闂撮殧澶氶暱鏃堕棿鎵ц涓嬫銆傚鏋滀笂娆′竴鐩存病鎵ц瀹岋紝涓嬫鏃犳硶鎵ц
	 * @param task
	 * @param delay
	 * @param period
	 */
	public void scheduleWithFixedDelay(Runnable task, long delay, long period){
		scheduler.scheduleWithFixedDelay(new DelegateTask(task), delay, period, TimeUnit.MILLISECONDS);
	}
	
	/**
	 * 姣忔鎵ц瀹屾垚鍚庯紝闂撮殧澶氶暱鏃堕棿鎵ц涓嬫銆傚鏋滀笂娆′竴鐩存病鎵ц瀹岋紝涓嬫鏃犳硶鎵ц
	 * @param task
	 * @param firstTime
	 * @param period
	 */
	public void scheduleWithFixedDelay(Runnable task, Date firstTime, long period){
		scheduler.scheduleWithFixedDelay(new DelegateTask(task), firstTime.getTime() - System.currentTimeMillis(), period, TimeUnit.MILLISECONDS);
	}
	
	/**
	 * 闂撮殧澶氶暱鏃堕棿鎵ц涓�娆★紙涓嶇涓婃鏄惁鎵ц瀹岋級
	 * @param task
	 * @param delay
	 * @param period
	 */
	public void scheduleAtFixedRate(Runnable task, long delay, long period) {
		scheduler.scheduleAtFixedRate(new DelegateTask(task), delay, period, TimeUnit.MILLISECONDS);
	}
	
	/**
	 * 闂撮殧澶氶暱鏃堕棿鎵ц涓�娆★紙涓嶇涓婃鏄惁鎵ц瀹岋級
	 * @param task
	 * @param firstTime
	 * @param period
	 */
	public void scheduleAtFixedRate(Runnable task, Date firstTime, long period) {
		scheduler.scheduleAtFixedRate(new DelegateTask(task), firstTime.getTime() - System.currentTimeMillis(), period, TimeUnit.MILLISECONDS);
	}
	
	private class DelegateTask implements Runnable {
		private Runnable task;
		
		DelegateTask(Runnable task){
			this.task = task;
		}

		@Override
		public void run() {
			try {
				task.run();
			} catch (Throwable t) {
				dbLogger.warn(t, 100);
			}
			
		}		
	}
}

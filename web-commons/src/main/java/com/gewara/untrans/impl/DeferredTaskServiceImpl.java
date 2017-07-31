package com.gewara.untrans.impl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.gewara.support.ErrorCode;
import com.gewara.support.GewaExecutorThreadFactory;
import com.gewara.untrans.DeferredResultTask;
import com.gewara.untrans.DeferredTaskCallback;
import com.gewara.untrans.DeferredTaskService;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

@Service("deferredTaskService")
public class DeferredTaskServiceImpl implements DeferredTaskService, InitializingBean {
	private GewaLogger dbLogger = WebLogger.getLogger(getClass());
	
	ThreadPoolExecutor executor = null;
	private int threadPoolSize = 60;//default 60
	public void setThreadPoolSize(int threadPoolSize) {
		this.threadPoolSize = threadPoolSize;
	}
	@Override
	public <R> void doTask(final DeferredResultTask task, final DeferredTaskCallback<R> callback){
		executor.submit(new Runnable() {
			@Override
			public void run() {
				ErrorCode<R> resultCode =  callback.doTask();
				if(resultCode.isSuccess()){
					task.getDeferredResult().setResult(resultCode.getRetval());
				}else{
					dbLogger.error(resultCode.getMsg());
					task.getDeferredResult().setResult(task.getErrorResult());
				}
			}
		});
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<Runnable>();
		executor = new ThreadPoolExecutor(threadPoolSize, threadPoolSize, 0L, TimeUnit.SECONDS, taskQueue, new GewaExecutorThreadFactory("GwDeferredResultTask"));
		executor.allowCoreThreadTimeOut(false);
	}
}

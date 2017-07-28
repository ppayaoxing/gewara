/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.support.ErrorCode;
import com.gewara.support.GewaExecutorThreadFactory;
import com.gewara.untrans.DeferredResultTask;
import com.gewara.untrans.DeferredTaskCallback;
import com.gewara.untrans.DeferredTaskService;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service("deferredTaskService")
public class DeferredTaskServiceImpl implements DeferredTaskService, InitializingBean {
	private GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	ThreadPoolExecutor executor = null;
	private int threadPoolSize = 60;

	public void setThreadPoolSize(int threadPoolSize) {
		this.threadPoolSize = threadPoolSize;
	}

	public <R> void doTask(final DeferredResultTask task, final DeferredTaskCallback<R> callback) {
		this.executor.submit(new Runnable() {
			public void run() {
				ErrorCode resultCode = callback.doTask();
				if (resultCode.isSuccess()) {
					task.getDeferredResult().setResult(resultCode.getRetval());
				} else {
					DeferredTaskServiceImpl.this.dbLogger.error(resultCode.getMsg());
					task.getDeferredResult().setResult(task.getErrorResult());
				}

			}
		});
	}

	public void afterPropertiesSet() throws Exception {
		LinkedBlockingQueue taskQueue = new LinkedBlockingQueue();
		this.executor = new ThreadPoolExecutor(this.threadPoolSize, this.threadPoolSize, 0L, TimeUnit.SECONDS,
				taskQueue, new GewaExecutorThreadFactory("GwDeferredResultTask"));
		this.executor.allowCoreThreadTimeOut(false);
	}
}
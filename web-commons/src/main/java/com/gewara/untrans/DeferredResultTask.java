package com.gewara.untrans;

import org.springframework.web.context.request.async.DeferredResult;

public class DeferredResultTask<R> extends AsynchTask {

	private DeferredResult deferredResult;
	private R errorResult;
	public DeferredResultTask(DeferredResult<R> deferredResult, String tasktype, String taskUkey, int maxWaitSeconds, boolean requireLock, R errorResult) {
		super(tasktype, taskUkey, maxWaitSeconds, requireLock);
		this.deferredResult = deferredResult;
		this.errorResult = errorResult;
	}
	
	public DeferredResultTask(DeferredResult<R> deferredResult, R errorResult) {
		super("tasktype", "taskUkey", 30, false);
		this.deferredResult = deferredResult;
		this.errorResult = errorResult;
	}
	
	
	public DeferredResult getDeferredResult() {
		return deferredResult;
	}
	public void setDeferredResult(DeferredResult deferredResult) {
		this.deferredResult = deferredResult;
	}

	public R getErrorResult() {
		return errorResult;
	}

	public void setErrorResult(R errorResult) {
		this.errorResult = errorResult;
	}

}

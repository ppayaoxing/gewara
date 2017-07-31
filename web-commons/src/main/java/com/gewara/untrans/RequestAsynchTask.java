package com.gewara.untrans;

import javax.servlet.AsyncContext;

public class RequestAsynchTask extends AsynchTask{
	private AsyncContext ctx;
	
	private String successForward;
	public String getSuccessForward() {
		return successForward;
	}
	public void setSuccessForward(String successForward) {
		this.successForward = successForward;
	}
	private String failureForward;
	
	public String getFailureForward() {
		return failureForward;
	}
	public void setFailureForward(String failureForward) {
		this.failureForward = failureForward;
	}
	public AsyncContext getCtx() {
		return ctx;
	}
	public RequestAsynchTask(String tasktype, String taskUkey, int maxWaitSeconds, AsyncContext ctx, boolean requireLock) {
		super(tasktype, taskUkey, maxWaitSeconds, requireLock);
		this.ctx = ctx;
	}

}

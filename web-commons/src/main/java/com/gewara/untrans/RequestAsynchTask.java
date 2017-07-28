/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

import com.gewara.untrans.AsynchTask;
import javax.servlet.AsyncContext;

public class RequestAsynchTask extends AsynchTask {
	private AsyncContext ctx;
	private String successForward;
	private String failureForward;

	public String getSuccessForward() {
		return this.successForward;
	}

	public void setSuccessForward(String successForward) {
		this.successForward = successForward;
	}

	public String getFailureForward() {
		return this.failureForward;
	}

	public void setFailureForward(String failureForward) {
		this.failureForward = failureForward;
	}

	public AsyncContext getCtx() {
		return this.ctx;
	}

	public RequestAsynchTask(String tasktype, String taskUkey, int maxWaitSeconds, AsyncContext ctx,
			boolean requireLock) {
		super(tasktype, taskUkey, maxWaitSeconds, requireLock);
		this.ctx = ctx;
	}
}
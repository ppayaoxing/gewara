/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.support.ErrorCode;
import com.gewara.untrans.AsynchTaskProcessor;
import com.gewara.untrans.DeferredResultTask;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

public abstract class DeferredAsynchTaskProcessor<R> implements AsynchTaskProcessor<DeferredResultTask<R>> {
	private GewaLogger dbLogger = WebLogger.getLogger(this.getClass());

	public void processTask(DeferredResultTask<R> task) {
		try {
			ErrorCode e = this.processRequest(task);
			if (e.isSuccess()) {
				task.getDeferredResult().setResult(e.getRetval());
			} else {
				task.getDeferredResult().setResult(task.getErrorResult());
			}
		} catch (Exception arg2) {
			this.dbLogger.warn("", arg2);
			task.getDeferredResult().setResult(task.getErrorResult());
		}

	}

	public abstract ErrorCode<R> processRequest(DeferredResultTask<R> arg0);
}
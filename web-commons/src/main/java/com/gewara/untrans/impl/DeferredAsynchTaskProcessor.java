package com.gewara.untrans.impl;

import com.gewara.support.ErrorCode;
import com.gewara.untrans.AsynchTaskProcessor;
import com.gewara.untrans.DeferredResultTask;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

/**
 * <pre> {@code
 * public DeferredResult<String> test() {
 *		DeferredResult<String> deferredResult = new DeferredResult<String>((long) (5 * 1000), "timeout2");
 *
 *		DeferredResultTask<String> deferredTask = new DeferredResultTask(deferredResult, "tasktype", "taskUkey", 30, true, "error string");
 *		
 *		testAsynchTaskService.addTask(deferredTask);
 *		
 *		return deferredResult;
 *	}
 * 
 * }</pre>
 * @param <R>
 */
public abstract class DeferredAsynchTaskProcessor<R> implements AsynchTaskProcessor<DeferredResultTask<R>> {

	private GewaLogger dbLogger = WebLogger.getLogger(getClass());
	@Override
	public void processTask(DeferredResultTask<R> task) {
	
		try {
				ErrorCode<R> code = processRequest(task);
				if(code.isSuccess()){
					task.getDeferredResult().setResult(code.getRetval());
				}else{
					task.getDeferredResult().setResult(task.getErrorResult());
				}
		} catch (Exception e) {
			dbLogger.warn("", e);
			task.getDeferredResult().setResult(task.getErrorResult());
		}
	}

	public abstract ErrorCode<R> processRequest(DeferredResultTask<R> task);

}

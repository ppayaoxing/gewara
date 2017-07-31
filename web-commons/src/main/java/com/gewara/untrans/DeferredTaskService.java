package com.gewara.untrans;


/**
 * DeferredResultÒì²½Ö´ĞĞ
 *  <pre> {@code
 * 
 * DeferredResult<String> deferredResult = new DeferredResult<String>(5000L, "timeout");		
 * DeferredResultTask<String> deferredTask = new DeferredResultTask(deferredResult,  "error string");
 * deferredTaskService.doTask(deferredTask, new DeferredTaskCallback<String>() {
 * 	@Override
 * 	public ErrorCode<String> doTask() {
 * 	//doSomething
 * 	}
 * });
 * return deferredResult;
 *
 * }</pre>
 *
 */
public interface DeferredTaskService {

	<T> void doTask(DeferredResultTask deferredTask, DeferredTaskCallback<T> callback);

}

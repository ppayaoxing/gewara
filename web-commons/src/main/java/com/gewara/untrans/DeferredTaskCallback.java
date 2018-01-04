package com.gewara.untrans;

import com.gewara.support.ErrorCode;

/**
 * spring mvc Deferred回调
 * @author quzhuping
 *
 * @param <R> 和DeferredResult设置一致
 */
public interface DeferredTaskCallback<R> {

	ErrorCode<R> doTask();
}

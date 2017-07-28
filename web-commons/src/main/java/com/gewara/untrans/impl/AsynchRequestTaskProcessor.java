/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.support.ErrorCode;
import com.gewara.untrans.AsynchTask;
import com.gewara.untrans.AsynchTaskProcessor;
import com.gewara.untrans.RequestAsynchTask;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;

public abstract class AsynchRequestTaskProcessor implements AsynchTaskProcessor<RequestAsynchTask> {
	private GewaLogger dbLogger = WebLogger.getLogger(this.getClass());

	public void processTask(RequestAsynchTask task) {
		AsyncContext actx = task.getCtx();
		HttpServletResponse res = (HttpServletResponse) actx.getResponse();
		boolean dispatch = false;

		try {
			if (task.isTimeout()) {
				this.processTimeout(task);
			} else {
				ErrorCode e = this.processRequest(task);
				if (e.isSuccess()) {
					if (StringUtils.isNotBlank(task.getSuccessForward())) {
						actx.dispatch(task.getSuccessForward());
						dispatch = true;
					} else {
						BaseWebUtils.writeJsonResponse(res, true, "success");
					}
				} else if (StringUtils.isNotBlank(task.getFailureForward())) {
					actx.dispatch(task.getSuccessForward());
					dispatch = true;
				} else {
					BaseWebUtils.writeJsonResponse(res, false, e.getMsg());
				}
			}
		} catch (Exception arg8) {
			this.dbLogger.warn("", arg8);
			BaseWebUtils.writeJsonResponse(res, false, "请求数据异常！");
		} finally {
			if (!dispatch) {
				actx.complete();
			}

		}

	}

	public abstract ErrorCode processRequest(RequestAsynchTask arg0);

	private void processTimeout(AsynchTask task) {
		AsyncContext actx = ((RequestAsynchTask) task).getCtx();

		try {
			BaseWebUtils.writeJsonResponse((HttpServletResponse) actx.getResponse(), false, "请求超时！");
		} catch (Exception arg11) {
			;
		} finally {
			try {
				actx.complete();
			} catch (Exception arg10) {
				this.dbLogger.warn("", arg10);
			}

		}

	}
}
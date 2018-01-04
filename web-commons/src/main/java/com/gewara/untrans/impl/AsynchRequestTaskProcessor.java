package com.gewara.untrans.impl;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.gewara.support.ErrorCode;
import com.gewara.untrans.AsynchTask;
import com.gewara.untrans.AsynchTaskProcessor;
import com.gewara.untrans.RequestAsynchTask;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

/**
 * �첽Servlet������
 * @author gebiao(ge.biao@gewara.com)
 * @since Apr 9, 2013 2:34:31 PM
 */
public abstract class AsynchRequestTaskProcessor implements AsynchTaskProcessor<RequestAsynchTask>{
	private GewaLogger dbLogger = WebLogger.getLogger(getClass());
	@Override
	public void processTask(RequestAsynchTask task) {
		AsyncContext actx = task.getCtx();
		HttpServletResponse res = (HttpServletResponse) actx.getResponse();
		boolean dispatch = false;		
		try {
			if(task.isTimeout()){//��ʱ
				processTimeout(task);
			}else{
				ErrorCode code = processRequest(task);
				if(code.isSuccess()){
					if(StringUtils.isNotBlank(task.getSuccessForward())){
						actx.dispatch(task.getSuccessForward());
						dispatch = true;
					}else{
						BaseWebUtils.writeJsonResponse(res, true, "success");
					}
				}else{
					if(StringUtils.isNotBlank(task.getFailureForward())){
						actx.dispatch(task.getSuccessForward());
						dispatch = true;
					}else{
						BaseWebUtils.writeJsonResponse(res, false, code.getMsg());
					}
				}
			}
		} catch (Exception e) {
			dbLogger.warn("", e);
			BaseWebUtils.writeJsonResponse(res, false, "���������쳣��");
		} finally{
			if(!dispatch) {
                actx.complete();
            }
		}
	}

	public abstract ErrorCode processRequest(RequestAsynchTask task);

	private void processTimeout(AsynchTask task) {
		AsyncContext actx = ((RequestAsynchTask)task).getCtx();
		try{
			BaseWebUtils.writeJsonResponse((HttpServletResponse) actx.getResponse(), false, "����ʱ��");
		}catch (Exception e) {
		}finally{
			try{actx.complete();}catch(Exception e){
				dbLogger.warn("", e);
			}
		}
	}
}

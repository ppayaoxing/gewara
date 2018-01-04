package com.gewara.web.support;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gewara.util.BaseWebUtils;
import com.gewara.util.LogTraceUtil.LogTrace;

public class RequestTrace implements LogTrace{
	/**
	 * @return 获取请求路径和请求参数组成 trace跟踪信息
	 */
	@Override
	public String getTrace() {
		HttpServletRequest request = getRequest();
		if(request!=null){
			String trace = request.getRequestURI();
			if(!ServletFileUpload.isMultipartContent(request)){
				trace += ":" + BaseWebUtils.getParamStr(request, true);
			}
			return trace;
		}
		return null;
	}
	private HttpServletRequest getRequest(){
		ServletRequestAttributes holder = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		if(holder!=null){
			HttpServletRequest request = holder.getRequest();
			if(request!=null){
				return request;
			}
		}
		return null;
	}

}

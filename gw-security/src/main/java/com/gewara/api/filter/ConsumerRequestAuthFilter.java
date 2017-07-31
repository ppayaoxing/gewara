package com.gewara.api.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.RpcResult;
import com.alibaba.dubbo.rpc.filter.GenericFilter;
import com.gewara.Config;
import com.gewara.api.vo.ResultCode;
import com.gewara.constant.AutherFilterConstant;
import com.gewara.model.acl.GewaraUser;
import com.gewara.model.acl.User;
import com.gewara.util.BaseWebUtils;
import com.gewara.web.util.LoginUtils;

public class ConsumerRequestAuthFilter extends GenericFilter {
	
	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		HttpServletRequest request = getRequest();
		if(request == null){
			return new RpcResult(ResultCode.getFailure("非法调用！！！"));
		}
		User user = getLogonUser();
		if(user == null){
			return new RpcResult(ResultCode.getFailure("请先登录！"));
		}
		RpcContext context = RpcContext.getContext();
		String pageUrl = request.getServletPath();
		context.setAttachment(AutherFilterConstant.REQURI, pageUrl);
		context.setAttachment(AutherFilterConstant.SYSTEMID, Config.SYSTEMID);
		context.setAttachment(AutherFilterConstant.USERID, String.valueOf(user.getId()));
		context.setAttachment(AutherFilterConstant.USERNAME, user.getUsername());
		String sessionid = BaseWebUtils.getCookieValue(request, LoginUtils.SESS_COOKIE_NAME);
		context.setAttachment(AutherFilterConstant.SESSIONID, sessionid);
		context.setAttachment(AutherFilterConstant.REMOTEIP, BaseWebUtils.getRemoteIp(request));
		Result result = super.invoke(invoker, invocation);
		return result;
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
	
	private final User getLogonUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth == null){
			return null;
		}
		if(auth.isAuthenticated() && !auth.getName().equals("anonymous")){//登录
			GewaraUser user = (GewaraUser) auth.getPrincipal();
			//refresh(user);
			if(user instanceof User) return (User)user;
		}
		return null;
	}
}

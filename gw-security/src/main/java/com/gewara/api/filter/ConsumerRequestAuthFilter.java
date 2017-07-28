/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.filter;

import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.RpcResult;
import com.alibaba.dubbo.rpc.filter.GenericFilter;
import com.gewara.Config;
import com.gewara.api.vo.ResultCode;
import com.gewara.model.acl.GewaraUser;
import com.gewara.model.acl.User;
import com.gewara.util.BaseWebUtils;
import com.gewara.web.util.LoginUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class ConsumerRequestAuthFilter extends GenericFilter {
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		HttpServletRequest request = this.getRequest();
		if (request == null) {
			return new RpcResult(ResultCode.getFailure("非法调用！！！"));
		} else {
			User user = this.getLogonUser();
			if (user == null) {
				return new RpcResult(ResultCode.getFailure("请先登录！"));
			} else {
				RpcContext context = RpcContext.getContext();
				String pageUrl = request.getServletPath();
				context.setAttachment("reqUri", pageUrl);
				context.setAttachment("systemid", Config.SYSTEMID);
				context.setAttachment("userid", String.valueOf(user.getId()));
				context.setAttachment("username", user.getUsername());
				String sessionid = BaseWebUtils.getCookieValue(request, LoginUtils.SESS_COOKIE_NAME);
				context.setAttachment("sessionid", sessionid);
				context.setAttachment("remoteIp", BaseWebUtils.getRemoteIp(request));
				Result result = super.invoke(invoker, invocation);
				return result;
			}
		}
	}

	private HttpServletRequest getRequest() {
		ServletRequestAttributes holder = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (holder != null) {
			HttpServletRequest request = holder.getRequest();
			if (request != null) {
				return request;
			}
		}

		return null;
	}

	private final User getLogonUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) {
			return null;
		} else {
			if (auth.isAuthenticated() && !auth.getName().equals("anonymous")) {
				GewaraUser user = (GewaraUser) auth.getPrincipal();
				if (user instanceof User) {
					return (User) user;
				}
			}

			return null;
		}
	}
}
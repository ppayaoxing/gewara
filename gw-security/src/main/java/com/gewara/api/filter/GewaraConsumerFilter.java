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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class GewaraConsumerFilter extends GenericFilter {
	public static final ThreadLocal<User> backgroundUser = new ThreadLocal();

	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		User user = this.getLogonUser();
		if (user == null) {
			return new GewaraConsumerFilter.ResponseResult(ResultCode.getFailure("ÇëÏÈµÇÂ¼£¡"));
		} else {
			RpcContext context = RpcContext.getContext();
			context.setAttachment("systemid", Config.SYSTEMID);
			context.setAttachment("userid", String.valueOf(user.getId()));
			context.setAttachment("username", user.getUsername());
			Result result = super.invoke(invoker, invocation);
			backgroundUser.set((Object) null);
			return result;
		}
	}

	protected final User getLogonUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) {
			return this.getBackgroundUser();
		} else {
			if (auth.isAuthenticated() && !auth.getName().equals("anonymous")) {
				GewaraUser user = (GewaraUser) auth.getPrincipal();
				if (user instanceof User) {
					return (User) user;
				}
			}

			return this.getBackgroundUser();
		}
	}

	private User getBackgroundUser() {
		return (User) backgroundUser.get();
	}

	public static void setBackgroundUser() {
		User user = new User("background");
		user.setId(Long.valueOf(1L));
		backgroundUser.set(user);
	}

	class ResponseResult extends RpcResult {
		private static final long serialVersionUID = 6016707108550302385L;

		public ResponseResult(ResultCode result) {
			super(result);
		}

		public ResultCode getValue() {
			return (ResultCode) super.getValue();
		}
	}
}
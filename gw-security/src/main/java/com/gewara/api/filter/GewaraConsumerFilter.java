package com.gewara.api.filter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

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

public class GewaraConsumerFilter extends GenericFilter {
	public static final ThreadLocal<User> backgroundUser = new ThreadLocal<User>();
	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		User user = getLogonUser();
		if(user == null){
			return new ResponseResult(ResultCode.getFailure("ÇëÏÈµÇÂ¼£¡"));
		}
		RpcContext context = RpcContext.getContext();
		context.setAttachment(AutherFilterConstant.SYSTEMID, Config.SYSTEMID);
		context.setAttachment(AutherFilterConstant.USERID, String.valueOf(user.getId()));
		context.setAttachment(AutherFilterConstant.USERNAME, user.getUsername());
		Result result = super.invoke(invoker, invocation);
		backgroundUser.set(null);
		return result;
	}
	
	protected final User getLogonUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth == null){
			return getBackgroundUser();
		}
		if(auth.isAuthenticated() && !auth.getName().equals("anonymous")){//µÇÂ¼
			GewaraUser user = (GewaraUser) auth.getPrincipal();
			//refresh(user);
			if(user instanceof User) return (User)user;
		}
		return getBackgroundUser();
	}
	private User getBackgroundUser(){
		return backgroundUser.get();
	}
	
	public static void setBackgroundUser(){
		User user = new User("background");
		user.setId(1L);
		backgroundUser.set(user);
	}
	class ResponseResult extends RpcResult{
		private static final long serialVersionUID = 6016707108550302385L;
		public ResponseResult(ResultCode result) {
			super(result);
		}
		@Override
		public ResultCode getValue() {
			return (ResultCode) super.getValue();
		}
	}
}

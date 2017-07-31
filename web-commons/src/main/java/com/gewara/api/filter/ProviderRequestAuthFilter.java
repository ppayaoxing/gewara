package com.gewara.api.filter;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.filter.GenericFilter;
import com.gewara.constant.AutherFilterConstant;

public class ProviderRequestAuthFilter extends GenericFilter{
	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		RpcContext context = RpcContext.getContext();
		Map<String,String> params = context.getAttachments();
		try{
			DubboApiAuth dubboApiAuth = createApiAuth(params);
			DubboAttachementUtil.setDubboApiAuth(dubboApiAuth);
			Result result = super.invoke(invoker, invocation);
			return result;
		}finally{
			DubboAttachementUtil.clearAttachments();
		}
	}
	
	private DubboApiAuth createApiAuth(Map<String,String> params){
		String reqUri = params.get(AutherFilterConstant.REQURI);
		String systemid = params.get(AutherFilterConstant.SYSTEMID);
		String logonUserid = params.get(AutherFilterConstant.USERID);
		Long userid = null;
		if(StringUtils.isNotBlank(logonUserid)){
			userid = Long.valueOf(logonUserid);
		}
		String username = params.get(AutherFilterConstant.USERNAME);
		String sessionid = params.get(AutherFilterConstant.SESSIONID);
		String remoteIp = params.get(AutherFilterConstant.REMOTEIP);
		return new DubboApiAuth(reqUri, systemid, userid, username, sessionid, remoteIp);
	}
}

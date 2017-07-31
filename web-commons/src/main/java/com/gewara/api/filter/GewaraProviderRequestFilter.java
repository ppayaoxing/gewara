package com.gewara.api.filter;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.filter.GenericFilter;
import com.gewara.api.vo.ResultCode;
import com.gewara.constant.AutherFilterConstant;
import com.gewara.util.GewaIpConfig;
import com.gewara.web.support.DynamicStats.LogCounter;
import com.gewara.web.support.ResourceStatsUtil;

public class GewaraProviderRequestFilter extends GenericFilter{
	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		RpcContext context = RpcContext.getContext();
		String remoteIp = context.getRemoteHost();
		//1)验证权限
		if(!GewaIpConfig.isGewaInnerIp(remoteIp) && !GewaIpConfig.isLocalIp(remoteIp)) {
			return new ResponseResult(ResultCode.getFailure(ResultCode.CODE_UNKNOWN_ERROR, "没有权限"));
		}
		Map<String,String> params = context.getAttachments();
		
		String systemid = params.get(AutherFilterConstant.SYSTEMID);
		if(StringUtils.isBlank(systemid)) {
			//FIXME:后期放开
			//return new ResponseResult(ResultCode.getFailure(ResultCode.CODE_UNKNOWN_ERROR, "没有权限"));
		}
		//2)计时
		long t = System.currentTimeMillis();
		String method = invoker.getUrl().getPath() + "." + invocation.getMethodName();
		LogCounter counter = ResourceStatsUtil.getApiMethodStats().beforeProcessAndReg(method, t);
		try{
			return super.invoke(invoker, invocation);
		}finally{
			ResourceStatsUtil.getApiMethodStats().afterProcess(counter, t, true);
		}
	}
}

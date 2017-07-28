/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.api.filter;

import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.filter.GenericFilter;
import com.gewara.api.filter.ResponseResult;
import com.gewara.api.vo.ResultCode;
import com.gewara.util.GewaIpConfig;
import com.gewara.web.support.ResourceStatsUtil;
import com.gewara.web.support.DynamicStats.LogCounter;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class GewaraProviderRequestFilter extends GenericFilter {
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		RpcContext context = RpcContext.getContext();
		String remoteIp = context.getRemoteHost();
		if (!GewaIpConfig.isGewaInnerIp(remoteIp) && !GewaIpConfig.isLocalIp(remoteIp)) {
			return new ResponseResult(ResultCode.getFailure("9999", "没有权限"));
		} else {
			Map params = context.getAttachments();
			String systemid = (String) params.get("systemid");
			if (StringUtils.isBlank(systemid)) {
				;
			}

			long t = System.currentTimeMillis();
			String method = invoker.getUrl().getPath() + "." + invocation.getMethodName();
			LogCounter counter = ResourceStatsUtil.getApiMethodStats().beforeProcessAndReg(method, t);

			Result arg10;
			try {
				arg10 = super.invoke(invoker, invocation);
			} finally {
				ResourceStatsUtil.getApiMethodStats().afterProcess(counter, t, true);
			}

			return arg10;
		}
	}
}
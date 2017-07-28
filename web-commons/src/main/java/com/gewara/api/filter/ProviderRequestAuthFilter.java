/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.api.filter;

import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.filter.GenericFilter;
import com.gewara.api.filter.DubboApiAuth;
import com.gewara.api.filter.DubboAttachementUtil;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class ProviderRequestAuthFilter extends GenericFilter {
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		RpcContext context = RpcContext.getContext();
		Map params = context.getAttachments();

		Result arg6;
		try {
			DubboApiAuth dubboApiAuth = this.createApiAuth(params);
			DubboAttachementUtil.setDubboApiAuth(dubboApiAuth);
			Result result = super.invoke(invoker, invocation);
			arg6 = result;
		} finally {
			DubboAttachementUtil.clearAttachments();
		}

		return arg6;
	}

	private DubboApiAuth createApiAuth(Map<String, String> params) {
		String reqUri = (String) params.get("reqUri");
		String systemid = (String) params.get("systemid");
		String logonUserid = (String) params.get("userid");
		Long userid = null;
		if (StringUtils.isNotBlank(logonUserid)) {
			userid = Long.valueOf(logonUserid);
		}

		String username = (String) params.get("username");
		String sessionid = (String) params.get("sessionid");
		String remoteIp = (String) params.get("remoteIp");
		return new DubboApiAuth(reqUri, systemid, userid, username, sessionid, remoteIp);
	}
}
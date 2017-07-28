/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.api.filter;

import com.alibaba.dubbo.rpc.RpcContext;
import com.gewara.api.filter.DubboApiAuth;
import com.gewara.util.Assert;
import java.util.HashMap;
import java.util.Map;

public class DubboAttachementUtil {
	private static final ThreadLocal<DubboApiAuth> holder = new ThreadLocal();

	public static DubboApiAuth getDubboApiAuth() {
		return (DubboApiAuth) holder.get();
	}

	public static void setDubboApiAuth(DubboApiAuth dubboApiAuth) {
		Assert.notNull(dubboApiAuth);
		holder.set(dubboApiAuth);
	}

	public static void clearAttachments() {
		holder.remove();
	}

	public static Map<String, String> getAttachments() {
		RpcContext context = RpcContext.getContext();
		return context != null ? new HashMap(context.getAttachments()) : new HashMap();
	}

	public static String getTrace() {
		RpcContext context = RpcContext.getContext();
		if (context != null) {
			Map params = getAttachments();
			String callip = context.getRemoteHost();
			String systemid = (String) params.get("systemid");
			params.put("callip", callip);
			params.put("systemid", systemid);
			return params.toString();
		} else {
			return null;
		}
	}
}
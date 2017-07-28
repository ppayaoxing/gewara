/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.api.filter;

import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.RpcResult;
import com.alibaba.dubbo.rpc.filter.GenericFilter;
import com.gewara.Config;
import com.gewara.api.filter.DubboConsumerUtil;
import com.gewara.api.vo.ResultCode;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import com.gewara.web.support.ResourceStatsUtil;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

@Activate(group = {"consumer"})
public class ResultCodeTransformFilter extends GenericFilter {
	private GewaLogger dbLogger = WebLogger.getLogger(this.getClass());

	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		Map header = DubboConsumerUtil.getHeader();

		RpcResult ret1;
		try {
			RpcContext e = RpcContext.getContext();
			if (header != null) {
				header.put("systemid", Config.SYSTEMID);
				e.setAttachments(header);
			} else {
				e.setAttachment("systemid", Config.SYSTEMID);
			}

			Result ret2 = super.invoke(invoker, invocation);
			if (ret2.hasException()) {
				this.dbLogger.error(invoker.getUrl().getPath() + "." + invocation.getMethodName(), ret2.getException(),
						10);
				ResultCode ret4 = ResultCode.getFailure("9999", "服务短路");
				ret4.setException(ret2.getException());
				String service = StringUtils.substringAfterLast(invoker.getUrl().getPath(), ".");
				ResourceStatsUtil.getErrorStats().incrementCount("dubbo." + service);
				RpcResult arg7 = new RpcResult(ret4);
				return arg7;
			}

			Result ret3 = ret2;
			return ret3;
		} catch (Throwable arg11) {
			this.dbLogger.error(arg11, 10);
			ResultCode ret = ResultCode.getFailure("9999", "服务短路！");
			ret.setException(arg11);
			ret1 = new RpcResult(ret);
		} finally {
			if (header != null) {
				DubboConsumerUtil.clearHeader();
			}

		}

		return ret1;
	}
}
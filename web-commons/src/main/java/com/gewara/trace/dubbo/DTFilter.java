/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.trace.dubbo;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.gewara.Config;
import com.gewara.trace.Span;
import com.gewara.trace.TraceContext;
import com.gewara.trace.TraceContextHolder;
import com.gewara.trace.agent.DtAgent;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import org.apache.commons.lang.StringUtils;

public class DTFilter implements Filter {
	protected final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private DtAgent dtAgent;

	public void setDtAgent(DtAgent dtAgent) {
		this.dtAgent = dtAgent;
	}

	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		RpcContext context = RpcContext.getContext();
		boolean isConsumerSide = context.isConsumerSide();
		boolean isProviderSide = context.isProviderSide();
		Span span = null;
		String traceId = null;
		int parentId = 0;
		boolean curSpanId = true;
		TraceContext traceContext = TraceContextHolder.getContext();

		Result curSpanIdStr1;
		try {
			int curSpanId1;
			if (isConsumerSide && traceContext != null) {
				parentId = traceContext.getParentId();
				curSpanId1 = traceContext.getSpanSeq();
				context.setAttachment(TraceContext.DT_TRACEID, traceContext.getTraceId());
				context.setAttachment(TraceContext.DT_PARENTID, parentId + "");
				context.setAttachment(TraceContext.DT_SPANSEQ, curSpanId1 + "");
			} else if (isProviderSide) {
				traceId = context.getAttachment(TraceContext.DT_TRACEID);
				String result = context.getAttachment(TraceContext.DT_PARENTID);
				String curSpanIdStr = context.getAttachment(TraceContext.DT_SPANSEQ);
				if (StringUtils.isNotBlank(traceId) && StringUtils.isNotBlank(result)
						&& StringUtils.isNotBlank(curSpanIdStr)) {
					parentId = Integer.valueOf(result).intValue();
					curSpanId1 = Integer.valueOf(curSpanIdStr).intValue() + 1000;
					span = new Span(Config.SYSTEMID, Config.getServerIp(),
							context.getUrl().getServiceInterface() + "." + context.getMethodName(), traceId,
							Integer.valueOf(parentId), Integer.valueOf(curSpanId1),
							Long.valueOf(System.currentTimeMillis()));
					traceContext = new TraceContext(traceId, curSpanId1, curSpanId1);
					TraceContextHolder.setContext(traceContext);
				}
			}

			Result result1 = invoker.invoke(invocation);
			curSpanIdStr1 = result1;
		} finally {
			if (isConsumerSide && traceContext != null) {
				traceContext.setParentId(parentId);
			}

			if (isProviderSide && span != null) {
				span.setRvTime(Long.valueOf(System.currentTimeMillis()));
				TraceContextHolder.addSpan(span);
				TraceContextHolder.clearContext();
				this.dtAgent.sendTraceInfo(TraceContextHolder.getTraceInfo(traceId));
			}

		}

		return curSpanIdStr1;
	}
}
/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.trace.aspect;

import com.gewara.Config;
import com.gewara.trace.Sampler;
import com.gewara.trace.Span;
import com.gewara.trace.TraceContext;
import com.gewara.trace.TraceContextHolder;
import com.gewara.trace.agent.DtAgent;
import com.gewara.trace.annotation.GwTrace;
import com.gewara.util.GewaLogger;
import com.gewara.util.ObjectId;
import com.gewara.util.WebLogger;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TraceAspect {
	protected final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	@Autowired
	@Qualifier("dtAgent")
	DtAgent dtAgent;
	Sampler sampler = new Sampler();

	@Around("@annotation(trace)")
	public Object around(JoinPoint joinPoint, GwTrace trace) throws Throwable {
		Span span = null;
		boolean begin = false;
		int parentId = 0;
		byte curSpanId = 1;
		String traceId = null;
		TraceContext context = TraceContextHolder.getContext();
		if (StringUtils.equals(trace.status(), "begin") && this.sampler.isSample()) {
			begin = true;
			traceId = ObjectId.uuid();
			context = new TraceContext(traceId, parentId, curSpanId);
			TraceContextHolder.setContext(context);
		}

		if (context != null) {
			parentId = context.getParentId();
			int curSpanId1 = context.getSpanSeq() + 1;
			span = new Span(Config.SYSTEMID, Config.getServerIp(), joinPoint.getSignature().toString(),
					context.getTraceId(), Integer.valueOf(parentId), Integer.valueOf(curSpanId1),
					Long.valueOf(System.currentTimeMillis()));
			context.setParentId(curSpanId1);
			context.setSpanSeq(curSpanId1);
		}

		Object arg9;
		try {
			Object rv = ((ProceedingJoinPoint) joinPoint).proceed();
			arg9 = rv;
		} finally {
			if (span != null) {
				span.setRvTime(Long.valueOf(System.currentTimeMillis()));
				TraceContextHolder.addSpan(span);
			}

			if (context != null) {
				context.setParentId(parentId);
			}

			if (begin) {
				TraceContextHolder.clearContext();
				this.dtAgent.sendTraceInfo(TraceContextHolder.getTraceInfo(traceId));
			}

		}

		return arg9;
	}
}
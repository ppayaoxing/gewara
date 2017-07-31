package com.gewara.trace.aspect;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

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

/**
 * DT系统AOP,结合<{@link GwTrace}>使用
 * <br>参详：<hr>http://wk.gewara.com/pages/viewpage.action?pageId=19147575</hr>
 * @author quzhuping
 */
@Component
@Aspect
public class TraceAspect {
	protected final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());

	@Autowired@Qualifier("dtAgent")
	DtAgent dtAgent;
	
	Sampler sampler = new Sampler();
	
	@Around(value = "@annotation(trace)")
	public Object around(JoinPoint joinPoint, GwTrace trace) throws Throwable{
		Span span = null;
		boolean begin = false;
		int parentId = 0;
		int curSpanId = 1;
		String traceId = null;
		
		TraceContext context = TraceContextHolder.getContext();
		if(StringUtils.equals(trace.status(), "begin") && sampler.isSample()){
			begin = true;
			traceId = ObjectId.uuid();
			context = new TraceContext(traceId, parentId, curSpanId);
			TraceContextHolder.setContext(context);
		}
		if(context != null){
			parentId = context.getParentId();
			curSpanId = context.getSpanSeq() + 1;
			
			span = new Span(Config.SYSTEMID, Config.getServerIp(), joinPoint.getSignature().toString(), context.getTraceId(), parentId, curSpanId, System.currentTimeMillis());
			context.setParentId(curSpanId);
			context.setSpanSeq(curSpanId);
		}
		try {
			Object rv = ((ProceedingJoinPoint) joinPoint).proceed();
			return rv;
		}finally{
			if(span != null){
				span.setRvTime(System.currentTimeMillis());
			    TraceContextHolder.addSpan(span);
			}
			if(context != null){
				context.setParentId(parentId);
			}
			if(begin){
				TraceContextHolder.clearContext();
				dtAgent.sendTraceInfo(TraceContextHolder.getTraceInfo(traceId));
			}
					
		}
	}	 
}

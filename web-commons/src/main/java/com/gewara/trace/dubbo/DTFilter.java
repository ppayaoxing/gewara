package com.gewara.trace.dubbo;

import org.apache.commons.lang.StringUtils;

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

//@Activate(group = {Constants.PROVIDER, Constants.CONSUMER})
public class DTFilter implements Filter {
	protected final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	
	private DtAgent dtAgent;
	public void setDtAgent(DtAgent dtAgent) {
		this.dtAgent = dtAgent;
	}

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation)
			throws RpcException {
		RpcContext context = RpcContext.getContext();
	    boolean isConsumerSide = context.isConsumerSide();
	    boolean isProviderSide = context.isProviderSide();
	    Span span = null;
	    String traceId = null;
	    int parentId = 0;
		int curSpanId = 1;
		TraceContext traceContext = TraceContextHolder.getContext();
	    try{
	    	if(isConsumerSide && traceContext != null){
	    		parentId = traceContext.getParentId();
	    		curSpanId = traceContext.getSpanSeq();
    			context.setAttachment(TraceContext.DT_TRACEID, traceContext.getTraceId());
    			context.setAttachment(TraceContext.DT_PARENTID, parentId + "");
    			context.setAttachment(TraceContext.DT_SPANSEQ, curSpanId + "");
    			
	    	}else if(isProviderSide){
	    		traceId = context.getAttachment(TraceContext.DT_TRACEID);
	    		String parentIdStr = context.getAttachment(TraceContext.DT_PARENTID);
	    		String curSpanIdStr = context.getAttachment(TraceContext.DT_SPANSEQ);
	    		if(StringUtils.isNotBlank(traceId) && StringUtils.isNotBlank(parentIdStr) && StringUtils.isNotBlank(curSpanIdStr)){
	    			parentId = Integer.valueOf(parentIdStr);
	    			curSpanId = Integer.valueOf(curSpanIdStr) + 1000;
	    			span = new Span(Config.SYSTEMID, Config.getServerIp(), context.getUrl().getServiceInterface()+ "." + context.getMethodName(), traceId, parentId, curSpanId, System.currentTimeMillis());
	    			
	    			traceContext = new TraceContext(traceId, curSpanId, curSpanId);
	    			TraceContextHolder.setContext(traceContext);
	    		}
	    	}
	    	Result result = invoker.invoke(invocation);
	    	return result;
	    }finally{
	    	if(isConsumerSide && traceContext != null){
	    		traceContext.setParentId(parentId);
	    	}
	    	if(isProviderSide){//释放ThreadLocal，发生trace消息
	    		if(span != null){
	    			span.setRvTime(System.currentTimeMillis());
	    			TraceContextHolder.addSpan(span);
	    			TraceContextHolder.clearContext();
	    			dtAgent.sendTraceInfo(TraceContextHolder.getTraceInfo(traceId));
	    		} 		
	    	}
	    }
	}
}

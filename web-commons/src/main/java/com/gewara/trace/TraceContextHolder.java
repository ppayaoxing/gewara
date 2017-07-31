package com.gewara.trace;

import java.util.ArrayList;
import java.util.List;

import com.gewara.util.Assert;
import com.gewara.util.Gcache;

public class TraceContextHolder {
	private static final ThreadLocal<TraceContext> holder = new ThreadLocal<TraceContext>();
	
	private static final Gcache<String, List<Span>> traceCache = new Gcache<>(500000);
	
	public static TraceContext getContext(){
		return holder.get();
	}
	
	public static void setContext(TraceContext attachments){
		 Assert.notNull(attachments);
		holder.set(attachments);
	}
	
	public static void clearContext(){
		holder.remove();
	}
	
	public static void addSpan(Span span){
		List spanList = traceCache.getIfPresent(span.getTraceId());
		if(spanList == null){
			spanList = new ArrayList<>();
			spanList.add(span);
			traceCache.put(span.getTraceId(), spanList);
		}else{
			spanList.add(span);
		}
	}
	
	public static List<Span> getTraceInfo(String traceId){
		List<Span> spanList = traceCache.getIfPresent(traceId);
		traceCache.invalidate(traceId);
		return spanList;
	}
}

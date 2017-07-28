/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.trace;

import com.gewara.trace.Span;
import com.gewara.trace.TraceContext;
import com.gewara.util.Assert;
import com.gewara.util.Gcache;
import java.util.ArrayList;
import java.util.List;

public class TraceContextHolder {
	private static final ThreadLocal<TraceContext> holder = new ThreadLocal();
	private static final Gcache<String, List<Span>> traceCache = new Gcache(500000L);

	public static TraceContext getContext() {
		return (TraceContext) holder.get();
	}

	public static void setContext(TraceContext attachments) {
		Assert.notNull(attachments);
		holder.set(attachments);
	}

	public static void clearContext() {
		holder.remove();
	}

	public static void addSpan(Span span) {
		List spanList = (List) traceCache.getIfPresent(span.getTraceId());
		if (spanList == null) {
			ArrayList spanList1 = new ArrayList();
			spanList1.add(span);
			traceCache.put(span.getTraceId(), spanList1);
		} else {
			spanList.add(span);
		}

	}

	public static List<Span> getTraceInfo(String traceId) {
		List spanList = (List) traceCache.getIfPresent(traceId);
		traceCache.invalidate(traceId);
		return spanList;
	}
}
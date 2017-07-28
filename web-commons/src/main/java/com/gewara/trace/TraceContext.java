/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.trace;

import java.io.Serializable;

public class TraceContext implements Serializable {
	private static final long serialVersionUID = -6108668320446033050L;
	public static String DT_TRACEID = "DT_TRACEID";
	public static String DT_PARENTID = "DT_PARENTID";
	public static String DT_SPANSEQ = "DT_SPANSEQ";
	private String traceId;
	private int parentId;
	private int spanSeq;

	public TraceContext(String traceId, int parentId, int spanSeq) {
		this.traceId = traceId;
		this.parentId = parentId;
		this.spanSeq = spanSeq;
	}

	public String getTraceId() {
		return this.traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public int getSpanSeq() {
		return this.spanSeq;
	}

	public void setSpanSeq(int spanSeq) {
		this.spanSeq = spanSeq;
	}

	public int getParentId() {
		return this.parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
}
package com.gewara.trace;

import java.io.Serializable;

/**
 * 调用链上下文
 * <br>参详：<hr>http://wk.gewara.com/pages/viewpage.action?pageId=19147575</hr>
 * @author user
 */
public class TraceContext implements Serializable{
	private static final long serialVersionUID = -6108668320446033050L;
	
	public static String DT_TRACEID = "DT_TRACEID";
	public static String DT_PARENTID = "DT_PARENTID";
	public static String DT_SPANSEQ = "DT_SPANSEQ";

	private String traceId; //调用链全局id
	private int parentId;
	private int spanSeq;	//当前span的序号，子节点在此基础上加1，生成自己的spanid
	
	public TraceContext(String traceId, int parentId, int spanSeq){
		this.traceId = traceId;
		this.parentId = parentId;
		this.spanSeq =spanSeq;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public int getSpanSeq() {
		return spanSeq;
	}

	public void setSpanSeq(int spanSeq) {
		this.spanSeq = spanSeq;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
}

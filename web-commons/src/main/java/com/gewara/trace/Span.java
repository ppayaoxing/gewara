package com.gewara.trace;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.gewara.util.JsonUtils;
/**
 * 调用链的一个节点，通过traceId确定数据的调用链归属
 * <br>参详：<hr>http://wk.gewara.com/pages/viewpage.action?pageId=19147575</hr>
 * @author user
 *
 */
public class Span implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;		//=traceId + spanId
	private String traceId;	//全局唯一id
	private Integer parentId;	//父ID，如果为0则为root span
	private Integer spanId;		//当前节点id
	private Long callTime;	//调用时间戳
	private Long rvTime;	//返回时间戳
	private String systemId;//系统id
	private String host;//节点主机名
	private String spanUri;	//节点uri
	private Integer duration;
	
	public Span(){
	}
	/**
	 * 构造函数
	 * @param systemId 系统id
	 * @param hostname 节点主机名
	 * @param spanUri 节点uri
	 * @param traceId 全局唯一id
	 * @param parentId 父ID，如果为0则为root span
	 * @param spanId 当前节点id
	 * @param calltime 调用时间戳
	 */
	public Span(String systemId, String host, String spanUri, String traceId, Integer parentId, Integer spanId,Long calltime){
		this.id = traceId + "_" + spanId;
		this.systemId = systemId;
		this.host = host;
		this.spanUri = clean(spanUri);
		this.traceId = traceId;
		this.parentId = parentId;
		this.spanId = spanId;
		this.callTime = calltime;
	}
	
	@Override
	public String toString(){
		return JsonUtils.writeObjectToJson(this);
	}
	
	public String getTraceId() {
		return traceId;
	}
	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getSpanId() {
		return spanId;
	}
	public void setSpanId(Integer spanId) {
		this.spanId = spanId;
	}
	public Long getCallTime() {
		return callTime;
	}
	public void setCallTime(Long callTime) {
		this.callTime = callTime;
	}
	public Long getRvTime() {
		return rvTime;
	}
	public void setRvTime(Long rvTime) {
		this.rvTime = rvTime;
		this.duration = (int) (this.rvTime - this.callTime);
	}
	public String getSystemId() {
		return systemId;
	}
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	public String getSpanUri() {
		return spanUri;
	}
	public void setSpanUri(String spanUri) {
		this.spanUri = clean(spanUri);
	}
	public String getId() {
		return id;
	}
	/**
	 * 存储时作为es的id使用
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	public String getHost() {
		return host;
	}

	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
	private String clean(String src){
		String rv = StringUtils.replace(StringUtils.replace(StringUtils.substringBefore(src, "("),"com.", "c."),"gewara.", "g.");
		if(StringUtils.contains(rv, " ")){
			rv = StringUtils.substringAfterLast(rv, " ");
		}
		return rv;
	}
}

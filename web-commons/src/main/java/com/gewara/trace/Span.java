/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.trace;

import com.gewara.util.JsonUtils;
import java.io.Serializable;
import org.apache.commons.lang.StringUtils;

public class Span implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String traceId;
	private Integer parentId;
	private Integer spanId;
	private Long callTime;
	private Long rvTime;
	private String systemId;
	private String host;
	private String spanUri;
	private Integer duration;

	public Span() {
	}

	public Span(String systemId, String host, String spanUri, String traceId, Integer parentId, Integer spanId,
			Long calltime) {
		this.id = traceId + "_" + spanId;
		this.systemId = systemId;
		this.host = host;
		this.spanUri = this.clean(spanUri);
		this.traceId = traceId;
		this.parentId = parentId;
		this.spanId = spanId;
		this.callTime = calltime;
	}

	public String toString() {
		return JsonUtils.writeObjectToJson(this);
	}

	public String getTraceId() {
		return this.traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getSpanId() {
		return this.spanId;
	}

	public void setSpanId(Integer spanId) {
		this.spanId = spanId;
	}

	public Long getCallTime() {
		return this.callTime;
	}

	public void setCallTime(Long callTime) {
		this.callTime = callTime;
	}

	public Long getRvTime() {
		return this.rvTime;
	}

	public void setRvTime(Long rvTime) {
		this.rvTime = rvTime;
		this.duration = Integer.valueOf((int) (this.rvTime.longValue() - this.callTime.longValue()));
	}

	public String getSystemId() {
		return this.systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getSpanUri() {
		return this.spanUri;
	}

	public void setSpanUri(String spanUri) {
		this.spanUri = this.clean(spanUri);
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHost() {
		return this.host;
	}

	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public void setHost(String host) {
		this.host = host;
	}

	private String clean(String src) {
		String rv = StringUtils.replace(StringUtils.replace(StringUtils.substringBefore(src, "("), "com.", "c."),
				"gewara.", "g.");
		if (StringUtils.contains(rv, " ")) {
			rv = StringUtils.substringAfterLast(rv, " ");
		}

		return rv;
	}
}
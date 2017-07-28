/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.push.api.req.vo;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class PushCommonReqVo implements Serializable {
	private static final long serialVersionUID = 4572609223488668907L;
	protected String remoteIp;
	private Map<String, Object> commonMap;

	public PushCommonReqVo() {
	}

	public PushCommonReqVo(String remoteIp, Map<String, Object> commonMap) {
		this.remoteIp = remoteIp;
		this.commonMap = commonMap;
	}

	public Map<String, Object> getCommonMap() {
		return this.commonMap;
	}

	public void setCommonMap(Map<String, Object> commonMap) {
		this.commonMap = commonMap;
	}

	public String getRemoteIp() {
		return this.remoteIp;
	}

	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}

	public void addValue(String key, String value) {
		this.commonMap.put(key, value);
	}

	public Object gainValue(String key) {
		return this.commonMap.get(key);
	}

	public String gainStringValue(String key) {
		Object object = this.gainValue(key);
		return object == null ? "" : String.valueOf(object);
	}

	public Long gainLongValue(String key) {
		String str = this.gainStringValue(key);
		return StringUtils.isBlank(str) ? null : Long.valueOf(str);
	}

	public Integer gainIntegerValue(String key) {
		String str = this.gainStringValue(key);
		return StringUtils.isBlank(str) ? null : Integer.valueOf(str);
	}
}
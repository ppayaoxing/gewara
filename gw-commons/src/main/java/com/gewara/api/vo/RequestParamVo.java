/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo;

import com.gewara.util.DateUtil;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class RequestParamVo implements Serializable {
	private static final long serialVersionUID = 118918163520189721L;
	private Map<String, String> params;
	private String reqUri;
	private String systemid;
	private Long logonUserId;
	private String sessionid;
	private String remoteIp;

	public Map<String, String> getParams() {
		return this.params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	public String getReqUri() {
		return this.reqUri;
	}

	public void setReqUri(String reqUri) {
		this.reqUri = reqUri;
	}

	public String getSystemid() {
		return this.systemid;
	}

	public void setSystemid(String systemid) {
		this.systemid = systemid;
	}

	public Long getLogonUserId() {
		return this.logonUserId;
	}

	public void setLogonUserId(Long logonUserId) {
		this.logonUserId = logonUserId;
	}

	public String getSessionid() {
		return this.sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public String getRemoteIp() {
		return this.remoteIp;
	}

	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}

	public Long getLong(String key) {
		String result = this.getString(key);
		return StringUtils.isBlank(result) ? null : Long.valueOf(Long.parseLong(result));
	}

	public Integer getInteger(String key) {
		String result = this.getString(key);
		return StringUtils.isBlank(result) ? null : Integer.valueOf(Integer.parseInt(result));
	}

	public Timestamp getTimestamp(String key) {
		String result = this.getString(key);
		return StringUtils.isBlank(result) ? null : DateUtil.parseTimestamp(result);
	}

	public Date getDate(String key) {
		String result = this.getString(key);
		return StringUtils.isBlank(result) ? null : DateUtil.parseDate(result);
	}

	public String getString(String key) {
		if (this.params == null) {
			return null;
		} else {
			String result = (String) this.params.get(key);
			return result;
		}
	}
}
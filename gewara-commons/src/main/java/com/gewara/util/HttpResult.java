/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.util.DateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.map.CaseInsensitiveMap;

public class HttpResult {
	private Map<String, String> responseHeader = new CaseInsensitiveMap();
	private List<String[]> cookies = new ArrayList();
	private boolean success;
	private String response;
	private String msg;
	private int status;

	public List<String[]> getCookies() {
		return this.cookies;
	}

	public HttpResult(boolean success, String response, String msg) {
		this.success = success;
		this.response = response;
		this.msg = msg;
	}

	public HttpResult(boolean success, String response, String msg, int status) {
		this.success = success;
		this.response = response;
		this.msg = msg;
		this.status = status;
	}

	public String getResponse() {
		return this.response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static HttpResult getSuccessReturn(String result) {
		return new HttpResult(true, result, (String) null, 200);
	}

	public boolean isSuccess() {
		return this.success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public static HttpResult getFailure(String msg) {
		return new HttpResult(false, (String) null, msg);
	}

	public static HttpResult getFailure(String msg, int status) {
		return new HttpResult(false, (String) null, msg, status);
	}

	public static HttpResult getFailure(String msg, int status, String content) {
		return new HttpResult(false, content, msg, status);
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void addHeader(String name, String value) {
		this.responseHeader.put(name, value);
	}

	public String getHeader(String name) {
		return (String) this.responseHeader.get(name);
	}

	public Map<String, String> getAllHeaders() {
		return this.responseHeader;
	}

	public void addCookie(String name, String path, String value, Date expire) {
		this.cookies.add(new String[] { name, path, value, DateUtil.formatTimestamp(expire) });
	}
}
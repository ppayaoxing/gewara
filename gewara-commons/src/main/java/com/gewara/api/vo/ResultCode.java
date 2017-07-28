/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class ResultCode<T> implements Serializable {
	public static final String CODE_SUCCESS = "0000";
	public static final String CODE_UNKNOWN_ERROR = "9999";
	public static final String CODE_DATA_ERROR = "4005";
	private static final long serialVersionUID = 4418416282894231647L;
	private String errcode;
	private String msg;
	private T retval;
	private boolean success = false;
	private Throwable exception;
	public static ResultCode SUCCESS = new ResultCode("0000", "²Ù×÷³É¹¦£¡", (Object) null);

	protected ResultCode(String code, String msg, T retval) {
		this.errcode = code;
		this.msg = msg;
		this.retval = retval;
		this.success = StringUtils.equals(code, "0000");
	}

	public boolean equals(Object another) {
		return another != null && another instanceof ResultCode ? this.errcode == ((ResultCode) another).errcode
				: false;
	}

	public boolean isSuccess() {
		return this.success;
	}

	public static ResultCode getFailure(String msg) {
		return new ResultCode("9999", msg, (Object) null);
	}

	public static ResultCode getFailure(String code, String msg) {
		return new ResultCode(code, msg, (Object) null);
	}

	public static ResultCode getSuccess(String msg) {
		return new ResultCode("0000", msg, (Object) null);
	}

	public static <T> ResultCode<T> getSuccessReturn(T retval) {
		return new ResultCode("0000", (String) null, retval);
	}

	public static ResultCode getSuccessMap() {
		return new ResultCode("0000", (String) null, new HashMap());
	}

	public static <T> ResultCode getFailureReturn(T retval) {
		return new ResultCode("9999", (String) null, retval);
	}

	public static <T> ResultCode getFailureReturn(T retval, String msg) {
		return new ResultCode("9999", msg, retval);
	}

	public static ResultCode getFullErrorCode(String code, String msg, Object retval) {
		return new ResultCode(code, msg, retval);
	}

	public T getRetval() {
		return this.retval;
	}

	public String getMsg() {
		return this.msg;
	}

	public void put(Object key, Object value) {
		((Map) this.retval).put(key, value);
	}

	public String getErrcode() {
		return this.errcode;
	}

	public Throwable getException() {
		return this.exception;
	}

	public void setException(Throwable exception) {
		this.exception = exception;
	}
}
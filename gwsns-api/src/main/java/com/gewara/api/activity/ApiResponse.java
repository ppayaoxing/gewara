/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.activity;

import java.io.Serializable;

public abstract class ApiResponse implements Serializable {
	public static final String CODE_SUCCESS = "0000";
	public static final String CODE_FAIL = "9999";
	private static final long serialVersionUID = -5249491982205094684L;
	private String code = "9999";
	private String msg;

	public boolean isSuccess() {
		return this.code != null ? "0000".equals(this.code) : false;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
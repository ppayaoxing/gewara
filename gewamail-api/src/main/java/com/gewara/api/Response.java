/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api;

import java.io.Serializable;

public class Response implements Serializable {
	private static final long serialVersionUID = -8647520008960856935L;
	private String code;
	private String msg;

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCodeSuccess() {
		this.code = "0000";
	}

	public void setCodeSuccess(String msg) {
		this.setCodeSuccess();
		this.setMsg(msg);
	}

	public boolean isSuccess() {
		return this.code != null ? "0000".equals(this.code) : false;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
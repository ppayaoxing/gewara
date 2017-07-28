/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api;

import java.io.Serializable;

public abstract class MsgResponse implements Serializable {
	private static final long serialVersionUID = -8647520008960856935L;
	private String code;
	private String msg;

	public boolean isSuccess() {
		return this.code != null ? "0000".equals(this.code) : false;
	}

	public void setSuccess() {
		this.code = "0000";
		this.msg = "³É¹¦";
	}

	public void setSuccess(String msg) {
		this.setSuccess();
		this.setMsg(msg);
	}

	public void setFailure() {
		this.code = "9999";
		this.msg = "Ê§°Ü";
	}

	public void setFailure(String msg) {
		this.setFailure();
		this.setMsg(msg);
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
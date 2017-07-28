/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.gmessage.external.entity;

import java.io.Serializable;

public class OperateResult implements Serializable {
	private static final long serialVersionUID = -4280148580555226376L;
	private boolean success = true;

	private String failCode = null;

	private String failMessage = null;

	public OperateResult(boolean success) {
		this.success = success;
	}

	public OperateResult(boolean success, String failCode) {
		this.success = success;
		this.failCode = failCode;
	}

	public boolean isSuccess() {
		return this.success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getFailCode() {
		return this.failCode;
	}

	public void setFailCode(String failCode) {
		this.failCode = failCode;
	}

	public String getFailMessage() {
		return this.failMessage;
	}

	public void setFailMessage(String failMessage) {
		this.failMessage = failMessage;
	}
}
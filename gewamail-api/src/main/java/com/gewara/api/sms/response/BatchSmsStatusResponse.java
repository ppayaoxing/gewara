/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sms.response;

import com.gewara.api.MsgResponse;

public class BatchSmsStatusResponse extends MsgResponse {
	private static final long serialVersionUID = -7944063687032876841L;
	private String statusInfo;

	public String getStatusInfo() {
		return this.statusInfo;
	}

	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}

	public BatchSmsStatusResponse() {
	}

	public BatchSmsStatusResponse(String statusInfo, String code, String msg) {
		super.setCode(code);
		super.setMsg(msg);
		this.statusInfo = statusInfo;
	}

	public BatchSmsStatusResponse getSuccessReturn(String statusInfo) {
		BatchSmsStatusResponse response = new BatchSmsStatusResponse();
		response.setStatusInfo(statusInfo);
		response.setSuccess();
		return response;
	}
}
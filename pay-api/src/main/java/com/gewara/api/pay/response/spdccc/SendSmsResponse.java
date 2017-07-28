/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.response.spdccc;

import com.gewara.api.pay.ApiResponse;

public class SendSmsResponse extends ApiResponse {
	private static final long serialVersionUID = -5616810065489456044L;
	private String tradeNo;
	private String verifyCode;
	private String teleNo;

	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getVerifyCode() {
		return this.verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getTeleNo() {
		return this.teleNo;
	}

	public void setTeleNo(String teleNo) {
		this.teleNo = teleNo;
	}
}
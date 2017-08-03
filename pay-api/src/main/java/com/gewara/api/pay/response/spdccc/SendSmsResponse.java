package com.gewara.api.pay.response.spdccc;

import com.gewara.api.pay.ApiResponse;

public class SendSmsResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5616810065489456044L;
	
	private String tradeNo;
	
	private String verifyCode;//短信验证码
	
	private String teleNo;//手机号
	
	public SendSmsResponse(){
		super();
	}
	
	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getTeleNo() {
		return teleNo;
	}

	public void setTeleNo(String teleNo) {
		this.teleNo = teleNo;
	}
	
}

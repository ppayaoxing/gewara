/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.response.spdccc;

import com.gewara.api.pay.ApiResponse;

public class SendPayResponse extends ApiResponse {
	private static final long serialVersionUID = -4471112511786362286L;
	private String tradeNo;
	private String bigOrderReqNo;

	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getBigOrderReqNo() {
		return this.bigOrderReqNo;
	}

	public void setBigOrderReqNo(String bigOrderReqNo) {
		this.bigOrderReqNo = bigOrderReqNo;
	}
}
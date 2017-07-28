/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.request.wx;

import com.gewara.api.pay.ApiRequest;
import java.util.HashMap;
import java.util.Map;

public class CheckfirstbindByTradeNoRequest extends ApiRequest {
	private static final long serialVersionUID = 4462122364999604768L;
	private String tradeNo;

	public CheckfirstbindByTradeNoRequest() {
	}

	public CheckfirstbindByTradeNoRequest(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public Map<String, String> getTextParams() {
		HashMap params = new HashMap();
		params.put("tradeNo", this.tradeNo);
		return params;
	}

	public boolean checkParams() {
		return this.tradeNo != null && !"".equals(this.tradeNo.trim());
	}

	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
}
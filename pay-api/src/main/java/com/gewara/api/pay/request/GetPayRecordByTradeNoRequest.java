/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.request;

import com.gewara.api.pay.ApiRequest;
import java.util.HashMap;
import java.util.Map;

public class GetPayRecordByTradeNoRequest extends ApiRequest {
	private static final long serialVersionUID = -4782512770871483369L;
	private String tradeNo;

	public GetPayRecordByTradeNoRequest() {
	}

	public GetPayRecordByTradeNoRequest(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public Map<String, String> getTextParams() {
		HashMap params = new HashMap();
		params.put("tradeNo", this.tradeNo);
		return params;
	}

	public boolean checkParams() {
		return this.tradeNo != null && this.tradeNo.trim().length() >= 15;
	}
}
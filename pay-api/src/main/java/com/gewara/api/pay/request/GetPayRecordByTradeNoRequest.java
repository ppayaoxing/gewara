package com.gewara.api.pay.request;

import java.util.HashMap;
import java.util.Map;

import com.gewara.api.pay.ApiRequest;

public class GetPayRecordByTradeNoRequest extends ApiRequest{

	private static final long serialVersionUID = -4782512770871483369L;
	
	private String tradeNo;
	
	public GetPayRecordByTradeNoRequest(){}
	
	public GetPayRecordByTradeNoRequest(String tradeNo){
		this.tradeNo = tradeNo;
	}
	
	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("tradeNo", tradeNo);
		return params;
	}

	@Override
	public boolean checkParams() {
		if(tradeNo==null || tradeNo.trim().length()<15)
			return false;
		return true;
	}

}

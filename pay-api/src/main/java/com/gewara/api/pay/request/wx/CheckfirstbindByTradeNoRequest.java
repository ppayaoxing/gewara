package com.gewara.api.pay.request.wx;

import java.util.HashMap;
import java.util.Map;

import com.gewara.api.pay.ApiRequest;

public class CheckfirstbindByTradeNoRequest extends ApiRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4462122364999604768L;
	
	/**订单号*/
	private String tradeNo;
	
	public CheckfirstbindByTradeNoRequest(){}
	
	public CheckfirstbindByTradeNoRequest(String tradeNo){
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
		if(tradeNo == null || "".equals(tradeNo.trim())){
			return false;
		}
		return true;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

}

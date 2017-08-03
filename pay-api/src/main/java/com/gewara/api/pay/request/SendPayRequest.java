package com.gewara.api.pay.request;

import java.util.Map;

import com.gewara.api.pay.ApiRequest;

public class SendPayRequest extends ApiRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4407561764514743815L;

	private Map<String, String> params;
	
	@Override
	public Map<String, String> getTextParams() {
		return params;
	}

	@Override
	public boolean checkParams() {
		return true;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}
}

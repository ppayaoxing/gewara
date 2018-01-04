package com.gewara.api.pay.request;

import java.util.HashMap;
import java.util.Map;

import com.gewara.api.pay.ApiRequest;

public class GetMerchantSpecRequest extends ApiRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5045993031881937584L;
	

	private String merchantCode;	//商户号标识

	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("merchantCode", merchantCode);
		return params;
	}

	@Override
	public boolean checkParams() {
		if(merchantCode == null || "".equals(merchantCode.trim())){
			return false;
		}
		return true;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

}

package com.gewara.api.pay.request;

import java.util.HashMap;
import java.util.Map;

import com.gewara.api.pay.ApiRequest;

public class MerchantGetAllRequest extends ApiRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5501011378123976776L;

	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> params = new HashMap<String, String>();
		return params;
	}

	@Override
	public boolean checkParams() {
		return true;
	}

}

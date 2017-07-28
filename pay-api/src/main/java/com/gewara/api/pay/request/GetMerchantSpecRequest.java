/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.request;

import com.gewara.api.pay.ApiRequest;
import java.util.HashMap;
import java.util.Map;

public class GetMerchantSpecRequest extends ApiRequest {
	private static final long serialVersionUID = -5045993031881937584L;
	private String merchantCode;

	public Map<String, String> getTextParams() {
		HashMap params = new HashMap();
		params.put("merchantCode", this.merchantCode);
		return params;
	}

	public boolean checkParams() {
		return this.merchantCode != null && !"".equals(this.merchantCode.trim());
	}

	public String getMerchantCode() {
		return this.merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
}
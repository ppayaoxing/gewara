/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.request;

import com.gewara.api.pay.ApiRequest;
import java.util.HashMap;
import java.util.Map;

public class ActivationQueryRequest extends ApiRequest {
	private static final long serialVersionUID = 7146445047023973426L;
	private String merchantCode;
	private String cardNumber;

	public ActivationQueryRequest() {
	}

	public ActivationQueryRequest(String merchantCode, String cardNumber) {
		this.merchantCode = merchantCode;
		this.cardNumber = cardNumber;
	}

	public Map<String, String> getTextParams() {
		HashMap params = new HashMap();
		params.put("merchantCode", this.merchantCode);
		params.put("cardNumber", this.cardNumber);
		return params;
	}

	public boolean checkParams() {
		return this.merchantCode != null && !"".equals(this.merchantCode.trim())
				? this.cardNumber != null && !"".equals(this.cardNumber.trim()) : false;
	}

	public String getMerchantCode() {
		return this.merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
}
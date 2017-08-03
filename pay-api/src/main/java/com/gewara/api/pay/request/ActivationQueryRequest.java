package com.gewara.api.pay.request;

import java.util.HashMap;
import java.util.Map;

import com.gewara.api.pay.ApiRequest;

public class ActivationQueryRequest extends ApiRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7146445047023973426L;
	
	/**商户标识*/
	private String merchantCode;
	
	/**银行卡号*/
	private String cardNumber;
	
	public ActivationQueryRequest(){
		
	}
	
	public ActivationQueryRequest(String merchantCode,String cardNumber){
		this.merchantCode = merchantCode;
		this.cardNumber = cardNumber;
	}
	
	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("merchantCode", merchantCode);
		params.put("cardNumber", cardNumber);
		return params;
	}

	@Override
	public boolean checkParams() {
		if(merchantCode == null || "".equals(merchantCode.trim())){
			return false;
		}

		if(cardNumber == null || "".equals(cardNumber.trim())){
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

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

}

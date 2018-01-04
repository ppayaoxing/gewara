package com.gewara.api.pay.request;

import java.util.HashMap;
import java.util.Map;

import com.gewara.api.pay.ApiRequest;

public class SendSmsRequest extends ApiRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2976473597715150062L;

	
	/**商户标识*/
	private String merchantCode;
	
	/**订单号*/
	private String tradeNo;
	
	/**银行卡号*/
	private String cardNumber;
	
	/**电话号码*/
	private String phoneNumber;	
	
	/**应付款*/
	private Integer fee;
	
	public SendSmsRequest(){
		
	}
	
	public SendSmsRequest(String merchantCode,String tradeNo,String cardNumber,String phoneNumber,Integer fee){
		this.merchantCode = merchantCode;
		this.tradeNo = tradeNo;
		this.cardNumber = cardNumber;
		this.phoneNumber = phoneNumber;
		this.fee = fee;
	}

	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("merchantCode", merchantCode);
		params.put("tradeNo", tradeNo);
		params.put("cardNumber", cardNumber);
		params.put("phoneNumber", phoneNumber);
		params.put("fee", fee + "");
		return params;
	}

	@Override
	public boolean checkParams() {
		if(merchantCode == null || "".equals(merchantCode.trim())){
			return false;
		}
		if(tradeNo == null || "".equals(tradeNo.trim())){
			return false;
		}
		if(cardNumber == null || "".equals(cardNumber.trim())){
			return false;
		}
		if(phoneNumber == null || "".equals(phoneNumber.trim())){
			return false;
		}
		if(fee == null){
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

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

}

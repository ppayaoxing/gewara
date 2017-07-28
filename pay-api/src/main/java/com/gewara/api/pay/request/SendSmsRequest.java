/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.request;

import com.gewara.api.pay.ApiRequest;
import java.util.HashMap;
import java.util.Map;

public class SendSmsRequest extends ApiRequest {
	private static final long serialVersionUID = 2976473597715150062L;
	private String merchantCode;
	private String tradeNo;
	private String cardNumber;
	private String phoneNumber;
	private Integer fee;

	public SendSmsRequest() {
	}

	public SendSmsRequest(String merchantCode, String tradeNo, String cardNumber, String phoneNumber, Integer fee) {
		this.merchantCode = merchantCode;
		this.tradeNo = tradeNo;
		this.cardNumber = cardNumber;
		this.phoneNumber = phoneNumber;
		this.fee = fee;
	}

	public Map<String, String> getTextParams() {
		HashMap params = new HashMap();
		params.put("merchantCode", this.merchantCode);
		params.put("tradeNo", this.tradeNo);
		params.put("cardNumber", this.cardNumber);
		params.put("phoneNumber", this.phoneNumber);
		params.put("fee", this.fee + "");
		return params;
	}

	public boolean checkParams() {
		return this.merchantCode != null && !"".equals(this.merchantCode.trim()) ? (this.tradeNo != null
				&& !"".equals(this.tradeNo.trim())
						? (this.cardNumber != null && !"".equals(this.cardNumber.trim())
								? (this.phoneNumber != null && !"".equals(this.phoneNumber.trim()) ? this.fee != null
										: false)
								: false)
						: false)
				: false;
	}

	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMerchantCode() {
		return this.merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public Integer getFee() {
		return this.fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}
}
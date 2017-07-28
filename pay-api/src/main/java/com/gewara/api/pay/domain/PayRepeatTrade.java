/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.domain;

import com.gewara.api.pay.ApiObject;
import java.sql.Timestamp;

public class PayRepeatTrade extends ApiObject {
	private static final long serialVersionUID = 7652210940331647300L;
	private String id;
	private String tradeNo;
	private String merTradeNo;
	private String payseqno;
	private String gatewayCode;
	private String merchantCode;
	private Integer paidAmount;
	private Timestamp notifyTime;
	private String abcOtherinfo;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getMerTradeNo() {
		return this.merTradeNo;
	}

	public void setMerTradeNo(String merTradeNo) {
		this.merTradeNo = merTradeNo;
	}

	public String getPayseqno() {
		return this.payseqno;
	}

	public void setPayseqno(String payseqno) {
		this.payseqno = payseqno;
	}

	public String getGatewayCode() {
		return this.gatewayCode;
	}

	public void setGatewayCode(String gatewayCode) {
		this.gatewayCode = gatewayCode;
	}

	public String getMerchantCode() {
		return this.merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public Integer getPaidAmount() {
		return this.paidAmount;
	}

	public void setPaidAmount(Integer paidAmount) {
		this.paidAmount = paidAmount;
	}

	public Timestamp getNotifyTime() {
		return this.notifyTime;
	}

	public void setNotifyTime(Timestamp notifyTime) {
		this.notifyTime = notifyTime;
	}

	public String getAbcOtherinfo() {
		return this.abcOtherinfo;
	}

	public void setAbcOtherinfo(String abcOtherinfo) {
		this.abcOtherinfo = abcOtherinfo;
	}
}
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.domain;

import com.gewara.api.pay.ApiObject;
import java.sql.Timestamp;

public class PayRecord extends ApiObject {
	private static final long serialVersionUID = -4420072502903272043L;
	private String id;
	private String tradeNo;
	private String merTradeNo;
	private String payseqno;
	private String gatewayCode;
	private String merchantCode;
	private Integer paidAmount;
	private Timestamp notifyTime;
	private Integer notifyCount;
	private String status;
	private String otherinfo;

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

	public Integer getNotifyCount() {
		return this.notifyCount;
	}

	public void setNotifyCount(Integer notifyCount) {
		this.notifyCount = notifyCount;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
}
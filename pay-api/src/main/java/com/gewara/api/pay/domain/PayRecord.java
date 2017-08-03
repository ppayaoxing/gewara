package com.gewara.api.pay.domain;

import java.sql.Timestamp;

import com.gewara.api.pay.ApiObject;

public class PayRecord extends ApiObject{

	private static final long serialVersionUID = -4420072502903272043L;
	//交易状态
	private String id;				//ID
	private String tradeNo;			//订单号
	private String merTradeNo;		//订单号
	private String payseqno;		//第三方支付序号
	private String gatewayCode;		//支付网关代码	
	private String merchantCode;	//商户号标识
	private Integer paidAmount;		//支付金额，单位：分
	private Timestamp notifyTime;		//支付时间
	private Integer notifyCount;	//通知次数
	private String status;			//支付状态
	private String otherinfo;	    //其他信息

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getMerTradeNo() {
		return merTradeNo;
	}

	public void setMerTradeNo(String merTradeNo) {
		this.merTradeNo = merTradeNo;
	}

	public String getPayseqno() {
		return payseqno;
	}

	public void setPayseqno(String payseqno) {
		this.payseqno = payseqno;
	}

	public String getGatewayCode() {
		return gatewayCode;
	}

	public void setGatewayCode(String gatewayCode) {
		this.gatewayCode = gatewayCode;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public Integer getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Integer paidAmount) {
		this.paidAmount = paidAmount;
	}

	public Timestamp getNotifyTime() {
		return notifyTime;
	}

	public void setNotifyTime(Timestamp notifyTime) {
		this.notifyTime = notifyTime;
	}

	public Integer getNotifyCount() {
		return notifyCount;
	}

	public void setNotifyCount(Integer notifyCount) {
		this.notifyCount = notifyCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOtherinfo() {
		return otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

}

package com.gewara.api.pay.response;

import java.sql.Timestamp;

import com.gewara.api.pay.ApiResponse;

public class GetPayOrderResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -238185555140104352L;
	
	private String tradeno;	
	
	//支付相关
	private String status;			//支付状态
	private Timestamp paidtime;		//支付时间
	private Integer paidAmount;		//支付金额，单位：分
	private String payseqno;		//第三方支付序号
	
	//通知相关
	private String notifyStatus;	//支付通知状态
	private Timestamp lastNotify;	//最后通知状态
	private Integer notifyTimes;	//通知次数
	
	private String gatewayCode;//支付网关代码	
	private String merchantCode;//商户号标识
	private String tradeNoSuffix;//订单号后缀，某些支付平台要求商户订单号不能重复提交，所以随机生成4位加在订单号后面传给银行，每次生成都追加在这个字段
	
	public String getTradeno() {
		return tradeno;
	}
	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getPaidtime() {
		return paidtime;
	}
	public void setPaidtime(Timestamp paidtime) {
		this.paidtime = paidtime;
	}
	public Integer getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(Integer paidAmount) {
		this.paidAmount = paidAmount;
	}
	public String getPayseqno() {
		return payseqno;
	}
	public void setPayseqno(String payseqno) {
		this.payseqno = payseqno;
	}
	public String getNotifyStatus() {
		return notifyStatus;
	}
	public void setNotifyStatus(String notifyStatus) {
		this.notifyStatus = notifyStatus;
	}
	public Timestamp getLastNotify() {
		return lastNotify;
	}
	public void setLastNotify(Timestamp lastNotify) {
		this.lastNotify = lastNotify;
	}
	public Integer getNotifyTimes() {
		return notifyTimes;
	}
	public void setNotifyTimes(Integer notifyTimes) {
		this.notifyTimes = notifyTimes;
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
	public String getTradeNoSuffix() {
		return tradeNoSuffix;
	}
	public void setTradeNoSuffix(String tradeNoSuffix) {
		this.tradeNoSuffix = tradeNoSuffix;
	}

}

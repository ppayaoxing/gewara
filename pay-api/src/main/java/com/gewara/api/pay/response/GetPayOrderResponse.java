/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.response;

import com.gewara.api.pay.ApiResponse;
import java.sql.Timestamp;

public class GetPayOrderResponse extends ApiResponse {
	private static final long serialVersionUID = -238185555140104352L;
	private String tradeno;
	private String status;
	private Timestamp paidtime;
	private Integer paidAmount;
	private String payseqno;
	private String notifyStatus;
	private Timestamp lastNotify;
	private Integer notifyTimes;
	private String gatewayCode;
	private String merchantCode;
	private String tradeNoSuffix;

	public String getTradeno() {
		return this.tradeno;
	}

	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getPaidtime() {
		return this.paidtime;
	}

	public void setPaidtime(Timestamp paidtime) {
		this.paidtime = paidtime;
	}

	public Integer getPaidAmount() {
		return this.paidAmount;
	}

	public void setPaidAmount(Integer paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getPayseqno() {
		return this.payseqno;
	}

	public void setPayseqno(String payseqno) {
		this.payseqno = payseqno;
	}

	public String getNotifyStatus() {
		return this.notifyStatus;
	}

	public void setNotifyStatus(String notifyStatus) {
		this.notifyStatus = notifyStatus;
	}

	public Timestamp getLastNotify() {
		return this.lastNotify;
	}

	public void setLastNotify(Timestamp lastNotify) {
		this.lastNotify = lastNotify;
	}

	public Integer getNotifyTimes() {
		return this.notifyTimes;
	}

	public void setNotifyTimes(Integer notifyTimes) {
		this.notifyTimes = notifyTimes;
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

	public String getTradeNoSuffix() {
		return this.tradeNoSuffix;
	}

	public void setTradeNoSuffix(String tradeNoSuffix) {
		this.tradeNoSuffix = tradeNoSuffix;
	}
}
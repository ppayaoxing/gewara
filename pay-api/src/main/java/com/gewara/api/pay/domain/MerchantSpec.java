/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.domain;

import com.gewara.api.pay.ApiObject;
import java.sql.Timestamp;

public class MerchantSpec extends ApiObject {
	private static final long serialVersionUID = 3131371299419499986L;
	public static final String REFUNDDEPT_CW = "CW";
	public static final String REFUNDDEPT_KF = "KF";
	private String merchantCode;
	private String gatewayCode;
	private String cityCode;
	private String acquiringBank;
	private String refundDept;
	private String refundHandling;
	private String queryUrl;
	private String partnerLinkman;
	private String partnerRefundEmail;
	private String partnerRefundPhoneCode;
	private String description;
	private Timestamp addTime;
	private Timestamp modifyTime;
	private String modifyUser;
	private String shoukuanStatus;
	private String shoukuanPayChannel;
	private String reportType;

	public String getMerchantCode() {
		return this.merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getGatewayCode() {
		return this.gatewayCode;
	}

	public void setGatewayCode(String gatewayCode) {
		this.gatewayCode = gatewayCode;
	}

	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAcquiringBank() {
		return this.acquiringBank;
	}

	public void setAcquiringBank(String acquiringBank) {
		this.acquiringBank = acquiringBank;
	}

	public String getRefundDept() {
		return this.refundDept;
	}

	public void setRefundDept(String refundDept) {
		this.refundDept = refundDept;
	}

	public String getRefundHandling() {
		return this.refundHandling;
	}

	public void setRefundHandling(String refundHandling) {
		this.refundHandling = refundHandling;
	}

	public String getQueryUrl() {
		return this.queryUrl;
	}

	public void setQueryUrl(String queryUrl) {
		this.queryUrl = queryUrl;
	}

	public String getPartnerLinkman() {
		return this.partnerLinkman;
	}

	public void setPartnerLinkman(String partnerLinkman) {
		this.partnerLinkman = partnerLinkman;
	}

	public String getPartnerRefundEmail() {
		return this.partnerRefundEmail;
	}

	public void setPartnerRefundEmail(String partnerRefundEmail) {
		this.partnerRefundEmail = partnerRefundEmail;
	}

	public String getPartnerRefundPhoneCode() {
		return this.partnerRefundPhoneCode;
	}

	public void setPartnerRefundPhoneCode(String partnerRefundPhoneCode) {
		this.partnerRefundPhoneCode = partnerRefundPhoneCode;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Timestamp getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getModifyUser() {
		return this.modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public String getShoukuanStatus() {
		return this.shoukuanStatus;
	}

	public void setShoukuanStatus(String shoukuanStatus) {
		this.shoukuanStatus = shoukuanStatus;
	}

	public String getShoukuanPayChannel() {
		return this.shoukuanPayChannel;
	}

	public void setShoukuanPayChannel(String shoukuanPayChannel) {
		this.shoukuanPayChannel = shoukuanPayChannel;
	}

	public String getReportType() {
		return this.reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
}
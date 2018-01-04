package com.gewara.api.pay.domain;

import java.sql.Timestamp;

import com.gewara.api.pay.ApiObject;

/**
 * 商户特别信息，由财务维护
 * 
 * @author leo.li
 * Modify Time 2014年3月28日 下午3:01:49
 */
public class MerchantSpec extends ApiObject{
		
	private static final long serialVersionUID = 3131371299419499986L;
	
	/**退款负责部门：CW：财务*/
	public static final String REFUNDDEPT_CW = "CW";
	/**退款负责部门：KF：客服*/
	public static final String REFUNDDEPT_KF = "KF";
	
	
	private String merchantCode;//商户号标识
	private String gatewayCode;//支付网关
	private String cityCode;//城市
	private String acquiringBank;//收单行
	private String refundDept;//退款负责部门：CW：财务；KF：客服
	private String refundHandling;//退款处理方式 :原路退回:ylth;通知合作方退款:tzhzftk;格瓦拉线下退款:gwxxtk;待确定中:dqdz
	private String queryUrl;//商户查询链接
	private String partnerLinkman;//合作方退款联系人
	private String partnerRefundEmail;//合作方退款邮箱
	private String partnerRefundPhoneCode;//合作方退款电话
	private String description;//备注
	private Timestamp addTime;	//新增时间
	private Timestamp modifyTime;	//修改时间
	private String modifyUser;//修改人

	private String shoukuanStatus;//收款系统接入状态
	private String shoukuanPayChannel;//收款系统支付渠道
	private String reportType;//报表系统类型
	
	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getGatewayCode() {
		return gatewayCode;
	}

	public void setGatewayCode(String gatewayCode) {
		this.gatewayCode = gatewayCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAcquiringBank() {
		return acquiringBank;
	}

	public void setAcquiringBank(String acquiringBank) {
		this.acquiringBank = acquiringBank;
	}

	public String getRefundDept() {
		return refundDept;
	}

	public void setRefundDept(String refundDept) {
		this.refundDept = refundDept;
	}

	public String getRefundHandling() {
		return refundHandling;
	}

	public void setRefundHandling(String refundHandling) {
		this.refundHandling = refundHandling;
	}

	public String getQueryUrl() {
		return queryUrl;
	}

	public void setQueryUrl(String queryUrl) {
		this.queryUrl = queryUrl;
	}

	public String getPartnerLinkman() {
		return partnerLinkman;
	}

	public void setPartnerLinkman(String partnerLinkman) {
		this.partnerLinkman = partnerLinkman;
	}

	public String getPartnerRefundEmail() {
		return partnerRefundEmail;
	}

	public void setPartnerRefundEmail(String partnerRefundEmail) {
		this.partnerRefundEmail = partnerRefundEmail;
	}

	public String getPartnerRefundPhoneCode() {
		return partnerRefundPhoneCode;
	}

	public void setPartnerRefundPhoneCode(String partnerRefundPhoneCode) {
		this.partnerRefundPhoneCode = partnerRefundPhoneCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Timestamp getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public String getShoukuanStatus() {
		return shoukuanStatus;
	}

	public void setShoukuanStatus(String shoukuanStatus) {
		this.shoukuanStatus = shoukuanStatus;
	}

	public String getShoukuanPayChannel() {
		return shoukuanPayChannel;
	}

	public void setShoukuanPayChannel(String shoukuanPayChannel) {
		this.shoukuanPayChannel = shoukuanPayChannel;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
}

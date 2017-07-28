/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.api;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class ApiUserBusinessVo extends BaseVo {
	private static final long serialVersionUID = 1570825734279704022L;
	private Long id;
	private String showModel;
	private String coopModel;
	private String createOrder;
	private String moneyto;
	private String gewaBusUser;
	private String gewaTecUser;
	private String partnerBusUser;
	private String partnerTecUser;
	private Timestamp onTime;
	private Timestamp offTime;
	private String webSite;
	private String email;
	private String remark;
	private Integer refundDepartment;
	private Integer refundWay;
	private String queryLink;
	private String partnerRefundMan;
	private String partnerRefundEmail;
	private String partnerRefundMobile;
	private String refundRemark;
	private String reportType;
	private String invoiceDraw;
	private String invoiceAmount;
	private String cycleRates;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShowModel() {
		return this.showModel;
	}

	public void setShowModel(String showModel) {
		this.showModel = showModel;
	}

	public String getCoopModel() {
		return this.coopModel;
	}

	public void setCoopModel(String coopModel) {
		this.coopModel = coopModel;
	}

	public String getCreateOrder() {
		return this.createOrder;
	}

	public void setCreateOrder(String createOrder) {
		this.createOrder = createOrder;
	}

	public String getMoneyto() {
		return this.moneyto;
	}

	public void setMoneyto(String moneyto) {
		this.moneyto = moneyto;
	}

	public String getGewaBusUser() {
		return this.gewaBusUser;
	}

	public void setGewaBusUser(String gewaBusUser) {
		this.gewaBusUser = gewaBusUser;
	}

	public String getGewaTecUser() {
		return this.gewaTecUser;
	}

	public void setGewaTecUser(String gewaTecUser) {
		this.gewaTecUser = gewaTecUser;
	}

	public String getPartnerBusUser() {
		return this.partnerBusUser;
	}

	public void setPartnerBusUser(String partnerBusUser) {
		this.partnerBusUser = partnerBusUser;
	}

	public String getPartnerTecUser() {
		return this.partnerTecUser;
	}

	public void setPartnerTecUser(String partnerTecUser) {
		this.partnerTecUser = partnerTecUser;
	}

	public Timestamp getOnTime() {
		return this.onTime;
	}

	public void setOnTime(Timestamp onTime) {
		this.onTime = onTime;
	}

	public Timestamp getOffTime() {
		return this.offTime;
	}

	public void setOffTime(Timestamp offTime) {
		this.offTime = offTime;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getRefundDepartment() {
		return this.refundDepartment;
	}

	public void setRefundDepartment(Integer refundDepartment) {
		this.refundDepartment = refundDepartment;
	}

	public Integer getRefundWay() {
		return this.refundWay;
	}

	public void setRefundWay(Integer refundWay) {
		this.refundWay = refundWay;
	}

	public String getQueryLink() {
		return this.queryLink;
	}

	public void setQueryLink(String queryLink) {
		this.queryLink = queryLink;
	}

	public String getPartnerRefundMan() {
		return this.partnerRefundMan;
	}

	public void setPartnerRefundMan(String partnerRefundMan) {
		this.partnerRefundMan = partnerRefundMan;
	}

	public String getPartnerRefundEmail() {
		return this.partnerRefundEmail;
	}

	public void setPartnerRefundEmail(String partnerRefundEmail) {
		this.partnerRefundEmail = partnerRefundEmail;
	}

	public String getPartnerRefundMobile() {
		return this.partnerRefundMobile;
	}

	public void setPartnerRefundMobile(String partnerRefundMobile) {
		this.partnerRefundMobile = partnerRefundMobile;
	}

	public String getRefundRemark() {
		return this.refundRemark;
	}

	public void setRefundRemark(String refundRemark) {
		this.refundRemark = refundRemark;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReportType() {
		return this.reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getInvoiceDraw() {
		return this.invoiceDraw;
	}

	public void setInvoiceDraw(String invoiceDraw) {
		this.invoiceDraw = invoiceDraw;
	}

	public String getInvoiceAmount() {
		return this.invoiceAmount;
	}

	public void setInvoiceAmount(String invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getCycleRates() {
		return this.cycleRates;
	}

	public void setCycleRates(String cycleRates) {
		this.cycleRates = cycleRates;
	}
}
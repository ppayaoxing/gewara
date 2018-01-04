package com.gewara.api.vo.api;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class ApiUserBusinessVo extends BaseVo{
	private static final long serialVersionUID = 1570825734279704022L;
	private Long id;
	private String showModel;		//展现方式 android ios wap pc 终端机、电视机
	private String coopModel;		//合作模式
	private String createOrder;		//是否产生订单
	private String moneyto;			//收款方
	private String gewaBusUser;		//格瓦拉商务负责人
	private String gewaTecUser;		//格瓦拉技术负责人
	private String partnerBusUser;	//合作商商务联系人
	private String partnerTecUser;	//合作商技术联系人
	private Timestamp onTime;		//上线日期
	private Timestamp offTime;		//下线日期
	private String webSite;			//线上地址
	private String email;			//合作商用户email 用户发账户信息
	private String remark;
	
	/** 
	 * 退款部门
	 * 0:财务
	 * 1:客服
	 */
	private Integer refundDepartment;
	
	/** 
	 * 退款方式  
	 * 0:原路退回
	 * 1:通知合作方退款
	 * 2:格瓦拉线下退款
	 * 3:待确定中
	 */
	private Integer refundWay;
	
	/** 商户查询链接 */
	private String queryLink;
	
	/** 合作方退款联系人 */
	private String partnerRefundMan;
	
	/** 合作方退款邮箱 */
	private String partnerRefundEmail;
	
	/** 合作方退款电话 */
	private String partnerRefundMobile;
	
	/** 退款其他备注 */
	private String refundRemark;
	
	/** 合作商报表类别 */
	private String reportType;
	
	/** 发票开具 (向用户/向合作商)*/
	private String invoiceDraw;
	
	/** 发票开具金额(全额/差额) */
	private String invoiceAmount;
	
	/** 结算周期及费率(开始时间-结束时间-费率(json格式))*/
	private String cycleRates;
	
	public ApiUserBusinessVo(){
		
	}
	
	@Override
	public Serializable realId() {
		return id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShowModel() {
		return showModel;
	}

	public void setShowModel(String showModel) {
		this.showModel = showModel;
	}

	public String getCoopModel() {
		return coopModel;
	}

	public void setCoopModel(String coopModel) {
		this.coopModel = coopModel;
	}

	public String getCreateOrder() {
		return createOrder;
	}

	public void setCreateOrder(String createOrder) {
		this.createOrder = createOrder;
	}

	public String getMoneyto() {
		return moneyto;
	}

	public void setMoneyto(String moneyto) {
		this.moneyto = moneyto;
	}

	public String getGewaBusUser() {
		return gewaBusUser;
	}

	public void setGewaBusUser(String gewaBusUser) {
		this.gewaBusUser = gewaBusUser;
	}

	public String getGewaTecUser() {
		return gewaTecUser;
	}

	public void setGewaTecUser(String gewaTecUser) {
		this.gewaTecUser = gewaTecUser;
	}

	public String getPartnerBusUser() {
		return partnerBusUser;
	}

	public void setPartnerBusUser(String partnerBusUser) {
		this.partnerBusUser = partnerBusUser;
	}

	public String getPartnerTecUser() {
		return partnerTecUser;
	}

	public void setPartnerTecUser(String partnerTecUser) {
		this.partnerTecUser = partnerTecUser;
	}

	public Timestamp getOnTime() {
		return onTime;
	}

	public void setOnTime(Timestamp onTime) {
		this.onTime = onTime;
	}

	public Timestamp getOffTime() {
		return offTime;
	}

	public void setOffTime(Timestamp offTime) {
		this.offTime = offTime;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Integer getRefundDepartment() {
		return refundDepartment;
	}
	
	public void setRefundDepartment(Integer refundDepartment) {
		this.refundDepartment = refundDepartment;
	}
	
	public Integer getRefundWay() {
		return refundWay;
	}
	
	public void setRefundWay(Integer refundWay) {
		this.refundWay = refundWay;
	}
	
	public String getQueryLink() {
		return queryLink;
	}
	
	public void setQueryLink(String queryLink) {
		this.queryLink = queryLink;
	}
	
	public String getPartnerRefundMan() {
		return partnerRefundMan;
	}
	
	public void setPartnerRefundMan(String partnerRefundMan) {
		this.partnerRefundMan = partnerRefundMan;
	}
	
	public String getPartnerRefundEmail() {
		return partnerRefundEmail;
	}
	
	public void setPartnerRefundEmail(String partnerRefundEmail) {
		this.partnerRefundEmail = partnerRefundEmail;
	}
	
	public String getPartnerRefundMobile() {
		return partnerRefundMobile;
	}
	
	public void setPartnerRefundMobile(String partnerRefundMobile) {
		this.partnerRefundMobile = partnerRefundMobile;
	}
	
	public String getRefundRemark() {
		return refundRemark;
	}
	
	public void setRefundRemark(String refundRemark) {
		this.refundRemark = refundRemark;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getInvoiceDraw() {
		return invoiceDraw;
	}

	public void setInvoiceDraw(String invoiceDraw) {
		this.invoiceDraw = invoiceDraw;
	}

	public String getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(String invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getCycleRates() {
		return cycleRates;
	}

	public void setCycleRates(String cycleRates) {
		this.cycleRates = cycleRates;
	}
	
}

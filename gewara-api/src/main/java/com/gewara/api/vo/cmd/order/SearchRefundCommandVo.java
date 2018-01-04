package com.gewara.api.vo.cmd.order;

import java.io.Serializable;
import java.sql.Timestamp;

public class SearchRefundCommandVo implements Serializable{
	private static final long serialVersionUID = 2730869767514567184L;
	private String tradeno;
	private String mobile;
	private Long memberid;
	private String status;
	private String retback;
	private String refundtype;
	private String ordertype;
	private Long placeid;
	private Timestamp addtimefrom;
	private Timestamp addtimeto;
	private Timestamp refundtimefrom;
	private Timestamp refundtimeto;
	private String origin;		// 退款来源
	private boolean excludeGewaRefund;
	
	public String getTradeno() {
		return tradeno;
	}
	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public Long getMemberid() {
		return memberid;
	}
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRetback() {
		return retback;
	}
	public void setRetback(String retback) {
		this.retback = retback;
	}
	public String getRefundtype() {
		return refundtype;
	}
	public void setRefundtype(String refundtype) {
		this.refundtype = refundtype;
	}
	public Long getPlaceid() {
		return placeid;
	}
	public void setPlaceid(Long placeid) {
		this.placeid = placeid;
	}
	public Timestamp getAddtimefrom() {
		return addtimefrom;
	}
	public void setAddtimefrom(Timestamp addtimefrom) {
		this.addtimefrom = addtimefrom;
	}
	public Timestamp getAddtimeto() {
		return addtimeto;
	}
	public void setAddtimeto(Timestamp addtimeto) {
		this.addtimeto = addtimeto;
	}
	public Timestamp getRefundtimefrom() {
		return refundtimefrom;
	}
	public void setRefundtimefrom(Timestamp refundtimefrom) {
		this.refundtimefrom = refundtimefrom;
	}
	public Timestamp getRefundtimeto() {
		return refundtimeto;
	}
	public void setRefundtimeto(Timestamp refundtimeto) {
		this.refundtimeto = refundtimeto;
	}
	public String getOrdertype() {
		return ordertype;
	}
	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public boolean isExcludeGewaRefund() {
		return excludeGewaRefund;
	}
	public void setExcludeGewaRefund(boolean excludeGewaRefund) {
		this.excludeGewaRefund = excludeGewaRefund;
	}
}

/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.cmd.order;

import java.io.Serializable;
import java.sql.Timestamp;

public class SearchRefundCommandVo implements Serializable {
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
	private String origin;

	public String getTradeno() {
		return this.tradeno;
	}

	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRetback() {
		return this.retback;
	}

	public void setRetback(String retback) {
		this.retback = retback;
	}

	public String getRefundtype() {
		return this.refundtype;
	}

	public void setRefundtype(String refundtype) {
		this.refundtype = refundtype;
	}

	public Long getPlaceid() {
		return this.placeid;
	}

	public void setPlaceid(Long placeid) {
		this.placeid = placeid;
	}

	public Timestamp getAddtimefrom() {
		return this.addtimefrom;
	}

	public void setAddtimefrom(Timestamp addtimefrom) {
		this.addtimefrom = addtimefrom;
	}

	public Timestamp getAddtimeto() {
		return this.addtimeto;
	}

	public void setAddtimeto(Timestamp addtimeto) {
		this.addtimeto = addtimeto;
	}

	public Timestamp getRefundtimefrom() {
		return this.refundtimefrom;
	}

	public void setRefundtimefrom(Timestamp refundtimefrom) {
		this.refundtimefrom = refundtimefrom;
	}

	public Timestamp getRefundtimeto() {
		return this.refundtimeto;
	}

	public void setRefundtimeto(Timestamp refundtimeto) {
		this.refundtimeto = refundtimeto;
	}

	public String getOrdertype() {
		return this.ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
}
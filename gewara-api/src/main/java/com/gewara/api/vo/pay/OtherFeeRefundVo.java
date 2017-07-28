/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.pay;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class OtherFeeRefundVo extends BaseVo {
	private static final long serialVersionUID = 7420087805465434371L;
	private Long id;
	private Integer version;
	private String tradeno;
	private String ordertype;
	private Long memberid;
	private Long partnerid;
	private String mobile;
	private String orderstatus;
	private String origin;
	private String reason;
	private Integer gewaRetAmount;
	private Integer oldFeeAmount;
	private String retback;
	private Long applyuser;
	private String applyinfo;
	private String otherinfo;
	private Timestamp addtime;
	private Timestamp refundtime;
	private String status;
	private Long dealuser;
	private String dealinfo;
	private Long batch;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getTradeno() {
		return this.tradeno;
	}

	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}

	public String getOrdertype() {
		return this.ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public Long getPartnerid() {
		return this.partnerid;
	}

	public void setPartnerid(Long partnerid) {
		this.partnerid = partnerid;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getOldFeeAmount() {
		return this.oldFeeAmount;
	}

	public void setOldFeeAmount(Integer oldFeeAmount) {
		this.oldFeeAmount = oldFeeAmount;
	}

	public String getOrderstatus() {
		return this.orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getGewaRetAmount() {
		return this.gewaRetAmount;
	}

	public void setGewaRetAmount(Integer gewaRetAmount) {
		this.gewaRetAmount = gewaRetAmount;
	}

	public String getRetback() {
		return this.retback;
	}

	public void setRetback(String retback) {
		this.retback = retback;
	}

	public Long getApplyuser() {
		return this.applyuser;
	}

	public void setApplyuser(Long applyuser) {
		this.applyuser = applyuser;
	}

	public String getApplyinfo() {
		return this.applyinfo;
	}

	public void setApplyinfo(String applyinfo) {
		this.applyinfo = applyinfo;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getRefundtime() {
		return this.refundtime;
	}

	public void setRefundtime(Timestamp refundtime) {
		this.refundtime = refundtime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getDealuser() {
		return this.dealuser;
	}

	public void setDealuser(Long dealuser) {
		this.dealuser = dealuser;
	}

	public String getDealinfo() {
		return this.dealinfo;
	}

	public void setDealinfo(String dealinfo) {
		this.dealinfo = dealinfo;
	}

	public Long getBatch() {
		return this.batch;
	}

	public void setBatch(Long batch) {
		this.batch = batch;
	}
}
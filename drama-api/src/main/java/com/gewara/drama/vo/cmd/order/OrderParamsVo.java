/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.cmd.order;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrderParamsVo implements Serializable {
	private static final long serialVersionUID = 4463096682044152182L;
	private Integer pageNo;
	private Long memberid;
	private String mobile;
	private String tradeno;
	private Timestamp starttime;
	private Timestamp endtime;
	private String ordertype;
	private String status;
	private String paymethod;
	private String category;
	private String citycode;
	private Long placeid;
	private Long itemid;
	private Long relatedid;
	private String express;
	private String expressstatus;
	private String sourcetype;
	private Long partnerid;
	private String order;
	private Boolean asc = Boolean.valueOf(false);
	private String level;
	private String errorMsg;
	private String xls;

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

	public String getTradeno() {
		return this.tradeno;
	}

	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}

	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public String getOrdertype() {
		return this.ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public Integer getPageNo() {
		if (this.pageNo == null || this.pageNo.intValue() < 0) {
			this.pageNo = Integer.valueOf(0);
		}

		return this.pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public String getPaymethod() {
		return this.paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrder() {
		return this.order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Boolean getAsc() {
		if (this.asc == null) {
			this.asc = Boolean.valueOf(false);
		}

		return this.asc;
	}

	public void setAsc(Boolean asc) {
		this.asc = asc;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public Long getPlaceid() {
		return this.placeid;
	}

	public void setPlaceid(Long placeid) {
		this.placeid = placeid;
	}

	public Long getItemid() {
		return this.itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getExpress() {
		return this.express;
	}

	public void setExpress(String express) {
		this.express = express;
	}

	public Long getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public String getErrorMsg() {
		return this.errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getXls() {
		return this.xls;
	}

	public void setXls(String xls) {
		this.xls = xls;
	}

	public String getExpressstatus() {
		return this.expressstatus;
	}

	public void setExpressstatus(String expressstatus) {
		this.expressstatus = expressstatus;
	}

	public String getSourcetype() {
		return this.sourcetype;
	}

	public void setSourcetype(String sourcetype) {
		this.sourcetype = sourcetype;
	}

	public Long getPartnerid() {
		return this.partnerid;
	}

	public void setPartnerid(Long partnerid) {
		this.partnerid = partnerid;
	}
}
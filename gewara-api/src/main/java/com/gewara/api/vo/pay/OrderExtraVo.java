/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.pay;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class OrderExtraVo extends BaseVo {
	private static final long serialVersionUID = 4821814105905969549L;
	public static final String LEVEL_INIT = "init";
	public static final String LEVEL_MAIN = "main";
	public static final String LEVEL_FINISH = "finish";
	private Long id;
	private String tradeno;
	private String status;
	private Timestamp addtime;
	private Timestamp updatetime;
	private String invoice;
	private String pretype;
	private Long memberid;
	private Long partnerid;
	private String ordertype;
	private String expressnote;
	private String expresstype;
	private String processLevel;
	private String expressStatus;
	private String dealStatus;
	private Long dealUser;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getInvoice() {
		return this.invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getPretype() {
		return this.pretype;
	}

	public void setPretype(String pretype) {
		this.pretype = pretype;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Long getPartnerid() {
		return this.partnerid;
	}

	public void setPartnerid(Long partnerid) {
		this.partnerid = partnerid;
	}

	public String getOrdertype() {
		return this.ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public String getExpressnote() {
		return this.expressnote;
	}

	public void setExpressnote(String expressnote) {
		this.expressnote = expressnote;
	}

	public String getExpresstype() {
		return this.expresstype;
	}

	public void setExpresstype(String expresstype) {
		this.expresstype = expresstype;
	}

	public boolean hasExpressType(String type) {
		return StringUtils.equals(this.expresstype, type);
	}

	public boolean hasPaidSuccess() {
		return StringUtils.equals(this.status, "paid_success");
	}

	public Serializable realId() {
		return this.id;
	}

	public String getProcessLevel() {
		return this.processLevel;
	}

	public void setProcessLevel(String processLevel) {
		this.processLevel = processLevel;
	}

	public String getExpressStatus() {
		return this.expressStatus;
	}

	public void setExpressStatus(String expressStatus) {
		this.expressStatus = expressStatus;
	}

	public String getDealStatus() {
		return this.dealStatus;
	}

	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}

	public Long getDealUser() {
		return this.dealUser;
	}

	public void setDealUser(Long dealUser) {
		this.dealUser = dealUser;
	}
}
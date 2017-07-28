/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.partner2.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class DistributionPartnerVo extends BaseVo {
	private static final long serialVersionUID = -2992423661776140813L;
	private long id;
	private long sellerid;
	private long partnerid;
	private String partnername;
	private String partnerkey;
	private String partnertype;
	private String groupid;
	private Timestamp contractstarttime;
	private Timestamp contractendtime;
	private long annualquota;
	private String businessmobile;
	private String businessname;
	private String sellermobile;
	private String sellername;
	private long technologyfee;
	private long maintainfee;
	private String runsub;
	private String advanceCharge;
	private String status;
	private String accountid;
	private String taxatfee;
	private String cooperatstatus;
	private String iscinemamanage;
	private Timestamp addtime;
	private Timestamp updatetime;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSellerid() {
		return this.sellerid;
	}

	public void setSellerid(long sellerid) {
		this.sellerid = sellerid;
	}

	public long getPartnerid() {
		return this.partnerid;
	}

	public void setPartnerid(long partnerid) {
		this.partnerid = partnerid;
	}

	public String getPartnername() {
		return this.partnername;
	}

	public void setPartnername(String partnername) {
		this.partnername = partnername;
	}

	public String getPartnerkey() {
		return this.partnerkey;
	}

	public void setPartnerkey(String partnerkey) {
		this.partnerkey = partnerkey;
	}

	public String getPartnertype() {
		return this.partnertype;
	}

	public void setPartnertype(String partnertype) {
		this.partnertype = partnertype;
	}

	public String getGroupid() {
		return this.groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public Timestamp getContractstarttime() {
		return this.contractstarttime;
	}

	public void setContractstarttime(Timestamp contractstarttime) {
		this.contractstarttime = contractstarttime;
	}

	public Timestamp getContractendtime() {
		return this.contractendtime;
	}

	public void setContractendtime(Timestamp contractendtime) {
		this.contractendtime = contractendtime;
	}

	public long getAnnualquota() {
		return this.annualquota;
	}

	public void setAnnualquota(long annualquota) {
		this.annualquota = annualquota;
	}

	public String getBusinessmobile() {
		return this.businessmobile;
	}

	public void setBusinessmobile(String businessmobile) {
		this.businessmobile = businessmobile;
	}

	public String getBusinessname() {
		return this.businessname;
	}

	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}

	public String getSellermobile() {
		return this.sellermobile;
	}

	public void setSellermobile(String sellermobile) {
		this.sellermobile = sellermobile;
	}

	public String getSellername() {
		return this.sellername;
	}

	public void setSellername(String sellername) {
		this.sellername = sellername;
	}

	public long getTechnologyfee() {
		return this.technologyfee;
	}

	public void setTechnologyfee(long technologyfee) {
		this.technologyfee = technologyfee;
	}

	public long getMaintainfee() {
		return this.maintainfee;
	}

	public void setMaintainfee(long maintainfee) {
		this.maintainfee = maintainfee;
	}

	public String getRunsub() {
		return this.runsub;
	}

	public void setRunsub(String runsub) {
		this.runsub = runsub;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAccountid() {
		return this.accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
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

	public String getAdvanceCharge() {
		return this.advanceCharge;
	}

	public void setAdvanceCharge(String advanceCharge) {
		this.advanceCharge = advanceCharge;
	}

	public String getTaxatfee() {
		return this.taxatfee;
	}

	public void setTaxatfee(String taxatfee) {
		this.taxatfee = taxatfee;
	}

	public String getCooperatstatus() {
		return this.cooperatstatus;
	}

	public void setCooperatstatus(String cooperatstatus) {
		this.cooperatstatus = cooperatstatus;
	}

	public String getIscinemamanage() {
		return this.iscinemamanage;
	}

	public void setIscinemamanage(String iscinemamanage) {
		this.iscinemamanage = iscinemamanage;
	}

	public Serializable realId() {
		return Long.valueOf(this.id);
	}
}
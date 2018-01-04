package com.gewara.partner2.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

/**
 * 分销系统-合作商
 * 
 * @author chunhui.wang
 *
 */
public class DistributionPartnerVo extends BaseVo {
	private static final long serialVersionUID = -2992423661776140813L;

	private long id; // 主键
	private long sellerid; // 销售经理编号
	private long partnerid; // 合作商ID
	private String partnername; // 合作商名称
	private String partnerkey; // 合作商key
	private String partnertype;//合作商类型
	private String groupid; // 分组
	private Timestamp contractstarttime; // 合同开始时间
	private Timestamp contractendtime; // 合同结束时间
	private long annualquota; // 年保额度
	private String businessmobile; // 商家对接人手机
	private String businessname; // 商家对接人名
	private String sellermobile; // 销售经理手机
	private String sellername; // 销售经理
	private long technologyfee; // 技术服务费
	private long maintainfee; // 维护费
	private String runsub; // 分润
	private String advanceCharge;//预付款金额
	private String status; // 状态 0 有效 1预警 2锁定 3删除
	private String accountid;// 资金账户
	private String taxatfee; //税费
	private String cooperatstatus;//合作状态
	private String iscinemamanage;//是否开启场次管理
	private Timestamp addtime; // 添加时间
	private Timestamp updatetime; // 更新时间

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSellerid() {
		return sellerid;
	}

	public void setSellerid(long sellerid) {
		this.sellerid = sellerid;
	}

	public long getPartnerid() {
		return partnerid;
	}

	public void setPartnerid(long partnerid) {
		this.partnerid = partnerid;
	}

	public String getPartnername() {
		return partnername;
	}

	public void setPartnername(String partnername) {
		this.partnername = partnername;
	}

	public String getPartnerkey() {
		return partnerkey;
	}

	public void setPartnerkey(String partnerkey) {
		this.partnerkey = partnerkey;
	}

	public String getPartnertype() {
		return partnertype;
	}

	public void setPartnertype(String partnertype) {
		this.partnertype = partnertype;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public Timestamp getContractstarttime() {
		return contractstarttime;
	}

	public void setContractstarttime(Timestamp contractstarttime) {
		this.contractstarttime = contractstarttime;
	}

	public Timestamp getContractendtime() {
		return contractendtime;
	}

	public void setContractendtime(Timestamp contractendtime) {
		this.contractendtime = contractendtime;
	}

	public long getAnnualquota() {
		return annualquota;
	}

	public void setAnnualquota(long annualquota) {
		this.annualquota = annualquota;
	}

	public String getBusinessmobile() {
		return businessmobile;
	}

	public void setBusinessmobile(String businessmobile) {
		this.businessmobile = businessmobile;
	}

	public String getBusinessname() {
		return businessname;
	}

	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}

	public String getSellermobile() {
		return sellermobile;
	}

	public void setSellermobile(String sellermobile) {
		this.sellermobile = sellermobile;
	}

	public String getSellername() {
		return sellername;
	}

	public void setSellername(String sellername) {
		this.sellername = sellername;
	}

	public long getTechnologyfee() {
		return technologyfee;
	}

	public void setTechnologyfee(long technologyfee) {
		this.technologyfee = technologyfee;
	}

	public long getMaintainfee() {
		return maintainfee;
	}

	public void setMaintainfee(long maintainfee) {
		this.maintainfee = maintainfee;
	}

	public String getRunsub() {
		return runsub;
	}

	public void setRunsub(String runsub) {
		this.runsub = runsub;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	
	public String getAdvanceCharge() {
		return advanceCharge;
	}

	public void setAdvanceCharge(String advanceCharge) {
		this.advanceCharge = advanceCharge;
	}
	
	public String getTaxatfee() {
		return taxatfee;
	}

	public void setTaxatfee(String taxatfee) {
		this.taxatfee = taxatfee;
	}
	
	public String getCooperatstatus() {
		return cooperatstatus;
	}

	public void setCooperatstatus(String cooperatstatus) {
		this.cooperatstatus = cooperatstatus;
	}
	
	public String getIscinemamanage() {
		return iscinemamanage;
	}

	public void setIscinemamanage(String iscinemamanage) {
		this.iscinemamanage = iscinemamanage;
	}

	@Override
	public Serializable realId() {
		return id;
	}
}

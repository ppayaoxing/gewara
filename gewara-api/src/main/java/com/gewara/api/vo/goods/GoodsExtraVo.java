/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.goods;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class GoodsExtraVo extends BaseVo {
	private static final long serialVersionUID = 8621222313371273059L;
	private Long goodsid;
	private String msgbefore;
	private String msgpro;
	private String msgafter;
	private String msgover;
	private String restriction;
	private String timeexp;
	private String rule;
	private String otherexp;
	private String department;
	private String appPresaleName;
	private String subsidyUnit;
	private Integer subsidyMoney;
	private String preType;
	private Integer hintnum;
	private Integer defnum;
	private Integer defSalesnum;
	private Integer defTotalnum;
	private String otherinfo;
	private Timestamp addtime;
	private Timestamp updatetime;

	public Serializable realId() {
		return this.goodsid;
	}

	public Long getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}

	public String getMsgbefore() {
		return this.msgbefore;
	}

	public void setMsgbefore(String msgbefore) {
		this.msgbefore = msgbefore;
	}

	public String getRestriction() {
		return this.restriction;
	}

	public String getAppPresaleName() {
		return this.appPresaleName;
	}

	public void setAppPresaleName(String appPresaleName) {
		this.appPresaleName = appPresaleName;
	}

	public void setRestriction(String restriction) {
		this.restriction = restriction;
	}

	public String getTimeexp() {
		return this.timeexp;
	}

	public void setTimeexp(String timeexp) {
		this.timeexp = timeexp;
	}

	public String getRule() {
		return this.rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public String getOtherexp() {
		return this.otherexp;
	}

	public void setOtherexp(String otherexp) {
		this.otherexp = otherexp;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSubsidyUnit() {
		return this.subsidyUnit;
	}

	public void setSubsidyUnit(String subsidyUnit) {
		this.subsidyUnit = subsidyUnit;
	}

	public Integer getSubsidyMoney() {
		return this.subsidyMoney;
	}

	public void setSubsidyMoney(Integer subsidyMoney) {
		this.subsidyMoney = subsidyMoney;
	}

	public Integer getHintnum() {
		return this.hintnum;
	}

	public void setHintnum(Integer hintnum) {
		this.hintnum = hintnum;
	}

	public Integer getDefnum() {
		return this.defnum;
	}

	public void setDefnum(Integer defnum) {
		this.defnum = defnum;
	}

	public Integer getDefSalesnum() {
		return this.defSalesnum;
	}

	public void setDefSalesnum(Integer defSalesnum) {
		this.defSalesnum = defSalesnum;
	}

	public Integer getDefTotalnum() {
		return this.defTotalnum;
	}

	public void setDefTotalnum(Integer defTotalnum) {
		this.defTotalnum = defTotalnum;
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

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getPreType() {
		return this.preType;
	}

	public void setPreType(String preType) {
		this.preType = preType;
	}

	public String getMsgpro() {
		return this.msgpro;
	}

	public void setMsgpro(String msgpro) {
		this.msgpro = msgpro;
	}

	public String getMsgafter() {
		return this.msgafter;
	}

	public void setMsgafter(String msgafter) {
		this.msgafter = msgafter;
	}

	public String getMsgover() {
		return this.msgover;
	}

	public void setMsgover(String msgover) {
		this.msgover = msgover;
	}
}
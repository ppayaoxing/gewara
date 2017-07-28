/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.res.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class OrderSpCodeVo extends BaseVo {
	private static final long serialVersionUID = -6196438649350032217L;
	private String pass;
	private Long id;
	private Long spid;
	private String remark;
	private Timestamp timefrom;
	private Timestamp timeto;
	private String bankname;
	private String enableRemark;
	private String description;
	private Integer usedcount;
	private Integer discount;
	private String spType;
	private Integer discountAmount;
	private Long discountid;
	private String cardRemark;
	private Integer fullTotalfee;
	private String tag;
	private String bindmobile;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDiscount() {
		return this.discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public String getSpType() {
		return this.spType;
	}

	public void setSpType(String spType) {
		this.spType = spType;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Long getSpid() {
		return this.spid;
	}

	public void setSpid(Long spid) {
		this.spid = spid;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getTimefrom() {
		return this.timefrom;
	}

	public void setTimefrom(Timestamp timefrom) {
		this.timefrom = timefrom;
	}

	public Timestamp getTimeto() {
		return this.timeto;
	}

	public void setTimeto(Timestamp timeto) {
		this.timeto = timeto;
	}

	public String getBankname() {
		return this.bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getEnableRemark() {
		return this.enableRemark;
	}

	public void setEnableRemark(String enableRemark) {
		this.enableRemark = enableRemark;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getUsedcount() {
		return this.usedcount;
	}

	public void setUsedcount(Integer usedcount) {
		this.usedcount = usedcount;
	}

	public Integer getDiscountAmount() {
		return this.discountAmount;
	}

	public void setDiscountAmount(Integer discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Long getDiscountid() {
		return this.discountid;
	}

	public void setDiscountid(Long discountid) {
		this.discountid = discountid;
	}

	public String getCardRemark() {
		return this.cardRemark;
	}

	public void setCardRemark(String cardRemark) {
		this.cardRemark = cardRemark;
	}

	public Serializable realId() {
		return this.pass;
	}

	public Integer getFullTotalfee() {
		return this.fullTotalfee;
	}

	public void setFullTotalfee(Integer fullTotalfee) {
		this.fullTotalfee = fullTotalfee;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getBindmobile() {
		return this.bindmobile;
	}

	public void setBindmobile(String bindmobile) {
		this.bindmobile = bindmobile;
	}
}
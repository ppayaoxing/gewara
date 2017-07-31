package com.gewara.api.partner.res.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class OrderSpCodeVo extends BaseVo{
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
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public String getSpType() {
		return spType;
	}
	public void setSpType(String spType) {
		this.spType = spType;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Long getSpid() {
		return spid;
	}
	public void setSpid(Long spid) {
		this.spid = spid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Timestamp getTimefrom() {
		return timefrom;
	}
	public void setTimefrom(Timestamp timefrom) {
		this.timefrom = timefrom;
	}
	public Timestamp getTimeto() {
		return timeto;
	}
	public void setTimeto(Timestamp timeto) {
		this.timeto = timeto;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getEnableRemark() {
		return enableRemark;
	}
	public void setEnableRemark(String enableRemark) {
		this.enableRemark = enableRemark;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getUsedcount() {
		return usedcount;
	}
	public void setUsedcount(Integer usedcount) {
		this.usedcount = usedcount;
	}
	
	public Integer getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(Integer discountAmount) {
		this.discountAmount = discountAmount;
	}
	public Long getDiscountid() {
		return discountid;
	}
	public void setDiscountid(Long discountid) {
		this.discountid = discountid;
	}
	
	public String getCardRemark() {
		return cardRemark;
	}
	public void setCardRemark(String cardRemark) {
		this.cardRemark = cardRemark;
	}
	@Override
	public Serializable realId() {
		return pass;
	}
	public Integer getFullTotalfee() {
		return fullTotalfee;
	}
	public void setFullTotalfee(Integer fullTotalfee) {
		this.fullTotalfee = fullTotalfee;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getBindmobile() {
		return bindmobile;
	}
	public void setBindmobile(String bindmobile) {
		this.bindmobile = bindmobile;
	}
	
}

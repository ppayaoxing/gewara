/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.res.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class OrderCardVo extends BaseVo {
	private static final long serialVersionUID = 6328113639822082721L;
	private String cardno;
	private String name;
	private String cardtype;
	private String usage;
	private Integer amount;
	private Long discountid;
	private String edition;
	private Integer discountAmount;
	private Integer due;
	private Integer fullTotalfee;
	private Integer opiMinPrice;
	private Timestamp timefrom;
	private Timestamp timeto;
	private String exchangetype;
	private String shortname;
	private String cardRemark;
	private String bindmobile;
	private Double cardUseAmount;
	private Integer orderTotalAmount;

	public String getCardno() {
		return this.cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardtype() {
		return this.cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getUsage() {
		return this.usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public Long getDiscountid() {
		return this.discountid;
	}

	public void setDiscountid(Long discountid) {
		this.discountid = discountid;
	}

	public String getEdition() {
		return this.edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public Integer getDiscountAmount() {
		return this.discountAmount;
	}

	public void setDiscountAmount(Integer discountAmount) {
		this.discountAmount = discountAmount;
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

	public String getExchangetype() {
		return this.exchangetype;
	}

	public void setExchangetype(String exchangetype) {
		this.exchangetype = exchangetype;
	}

	public String getShortname() {
		return this.shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public Integer getDue() {
		return this.due;
	}

	public void setDue(Integer due) {
		this.due = due;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Serializable realId() {
		return this.cardno;
	}

	public String getCardRemark() {
		return this.cardRemark;
	}

	public void setCardRemark(String cardRemark) {
		this.cardRemark = cardRemark;
	}

	public Integer getFullTotalfee() {
		return this.fullTotalfee;
	}

	public void setFullTotalfee(Integer fullTotalfee) {
		this.fullTotalfee = fullTotalfee;
	}

	public Integer getOpiMinPrice() {
		return this.opiMinPrice;
	}

	public void setOpiMinPrice(Integer opiMinPrice) {
		this.opiMinPrice = opiMinPrice;
	}

	public String getBindmobile() {
		return this.bindmobile;
	}

	public void setBindmobile(String bindmobile) {
		this.bindmobile = bindmobile;
	}

	public Double getCardUseAmount() {
		return this.cardUseAmount;
	}

	public void setCardUseAmount(Double cardUseAmount) {
		this.cardUseAmount = cardUseAmount;
	}

	public Integer getOrderTotalAmount() {
		return this.orderTotalAmount;
	}

	public void setOrderTotalAmount(Integer orderTotalAmount) {
		this.orderTotalAmount = orderTotalAmount;
	}
}
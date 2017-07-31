package com.gewara.api.partner.res.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class OrderCardVo extends BaseVo{
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
	private Integer fullTotalfee;	//满多少才参与优惠（包含）
	private Integer opiMinPrice;	//场次最低价格
	private Timestamp timefrom;
	private Timestamp timeto;
	private String exchangetype;
	private String shortname;
	private String cardRemark;
	private String bindmobile;
	private Double cardUseAmount;		// ElecCard已使用金额
	private Integer orderTotalAmount;  //订单总金额
	public OrderCardVo(){
		
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	public Long getDiscountid() {
		return discountid;
	}
	public void setDiscountid(Long discountid) {
		this.discountid = discountid;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public Integer getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(Integer discountAmount) {
		this.discountAmount = discountAmount;
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
	public String getExchangetype() {
		return exchangetype;
	}
	public void setExchangetype(String exchangetype) {
		this.exchangetype = exchangetype;
	}
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	public Integer getDue() {
		return due;
	}
	public void setDue(Integer due) {
		this.due = due;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	@Override
	public Serializable realId() {
		return cardno;
	}
	public String getCardRemark() {
		return cardRemark;
	}
	public void setCardRemark(String cardRemark) {
		this.cardRemark = cardRemark;
	}
	public Integer getFullTotalfee() {
		return fullTotalfee;
	}
	public void setFullTotalfee(Integer fullTotalfee) {
		this.fullTotalfee = fullTotalfee;
	}
	public Integer getOpiMinPrice() {
		return opiMinPrice;
	}
	public void setOpiMinPrice(Integer opiMinPrice) {
		this.opiMinPrice = opiMinPrice;
	}
	public String getBindmobile() {
		return bindmobile;
	}
	public void setBindmobile(String bindmobile) {
		this.bindmobile = bindmobile;
	}
	public Double getCardUseAmount() {
		return cardUseAmount;
	}
	public void setCardUseAmount(Double cardUseAmount) {
		this.cardUseAmount = cardUseAmount;
	}
	public Integer getOrderTotalAmount() {
		return orderTotalAmount;
	}
	public void setOrderTotalAmount(Integer orderTotalAmount) {
		this.orderTotalAmount = orderTotalAmount;
	}
	
}

package com.gewara.api.partner.res.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class MemberECardVo extends BaseVo{
	private static final long serialVersionUID = -9002804759726715451L;
	private String cardno;
	private String name;
	private String cardtype;
	private Timestamp starttime;
	private Timestamp endtime;
	private String status;
	private String edition;
	private Integer amount;
	private Integer fullTotalfee;	//满多少才参与优惠（包含）
	private Integer opiMinPrice;	//场次最低价格
	private String cardtag;
	private String channelinfo;
	private String exchangetype;
	private String soldType;
	private String validmovie;
	private String statusText;
	private String cardRemark;
	public MemberECardVo(){
		
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
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	
	public String getCardtag() {
		return cardtag;
	}
	public void setCardtag(String cardtag) {
		this.cardtag = cardtag;
	}
	public String getChannelinfo() {
		return channelinfo;
	}
	public void setChannelinfo(String channelinfo) {
		this.channelinfo = channelinfo;
	}
	public String getExchangetype() {
		return exchangetype;
	}
	public void setExchangetype(String exchangetype) {
		this.exchangetype = exchangetype;
	}
	@Override
	public Serializable realId() {
		return cardno;
	}
	public Timestamp getStarttime() {
		return starttime;
	}
	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}
	public Timestamp getEndtime() {
		return endtime;
	}
	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getSoldType() {
		return soldType;
	}
	public void setSoldType(String soldType) {
		this.soldType = soldType;
	}
	public String getValidmovie() {
		return validmovie;
	}
	public void setValidmovie(String validmovie) {
		this.validmovie = validmovie;
	}
	public String getStatusText() {
		return statusText;
	}
	public void setStatusText(String statusText) {
		this.statusText = statusText;
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
	
	
}

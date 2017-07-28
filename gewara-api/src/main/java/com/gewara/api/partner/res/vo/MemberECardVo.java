/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.res.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class MemberECardVo extends BaseVo {
	private static final long serialVersionUID = -9002804759726715451L;
	private String cardno;
	private String name;
	private String cardtype;
	private Timestamp starttime;
	private Timestamp endtime;
	private String status;
	private String edition;
	private Integer amount;
	private Integer fullTotalfee;
	private Integer opiMinPrice;
	private String cardtag;
	private String channelinfo;
	private String exchangetype;
	private String soldType;
	private String validmovie;
	private String statusText;
	private String cardRemark;

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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEdition() {
		return this.edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getCardtag() {
		return this.cardtag;
	}

	public void setCardtag(String cardtag) {
		this.cardtag = cardtag;
	}

	public String getChannelinfo() {
		return this.channelinfo;
	}

	public void setChannelinfo(String channelinfo) {
		this.channelinfo = channelinfo;
	}

	public String getExchangetype() {
		return this.exchangetype;
	}

	public void setExchangetype(String exchangetype) {
		this.exchangetype = exchangetype;
	}

	public Serializable realId() {
		return this.cardno;
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

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getSoldType() {
		return this.soldType;
	}

	public void setSoldType(String soldType) {
		this.soldType = soldType;
	}

	public String getValidmovie() {
		return this.validmovie;
	}

	public void setValidmovie(String validmovie) {
		this.validmovie = validmovie;
	}

	public String getStatusText() {
		return this.statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
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
}
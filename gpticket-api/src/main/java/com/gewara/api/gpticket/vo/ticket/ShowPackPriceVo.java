/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gpticket.vo.ticket;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class ShowPackPriceVo extends BaseVo {
	private static final long serialVersionUID = -6403056517188327510L;
	private String packpseq;
	private String name;
	private String packpid;
	private String saseqNo;
	private String siseq;
	private String areaseq;
	private String partner;
	private String pseqno;
	private String sispseq;
	private String ticketid;
	private Integer quantity;
	private Integer price;
	private Timestamp starttime;
	private Timestamp endtime;
	private String retail;
	private String status;
	private Long priceid;
	private Long itemPackid;
	private Integer maxBuyNumberEachOrder;

	public Serializable realId() {
		return this.packpseq;
	}

	public String getPackpseq() {
		return this.packpseq;
	}

	public void setPackpseq(String packpseq) {
		this.packpseq = packpseq;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPackpid() {
		return this.packpid;
	}

	public void setPackpid(String packpid) {
		this.packpid = packpid;
	}

	public String getSaseqNo() {
		return this.saseqNo;
	}

	public void setSaseqNo(String saseqNo) {
		this.saseqNo = saseqNo;
	}

	public String getSiseq() {
		return this.siseq;
	}

	public void setSiseq(String siseq) {
		this.siseq = siseq;
	}

	public String getAreaseq() {
		return this.areaseq;
	}

	public void setAreaseq(String areaseq) {
		this.areaseq = areaseq;
	}

	public String getPartner() {
		return this.partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getPseqno() {
		return this.pseqno;
	}

	public void setPseqno(String pseqno) {
		this.pseqno = pseqno;
	}

	public String getSispseq() {
		return this.sispseq;
	}

	public void setSispseq(String sispseq) {
		this.sispseq = sispseq;
	}

	public String getTicketid() {
		return this.ticketid;
	}

	public void setTicketid(String ticketid) {
		this.ticketid = ticketid;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
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

	public String getRetail() {
		return this.retail;
	}

	public void setRetail(String retail) {
		this.retail = retail;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getPriceid() {
		return this.priceid;
	}

	public void setPriceid(Long priceid) {
		this.priceid = priceid;
	}

	public Long getItemPackid() {
		return this.itemPackid;
	}

	public void setItemPackid(Long itemPackid) {
		this.itemPackid = itemPackid;
	}

	public Integer getMaxBuyNumberEachOrder() {
		return this.maxBuyNumberEachOrder;
	}

	public void setMaxBuyNumberEachOrder(Integer maxBuyNumberEachOrder) {
		this.maxBuyNumberEachOrder = maxBuyNumberEachOrder;
	}
}
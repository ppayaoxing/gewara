/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gpticket.vo.ticket;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class ShowPriceVo extends BaseVo {
	private static final long serialVersionUID = -8924784923828458573L;
	private String sispseq;
	private String saseqNo;
	private String siseq;
	private String areaseq;
	private String partner;
	private String pseqno;
	private String ticketid;
	private Long dramaid;
	private Integer price;
	private Integer lowest;
	private Integer ticketTotal;
	private Integer ticketLimit;
	private Long priceid;
	private String status;
	private String flag;
	private Long color;
	private String retail;
	private Integer maxBuy;
	private Timestamp createtime;
	private Timestamp updatetime;

	public Serializable realId() {
		return this.sispseq;
	}

	public String getSispseq() {
		return this.sispseq;
	}

	public void setSispseq(String sispseq) {
		this.sispseq = sispseq;
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

	public String getTicketid() {
		return this.ticketid;
	}

	public void setTicketid(String ticketid) {
		this.ticketid = ticketid;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getLowest() {
		return this.lowest;
	}

	public void setLowest(Integer lowest) {
		this.lowest = lowest;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Long getPriceid() {
		return this.priceid;
	}

	public void setPriceid(Long priceid) {
		this.priceid = priceid;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public Long getDramaid() {
		return this.dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public Integer getTicketTotal() {
		return this.ticketTotal;
	}

	public void setTicketTotal(Integer ticketTotal) {
		this.ticketTotal = ticketTotal;
	}

	public Integer getTicketLimit() {
		return this.ticketLimit;
	}

	public void setTicketLimit(Integer ticketLimit) {
		this.ticketLimit = ticketLimit;
	}

	public String getSaseqNo() {
		return this.saseqNo;
	}

	public void setSaseqNo(String saseqNo) {
		this.saseqNo = saseqNo;
	}

	public Long getColor() {
		return this.color;
	}

	public void setColor(Long color) {
		this.color = color;
	}

	public String getRetail() {
		return this.retail;
	}

	public void setRetail(String retail) {
		this.retail = retail;
	}

	public Integer getMaxBuy() {
		return this.maxBuy;
	}

	public void setMaxBuy(Integer maxBuy) {
		this.maxBuy = maxBuy;
	}
}
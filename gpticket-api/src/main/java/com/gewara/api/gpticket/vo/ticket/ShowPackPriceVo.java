package com.gewara.api.gpticket.vo.ticket;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class ShowPackPriceVo extends BaseVo {
	private static final long serialVersionUID = -6403056517188327510L;
	private String packpseq;		//套票编号
	private String name;			//套票名称
	private String packpid;			//第三方套票编号
	private String saseqNo;			//区域编号(ShowArea-->saseqNo)
	private String siseq;			//场次ID
	private String areaseq;			//第三方区域ID
	private String partner;			//第三方标识
	private String pseqno;			//第三方场次编号
	private String sispseq;			//价格编号
	private String ticketid;		//第三方价格编号
	private Integer quantity;		//套票绑定数
	private Integer price;			//价格
	private Timestamp starttime;	//开始时间
	private Timestamp endtime;		//结束时间
	private String retail;			//是否零售
	private String status;			//状态
	private Long priceid;			//场次价格ID
	private Long itemPackid;		//场馆套票ID	
	private Integer maxBuyNumberEachOrder;//每单的单个票价的最大购票数目
	
	@Override
	public Serializable realId() {
		return packpseq;
	}

	public String getPackpseq() {
		return packpseq;
	}

	public void setPackpseq(String packpseq) {
		this.packpseq = packpseq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPackpid() {
		return packpid;
	}

	public void setPackpid(String packpid) {
		this.packpid = packpid;
	}

	public String getSaseqNo() {
		return saseqNo;
	}

	public void setSaseqNo(String saseqNo) {
		this.saseqNo = saseqNo;
	}

	public String getSiseq() {
		return siseq;
	}

	public void setSiseq(String siseq) {
		this.siseq = siseq;
	}

	public String getAreaseq() {
		return areaseq;
	}

	public void setAreaseq(String areaseq) {
		this.areaseq = areaseq;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getPseqno() {
		return pseqno;
	}

	public void setPseqno(String pseqno) {
		this.pseqno = pseqno;
	}

	public String getSispseq() {
		return sispseq;
	}

	public void setSispseq(String sispseq) {
		this.sispseq = sispseq;
	}

	public String getTicketid() {
		return ticketid;
	}

	public void setTicketid(String ticketid) {
		this.ticketid = ticketid;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
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

	public String getRetail() {
		return retail;
	}

	public void setRetail(String retail) {
		this.retail = retail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getPriceid() {
		return priceid;
	}

	public void setPriceid(Long priceid) {
		this.priceid = priceid;
	}

	public Long getItemPackid() {
		return itemPackid;
	}

	public void setItemPackid(Long itemPackid) {
		this.itemPackid = itemPackid;
	}

	public Integer getMaxBuyNumberEachOrder() {
		return maxBuyNumberEachOrder;
	}

	public void setMaxBuyNumberEachOrder(Integer maxBuyNumberEachOrder) {
		this.maxBuyNumberEachOrder = maxBuyNumberEachOrder;
	}

}

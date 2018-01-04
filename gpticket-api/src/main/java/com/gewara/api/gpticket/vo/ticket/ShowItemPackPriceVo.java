package com.gewara.api.gpticket.vo.ticket;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class ShowItemPackPriceVo extends BaseVo {

	private static final long serialVersionUID = 6420436328856569550L;

	private Long id;
	private String name;			//套票名称
	private String packpid;			//第三方套票编号
	private String siseq;			//场次ID(ShowItem-->siseq)
	private String partner;			//第三方标识
	private String pseqno;			//第三方场次编号
	private String ticketid;		//第三方价格编号
	private Integer quantity;		//套票绑定数
	private Integer price;			//价格
	private Integer discount;		//优惠折扣
	private Timestamp starttime;	//开始时间
	private Timestamp endtime;		//结束时间
	private String retail;			//是否零售
	private Long priceid;			//场次价格ID
	private String status;
	
	private Timestamp addtime;
	private Timestamp updatetime;
	
	@Override
	public Serializable realId() {
		return id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getSiseq() {
		return siseq;
	}

	public void setSiseq(String siseq) {
		this.siseq = siseq;
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

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
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

	public Long getPriceid() {
		return priceid;
	}

	public void setPriceid(Long priceid) {
		this.priceid = priceid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	
}

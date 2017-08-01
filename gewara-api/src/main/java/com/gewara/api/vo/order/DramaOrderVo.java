package com.gewara.api.vo.order;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;
public class DramaOrderVo extends GewaOrderVo {
	
	private Long id;
	private Long orderid;
	private Long theatreid;
	private Long dramaid;
	private Long dpid;
	private String ticketfaceid;
	private Integer quantity;
	private String Checkpass;
	private String dramaname;
	private String theatrename;
	private String opentype;
	private String roomname;
	private String period;
	private String ticketface;
	private String Serialno;
	private String Seller;
	private String Sellerseq;
	private String Dpiname;
	private String Seatprice;
	private String Pricetype;
	private Timestamp playtime;
	
	@Override
	public Serializable realId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getId() {
		return id;
	}

	public Long getOrderid() {
		return orderid;
	}

	public Long getTheatreid() {
		return theatreid;
	}

	public Long getDramaid() {
		return dramaid;
	}

	public Long getDpid() {
		return dpid;
	}

	public String getTicketfaceid() {
		return ticketfaceid;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public String getCheckpass() {
		return Checkpass;
	}

	public String getDramaname() {
		return dramaname;
	}

	public String getTheatrename() {
		return theatrename;
	}

	public String getOpentype() {
		return opentype;
	}

	public String getRoomname() {
		return roomname;
	}

	public String getPeriod() {
		return period;
	}

	public String getTicketface() {
		return ticketface;
	}

	public String getSerialno() {
		return Serialno;
	}

	public String getSeller() {
		return Seller;
	}

	public String getSellerseq() {
		return Sellerseq;
	}

	public String getDpiname() {
		return Dpiname;
	}

	public String getSeatprice() {
		return Seatprice;
	}

	public String getPricetype() {
		return Pricetype;
	}

	public Timestamp getPlaytime() {
		return playtime;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public void setTheatreid(Long theatreid) {
		this.theatreid = theatreid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public void setTicketfaceid(String ticketfaceid) {
		this.ticketfaceid = ticketfaceid;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setCheckpass(String checkpass) {
		Checkpass = checkpass;
	}

	public void setDramaname(String dramaname) {
		this.dramaname = dramaname;
	}

	public void setTheatrename(String theatrename) {
		this.theatrename = theatrename;
	}

	public void setOpentype(String opentype) {
		this.opentype = opentype;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public void setTicketface(String ticketface) {
		this.ticketface = ticketface;
	}

	public void setSerialno(String serialno) {
		Serialno = serialno;
	}

	public void setSeller(String seller) {
		Seller = seller;
	}

	public void setSellerseq(String sellerseq) {
		Sellerseq = sellerseq;
	}

	public void setDpiname(String dpiname) {
		Dpiname = dpiname;
	}

	public void setSeatprice(String seatprice) {
		Seatprice = seatprice;
	}

	public void setPricetype(String pricetype) {
		Pricetype = pricetype;
	}

	public void setPlaytime(Timestamp playtime) {
		this.playtime = playtime;
	}

}

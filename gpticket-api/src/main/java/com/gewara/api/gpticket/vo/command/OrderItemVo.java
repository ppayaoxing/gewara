/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gpticket.vo.command;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class OrderItemVo implements Serializable {
	private static final long serialVersionUID = -2463980550332199912L;
	public static final String TYPE_PRICE = "price";
	public static final String TYPE_SEAT = "seat";
	private String siseqno;
	private String type;
	private String seatIds;
	private String ticketRange;
	private String packTicketId;
	private String priceInfo;
	private Map<String, Integer> priceMap = new HashMap();
	private Integer discountTotal;
	private String idnumber;

	public OrderItemVo() {
	}

	public OrderItemVo(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSiseqno() {
		return this.siseqno;
	}

	public void setSiseqno(String siseqno) {
		this.siseqno = siseqno;
	}

	public String getSeatIds() {
		return this.seatIds;
	}

	public void setSeatIds(String seatIds) {
		this.seatIds = seatIds;
	}

	public String getTicketRange() {
		return this.ticketRange;
	}

	public void setTicketRange(String ticketRange) {
		this.ticketRange = ticketRange;
	}

	public String getPriceInfo() {
		return this.priceInfo;
	}

	public void setPriceInfo(String priceInfo) {
		this.priceInfo = priceInfo;
	}

	public Integer getDiscountTotal() {
		return this.discountTotal;
	}

	public void setDiscountTotal(Integer discountTotal) {
		this.discountTotal = discountTotal;
	}

	public Map<String, Integer> getPriceMap() {
		return this.priceMap;
	}

	public void setPriceMap(Map<String, Integer> priceMap) {
		this.priceMap = priceMap;
	}

	public String getPackTicketId() {
		return this.packTicketId;
	}

	public void setPackTicketId(String packTicketId) {
		this.packTicketId = packTicketId;
	}

	public String getIdnumber() {
		return this.idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
}
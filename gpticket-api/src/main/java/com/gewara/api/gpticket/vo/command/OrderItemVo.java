package com.gewara.api.gpticket.vo.command;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class OrderItemVo implements Serializable{
	private static final long serialVersionUID = -2463980550332199912L;
	public static final String TYPE_PRICE = "price";
	public static final String TYPE_SEAT = "seat";
	private String siseqno;			//场次编号
	private String type; 			//类型
	private String seatIds; 		//座票标识序列,站票标识序列,格式：[lineno:rankno,....],如1:1,1:2；锁票信息
	private String ticketRange;		//站票请求 ，场区_票价:数量，格式：{"场次区域ID_票价ID":"数量"} 例子：{"2183_602":"1"}
	private String packTicketId; 	//套票ID
	private String priceInfo;
	private Map<String, Integer> priceMap = new HashMap<String, Integer>();
	private Integer discountTotal;
	private String idnumber;		//身份证信息
	
	public OrderItemVo(){}
	
	public OrderItemVo(String type){
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getSiseqno() {
		return siseqno;
	}

	public void setSiseqno(String siseqno) {
		this.siseqno = siseqno;
	}

	public String getSeatIds() {
		return seatIds;
	}
	public void setSeatIds(String seatIds) {
		this.seatIds = seatIds;
	}
	public String getTicketRange() {
		return ticketRange;
	}
	public void setTicketRange(String ticketRange) {
		this.ticketRange = ticketRange;
	}
	
	public String getPriceInfo() {
		return priceInfo;
	}

	public void setPriceInfo(String priceInfo) {
		this.priceInfo = priceInfo;
	}

	public Integer getDiscountTotal() {
		return discountTotal;
	}
	public void setDiscountTotal(Integer discountTotal) {
		this.discountTotal = discountTotal;
	}
	public Map<String, Integer> getPriceMap() {
		return priceMap;
	}
	public void setPriceMap(Map<String, Integer> priceMap) {
		this.priceMap = priceMap;
	}
	public String getPackTicketId() {
		return packTicketId;
	}
	public void setPackTicketId(String packTicketId) {
		this.packTicketId = packTicketId;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	
}

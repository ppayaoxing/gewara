package com.gewara.api.vo.order;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.partner.res.vo.RoomSeatVo;
import com.gewara.api.vo.BaseVo;
import com.gewara.cons.SeatConstant;

public class SellSeatVo extends BaseVo {
	private static final long serialVersionUID = 7220661632796433750L;
	public static final String SECTION_UP = "up";		//楼上
	public static final String SECTION_DOWN = "dw";		//楼下
	private Long id;				//与OpenSeat共用Id
	private Integer version;		//版本
	private Long orderid;			//订单号
	private Long mpid;				//关联场次
	private String seatline;		//座位行号
	private String seatrank;		//座位列号
	private String secid;			//区域编号
	private Timestamp validtime;
	private Integer price;
	private String status;			//状态
	public SellSeatVo(){}
	public SellSeatVo(RoomSeatVo rseat, Long mpid, Integer price, Timestamp validtime){
		this.mpid = mpid;
		this.version = 0;
		this.status = SeatConstant.STATUS_NEW;
		this.validtime = validtime;
		this.secid = rseat.getSecid();
		this.copyFrom(rseat, price);
	}
	/**
	 * only for wanda
	 * @param seatline
	 * @param seatrank
	 * @param mpid
	 */
	public SellSeatVo(String seatline, String seatrank, Long mpid){
		this.version = 0;
		this.status = SeatConstant.STATUS_NEW;
		this.mpid = mpid;
		this.seatline = seatline;
		this.seatrank = seatrank;
	}
	public void copyFrom(RoomSeatVo rseat, Integer sprice) {
		this.seatline = rseat.getSeatline();
		this.seatrank = rseat.getSeatrank();
		this.secid = rseat.getSecid();
		this.price = sprice;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Timestamp getValidtime() {
		return validtime;
	}
	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Long getMpid() {
		return mpid;
	}
	public void setMpid(Long mpid) {
		this.mpid = mpid;
	}
	public String getSeatrank() {
		return seatrank;
	}
	public void setSeatrank(String seatrank) {
		this.seatrank = seatrank;
	}
	public String getSeatline() {
		return seatline;
	}
	public void setSeatline(String seatline) {
		this.seatline = seatline;
	}
	public boolean isAvailable(Timestamp cur) {
		return status.equals(SeatConstant.STATUS_NEW) && validtime.before(cur);
	}
	public boolean isAvailableBy(Long sorderid, Timestamp cur){
		return status.equals(SeatConstant.STATUS_NEW) && validtime.before(cur) || sorderid.equals(this.orderid);
	}
	public boolean isSold(){
		return SeatConstant.STATUS_SOLD.equals(status);
	}
	public String getKey(){
		return this.seatline+":"+this.seatrank;
	}
	public String getSeatLabel(){
		//return getSeatLabel(secid, seatline, seatrank);
		if(StringUtils.isNotBlank(secid)){
			if(SECTION_UP.equals(secid)){
				return "楼上" + seatline + "排"+seatrank+"座";
			}else if(SECTION_DOWN.equals(secid)){
				return "楼下" + seatline + "排" + seatrank + "座";
			}
		}
		return seatline+"排"+seatrank+"座";
	}
	public Long getOrderid() {
		return orderid;
	}
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}
	public String getSecid() {
		return secid;
	}
	public void setSecid(String secid) {
		this.secid = secid;
	}
	@Override
	public Serializable realId() {
		return id;
	}
}

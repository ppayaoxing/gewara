package com.gewara.drama.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.drama.constant.TheatreSeatConstant;

public class SellDramaSeatVo extends BaseVo {

	private static final long serialVersionUID = -7943952447862925974L;

	private Long id;
	private Integer version;		//版本
	private Long odiid;				//关联场次
	private Long dpid;				//
	private Long areaid;			//关联场区
	private Long orderid;			//订单号
	private String seatline;		//座位行号
	private String seatrank;		//座位列号
	private Timestamp validtime;
	private Integer price;
	private Integer theatreprice;
	private Integer costprice;
	private String status;			//状态
	private String remark;
	
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Long getOdiid() {
		return odiid;
	}

	public void setOdiid(Long odiid) {
		this.odiid = odiid;
	}

	public Long getDpid() {
		return dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public Long getAreaid() {
		return areaid;
	}

	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public String getSeatline() {
		return seatline;
	}

	public void setSeatline(String seatline) {
		this.seatline = seatline;
	}

	public String getSeatrank() {
		return seatrank;
	}

	public void setSeatrank(String seatrank) {
		this.seatrank = seatrank;
	}

	public Timestamp getValidtime() {
		return validtime;
	}

	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getTheatreprice() {
		return theatreprice;
	}

	public void setTheatreprice(Integer theatreprice) {
		this.theatreprice = theatreprice;
	}

	public Integer getCostprice() {
		return costprice;
	}

	public void setCostprice(Integer costprice) {
		this.costprice = costprice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public boolean hasAvailable() {
		Timestamp cur = new Timestamp(System.currentTimeMillis());
		return StringUtils.equals(status, TheatreSeatConstant.STATUS_NEW) && validtime.before(cur);
	}
	
	public boolean hasAvailableBy(Long sorderid){
		Timestamp cur = new Timestamp(System.currentTimeMillis());
		return StringUtils.equals(status, TheatreSeatConstant.STATUS_NEW) && validtime.before(cur) || sorderid.equals(this.orderid);
	}
	
	public boolean hasSold(){
		return TheatreSeatConstant.STATUS_SOLD.equals(status);
	}
	
	public String getSeatLabel(){
		return seatline+"排"+seatrank+"座";
	}

	
	public String getKey(){
		return this.seatline + ":" + this.seatrank;
	}
}

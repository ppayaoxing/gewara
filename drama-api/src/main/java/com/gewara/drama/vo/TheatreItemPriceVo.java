package com.gewara.drama.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class TheatreItemPriceVo extends BaseVo {

	private static final long serialVersionUID = -4661186434438292766L;
	private Long id;
	private Long dpid;
	private Long dramaid;
	private Integer price;				
	private Integer costprice;			
	private Integer theatreprice;	
	private String seattype;
	private String status;				
	private String remark;				
	private String otherinfo;			//其它信息
	private Long color;					//颜色
	private String flag;					//
	private String seller;				//
	private Long priceid;				//第三方场次价格编号(ShowItemPrice-->id)
	private String retail;				//是否可以零售
	private Long settleid;				//结算ID
	private String origin;				//
	private Timestamp addtime;
	private Timestamp updatetime;		//更新时间
	
	private Integer totalnum;			//总票数
	private Integer csellnum;			//场馆卖出数
	private Integer gsellnum;			//格瓦拉锁定
	private Integer sellnum;			//卖出票数量
	private Integer sellordernum;		//卖出订单数量
	
	private String supplierCode;
	private Long dramaSettleid;

	private String sendDiscount;

	public TheatreItemPriceVo(){}
	
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

	public Long getDpid() {
		return dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public Long getDramaid() {
		return dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getCostprice() {
		return costprice;
	}

	public void setCostprice(Integer costprice) {
		this.costprice = costprice;
	}

	public Integer getTheatreprice() {
		return theatreprice;
	}

	public void setTheatreprice(Integer theatreprice) {
		this.theatreprice = theatreprice;
	}

	public String getSeattype() {
		return seattype;
	}

	public void setSeattype(String seattype) {
		this.seattype = seattype;
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

	public String getOtherinfo() {
		return otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public Long getColor() {
		return color;
	}

	public void setColor(Long color) {
		this.color = color;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getRetail() {
		return retail;
	}

	public void setRetail(String retail) {
		this.retail = retail;
	}

	public Long getSettleid() {
		return settleid;
	}

	public void setSettleid(Long settleid) {
		this.settleid = settleid;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public Long getPriceid() {
		return priceid;
	}

	public void setPriceid(Long priceid) {
		this.priceid = priceid;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Integer getTotalnum() {
		return totalnum;
	}

	public void setTotalnum(Integer totalnum) {
		this.totalnum = totalnum;
	}

	public Integer getCsellnum() {
		return csellnum;
	}

	public void setCsellnum(Integer csellnum) {
		this.csellnum = csellnum;
	}

	public Integer getGsellnum() {
		return gsellnum;
	}

	public void setGsellnum(Integer gsellnum) {
		this.gsellnum = gsellnum;
	}

	public Integer getSellnum() {
		return sellnum;
	}

	public void setSellnum(Integer sellnum) {
		this.sellnum = sellnum;
	}

	public Integer getSellordernum() {
		return sellordernum;
	}

	public void setSellordernum(Integer sellordernum) {
		this.sellordernum = sellordernum;
	}

	public Integer hasRemainnum(){
		return this.totalnum - gsellnum - csellnum - sellnum;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public Long getDramaSettleid() {
		return dramaSettleid;
	}

	public void setDramaSettleid(Long dramaSettleid) {
		this.dramaSettleid = dramaSettleid;
	}

	public String getSendDiscount() {
		return sendDiscount;
	}

	public void setSendDiscount(String sendDiscount) {
		this.sendDiscount = sendDiscount;
	}
}

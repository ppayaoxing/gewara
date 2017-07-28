/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

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
	private String otherinfo;
	private Long color;
	private String flag;
	private String seller;
	private Long priceid;
	private String retail;
	private Long settleid;
	private String origin;
	private Timestamp addtime;
	private Timestamp updatetime;
	private Integer totalnum;
	private Integer csellnum;
	private Integer gsellnum;
	private Integer sellnum;
	private Integer sellordernum;
	private String supplierCode;
	private Long dramaSettleid;
	private String sendDiscount;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDpid() {
		return this.dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public Long getDramaid() {
		return this.dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getCostprice() {
		return this.costprice;
	}

	public void setCostprice(Integer costprice) {
		this.costprice = costprice;
	}

	public Integer getTheatreprice() {
		return this.theatreprice;
	}

	public void setTheatreprice(Integer theatreprice) {
		this.theatreprice = theatreprice;
	}

	public String getSeattype() {
		return this.seattype;
	}

	public void setSeattype(String seattype) {
		this.seattype = seattype;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public Long getColor() {
		return this.color;
	}

	public void setColor(Long color) {
		this.color = color;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getRetail() {
		return this.retail;
	}

	public void setRetail(String retail) {
		this.retail = retail;
	}

	public Long getSettleid() {
		return this.settleid;
	}

	public void setSettleid(Long settleid) {
		this.settleid = settleid;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getSeller() {
		return this.seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public Long getPriceid() {
		return this.priceid;
	}

	public void setPriceid(Long priceid) {
		this.priceid = priceid;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Integer getTotalnum() {
		return this.totalnum;
	}

	public void setTotalnum(Integer totalnum) {
		this.totalnum = totalnum;
	}

	public Integer getCsellnum() {
		return this.csellnum;
	}

	public void setCsellnum(Integer csellnum) {
		this.csellnum = csellnum;
	}

	public Integer getGsellnum() {
		return this.gsellnum;
	}

	public void setGsellnum(Integer gsellnum) {
		this.gsellnum = gsellnum;
	}

	public Integer getSellnum() {
		return this.sellnum;
	}

	public void setSellnum(Integer sellnum) {
		this.sellnum = sellnum;
	}

	public Integer getSellordernum() {
		return this.sellordernum;
	}

	public void setSellordernum(Integer sellordernum) {
		this.sellordernum = sellordernum;
	}

	public Integer hasRemainnum() {
		return Integer.valueOf(this.totalnum.intValue() - this.gsellnum.intValue() - this.csellnum.intValue()
				- this.sellnum.intValue());
	}

	public String getSupplierCode() {
		return this.supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public Long getDramaSettleid() {
		return this.dramaSettleid;
	}

	public void setDramaSettleid(Long dramaSettleid) {
		this.dramaSettleid = dramaSettleid;
	}

	public String getSendDiscount() {
		return this.sendDiscount;
	}

	public void setSendDiscount(String sendDiscount) {
		this.sendDiscount = sendDiscount;
	}
}
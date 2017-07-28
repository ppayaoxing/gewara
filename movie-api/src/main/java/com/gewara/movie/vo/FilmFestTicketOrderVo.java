/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.util.Date;

public class FilmFestTicketOrderVo extends BaseVo {
	private static final long serialVersionUID = -6809158194654658394L;
	private Long id;
	private String orderType;
	private String ordertitle;
	private String tradeNo;
	private String mobile;
	private Date createtime;
	private Date addtime;
	private Date updatetime;
	private Date paidtime;
	private Date playtime;
	private Date taketime;
	private Long memberid;
	private String description2;
	private Integer alipaid;
	private Integer wabi;
	private Integer totalcost;
	private Integer totalfee;
	private Integer discount;
	private Integer costprice;
	private Integer unitprice;
	private Integer quantity;
	private Integer itemfee;
	private String otherinfo;
	private String citycode;
	private String category;
	private Long placeid;
	private Long relatedid;
	private Long itemid;
	private String filmTag;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderType() {
		return this.orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrdertitle() {
		return this.ordertitle;
	}

	public void setOrdertitle(String ordertitle) {
		this.ordertitle = ordertitle;
	}

	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Date getPaidtime() {
		return this.paidtime;
	}

	public void setPaidtime(Date paidtime) {
		this.paidtime = paidtime;
	}

	public Date getPlaytime() {
		return this.playtime;
	}

	public void setPlaytime(Date playtime) {
		this.playtime = playtime;
	}

	public Date getTaketime() {
		return this.taketime;
	}

	public void setTaketime(Date taketime) {
		this.taketime = taketime;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getDescription2() {
		return this.description2;
	}

	public void setDescription2(String description2) {
		this.description2 = description2;
	}

	public Integer getAlipaid() {
		return this.alipaid;
	}

	public void setAlipaid(Integer alipaid) {
		this.alipaid = alipaid;
	}

	public Integer getWabi() {
		return this.wabi;
	}

	public void setWabi(Integer wabi) {
		this.wabi = wabi;
	}

	public Integer getTotalcost() {
		return this.totalcost;
	}

	public void setTotalcost(Integer totalcost) {
		this.totalcost = totalcost;
	}

	public Integer getTotalfee() {
		return this.totalfee;
	}

	public void setTotalfee(Integer totalfee) {
		this.totalfee = totalfee;
	}

	public Integer getDiscount() {
		return this.discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getCostprice() {
		return this.costprice;
	}

	public void setCostprice(Integer costprice) {
		this.costprice = costprice;
	}

	public Integer getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(Integer unitprice) {
		this.unitprice = unitprice;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getItemfee() {
		return this.itemfee;
	}

	public void setItemfee(Integer itemfee) {
		this.itemfee = itemfee;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getPlaceid() {
		return this.placeid;
	}

	public void setPlaceid(Long placeid) {
		this.placeid = placeid;
	}

	public Long getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public Long getItemid() {
		return this.itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public String getFilmTag() {
		return this.filmTag;
	}

	public void setFilmTag(String filmTag) {
		this.filmTag = filmTag;
	}
}
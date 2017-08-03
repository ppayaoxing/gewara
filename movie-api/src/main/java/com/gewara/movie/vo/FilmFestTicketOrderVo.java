package com.gewara.movie.vo;

import java.io.Serializable;
import java.util.Date;

import com.gewara.api.vo.BaseVo;

public class FilmFestTicketOrderVo extends BaseVo{
	private static final long serialVersionUID = -6809158194654658394L;
	private Long id;					//ID
	private String orderType;
	private String ordertitle;		//订单标题
	private String tradeNo;			//订单号
	private String mobile;			//联系手机
	private Date createtime;		//用户下单时间
	private Date addtime;		//增加时间：第一次创建时间、待处理创建时间、火凤凰锁定时间
	private Date updatetime;		//用户修改时间
	private Date paidtime;		//付款时间
	private Date playtime;		//场次时间
	private Date taketime;		//取票时间
	private Long memberid;			//关联用户
	private String description2;		//商品描述
	private Integer alipaid;			//淘宝或汇付支付的金额
	private Integer wabi;				//瓦币消费
	private Integer totalcost;		//总成本价
	private Integer totalfee;			//订单总金额
	private Integer discount;			//订单优惠
	private Integer costprice;		//成本价
	private Integer unitprice;		//单价
	private Integer quantity;			//数量
	private Integer itemfee;			//订单附属品总价
	private String otherinfo;			//其他信息
	private String citycode;			//城市代码
	private String category;			//订单类别
	private Long placeid;			//关联场馆：Cinema、Theatre
	private Long relatedid;			//mpid,goodsid,dpid(drama),pubid(pubsale)
	private Long itemid;			//movieid,dramaid
	private String filmTag;
	
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

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrdertitle() {
		return ordertitle;
	}

	public void setOrdertitle(String ordertitle) {
		this.ordertitle = ordertitle;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Date getPaidtime() {
		return paidtime;
	}

	public void setPaidtime(Date paidtime) {
		this.paidtime = paidtime;
	}

	public Date getPlaytime() {
		return playtime;
	}

	public void setPlaytime(Date playtime) {
		this.playtime = playtime;
	}

	public Date getTaketime() {
		return taketime;
	}

	public void setTaketime(Date taketime) {
		this.taketime = taketime;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getDescription2() {
		return description2;
	}

	public void setDescription2(String description2) {
		this.description2 = description2;
	}

	public Integer getAlipaid() {
		return alipaid;
	}

	public void setAlipaid(Integer alipaid) {
		this.alipaid = alipaid;
	}

	public Integer getWabi() {
		return wabi;
	}

	public void setWabi(Integer wabi) {
		this.wabi = wabi;
	}

	public Integer getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(Integer totalcost) {
		this.totalcost = totalcost;
	}

	public Integer getTotalfee() {
		return totalfee;
	}

	public void setTotalfee(Integer totalfee) {
		this.totalfee = totalfee;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getCostprice() {
		return costprice;
	}

	public void setCostprice(Integer costprice) {
		this.costprice = costprice;
	}

	public Integer getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Integer unitprice) {
		this.unitprice = unitprice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getItemfee() {
		return itemfee;
	}

	public void setItemfee(Integer itemfee) {
		this.itemfee = itemfee;
	}

	public String getOtherinfo() {
		return otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getPlaceid() {
		return placeid;
	}

	public void setPlaceid(Long placeid) {
		this.placeid = placeid;
	}

	public Long getRelatedid() {
		return relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public Long getItemid() {
		return itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public String getFilmTag() {
		return filmTag;
	}

	public void setFilmTag(String filmTag) {
		this.filmTag = filmTag;
	}



}

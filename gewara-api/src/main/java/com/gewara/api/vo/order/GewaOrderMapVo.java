package com.gewara.api.vo.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;

public class GewaOrderMapVo extends BaseVo implements Serializable {
	
	private static final long serialVersionUID = -2087716993799697315L;
	private Long id;
	private String tradeNo;
	private String ordertype;
	private GewaOrderVo order;
	private List<BuyItemVo> buyItemList = new ArrayList<BuyItemVo>();
	private BaseVo place;											//场馆
	private BaseVo profile;											//场馆扩展
	private BaseVo item;											//项目
	private BaseVo schedule;										//场次，物品，卡
	private BaseVo relate;											//关联活动
	
	public GewaOrderMapVo(){}
	
	public GewaOrderMapVo(GewaOrderVo order){
		this.order = order;
		this.id = order.getId();
		this.tradeNo = order.getTradeNo();
		this.ordertype = order.getOrdertype();
	}
	
	@Override
	public Serializable realId() {
		return id;
	}
	public String getTradeNo() {
		return tradeNo;
	}
	
	public String getOrdertype() {
		return ordertype;
	}
	
	public GewaOrderVo getOrder() {
		return order;
	}
	public void setOrder(GewaOrderVo order) {
		this.order = order;
	}
	public List<BuyItemVo> getBuyItemList() {
		return buyItemList;
	}
	public void setBuyItemList(List<BuyItemVo> buyItemList) {
		this.buyItemList = buyItemList;
	}
	public Object getPlace() {
		return place;
	}
	public void setPlace(BaseVo place) {
		this.place = place;
	}
	public Object getProfile() {
		return profile;
	}

	public void setProfile(BaseVo profile) {
		this.profile = profile;
	}

	public Object getItem() {
		return item;
	}
	public void setItem(BaseVo item) {
		this.item = item;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Object getSchedule() {
		return schedule;
	}

	public void setSchedule(BaseVo schedule) {
		this.schedule = schedule;
	}
	
	public Object getRelate() {
		return relate;
	}

	public void setRelate(BaseVo relate) {
		this.relate = relate;
	}

	public boolean hasOrdertype(String orderType){
		if(StringUtils.isBlank(orderType)){
			return false;
		}
		return StringUtils.equals(orderType, this.ordertype);
	}

	public String getOrdertitle(){
		String title = "";
		return title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}

/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.order;

import com.gewara.api.vo.BaseVo;
import com.gewara.api.vo.order.BuyItemVo;
import com.gewara.api.vo.order.GewaOrderVo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class GewaOrderMapVo extends BaseVo implements Serializable {
	private static final long serialVersionUID = -2087716993799697315L;
	private Long id;
	private String tradeNo;
	private String ordertype;
	private GewaOrderVo order;
	private List<BuyItemVo> buyItemList = new ArrayList();
	private BaseVo place;
	private BaseVo profile;
	private BaseVo item;
	private BaseVo schedule;
	private BaseVo relate;

	public GewaOrderMapVo() {
	}

	public GewaOrderMapVo(GewaOrderVo order) {
		this.order = order;
		this.id = order.getId();
		this.tradeNo = order.getTradeNo();
		this.ordertype = order.getOrdertype();
	}

	public Serializable realId() {
		return this.id;
	}

	public String getTradeNo() {
		return this.tradeNo;
	}

	public String getOrdertype() {
		return this.ordertype;
	}

	public GewaOrderVo getOrder() {
		return this.order;
	}

	public void setOrder(GewaOrderVo order) {
		this.order = order;
	}

	public List<BuyItemVo> getBuyItemList() {
		return this.buyItemList;
	}

	public void setBuyItemList(List<BuyItemVo> buyItemList) {
		this.buyItemList = buyItemList;
	}

	public Object getPlace() {
		return this.place;
	}

	public void setPlace(BaseVo place) {
		this.place = place;
	}

	public Object getProfile() {
		return this.profile;
	}

	public void setProfile(BaseVo profile) {
		this.profile = profile;
	}

	public Object getItem() {
		return this.item;
	}

	public void setItem(BaseVo item) {
		this.item = item;
	}

	public static long getSerialversionuid() {
		return -2087716993799697315L;
	}

	public Object getSchedule() {
		return this.schedule;
	}

	public void setSchedule(BaseVo schedule) {
		this.schedule = schedule;
	}

	public Object getRelate() {
		return this.relate;
	}

	public void setRelate(BaseVo relate) {
		this.relate = relate;
	}

	public boolean hasOrdertype(String orderType) {
		return StringUtils.isBlank(orderType) ? false : StringUtils.equals(orderType, this.ordertype);
	}

	public String getOrdertitle() {
		String title = "";
		return title;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
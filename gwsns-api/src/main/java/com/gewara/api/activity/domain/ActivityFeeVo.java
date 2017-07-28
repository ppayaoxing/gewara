/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.activity.domain;

import com.gewara.api.activity.ApiObject;
import java.io.Serializable;
import java.sql.Timestamp;

public class ActivityFeeVo extends ApiObject {
	private static final long serialVersionUID = 2892910571679692378L;
	private Long id;
	private Long activityId;
	private Long goodsId;
	private String feeName;
	private Integer price;
	private Timestamp beginTime;
	private Timestamp endTime;
	private Integer quantity;
	private Integer orderQuantity;
	private Integer validQuantity;
	private String isLimited;
	private Integer limitCount;
	private Integer limitOrderCount;
	private String islimitedOrder;
	private String status;
	private Timestamp addTime;
	private Timestamp updateTime;
	private String isAlgorithm;
	private String algorithm;
	private String allowaddnum;
	private Integer maxbuy;
	private Integer virtualcount = Integer.valueOf(0);

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getActivityId() {
		return this.activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getFeeName() {
		return this.feeName;
	}

	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Timestamp getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getOrderQuantity() {
		return this.orderQuantity;
	}

	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Integer getValidQuantity() {
		return this.validQuantity;
	}

	public void setValidQuantity(Integer validQuantity) {
		this.validQuantity = validQuantity;
	}

	public String getIsLimited() {
		return this.isLimited;
	}

	public void setIsLimited(String isLimited) {
		this.isLimited = isLimited;
	}

	public Integer getLimitCount() {
		return this.limitCount;
	}

	public void setLimitCount(Integer limitCount) {
		this.limitCount = limitCount;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getLimitOrderCount() {
		return this.limitOrderCount;
	}

	public void setLimitOrderCount(Integer limitOrderCount) {
		this.limitOrderCount = limitOrderCount;
	}

	public boolean isJoining() {
		if (this.beginTime == null) {
			return false;
		} else {
			Timestamp cur = new Timestamp(System.currentTimeMillis());
			return this.beginTime.after(cur);
		}
	}

	public String getIslimitedOrder() {
		return this.islimitedOrder;
	}

	public void setIslimitedOrder(String islimitedOrder) {
		this.islimitedOrder = islimitedOrder;
	}

	public String getIsAlgorithm() {
		return this.isAlgorithm;
	}

	public void setIsAlgorithm(String isAlgorithm) {
		this.isAlgorithm = isAlgorithm;
	}

	public String getAlgorithm() {
		return this.algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	public String getAllowaddnum() {
		return this.allowaddnum;
	}

	public void setAllowaddnum(String allowaddnum) {
		this.allowaddnum = allowaddnum;
	}

	public Integer getMaxbuy() {
		return this.maxbuy;
	}

	public void setMaxbuy(Integer maxbuy) {
		this.maxbuy = maxbuy;
	}

	public Integer getVirtualcount() {
		return this.virtualcount;
	}

	public void setVirtualcount(Integer virtualcount) {
		this.virtualcount = virtualcount;
	}
}
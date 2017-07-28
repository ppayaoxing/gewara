/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gworder.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class CinemaMerchantGoodsStatisVo extends BaseVo {
	private static final long serialVersionUID = -8567796112326795892L;
	private Long cinemaid;
	private String dateStr;
	private Integer totalfee;
	private Integer quantity;
	private Integer orderNum;
	private Long createTime;
	private Long updateTime;

	public Serializable realId() {
		return this.dateStr;
	}

	public Long getCinemaid() {
		return this.cinemaid;
	}

	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}

	public String getDateStr() {
		return this.dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

	public Integer getTotalfee() {
		return this.totalfee;
	}

	public void setTotalfee(Integer totalfee) {
		this.totalfee = totalfee;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Long getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}
}
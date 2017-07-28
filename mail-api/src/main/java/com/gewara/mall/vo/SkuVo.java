/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mall.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class SkuVo extends BaseVo {
	private static final long serialVersionUID = 8217681262266417529L;
	private Long id;
	private Integer version;
	private Long productId;
	private Integer unitPrice;
	private Integer costPrice;
	private Integer stock;
	private Integer sold;
	private String status;
	private String otherInfo;
	private Integer retainage;
	private Integer point;
	private Integer pointPrice;

	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getCostPrice() {
		return this.costPrice;
	}

	public void setCostPrice(Integer costPrice) {
		this.costPrice = costPrice;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getSold() {
		return this.sold;
	}

	public void setSold(Integer sold) {
		this.sold = sold;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOtherInfo() {
		return this.otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getRetainage() {
		return this.retainage;
	}

	public void setRetainage(Integer retainage) {
		this.retainage = retainage;
	}

	public Integer getPoint() {
		return this.point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Integer getPointPrice() {
		return this.pointPrice;
	}

	public void setPointPrice(Integer pointPrice) {
		this.pointPrice = pointPrice;
	}
}
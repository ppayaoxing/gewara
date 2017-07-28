/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mall.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class MallOrderItemVo extends BaseVo {
	private static final long serialVersionUID = -456661946584735116L;
	private Long id;
	private Long shipperOrderId;
	private Long mallOrderId;
	private Long productId;
	private Integer qty;
	private Integer unitPrice;
	private Integer totalFee;
	private Integer costPrice;
	private Integer totalCost;
	private Integer usedPoint;
	private Long skuId;
	private String attributeName1;
	private String attributeName2;

	public Integer getQty() {
		return this.qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Long getMallOrderId() {
		return this.mallOrderId;
	}

	public void setMallOrderId(Long mallOrderId) {
		this.mallOrderId = mallOrderId;
	}

	public Long getSkuId() {
		return this.skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Integer getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Serializable realId() {
		return this.id;
	}

	public Integer getCostPrice() {
		return this.costPrice;
	}

	public void setCostPrice(Integer costPrice) {
		this.costPrice = costPrice;
	}

	public Integer getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}

	public String getAttributeName1() {
		return this.attributeName1;
	}

	public void setAttributeName1(String attributeName1) {
		this.attributeName1 = attributeName1;
	}

	public String getAttributeName2() {
		return this.attributeName2;
	}

	public void setAttributeName2(String attributeName2) {
		this.attributeName2 = attributeName2;
	}

	public Integer getUsedPoint() {
		return this.usedPoint;
	}

	public void setUsedPoint(Integer usedPoint) {
		this.usedPoint = usedPoint;
	}

	public int getDue() {
		return this.unitPrice.intValue() * this.qty.intValue();
	}

	public Integer getTotalFee() {
		return this.totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public Long getShipperOrderId() {
		return this.shipperOrderId;
	}

	public void setShipperOrderId(Long shipperOrderId) {
		this.shipperOrderId = shipperOrderId;
	}
}
package com.gewara.mall.vo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class MallOrderItemVo extends BaseVo {
	/**
	 * 订单类目
	 */
	private static final long serialVersionUID = -456661946584735116L;

	private Long id;								//id
	private Long shipperOrderId;						//发货商订单ID
	private Long mallOrderId;						//订单id
	private Long productId;							//商品id
	private Integer qty;							//购买数量
	private Integer unitPrice;						//单价
	private Integer totalFee;						//总价（unitPrice*qty）
	private Integer costPrice;						//结算价
	private Integer totalCost;						//订单成本总金额
	private Integer usedPoint;						//使用的积分数量
	private Long skuId;								//商品sku id
	private String attributeName1;					
	private String attributeName2;
	public MallOrderItemVo() {
	}
	
	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Long getMallOrderId() {
		return mallOrderId;
	}

	public void setMallOrderId(Long mallOrderId) {
		this.mallOrderId = mallOrderId;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Serializable realId() {
		return id;
	}

	public Integer getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Integer costPrice) {
		this.costPrice = costPrice;
	}

	public Integer getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}
	public String getAttributeName1() {
		return attributeName1;
	}
	public void setAttributeName1(String attributeName1) {
		this.attributeName1 = attributeName1;
	}
	public String getAttributeName2() {
		return attributeName2;
	}
	public void setAttributeName2(String attributeName2) {
		this.attributeName2 = attributeName2;
	}
	public Integer getUsedPoint() {
		return usedPoint;
	}
	public void setUsedPoint(Integer usedPoint) {
		this.usedPoint = usedPoint;
	}
	public int getDue(){
		return unitPrice*qty;
	}
	
	public Integer getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}
	public Long getShipperOrderId() {
		return shipperOrderId;
	}
	public void setShipperOrderId(Long shipperOrderId) {
		this.shipperOrderId = shipperOrderId;
	}
	
}

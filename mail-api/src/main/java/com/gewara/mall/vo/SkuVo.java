package com.gewara.mall.vo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class SkuVo extends BaseVo{
	private static final long serialVersionUID = 8217681262266417529L;
	private Long id;
	private Integer version;						//更新版本
	private Long productId;							//商品id
	private Integer unitPrice;						//单价
	private Integer costPrice;						//成本价
	private Integer stock;							//库存
	private Integer sold;							//已售库存
	private String status;							//SKU状态
	private String otherInfo;						//其他信息json格式
	private Integer retainage;						//预售的尾款
	private Integer point;							//积分
	private Integer pointPrice;						//积分换算价格
	public SkuVo(){
		
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(Integer costPrice) {
		this.costPrice = costPrice;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getSold() {
		return sold;
	}
	public void setSold(Integer sold) {
		this.sold = sold;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
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
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getRetainage() {
		return retainage;
	}
	public void setRetainage(Integer retainage) {
		this.retainage = retainage;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public Integer getPointPrice() {
		return pointPrice;
	}
	public void setPointPrice(Integer pointPrice) {
		this.pointPrice = pointPrice;
	}
	
}

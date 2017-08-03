package com.gewara.mall.vo;


import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class OrderProductVo extends BaseVo{
	/**
	 * 
	 */
	private static final long serialVersionUID = -465385215940781768L;
	
	private ProductVo product;
	private MallOrderItemVo orderItem;
	private SkuVo sku;
	private SkuSpecificationVo skuSpecification;
	private VendorVo vendor;
	public OrderProductVo(VendorVo vendor, ProductVo product, MallOrderItemVo orderItem, SkuSpecificationVo skuSpecification,SkuVo sku){
		this.product = product;
		this.orderItem = orderItem;
		this.skuSpecification = skuSpecification;
		this.vendor = vendor;
		this.sku = sku;
	}
	public ProductVo getProduct() {
		return product;
	}
	public void setProduct(ProductVo product) {
		this.product = product;
	}
	public MallOrderItemVo getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(MallOrderItemVo orderItem) {
		this.orderItem = orderItem;
	}
	public SkuVo getSku() {
		return sku;
	}
	public void setSku(SkuVo sku) {
		this.sku = sku;
	}
	public SkuSpecificationVo getSkuSpecification() {
		return skuSpecification;
	}
	public void setSkuSpecification(SkuSpecificationVo skuSpecification) {
		this.skuSpecification = skuSpecification;
	}
	public VendorVo getVendor() {
		return vendor;
	}
	public void setVendor(VendorVo vendor) {
		this.vendor = vendor;
	}
	@Override
	public Serializable realId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}

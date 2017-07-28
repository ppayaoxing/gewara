/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mall.vo;

import com.gewara.api.vo.BaseVo;
import com.gewara.mall.vo.MallOrderItemVo;
import com.gewara.mall.vo.ProductVo;
import com.gewara.mall.vo.SkuSpecificationVo;
import com.gewara.mall.vo.SkuVo;
import com.gewara.mall.vo.VendorVo;
import java.io.Serializable;

public class OrderProductVo extends BaseVo {
	private static final long serialVersionUID = -465385215940781768L;
	private ProductVo product;
	private MallOrderItemVo orderItem;
	private SkuVo sku;
	private SkuSpecificationVo skuSpecification;
	private VendorVo vendor;

	public OrderProductVo(VendorVo vendor, ProductVo product, MallOrderItemVo orderItem,
			SkuSpecificationVo skuSpecification, SkuVo sku) {
		this.product = product;
		this.orderItem = orderItem;
		this.skuSpecification = skuSpecification;
		this.vendor = vendor;
		this.sku = sku;
	}

	public ProductVo getProduct() {
		return this.product;
	}

	public void setProduct(ProductVo product) {
		this.product = product;
	}

	public MallOrderItemVo getOrderItem() {
		return this.orderItem;
	}

	public void setOrderItem(MallOrderItemVo orderItem) {
		this.orderItem = orderItem;
	}

	public SkuVo getSku() {
		return this.sku;
	}

	public void setSku(SkuVo sku) {
		this.sku = sku;
	}

	public SkuSpecificationVo getSkuSpecification() {
		return this.skuSpecification;
	}

	public void setSkuSpecification(SkuSpecificationVo skuSpecification) {
		this.skuSpecification = skuSpecification;
	}

	public VendorVo getVendor() {
		return this.vendor;
	}

	public void setVendor(VendorVo vendor) {
		this.vendor = vendor;
	}

	public Serializable realId() {
		return null;
	}
}
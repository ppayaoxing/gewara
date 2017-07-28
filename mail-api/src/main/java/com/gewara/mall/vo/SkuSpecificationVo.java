/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mall.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class SkuSpecificationVo extends BaseVo {
	private static final long serialVersionUID = 7964278333868311752L;
	private Long id;
	private Long productId;
	private Long skuId;
	private String skey;
	private Long attributeId1;
	private Long attributeValueId1;
	private Long attributeId2;
	private Long attributeValueId2;

	public Long getSkuId() {
		return this.skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Long getAttributeId1() {
		return this.attributeId1;
	}

	public void setAttributeId1(Long attributeId1) {
		this.attributeId1 = attributeId1;
	}

	public Long getAttributeValueId1() {
		return this.attributeValueId1;
	}

	public void setAttributeValueId1(Long attributeValueId1) {
		this.attributeValueId1 = attributeValueId1;
	}

	public Long getAttributeId2() {
		return this.attributeId2;
	}

	public void setAttributeId2(Long attributeId2) {
		this.attributeId2 = attributeId2;
	}

	public Long getAttributeValueId2() {
		return this.attributeValueId2;
	}

	public void setAttributeValueId2(Long attributeValueId2) {
		this.attributeValueId2 = attributeValueId2;
	}

	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getSkey() {
		return this.skey;
	}

	public void setSkey(String skey) {
		this.skey = skey;
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
}
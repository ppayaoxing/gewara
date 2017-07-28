/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.res.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class SpDiscountVo extends BaseVo {
	private static final long serialVersionUID = 1706595364713204120L;
	private Long id;
	private String title;
	private String description;
	private Integer isenable;
	private String validUrl;
	private Integer needBindMobile;
	private Long usedDiscountId;
	private String cancelable;
	private String paymethod;
	private Integer needSpcode;
	private Integer discount;
	private String discountType;
	private String otherinfo;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getIsenable() {
		return this.isenable;
	}

	public void setIsenable(Integer isenable) {
		this.isenable = isenable;
	}

	public String getValidUrl() {
		return this.validUrl;
	}

	public void setValidUrl(String validUrl) {
		this.validUrl = validUrl;
	}

	public Integer getNeedBindMobile() {
		return this.needBindMobile;
	}

	public void setNeedBindMobile(Integer needBindMobile) {
		this.needBindMobile = needBindMobile;
	}

	public Long getUsedDiscountId() {
		return this.usedDiscountId;
	}

	public void setUsedDiscountId(Long usedDiscountId) {
		this.usedDiscountId = usedDiscountId;
	}

	public String getCancelable() {
		return this.cancelable;
	}

	public void setCancelable(String cancelable) {
		this.cancelable = cancelable;
	}

	public String getPaymethod() {
		return this.paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public Integer getNeedSpcode() {
		return this.needSpcode;
	}

	public void setNeedSpcode(Integer needSpcode) {
		this.needSpcode = needSpcode;
	}

	public Integer getDiscount() {
		return this.discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public String getDiscountType() {
		return this.discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
}
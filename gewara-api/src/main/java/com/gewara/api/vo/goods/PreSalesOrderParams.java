/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.goods;

import java.io.Serializable;

public class PreSalesOrderParams implements Serializable {
	private static final long serialVersionUID = 3648019464644364816L;
	private Long goodsid;
	private Long memberid;
	private Long addressId;
	private String category;
	private String partnerkey;
	private String realname;
	private String address;
	private String remark;
	private String mobile;
	private String origin;
	private Integer quantity;
	private String citycode;
	private String sharecode;
	private String takemethod;

	public Long getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Long getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPartnerkey() {
		return this.partnerkey;
	}

	public void setPartnerkey(String partnerkey) {
		this.partnerkey = partnerkey;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getSharecode() {
		return this.sharecode;
	}

	public void setSharecode(String sharecode) {
		this.sharecode = sharecode;
	}

	public String getTakemethod() {
		return this.takemethod;
	}

	public void setTakemethod(String takemethod) {
		this.takemethod = takemethod;
	}
}
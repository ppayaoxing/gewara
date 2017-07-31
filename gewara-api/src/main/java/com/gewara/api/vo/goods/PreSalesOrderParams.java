package com.gewara.api.vo.goods;

import java.io.Serializable;


/**
 * 预售下单 参数Bean，封装多个参数
 * @author zhoufy
 */
public class PreSalesOrderParams implements Serializable{

	private static final long serialVersionUID = 3648019464644364816L;
	
	private Long goodsid;
	private Long memberid;
	private Long addressId;   //地址id，member_usefuladdress中的主键id
	private String category;  //预售物品分类，如衍生品有多个类别
	private String partnerkey;
	private String realname;
	private String address;
	private String remark;
	private String mobile;
	private String origin;
	private Integer quantity;
	private String citycode;
	private String sharecode;		//用户分享码，拼团分享用
	private String takemethod;		//（演出-电子票N  纸质票Y C手机电子票）
	
	public Long getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}
	public Long getMemberid() {
		return memberid;
	}
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPartnerkey() {
		return partnerkey;
	}
	public void setPartnerkey(String partnerkey) {
		this.partnerkey = partnerkey;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getSharecode() {
		return sharecode;
	}
	public void setSharecode(String sharecode) {
		this.sharecode = sharecode;
	}
	public String getTakemethod() {
		return takemethod;
	}
	public void setTakemethod(String takemethod) {
		this.takemethod = takemethod;
	}
	
}

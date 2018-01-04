package com.gewara.api.partner.res.vo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class SpDiscountVo extends BaseVo{
	private static final long serialVersionUID = 1706595364713204120L;
	private Long id;
	private String title;				
	private String description;
	private Integer isenable;			//不支持此场次活动  1支持  0不支持
	private String validUrl;			//验证url 例如输入卡号
	private Integer needBindMobile;		//需要绑定手机号
	private Long usedDiscountId;		//已经使用参生的折扣id
	private String cancelable;			//是否能取消
	private String paymethod;			//支付方式
	private Integer needSpcode;			//是否需要特价活动码
	private Integer discount;           
	private String discountType;
	private String otherinfo;
	public SpDiscountVo(){
		
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getIsenable() {
		return isenable;
	}
	public void setIsenable(Integer isenable) {
		this.isenable = isenable;
	}
	public String getValidUrl() {
		return validUrl;
	}
	public void setValidUrl(String validUrl) {
		this.validUrl = validUrl;
	}
	public Integer getNeedBindMobile() {
		return needBindMobile;
	}
	public void setNeedBindMobile(Integer needBindMobile) {
		this.needBindMobile = needBindMobile;
	}
	public Long getUsedDiscountId() {
		return usedDiscountId;
	}
	public void setUsedDiscountId(Long usedDiscountId) {
		this.usedDiscountId = usedDiscountId;
	}
	public String getCancelable() {
		return cancelable;
	}
	public void setCancelable(String cancelable) {
		this.cancelable = cancelable;
	}
	public String getPaymethod() {
		return paymethod;
	}
	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}
	public Integer getNeedSpcode() {
		return needSpcode;
	}
	public void setNeedSpcode(Integer needSpcode) {
		this.needSpcode = needSpcode;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	
}

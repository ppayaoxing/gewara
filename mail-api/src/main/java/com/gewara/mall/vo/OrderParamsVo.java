package com.gewara.mall.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrderParamsVo implements Serializable {
	private static final long serialVersionUID = 4463096682044152182L;
	
	private Long productId;
	private Long skuId;
	private String productCode;
	private String status;
	private String tradeNo;
	private Timestamp startTime;
	private Timestamp endTime;
	private Long categoryId;
	private String mobile;
	private Long vendorId;
	private String downloadType;
	private Integer startPrice;
	private Integer endPrice;
	private Long partnerId;
	private String category;
	private String shStatus;
	private String errorMsg;
	
	
	public boolean isSubQry(){
		if(productId!=null || skuId!=null || category != null || vendorId != null){
			return true;
		}
		return false;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Long getVendorId() {
		return vendorId;
	}
	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}
	public String getDownloadType() {
		return downloadType;
	}
	public void setDownloadType(String downloadType) {
		this.downloadType = downloadType;
	}
	public Integer getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(Integer startPrice) {
		this.startPrice = startPrice;
	}
	public Integer getEndPrice() {
		return endPrice;
	}
	public void setEndPrice(Integer endPrice) {
		this.endPrice = endPrice;
	}
	public Long getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getSkuId() {
		return skuId;
	}
	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getShStatus() {
		return shStatus;
	}
	public void setShStatus(String shStatus) {
		this.shStatus = shStatus;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}

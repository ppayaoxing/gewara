package com.gewara.model.pay;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.model.BaseObject;

/**
 * @author sunder
 */
public class PayMerchant extends BaseObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9165412894541987043L;
	
	public static final String DEFAULT_Y = "Y";//
	public static final String DEFAULT_N = "N";//

	/**
	 * //主键
	 */
	private Long id;
	/**
	 * //支配配置ID
	 */
	private Long gatewayId;
	/**
	 * //商户号标识
	 */
	private String merchantCode;
	/**
	 * //城市
	 */
	private String cityCode;
	/**
	 * 	//收单行
	 */
	private String acquiringBank;
	/**
	 * //商户号说明
	 */
	private String description;
	/**
	 * 	//商户号状态：NO_USE：未启用；IN_USE：使用中；DESUETUDE：废弃；
	 */
	private String status;
	/**
	 * 	//同步时间
	 */
	private Timestamp updateTime;
	/**
	 * //是否默认
	 */
	private String isDefault;
	/**
	 * 	//修改时间
	 */
	private Timestamp modifyTime;
	/**
	 * 	//最后修改人
	 */
	private String modifyUser;
	
	public PayMerchant(){
		this.updateTime = new Timestamp(System.currentTimeMillis());
		this.isDefault = DEFAULT_N;
	}
	
	public PayMerchant(String modifyUser){
		this();
		this.modifyUser = modifyUser;
	}

	@Override
	public Serializable realId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public boolean isDefault(){
		return StringUtils.equals(PayMerchant.DEFAULT_Y, isDefault);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGatewayId() {
		return gatewayId;
	}

	public void setGatewayId(Long gatewayId) {
		this.gatewayId = gatewayId;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAcquiringBank() {
		return acquiringBank;
	}

	public void setAcquiringBank(String acquiringBank) {
		this.acquiringBank = acquiringBank;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public Timestamp getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

}

package com.gewara.api.pay.domain;

import java.util.List;

import com.gewara.api.pay.ApiObject;

public class Gateway extends ApiObject{

	private static final long serialVersionUID = -8456169610882556337L;
	
	private Long id ;
	private String gatewayCode;	//支付网关
	private String gatewayName;	//支付网关名称
	private String supportBank;	//是否支持银行
	private String gatewayType;	//类型：PLATFORM：支付平台；BANK：银行直连；CARD：卡支付
	private String status;		//状态：NO_USE：未启用；IN_USE：使用中；DESUETUDE：废弃；
	private String bankTypeKey;	//银行类型key，这里只放特殊的，形如{"C":"信用卡","KJ":"快捷信用卡支付"}
	private boolean supportRefund;//是否支持退款
	
	private List<Merchant> merchantList;
	
	private List<Bank> bankList;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGatewayCode() {
		return gatewayCode;
	}

	public void setGatewayCode(String gatewayCode) {
		this.gatewayCode = gatewayCode;
	}

	public String getGatewayName() {
		return gatewayName;
	}

	public void setGatewayName(String gatewayName) {
		this.gatewayName = gatewayName;
	}

	public String getSupportBank() {
		return supportBank;
	}

	public void setSupportBank(String supportBank) {
		this.supportBank = supportBank;
	}

	public String getGatewayType() {
		return gatewayType;
	}

	public void setGatewayType(String gatewayType) {
		this.gatewayType = gatewayType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBankTypeKey() {
		return bankTypeKey;
	}

	public void setBankTypeKey(String bankTypeKey) {
		this.bankTypeKey = bankTypeKey;
	}

	public List<Merchant> getMerchantList() {
		return merchantList;
	}

	public void setMerchantList(List<Merchant> merchantList) {
		this.merchantList = merchantList;
	}

	public List<Bank> getBankList() {
		return bankList;
	}

	public void setBankList(List<Bank> bankList) {
		this.bankList = bankList;
	}

	public boolean isSupportRefund() {
		return supportRefund;
	}

	public void setSupportRefund(boolean supportRefund) {
		this.supportRefund = supportRefund;
	}

}

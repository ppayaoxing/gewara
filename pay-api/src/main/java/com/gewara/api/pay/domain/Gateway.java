/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.domain;

import com.gewara.api.pay.ApiObject;
import com.gewara.api.pay.domain.Bank;
import com.gewara.api.pay.domain.Merchant;
import java.util.List;

public class Gateway extends ApiObject {
	private static final long serialVersionUID = -8456169610882556337L;
	private Long id;
	private String gatewayCode;
	private String gatewayName;
	private String supportBank;
	private String gatewayType;
	private String status;
	private String bankTypeKey;
	private boolean supportRefund;
	private List<Merchant> merchantList;
	private List<Bank> bankList;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGatewayCode() {
		return this.gatewayCode;
	}

	public void setGatewayCode(String gatewayCode) {
		this.gatewayCode = gatewayCode;
	}

	public String getGatewayName() {
		return this.gatewayName;
	}

	public void setGatewayName(String gatewayName) {
		this.gatewayName = gatewayName;
	}

	public String getSupportBank() {
		return this.supportBank;
	}

	public void setSupportBank(String supportBank) {
		this.supportBank = supportBank;
	}

	public String getGatewayType() {
		return this.gatewayType;
	}

	public void setGatewayType(String gatewayType) {
		this.gatewayType = gatewayType;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBankTypeKey() {
		return this.bankTypeKey;
	}

	public void setBankTypeKey(String bankTypeKey) {
		this.bankTypeKey = bankTypeKey;
	}

	public List<Merchant> getMerchantList() {
		return this.merchantList;
	}

	public void setMerchantList(List<Merchant> merchantList) {
		this.merchantList = merchantList;
	}

	public List<Bank> getBankList() {
		return this.bankList;
	}

	public void setBankList(List<Bank> bankList) {
		this.bankList = bankList;
	}

	public boolean isSupportRefund() {
		return this.supportRefund;
	}

	public void setSupportRefund(boolean supportRefund) {
		this.supportRefund = supportRefund;
	}
}
package com.gewara.api.pay.response;

import java.util.List;

import com.gewara.api.pay.ApiResponse;
import com.gewara.api.pay.domain.Merchant;

public class MerchantGetAllResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8718363001993407793L;
	

	private List<Merchant> merchantList;


	public List<Merchant> getMerchantList() {
		return merchantList;
	}


	public void setMerchantList(List<Merchant> merchantList) {
		this.merchantList = merchantList;
	}

}

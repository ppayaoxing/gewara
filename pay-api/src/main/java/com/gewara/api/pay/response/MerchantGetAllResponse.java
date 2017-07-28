/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.response;

import com.gewara.api.pay.ApiResponse;
import com.gewara.api.pay.domain.Merchant;
import java.util.List;

public class MerchantGetAllResponse extends ApiResponse {
	private static final long serialVersionUID = -8718363001993407793L;
	private List<Merchant> merchantList;

	public List<Merchant> getMerchantList() {
		return this.merchantList;
	}

	public void setMerchantList(List<Merchant> merchantList) {
		this.merchantList = merchantList;
	}
}
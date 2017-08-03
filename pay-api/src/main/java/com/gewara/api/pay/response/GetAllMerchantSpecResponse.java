package com.gewara.api.pay.response;

import java.util.List;

import com.gewara.api.pay.ApiResponse;
import com.gewara.api.pay.domain.MerchantSpec;

public class GetAllMerchantSpecResponse extends ApiResponse {
	
	private static final long serialVersionUID = -5263240139774930009L;
	
	private List<MerchantSpec> merchantSpecList;

	public List<MerchantSpec> getMerchantSpecList() {
		return merchantSpecList;
	}

	public void setMerchantSpecList(List<MerchantSpec> merchantSpecList) {
		this.merchantSpecList = merchantSpecList;
	}



}

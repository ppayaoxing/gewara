/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.response;

import com.gewara.api.pay.ApiResponse;
import com.gewara.api.pay.domain.MerchantSpec;

public class GetMerchantSpecResponse extends ApiResponse {
	private static final long serialVersionUID = -951447119689175283L;
	private MerchantSpec merchantSpec;

	public MerchantSpec getMerchantSpec() {
		return this.merchantSpec;
	}

	public void setMerchantSpec(MerchantSpec merchantSpec) {
		this.merchantSpec = merchantSpec;
	}
}
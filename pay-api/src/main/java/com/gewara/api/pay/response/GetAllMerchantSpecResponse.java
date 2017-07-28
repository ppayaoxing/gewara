/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.response;

import com.gewara.api.pay.ApiResponse;
import com.gewara.api.pay.domain.MerchantSpec;
import java.util.List;

public class GetAllMerchantSpecResponse extends ApiResponse {
	private static final long serialVersionUID = -5263240139774930009L;
	private List<MerchantSpec> merchantSpecList;

	public List<MerchantSpec> getMerchantSpecList() {
		return this.merchantSpecList;
	}

	public void setMerchantSpecList(List<MerchantSpec> merchantSpecList) {
		this.merchantSpecList = merchantSpecList;
	}
}
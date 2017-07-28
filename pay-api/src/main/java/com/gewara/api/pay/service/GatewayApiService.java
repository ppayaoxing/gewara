/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.service;

import com.gewara.api.pay.request.GatewayGetAllRequest;
import com.gewara.api.pay.request.GatewayGetRequest;
import com.gewara.api.pay.request.MerchantGetAllRequest;
import com.gewara.api.pay.response.GatewayGetAllResponse;
import com.gewara.api.pay.response.GatewayGetResponse;
import com.gewara.api.pay.response.MerchantGetAllResponse;
import com.gewara.api.vo.ResultCode;

public interface GatewayApiService {
	ResultCode<GatewayGetAllResponse> getAll(GatewayGetAllRequest arg0);

	ResultCode<GatewayGetResponse> get(GatewayGetRequest arg0);

	ResultCode<MerchantGetAllResponse> getAllMerchant(MerchantGetAllRequest arg0);
}
package com.gewara.api.pay.service;

import com.gewara.api.pay.request.GatewayGetAllRequest;
import com.gewara.api.pay.request.GatewayGetRequest;
import com.gewara.api.pay.request.MerchantGetAllRequest;
import com.gewara.api.pay.response.GatewayGetAllResponse;
import com.gewara.api.pay.response.GatewayGetResponse;
import com.gewara.api.pay.response.MerchantGetAllResponse;
import com.gewara.api.vo.ResultCode;

public interface GatewayApiService {

	/**
	 * 获取所有支付网关信息
	 * 
	 * @param request
	 * @return
	 *
	 * @author leo.li
	 * Modify Time Nov 19, 2013 6:33:36 PM
	 */
	ResultCode<GatewayGetAllResponse> getAll(GatewayGetAllRequest request);
	
	/**
	 * 根据网关id获取支付网关信息
	 * 
	 * @param request
	 * @return
	 *
	 * @author leo.li
	 * Modify Time Nov 19, 2013 6:33:54 PM
	 */
	ResultCode<GatewayGetResponse> get(GatewayGetRequest request);
	
	/**
	 * 获取所有商户信息
	 * 
	 * @param request
	 * @return
	 *
	 * @author leo.li
	 * Modify Time Nov 19, 2013 6:34:19 PM
	 */
	ResultCode<MerchantGetAllResponse> getAllMerchant(MerchantGetAllRequest request);
}

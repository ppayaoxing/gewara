package com.gewara.api.pay.service;

import com.gewara.api.pay.request.abc.PointPayRequest;
import com.gewara.api.pay.response.abc.PointPayResponse;
import com.gewara.api.vo.ResultCode;


/**
 * 农业银行认证支付，服务接口
 * @author dengyz
 *
 */
public interface AbcPointPayFastApiService {
	
	/**
	 * 积分消费
	 * @param request
	 * @return
	 */
	ResultCode<PointPayResponse> pointPay(PointPayRequest request);
}

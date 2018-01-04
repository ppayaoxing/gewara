package com.gewara.api.pay.service;

import com.gewara.api.pay.request.ActivationQueryRequest;
import com.gewara.api.pay.request.GetBindParamsRequest;
import com.gewara.api.pay.request.SendPayRequest;
import com.gewara.api.pay.request.SendSmsRequest;
import com.gewara.api.pay.response.ActivationQueryResponse;
import com.gewara.api.pay.response.GetBindParamsResponse;
import com.gewara.api.pay.response.SendPayResponse;
import com.gewara.api.pay.response.SendSmsResponse;
import com.gewara.api.vo.ResultCode;

/**
 * 银联认证支付2.0，服务接口
 * 
 * @author leo.li
 * Modify Time Nov 6, 2013 2:43:00 PM
 */
public interface UnionPayFastApiService {

	/**
	 * 银联认证支付2.0，发送短信验证码服务
	 * 
	 * @param request
	 * @return
	 *
	 * @author leo.li
	 * Modify Time Nov 6, 2013 2:42:24 PM
	 */
	ResultCode<SendSmsResponse> sendSms(SendSmsRequest request);
	
	/**
	 * 卡开通状态查询
	 * 
	 * @param request
	 * @return
	 *
	 * @author leo.li
	 * Modify Time Nov 6, 2013 3:26:55 PM
	 */
	ResultCode<ActivationQueryResponse> activationQuery(ActivationQueryRequest request);
	
	/**
	 * 获取卡激活参数
	 * 
	 * @param request
	 * @return
	 *
	 * @author leo.li
	 * Modify Time Nov 6, 2013 4:20:34 PM
	 */
	ResultCode<GetBindParamsResponse> getBindParams(GetBindParamsRequest request);
	
	/**
	 * 发送支付请求
	 * 
	 * @param request
	 * @return
	 *
	 * @author leo.li
	 * Modify Time Nov 6, 2013 4:20:57 PM
	 */
	ResultCode<SendPayResponse> sendPay(SendPayRequest request);
	
	
	
}

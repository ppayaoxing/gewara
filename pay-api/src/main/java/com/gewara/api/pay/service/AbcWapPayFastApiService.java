package com.gewara.api.pay.service;

import com.gewara.api.pay.request.abc.MoneyAndPointPayRequest;
import com.gewara.api.pay.request.abc.MoneyPayRequest;
import com.gewara.api.pay.request.abc.PointPayRequest;
import com.gewara.api.pay.request.abc.QueryPointRequest;
import com.gewara.api.pay.request.abc.SendSmsRequest;
import com.gewara.api.pay.response.abc.MoneyAndPointPayResponse;
import com.gewara.api.pay.response.abc.MoneyPayResponse;
import com.gewara.api.pay.response.abc.PointPayResponse;
import com.gewara.api.pay.response.abc.QueryPointResponse;
import com.gewara.api.pay.response.abc.SendSmsResponse;
import com.gewara.api.vo.ResultCode;


/**
 * 农业银行认证支付，服务接口
 * @author dengyz
 *
 */
public interface AbcWapPayFastApiService {

	/**
	 * 积分查询
	 * @param request
	 * @return
	 */
	ResultCode<QueryPointResponse> queryPoint(QueryPointRequest request);
	
	/**
	 * 积分消费
	 * @param request
	 * @return
	 */
	ResultCode<PointPayResponse> pointPay(PointPayRequest request);
	
	/**
	 * 支付发短信
	 * @param request
	 * @return
	 */
	ResultCode<SendSmsResponse> sendSms(SendSmsRequest request);
	
	/**
	 * 快捷消费
	 * @param request
	 * @return
	 */
	ResultCode<MoneyPayResponse> moneyPay(MoneyPayRequest request);
	
	/**
	 * 积分快捷支付
	 * 此接口是把积分支付+快捷支付两个接口合并为一
	 * 如果不需要同时调两个接口的，请调用pointPay或者moneyPay接口。
	 * @param params
	 * @return
	 */
	ResultCode<MoneyAndPointPayResponse> moneyAndPointPay(MoneyAndPointPayRequest request);
}

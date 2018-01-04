package com.gewara.api.pay.service;

import com.gewara.api.pay.request.GetPayOrderRequest;
import com.gewara.api.pay.request.GetPayRecordByTradeNoRequest;
import com.gewara.api.pay.request.GetPayRecordRequest;
import com.gewara.api.pay.request.GetPayRepeatTradeRequest;
import com.gewara.api.pay.response.GetPayOrderResponse;
import com.gewara.api.pay.response.GetPayRecordResponse;
import com.gewara.api.pay.response.GetPayRepeatTradeResponse;
import com.gewara.api.vo.ResultCode;

public interface PayOrderApiService {

	/**
	 * 通过tradeNo获取支付订单信息
	 * @param request
	 * @return
	 */
	ResultCode<GetPayOrderResponse> get(GetPayOrderRequest request);
	
	/**
	 * 通过tradeNo获取银行流水信息信息
	 * @param request
	 * @return
	 */
	ResultCode<GetPayRecordResponse> getPayRecordByTradeNo(GetPayRecordByTradeNoRequest request);
	
	/**
	 * 获取一段时间内的，重复订单对应的PayRecord
	 * @return
	 */
	ResultCode<GetPayRecordResponse> getPayRecord(GetPayRecordRequest request);
	
	/**
	 * 获取一段时间内，重复支付银行流水信息
	 * 注意：1、开始时间与结束区间最大不能超过10天； 2、list结果记录数最大为1000，总记录数记录在total中
	 * @param request
	 * @return
	 */
	ResultCode<GetPayRepeatTradeResponse> getPayRepeatTrade(GetPayRepeatTradeRequest request);
	
	/**
	 * 获取一段时间内,指定gatewayCode和merchantCode对应的银行流水信息信息
	 * @return
	 */
	ResultCode<GetPayRecordResponse> queryPayRecord(GetPayRecordRequest request);
}

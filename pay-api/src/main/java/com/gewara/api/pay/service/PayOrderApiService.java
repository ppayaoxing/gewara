/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
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
	ResultCode<GetPayOrderResponse> get(GetPayOrderRequest arg0);

	ResultCode<GetPayRecordResponse> getPayRecordByTradeNo(GetPayRecordByTradeNoRequest arg0);

	ResultCode<GetPayRecordResponse> getPayRecord(GetPayRecordRequest arg0);

	ResultCode<GetPayRepeatTradeResponse> getPayRepeatTrade(GetPayRepeatTradeRequest arg0);

	ResultCode<GetPayRecordResponse> queryPayRecord(GetPayRecordRequest arg0);
}
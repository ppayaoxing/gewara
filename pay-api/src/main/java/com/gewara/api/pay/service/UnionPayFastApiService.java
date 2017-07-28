/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
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

public interface UnionPayFastApiService {
	ResultCode<SendSmsResponse> sendSms(SendSmsRequest arg0);

	ResultCode<ActivationQueryResponse> activationQuery(ActivationQueryRequest arg0);

	ResultCode<GetBindParamsResponse> getBindParams(GetBindParamsRequest arg0);

	ResultCode<SendPayResponse> sendPay(SendPayRequest arg0);
}
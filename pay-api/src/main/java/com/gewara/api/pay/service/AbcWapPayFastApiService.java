/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
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

public interface AbcWapPayFastApiService {
	ResultCode<QueryPointResponse> queryPoint(QueryPointRequest arg0);

	ResultCode<PointPayResponse> pointPay(PointPayRequest arg0);

	ResultCode<SendSmsResponse> sendSms(SendSmsRequest arg0);

	ResultCode<MoneyPayResponse> moneyPay(MoneyPayRequest arg0);

	ResultCode<MoneyAndPointPayResponse> moneyAndPointPay(MoneyAndPointPayRequest arg0);
}
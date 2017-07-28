/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.service;

import com.gewara.api.pay.request.abc.PointPayRequest;
import com.gewara.api.pay.response.abc.PointPayResponse;
import com.gewara.api.vo.ResultCode;

public interface AbcPointPayFastApiService {
	ResultCode<PointPayResponse> pointPay(PointPayRequest arg0);
}
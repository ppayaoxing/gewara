/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sms.service;

import com.gewara.api.sms.request.MTRequest;
import com.gewara.api.sms.response.BatchSmsStatusResponse;
import com.gewara.api.sms.response.MTResponse;
import com.gewara.api.vo.ResultCode;
import java.util.List;
import java.util.Map;

public interface SmsService {

	@Deprecated
	MTResponse sendSMS(MTRequest arg0);

	ResultCode sendSMS2(MTRequest arg0);

	@Deprecated
	BatchSmsStatusResponse queryBatchSmsStatus(String arg0);

	ResultCode<BatchSmsStatusResponse> queryBatchSmsStatus2(String arg0);

	ResultCode<Map<String, String>> findYesterdayStatus4Shanghai(List<String> arg0);
}
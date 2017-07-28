/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.service;

import com.gewara.api.partner.req.vo.PartnerCommonReqVo;
import com.gewara.api.vo.ResultCode;
import java.util.Map;

public interface PartnerSpdcccPayVoService {
	ResultCode<String> sendSms(PartnerCommonReqVo arg0);

	ResultCode toSpdcccPay(PartnerCommonReqVo arg0);

	ResultCode<String> sendAbcWapPayFastSms(PartnerCommonReqVo arg0);

	ResultCode toAbcWapPayFast(PartnerCommonReqVo arg0);

	ResultCode<Map<String, String>> getAbcPostPointConfig(PartnerCommonReqVo arg0);

	ResultCode<String> toAbcPointPayFast(PartnerCommonReqVo arg0);

	ResultCode<Map<String, String>> queryPoint(PartnerCommonReqVo arg0);
}
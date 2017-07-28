/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.service;

import com.gewara.api.partner.req.vo.PartnerCommonReqVo;
import com.gewara.api.vo.ResultCode;

public interface PartnerWandaVoService {
	ResultCode<String> getSeatInfo2(PartnerCommonReqVo arg0);

	ResultCode<String> createOrder2(PartnerCommonReqVo arg0);

	ResultCode<String> getSdRemark(PartnerCommonReqVo arg0);
}
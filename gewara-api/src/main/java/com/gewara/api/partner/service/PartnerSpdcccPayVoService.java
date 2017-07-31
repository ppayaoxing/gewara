package com.gewara.api.partner.service;

import java.util.Map;

import com.gewara.api.partner.req.vo.PartnerCommonReqVo;
import com.gewara.api.vo.ResultCode;

public interface PartnerSpdcccPayVoService {
	ResultCode<String> sendSms(PartnerCommonReqVo reqVo);
	ResultCode toSpdcccPay(PartnerCommonReqVo reqVo);
	
	
	
	/**
	 * Å©ÐÐÖ§¸¶
	 */
	ResultCode<String> sendAbcWapPayFastSms(PartnerCommonReqVo reqVo);
	ResultCode toAbcWapPayFast(PartnerCommonReqVo reqVo);
	
	ResultCode<Map<String, String>> getAbcPostPointConfig(PartnerCommonReqVo reqVo);
	
	
	ResultCode<String> toAbcPointPayFast(PartnerCommonReqVo reqVo);
	
	ResultCode<Map<String, String>> queryPoint(PartnerCommonReqVo reqVo);
}

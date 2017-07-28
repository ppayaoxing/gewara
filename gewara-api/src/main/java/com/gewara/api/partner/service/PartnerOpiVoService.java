/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.service;

import com.gewara.api.partner.req.vo.PartnerCommonReqVo;
import com.gewara.api.partner.res.vo.OpiSeatVo;
import com.gewara.api.vo.ResultCode;
import java.util.Map;

public interface PartnerOpiVoService {
	ResultCode<OpiSeatVo> getOpiCacheSeat(PartnerCommonReqVo arg0);

	ResultCode<OpiSeatVo> getOpiSeat(PartnerCommonReqVo arg0);

	ResultCode<Map<String, String>> getCachedRemoteLockSeat(Long arg0, String arg1);
}
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.dubbo.partner;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.partner.req.PartnerCommonReqVo;
import com.gewara.drama.vo.partner.res.OdiTheatreSeatExtraVo;

public interface PartnerDpiVoService {
	ResultCode<OdiTheatreSeatExtraVo> getCacheSeatByTheatreSeatArea(PartnerCommonReqVo arg0);

	ResultCode<OdiTheatreSeatExtraVo> getOpenTheatreSeatByTheatreSeatArea(PartnerCommonReqVo arg0);
}
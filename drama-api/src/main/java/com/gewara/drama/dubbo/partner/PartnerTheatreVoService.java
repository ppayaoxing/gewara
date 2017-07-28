/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.dubbo.partner;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreVo;
import com.gewara.drama.vo.partner.req.PartnerCommonReqVo;
import com.gewara.drama.vo.partner.req.PartnerTheatreReqVo;
import java.util.List;

public interface PartnerTheatreVoService {
	ResultCode<TheatreVo> getCurTheatreVo(PartnerCommonReqVo arg0);

	ResultCode<List<TheatreVo>> getBookingTheatreList(PartnerTheatreReqVo arg0);
}
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.service;

import com.gewara.api.partner.req.vo.PartnerAddOrderReqVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.order.GewaOrderVo;

public interface BaoChangOrderVoService {
	ResultCode<GewaOrderVo> addBaoChangTicketOrder(PartnerAddOrderReqVo arg0);

	ResultCode<GewaOrderVo> addBaoChangTicketOrder4Remain(Long arg0, String arg1, String arg2, String arg3);
}
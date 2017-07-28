/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.service.mall;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.order.GewaOrderVo;

public interface PartnerMallVoService {
	ResultCode<GewaOrderVo> useSpecialDiscount(String arg0, String arg1, String arg2, Long arg3);
}
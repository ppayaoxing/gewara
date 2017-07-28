/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.service;

import com.gewara.api.vo.ResultCode;

public interface PartnerPsbcappVoService {
	ResultCode<Boolean> validPsbcappOrder(String arg0, Integer arg1);
}
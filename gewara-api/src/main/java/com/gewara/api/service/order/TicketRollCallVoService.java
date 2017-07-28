/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.order;

import com.gewara.api.vo.ResultCode;

public interface TicketRollCallVoService {
	ResultCode<Boolean> isTicketRollCallMember(Long arg0, String arg1);
}
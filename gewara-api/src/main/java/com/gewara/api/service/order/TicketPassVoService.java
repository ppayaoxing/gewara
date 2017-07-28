/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.order;

import com.gewara.api.vo.ResultCode;

public interface TicketPassVoService {
	ResultCode<String> getCheckpassTemplate(String arg0);
}
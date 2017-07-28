/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gpticket.service;

import com.gewara.api.gpticket.vo.command.ReserveVo;
import com.gewara.api.vo.ResultCode;
import java.util.List;
import java.util.Map;

public interface GpticketExtraApiService {
	ResultCode<List> syncFailOrderUuid();

	ResultCode<Boolean> removeFailOrderUuid();

	ResultCode notifyReserve(ReserveVo arg0);

	ResultCode<Map> checkTicket(String arg0);

	ResultCode<Map> queryQueueNums(String arg0, String arg1);
}
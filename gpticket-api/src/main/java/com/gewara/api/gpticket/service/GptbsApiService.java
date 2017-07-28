/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gpticket.service;

import com.gewara.api.vo.ResultCode;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface GptbsApiService {
	ResultCode<Map> getOrderPrintInfo2(String arg0);

	ResultCode<List<Map>> getOrderPrintInfo(Timestamp arg0, Timestamp arg1);

	ResultCode<String> getTicketFaceExp(String arg0);

	ResultCode<List<Map>> getStadiumListByUpdate(Timestamp arg0);

	ResultCode updateTakeTicketStatus(String arg0);
}
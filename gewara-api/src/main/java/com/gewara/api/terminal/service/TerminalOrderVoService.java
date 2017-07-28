/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.terminal.service;

import com.gewara.api.terminal.vo.CustomPaperVo;
import com.gewara.api.terminal.vo.DpiLayoutVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.order.GewaOrderVo;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TerminalOrderVoService {
	ResultCode<GewaOrderVo> getTicketOrderByTradeno(String arg0);

	ResultCode<GewaOrderVo> getGoodsOrderByTradeno(String arg0);

	ResultCode<List<GewaOrderVo>> getDramaOrderByTradeno(String arg0);

	ResultCode<List<String>> getRefundOrderList(Timestamp arg0);

	ResultCode<List<Map>> getPeakPeriodByTag(Long arg0, Timestamp arg1, Timestamp arg2, String arg3);

	ResultCode<DpiLayoutVo> getDpiLayoutVo(Long arg0);

	ResultCode<String> getDramaOrderPrintInfo(String arg0);

	ResultCode<List<CustomPaperVo>> customPaperVoList(String arg0, Date arg1, Date arg2);

	ResultCode<List<String>> getSuccessTradenoList(Timestamp arg0);

	ResultCode<CustomPaperVo> getCustomPaperVoByTradeNo(String arg0);

	ResultCode<List<String>> getSuccessTradenoList(Timestamp arg0, Timestamp arg1);
}
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.terminal.service;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.order.GewaOrderVo;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface TerminalFilmVoService {
	ResultCode<Map<String, Object>> getMpiLayoutVoByMpid(Long arg0);

	ResultCode<String> getMpiLayoutVo(Long arg0);

	ResultCode<List<String>> getSuccessFilmOrderList(Long arg0, Timestamp arg1, Timestamp arg2);

	ResultCode<List<String>> getMovieSuccessTradenoList(Long arg0, Timestamp arg1);

	ResultCode<GewaOrderVo> getTicketOrderByTradeno(String arg0);
}
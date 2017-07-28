/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.movie;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.movie.TakeInfoVo;
import com.gewara.api.vo.order.GewaOrderVo;
import java.sql.Timestamp;
import java.util.List;

public interface TicketOrderVoService {
	ResultCode<List<GewaOrderVo>> getTicketOrderListByMpid(Long arg0, Timestamp arg1, Timestamp arg2, String arg3,
			String arg4);

	@Deprecated
	ResultCode<GewaOrderVo> getTicketOrderByTradeno(String arg0);

	ResultCode<List<TakeInfoVo>> getTakeInfoList(String arg0);
}
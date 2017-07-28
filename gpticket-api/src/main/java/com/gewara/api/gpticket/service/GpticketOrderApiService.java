/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gpticket.service;

import com.gewara.api.gpticket.vo.command.OrderCommandVo;
import com.gewara.api.gpticket.vo.command.OrderIdVo;
import com.gewara.api.gpticket.vo.ticket.DramaRemoteOrderVo;
import com.gewara.api.vo.ResultCode;

public interface GpticketOrderApiService {
	ResultCode<String> getLockSeat(String arg0);

	ResultCode<String> getLockSeatByUsertype(String arg0, String arg1);

	ResultCode<String> getUnLockPrice(String arg0);

	ResultCode<String> getUnLockPriceByUsertype(String arg0, String arg1);

	ResultCode<DramaRemoteOrderVo> createOrder(OrderCommandVo arg0);

	ResultCode<DramaRemoteOrderVo> lockPrice(OrderCommandVo arg0);

	ResultCode<DramaRemoteOrderVo> lockSeat(OrderCommandVo arg0);

	ResultCode<DramaRemoteOrderVo> fixOrder(OrderCommandVo arg0);

	ResultCode<DramaRemoteOrderVo> unLockOrder(OrderIdVo arg0);

	ResultCode<DramaRemoteOrderVo> backOrder(OrderIdVo arg0);

	ResultCode<DramaRemoteOrderVo> qryOrder(OrderIdVo arg0);

	ResultCode<DramaRemoteOrderVo> checkOrder(OrderIdVo arg0);

	ResultCode<String> qryTicketFace(String arg0);

	ResultCode<String> qryOrderInfo(OrderIdVo arg0);

	ResultCode updateOrderGreetings(OrderIdVo arg0);
}
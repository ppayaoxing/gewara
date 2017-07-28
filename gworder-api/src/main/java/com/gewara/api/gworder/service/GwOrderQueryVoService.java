/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gworder.service;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.order.GewaOrderVo;
import java.sql.Timestamp;
import java.util.List;

public interface GwOrderQueryVoService {
	ResultCode<List<GewaOrderVo>> getMallPostOrderListByMemberId(Long arg0, Timestamp arg1, Timestamp arg2, int arg3,
			int arg4);

	ResultCode<List<GewaOrderVo>> getMallOrderListByMemberId(Long arg0, Timestamp arg1, Timestamp arg2);

	ResultCode<List<GewaOrderVo>> getOrderScheduleList(Long arg0, int arg1, int arg2);

	ResultCode<List<GewaOrderVo>> getCurrentTicketOrderByMemberId(Long arg0, int arg1, int arg2);

	ResultCode<List<GewaOrderVo>> getCurrentGoodsOrderList(Long arg0, List<Long> arg1, Timestamp arg2);

	ResultCode<List<GewaOrderVo>> getCurrentGoodsOrderByMemberId(Long arg0, int arg1, int arg2);

	ResultCode<List<GewaOrderVo>> getCurrentBaoChangOrderByMemberId(Long arg0, int arg1, int arg2);

	ResultCode<List<GewaOrderVo>> getOrderListByPartnerId(Long arg0, Long arg1, Timestamp arg2, Integer arg3,
			Integer arg4);

	ResultCode<List<GewaOrderVo>> getCurrentTicketOrderByMemberId(Long arg0, Timestamp arg1);

	ResultCode<List<GewaOrderVo>> getNewGewaOrderListToMovieApp(Long arg0);

	ResultCode<List<GewaOrderVo>> getOrderListByMemberId(Long arg0, boolean arg1, String arg2, int arg3, int arg4,
			int arg5);
}
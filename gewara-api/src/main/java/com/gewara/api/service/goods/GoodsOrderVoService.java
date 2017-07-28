/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.goods;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.goods.PreSalesOrderParams;
import com.gewara.api.vo.order.GewaOrderVo;
import java.sql.Timestamp;
import java.util.List;

public interface GoodsOrderVoService {
	ResultCode<GewaOrderVo> addActivityGoodsOrder(Long arg0, Long arg1, String arg2, String arg3, String arg4,
			String arg5, Integer arg6, String arg7);

	ResultCode<GewaOrderVo> addActivityGoodsOrderWithParnter(Long arg0, Long arg1, String arg2, String arg3,
			String arg4, String arg5, Integer arg6, String arg7, String arg8);

	ResultCode<GewaOrderVo> addPreGoodsOrder(PreSalesOrderParams arg0);

	ResultCode<GewaOrderVo> addPreGoodsOrderForWap(PreSalesOrderParams arg0);

	ResultCode<Integer> getPaidSuccessOrderCount(String arg0, Long arg1);

	ResultCode<List<GewaOrderVo>> getPaidSuccessAndReturnOrderList(String arg0, Long arg1, Timestamp arg2,
			Timestamp arg3);

	ResultCode cancelLastNotPaidGoodsOrder(Long arg0);

	ResultCode<GewaOrderVo> getGewaOrderByGoods(Long arg0, Long arg1);

	ResultCode<Integer> getGewaOrderCount(Long arg0, Long arg1, String arg2);

	@Deprecated
	ResultCode<GewaOrderVo> getGewaOrderByTradeNo(String arg0);

	ResultCode<List<GewaOrderVo>> getPaidSuccessOrderList(String arg0, Long arg1, Timestamp arg2, Timestamp arg3);

	ResultCode<List<GewaOrderVo>> getOrderList(List<Long> arg0, String arg1, String arg2, Integer arg3, Integer arg4);
}
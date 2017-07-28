/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.drama;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.cmd.order.OrderParamsVo;
import com.gewara.api.vo.order.BuyItemVo;
import com.gewara.api.vo.order.GewaOrderVo;
import com.gewara.api.vo.pay.OrderOtherVo;
import java.util.List;

public interface DramaOrderVoService {
	ResultCode<List<GewaOrderVo>> getDramaOrderVoList(OrderParamsVo arg0, int arg1, int arg2);

	ResultCode<List<BuyItemVo>> getItemList(Long arg0);

	@Deprecated
	ResultCode<GewaOrderVo> getDramaOrderVo(Long arg0);

	ResultCode<GewaOrderVo> getLastUnpaidDramaOrder(Long arg0, String arg1, Long arg2);

	ResultCode<List<String>> getDramaOrderSeatLabelList(Long arg0);

	ResultCode<OrderOtherVo> getDramaOrderOtherData(Long arg0);

	@Deprecated
	ResultCode checkPriorizite(Long arg0, Long arg1);

	ResultCode saveOrderPrintInfo(Long arg0, String arg1);

	ResultCode<Integer> saveOrderAddress(Long arg0, Long arg1);
}
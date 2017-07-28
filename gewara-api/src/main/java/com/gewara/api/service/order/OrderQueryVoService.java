/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.order;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;
import com.gewara.api.vo.cmd.order.OrderParamsVo;
import com.gewara.api.vo.cmd.order.ParamsVo;
import com.gewara.api.vo.cmd.order.SearchOrderCommandVo;
import com.gewara.api.vo.order.BuyItemVo;
import com.gewara.api.vo.order.GewaOrderMapVo;
import com.gewara.api.vo.order.GewaOrderVo;
import com.gewara.api.vo.pay.OrderAddressVo;
import com.gewara.api.vo.pay.OrderExtraVo;
import com.gewara.api.vo.pay.OrderNoteVo;
import java.sql.Timestamp;
import java.util.List;

public interface OrderQueryVoService {
	ResultCode<List<GewaOrderVo>> getTicketOrderList(ParamsVo arg0);

	ResultCode<List<GewaOrderVo>> searchTicketOrderList(SearchOrderCommandVo arg0);

	ResultCode<List<OrderAddressVo>> getOrderAddressVoList(List<String> arg0);

	ResultCode<List<BuyItemVo>> getItemList(Long arg0);

	ResultCode<List<OrderNoteVo>> getNoteList(Long arg0);

	ResultCode<Integer> getOrderCount(OrderParamsVo arg0);

	ResultCode<List<GewaOrderVo>> getOrderList(ParamsVo arg0);

	ResultCode<List<GewaOrderVo>> getCurFailureOrderList(ParamsVo arg0);

	ResultCode<GewaOrderVo> getGewaOrder(Long arg0);

	ResultCode<OrderAddressVo> getOrderAddressVo(String arg0);

	ResultCode<List<GewaOrderVo>> getGoodsOrderList(ParamsVo arg0);

	ResultCode<Integer> getGewaorderCountByMobile(ParamsVo arg0);

	ResultCode<Boolean> isTakeByTradeno(String arg0);

	ResultCode<GewaOrderVo> getGewaOrderByTradeNo(String arg0);

	ResultCode<GewaOrderMapVo> getGewaOrderMap(GewaOrderMapVo arg0);

	ResultCode<OrderExtraVo> getOrderExtraByTradeNo(String arg0);

	ResultCode<OrderNoteVo> getOrderNodeByTradeNo(String arg0);

	ResultCode<Integer> getOrderMemberHis(Long arg0);

	ResultCode<Integer> getOrderMemberHisWithType(Long arg0, String arg1);

	ResultCode<List<GewaOrderMapVo>> getGewaOrderMapList(List<GewaOrderVo> arg0);

	ResultCode<List<GewaOrderVo>> getHisOrderListByMemberid(ParamsVo arg0);

	ResultCode<List<GewaOrderVo>> getGewaOrderListByTradenoList(List<String> arg0);

	ResultCode<VoMap> getOpiMapByMpid(Long arg0, Timestamp arg1);
}
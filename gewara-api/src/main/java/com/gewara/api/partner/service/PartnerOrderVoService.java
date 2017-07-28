/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.service;

import com.gewara.api.partner.req.vo.PartnerAddOrderReqVo;
import com.gewara.api.partner.req.vo.PartnerCommonReqVo;
import com.gewara.api.partner.req.vo.PartnerOrderInfoReqVo;
import com.gewara.api.partner.req.vo.PartnerOrderQueryReqVo;
import com.gewara.api.partner.req.vo.PartnerOrderRefundInfoReqVo;
import com.gewara.api.partner.req.vo.PartnerSpCodeReqVo;
import com.gewara.api.partner.res.vo.OrderCardVo;
import com.gewara.api.partner.res.vo.OrderSpCodeVo;
import com.gewara.api.partner.res.vo.SpDiscountVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.order.BuyItemVo;
import com.gewara.api.vo.order.GewaOrderVo;
import com.gewara.api.vo.pay.OrderAddressVo;
import com.gewara.api.vo.pay.OrderExtraVo;
import com.gewara.api.vo.pay.OrderNoteVo;
import com.gewara.api.vo.pay.OrderRefundVo;
import com.gewara.api.vo.pay.PayMethodInfoVo;
import com.gewara.api.vo.pay.RouteVo;
import com.gewara.api.vo.pay.SelectPayMethodVo;
import java.util.List;
import java.util.Map;

public interface PartnerOrderVoService {
	ResultCode<GewaOrderVo> addTicketOrder(PartnerAddOrderReqVo arg0);

	ResultCode<GewaOrderVo> getOrderDetail(PartnerOrderInfoReqVo arg0);

	ResultCode<GewaOrderVo> getGewaOrder(PartnerOrderInfoReqVo arg0);

	ResultCode<Long> getValidTime(PartnerOrderInfoReqVo arg0);

	ResultCode<List<SpDiscountVo>> getDiscountList(PartnerOrderInfoReqVo arg0);

	ResultCode<PayMethodInfoVo> showPayMethodList(PartnerOrderInfoReqVo arg0);

	ResultCode<SelectPayMethodVo> selectPayMethod(PartnerOrderInfoReqVo arg0);

	ResultCode<String> getOrderTakeTicketMsg(PartnerOrderInfoReqVo arg0);

	ResultCode<String> getOrderStatus(PartnerOrderInfoReqVo arg0);

	ResultCode cancelOrder(PartnerOrderInfoReqVo arg0);

	ResultCode cancelOrderDiscount(PartnerOrderInfoReqVo arg0);

	ResultCode balancePay(PartnerOrderInfoReqVo arg0);

	ResultCode<List<OrderCardVo>> getCardListByTradeNo(PartnerOrderInfoReqVo arg0);

	ResultCode<OrderCardVo> useCard(PartnerOrderInfoReqVo arg0);

	ResultCode<Integer> confirmCardPay(PartnerOrderInfoReqVo arg0);

	ResultCode<List<GewaOrderVo>> getMemberOrderList(PartnerOrderQueryReqVo arg0);

	ResultCode<Map> useSpcode(PartnerOrderInfoReqVo arg0);

	ResultCode<List<OrderSpCodeVo>> getSpCodeVoList(PartnerSpCodeReqVo arg0);

	ResultCode unionWapFast(PartnerCommonReqVo arg0);

	ResultCode<GewaOrderVo> addPartnerUserTicketOrder(PartnerAddOrderReqVo arg0);

	ResultCode<List<BuyItemVo>> getItemList(PartnerOrderInfoReqVo arg0);

	ResultCode<OrderRefundVo> getOrderRefundByTradeNo(PartnerOrderInfoReqVo arg0);

	ResultCode confirmRefundOrder(PartnerOrderRefundInfoReqVo arg0);

	ResultCode checkRefundOrder(PartnerOrderInfoReqVo arg0);

	ResultCode filterRefundOrder(PartnerOrderInfoReqVo arg0);

	ResultCode<List<RouteVo>> getRouteVoByTradeNo(PartnerOrderInfoReqVo arg0);

	ResultCode<OrderExtraVo> getOrderExtraByTradeNo(PartnerOrderInfoReqVo arg0);

	ResultCode<OrderAddressVo> getOrderAddressVo(PartnerOrderInfoReqVo arg0);

	ResultCode<GewaOrderVo> useWeixinCard(PartnerOrderInfoReqVo arg0);

	ResultCode<List<OrderNoteVo>> getOrderNoteList(PartnerOrderInfoReqVo arg0);

	ResultCode<List<OrderSpCodeVo>> getSpCodeVoListByMemberId(PartnerSpCodeReqVo arg0);

	ResultCode<List<OrderSpCodeVo>> getUnoverdueSpCodeVoList(PartnerSpCodeReqVo arg0);

	ResultCode usePoint(String arg0, String arg1, int arg2, String arg3);

	ResultCode sendVoiceCode(String arg0, String arg1, String arg2, boolean arg3);

	ResultCode<List<SpDiscountVo>> getShareDiscountList(PartnerOrderInfoReqVo arg0);

	ResultCode<Map<String, String>> getRelatedData(GewaOrderVo arg0);

	ResultCode cancelBaoChangGewaOrder(PartnerOrderInfoReqVo arg0);

	ResultCode<List<GewaOrderVo>> getMemberOrderListNew(PartnerOrderQueryReqVo arg0);

	ResultCode<Map<String, String>> getWxFriendCardData(String arg0);

	ResultCode<GewaOrderVo> removeOrderForWap(PartnerOrderInfoReqVo arg0);

	ResultCode<String> getTicketPassMsg(PartnerOrderInfoReqVo arg0);

	ResultCode<Map<String, String>> getQQcardConsumeInfo(String arg0);

	ResultCode<String> saveQQcardConsumeInfo(String arg0, String arg1, String arg2);

	ResultCode<OrderCardVo> useFCard(PartnerOrderInfoReqVo arg0);
}
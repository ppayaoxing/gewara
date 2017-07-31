package com.gewara.api.partner.service;

import java.util.List;
import java.util.Map;

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

public interface PartnerOrderVoService {
	/**
	 * 创建电影订单
	 * 
	 * @param reqVo
	 * @return
	 */
	ResultCode<GewaOrderVo> addTicketOrder(PartnerAddOrderReqVo reqVo);
	/**
	 * 订单详情
	 * 
	 * @param appkey
	 * @param memberId
	 * @param tradeNo
	 * @return
	 */
	ResultCode<GewaOrderVo> getOrderDetail(PartnerOrderInfoReqVo reqVo);
	/**
	 * 获取订单详情
	 * @param reqVo
	 * @return
	 */
	ResultCode<GewaOrderVo> getGewaOrder(PartnerOrderInfoReqVo reqVo);
	/**
	 * 订单倒计时
	 * 
	 * @param appkey
	 * @param memberId
	 * @param tradeNo
	 * @return
	 */
	ResultCode<Long> getValidTime(PartnerOrderInfoReqVo reqVo);

	/**
	 * 根据订单号获取特价活动列表
	 * 
	 * @param appkey
	 * @param memberId
	 * @param tradeNo
	 * @return
	 */
	ResultCode<List<SpDiscountVo>> getDiscountList(PartnerOrderInfoReqVo reqVo);

	/**
	 * 订单的支付方式列表
	 * 
	 * @param appkey
	 * @param memberId
	 * @param tradeNo
	 * @return
	 */
	ResultCode<PayMethodInfoVo> showPayMethodList(PartnerOrderInfoReqVo reqVo);

	/**
	 * 根据支付方式获取提交参数信息
	 * 
	 * @param appkey
	 * @param memberId
	 * @param tradeNo
	 * @return
	 */
	ResultCode<SelectPayMethodVo> selectPayMethod(PartnerOrderInfoReqVo reqVo);
	/**
	 * 获取订单的取票短信
	 * @param reqVo
	 * @return
	 */
	ResultCode<String> getOrderTakeTicketMsg(PartnerOrderInfoReqVo reqVo);
	/**
	 * 获取订单的状态
	 * @param reqVo
	 * @return
	 */
	ResultCode<String> getOrderStatus(PartnerOrderInfoReqVo reqVo);
	/**
	 * 用户取消订单
	 * @param reqVo
	 * @return
	 */
	ResultCode cancelOrder(PartnerOrderInfoReqVo reqVo);
	/**
	 * 用户取消使用优惠
	 * @param vo
	 * @return
	 */
	ResultCode cancelOrderDiscount(PartnerOrderInfoReqVo reqVo);
	/**
	 * 用户余额支付
	 * @param reqVo
	 * @return
	 */
	ResultCode balancePay(PartnerOrderInfoReqVo reqVo);
	/**
	 * 获取订单可以使用的兑换券
	 * @param vo
	 * @return
	 */
	ResultCode<List<OrderCardVo>> getCardListByTradeNo(PartnerOrderInfoReqVo reqVo);
	/**
	 * 使用券或码
	 * @param reqVo
	 * @return
	 */
	ResultCode<OrderCardVo> useCard(PartnerOrderInfoReqVo reqVo);
	/**
	 * 券确认支付
	 * @param reqVo
	 * @return
	 */
	ResultCode<Integer> confirmCardPay(PartnerOrderInfoReqVo reqVo);
	/**
	 * 获取用户订单信息列表
	 * @param reqVo
	 * @return
	 */
	ResultCode<List<GewaOrderVo>> getMemberOrderList(PartnerOrderQueryReqVo reqVo);
	/**
	 * 使用特价活动码
	 * @param reqVo
	 * @return
	 */
	ResultCode<Map> useSpcode(PartnerOrderInfoReqVo reqVo);
	/**
	 * 获取特价活动码列表
	 * @param reqVo
	 * @return
	 */
	ResultCode<List<OrderSpCodeVo>> getSpCodeVoList(PartnerSpCodeReqVo reqVo);
	/**
	 * unionWapFast支付
	 * @param reqVo
	 * @return
	 */
	ResultCode unionWapFast(PartnerCommonReqVo reqVo);

	/**
	 * 合作商创建订单，非格瓦拉用户、非联名登录用户
	 * @param reqVo
	 * @return
	 */
	ResultCode<GewaOrderVo> addPartnerUserTicketOrder(PartnerAddOrderReqVo reqVo);
	/**
	 * 获取购买列表
	 * @param orderId
	 * @return
	 */
	ResultCode<List<BuyItemVo>> getItemList(PartnerOrderInfoReqVo reqVo);
	/**
	 * 根据订单号查询订单退款
	 * @param tradeNo
	 * @return
	 */
	ResultCode<OrderRefundVo> getOrderRefundByTradeNo(PartnerOrderInfoReqVo reqVo);
	/**
	 * 提交退款
	 * @param orderId
	 * @param tradeNo
	 * @param retback
	 * @param reasoninfo
	 * @return
	 */
	ResultCode confirmRefundOrder(PartnerOrderRefundInfoReqVo reqVo);
	/**
	 * 检查订单能否退款
	 * @param tradeNo
	 * @return
	 */
	ResultCode checkRefundOrder(PartnerOrderInfoReqVo reqVo);
	/**
	 * 检查订单能否退款
	 * @param tradeNo
	 * @return
	 */
	ResultCode filterRefundOrder(PartnerOrderInfoReqVo reqVo);
	/**
	 * 根据订单号查询物流信息
	 * @param tradeNo
	 * @return
	 */
	ResultCode<List<RouteVo>> getRouteVoByTradeNo(PartnerOrderInfoReqVo reqVo);
	/**
	 * 根据订单号查询订单拓展信息
	 * @param tradeNo
	 * @return
	 */
	ResultCode<OrderExtraVo> getOrderExtraByTradeNo(PartnerOrderInfoReqVo reqVo);
	/**
	 * 根据订单号查询地址
	 * @param tradeNo
	 * @return
	 */
	ResultCode<OrderAddressVo> getOrderAddressVo(PartnerOrderInfoReqVo reqVo);

	ResultCode<GewaOrderVo> useWeixinCard(PartnerOrderInfoReqVo reqVo);
	
	ResultCode<List<OrderNoteVo>> getOrderNoteList(PartnerOrderInfoReqVo reqVo);
	
	ResultCode<List<OrderSpCodeVo>> getSpCodeVoListByMemberId(PartnerSpCodeReqVo reqVo);
	ResultCode<List<OrderSpCodeVo>> getUnoverdueSpCodeVoList(PartnerSpCodeReqVo reqVo);
	/**
	 * 使用积分
	 * @param tradeNo
	 * @return
	 */
	ResultCode usePoint(String memberEncode,String tradeNo,int usePoint,String ip);
	ResultCode sendVoiceCode(String tradeNo, String ip, String mobile, boolean checkSecurity);
	/**
	 * 当订单已选择活动后,不能与其他优惠方式共享的活动状态返回为可用
	 * @param tradeNo
	 * @return
	 */
	ResultCode<List<SpDiscountVo>> getShareDiscountList(PartnerOrderInfoReqVo reqVo);
	
	ResultCode<Map<String, String>> getRelatedData(GewaOrderVo order);
	/**
	 * 取消包场gewaOrder订单
	 * @param reqVo
	 * @return
	 */
	ResultCode cancelBaoChangGewaOrder(PartnerOrderInfoReqVo reqVo);
	/**
	 * 原getMemberOrderList查询订单方法，不查询HisOrder的订单；
	 * getMemberOrderListNew方法，查询GewaOrder、PostOrder、HisOrder
	 * @param reqVo
	 * @return
	 */
	ResultCode<List<GewaOrderVo>> getMemberOrderListNew(PartnerOrderQueryReqVo reqVo);
	/**
	 * 根据订单号获取微信朋友券数据
	 * @param tradeNo
	 * @return
	 */
	ResultCode<Map<String, String>> getWxFriendCardData(String tradeNo);
	/**
	 * 用户删除订单（wap用）
	 * @param reqVo
	 * @return
	 */
	ResultCode<GewaOrderVo> removeOrderForWap(PartnerOrderInfoReqVo reqVo);

	/**
	 * 获取订单的取票密码
	 * @param reqVo
	 * @return
	 */
	ResultCode<String> getTicketPassMsg(PartnerOrderInfoReqVo reqVo);

	/**
	 * 获取来自QQ联名登录的订单信息
	 * 
	 * @param tradeNo
	 * @return
	 */
	ResultCode<Map<String, String>> getQQcardConsumeInfo(String tradeNo);

	/**
	 * 保存来自QQ联名登录的订单信息，给QQ卡券核销时使用
	 * 
	 * @param tradeNo
	 * @param cardId
	 * @param code
	 * @return
	 */
	ResultCode<String> saveQQcardConsumeInfo(String tradeNo, String cardId, String code);
	/**
	 * 使用点卡(FCard)
	 * @param reqVo
	 * @return
	 */
	ResultCode<OrderCardVo> useFCard(PartnerOrderInfoReqVo reqVo);

}

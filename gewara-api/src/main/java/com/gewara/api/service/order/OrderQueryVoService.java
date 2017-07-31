package com.gewara.api.service.order;

import java.sql.Timestamp;
import java.util.List;

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

public interface OrderQueryVoService {
	/**
	 * 查询影票订单
	 * @param clazz
	 * @param command
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<GewaOrderVo>> getTicketOrderList(ParamsVo param);
	
	/**
	 * 查询电影票关联表
	 * @param soc
	 * @return
	 */
	ResultCode<List<GewaOrderVo>> searchTicketOrderList(SearchOrderCommandVo soc);

	/**
	 * 获取订单地址列表
	 * @param tradeNoList
	 * @return
	 */
	ResultCode<List<OrderAddressVo>> getOrderAddressVoList(List<String> tradeNoList);
	
	/**
	 * 获取购买列表
	 * @param orderId
	 * @return
	 */
	ResultCode<List<BuyItemVo>> getItemList(Long orderId);

	/**
	 * 获取订单信息列表
	 * @param orderId
	 * @return
	 */
	ResultCode<List<OrderNoteVo>> getNoteList(Long orderId);
	
	/**
	 * 查询订单数量
	 * @param command
	 * @return
	 */
	ResultCode<Integer> getOrderCount(OrderParamsVo command);
	
	/**
	 * 查询订单列表
	 * @param param
	 * @return
	 */
	ResultCode<List<GewaOrderVo>> getOrderList(ParamsVo param);
	
	/**
	 * 查询超时取消订单
	 * @param param
	 * @return
	 */
	ResultCode<List<GewaOrderVo>> getCurFailureOrderList(ParamsVo param);
	
	/**
	 * 根据主键查询订单
	 * @param orderId
	 * @return
	 */
	ResultCode<GewaOrderVo> getGewaOrder(Long orderId);
	
	/**
	 * 根据订单号查询地址
	 * @param tradeNo
	 * @return
	 */
	ResultCode<OrderAddressVo> getOrderAddressVo(String tradeNo);
	
	/**
	 * 获取卖品订单列表
	 * @param param
	 * @return
	 */
	ResultCode<List<GewaOrderVo>> getGoodsOrderList(ParamsVo param);
	
	/**
	 * 根据电话查询订单数量
	 * @param param
	 * @return
	 */
	ResultCode<Integer> getGewaorderCountByMobile(ParamsVo param);
	
	/**
	 * 查询订单是否支持快递
	 * @param tradeno
	 * @return
	 */
	ResultCode<Boolean> isTakeByTradeno(String tradeno);
	
	/**
	 * 根据订单号查询订单
	 * @param tradeNo
	 * @return
	 */
	ResultCode<GewaOrderVo> getGewaOrderByTradeNo(String tradeNo);
	
	/**
	 * 查询订单Map
	 * @param orderMap
	 * @return
	 */
	ResultCode<GewaOrderMapVo> getGewaOrderMap(GewaOrderMapVo orderMap);
	
	/**
	 * 根据订单号查询订单拓展信息
	 * @param tradeNo
	 * @return
	 */
	ResultCode<OrderExtraVo> getOrderExtraByTradeNo(String tradeNo);
	
	/**
	 * 根据订单号查询订单信息
	 * @param tradeNo
	 * @return
	 */
	ResultCode<OrderNoteVo> getOrderNodeByTradeNo(String tradeNo);
	
	
	/**
	 * 获取用户购票数量
	 * @param memberid
	 * @return
	 */
	ResultCode<Integer> getOrderMemberHis(Long memberid);
	
	/**
	 * 获取用户购票数量
	 * @param memberid
	 * @param ordertype
	 * @return
	 */
	ResultCode<Integer> getOrderMemberHisWithType(Long memberid, String ordertype);
	
	ResultCode<List<GewaOrderMapVo>> getGewaOrderMapList(List<GewaOrderVo> orderList);
	
	/**
	 * 根据用户ID获取订单信息
	 * @param memberid
	 * @return
	 */
	ResultCode<List<GewaOrderVo>> getHisOrderListByMemberid(ParamsVo param);
	
	/**
	 * 根据用户ID获取订单信息
	 * @param memberid
	 * @return
	 */
	ResultCode<List<GewaOrderVo>> getGewaOrderListByTradenoList(List<String> tradenos);
	
	/**
	 * 根据mpid查询（过期）场次信息
	 * @param mpid
	 * @return
	 */
	ResultCode<VoMap> getOpiMapByMpid(Long mpid, Timestamp playtime);
}

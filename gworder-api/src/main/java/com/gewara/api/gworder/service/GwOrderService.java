package com.gewara.api.gworder.service;

import java.io.Serializable;
import java.util.List;

import com.gewara.api.gworder.vo.CreateBaoChangOrderReq;
import com.gewara.api.gworder.vo.CreateDramaOrderReq;
import com.gewara.api.gworder.vo.CreateMallOrderReq;
import com.gewara.api.gworder.vo.CreateMovieOrderReq;
import com.gewara.api.gworder.vo.CreateOrderReq;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.order.GewaOrderVo;
import com.gewara.api.vo.pay.PubSaleVo;

public interface GwOrderService extends ContextManagerService{

	/**
	 * 快速将CreateOrderReq放入处理队列中,直接返回
	 * <br>后台异步处理创建流程，创建成功后通过JMS消息异步通知
	 * <br>工作队列未满，放入成功，返回ResultCode.SUCCESS
	 * <br>如果失败，返回ResultCode.Failure
	 * @param createOrderReq
	 * @return ResultCode 
	 */
	ResultCode asynCreateOrder(CreateOrderReq createOrderReq);
	
	/**
	 * 快速将CreateMovieOrderReq放入处理队列中,直接返回
	 * <br>后台异步处理创建流程，创建成功后通过JMS消息异步通知
	 * <br>工作队列未满，放入成功，返回ResultCode.SUCCESS
	 * <br>如果失败，返回ResultCode.Failure
	 * @param createOrderReq
	 * @return ResultCode 
	 */
	ResultCode asynCreateMovieOrder(CreateMovieOrderReq createOrderReq);
	
	/**
	 * 同步创建电影订单
	 * <br>使用场景：下单量小，原来调用dubbo接口，异步改造难度大,如：partner、wap调用
	 * @param createOrderReq
	 * @return ResultCode，成功返回GewaOrderVo对象
	 */
	ResultCode<GewaOrderVo> synCreateMovieOrder(CreateMovieOrderReq createOrderReq);
	/**
	 * 创建商城订单
	 * @param createOrderReq
	 * @return
	 */
	ResultCode<GewaOrderVo> createMallOrder(CreateMallOrderReq createOrderReq);
	
	/**
	 * 快速将CreateDramaOrderReq放入处理队列中,直接返回
	 * <br>后台异步处理创建流程，创建成功后通过JMS消息异步通知
	 * <br>工作队列未满，放入成功，返回ResultCode.SUCCESS
	 * <br>如果失败，返回ResultCode.Failure
	 * @param createOrderReq
	 * @return ResultCode 
	 */
	ResultCode asynCreateDramaOrder(CreateDramaOrderReq createOrderReq);
	/**
	 * 同步创建演出订单
	 * <br>使用场景：下单量小，原来调用dubbo接口，异步改造难度大,如：partner、wap调用
	 * @param createOrderReq
	 * @return ResultCode，成功返回GewaOrderVo对象
	 */
	ResultCode<GewaOrderVo> synCreateDramaOrder(CreateDramaOrderReq createOrderReq);
		
	/**
	 * 根据订单号查询订单信息(用户正在进行操作的订单（下单完成、去支付等）)
	 * @param id
	 * @return
	 */
	ResultCode<GewaOrderVo> getCurOrderById(Long id);
	
	/**
	 * 根据订单号查询订单信息(不包含历史订单及已移除到未支付表里的订单)
	 * @param id
	 * @return
	 */
	ResultCode<GewaOrderVo> getOrderById(Long id);
	
	/**
	 * 根据订单号查询订单信息(当前订单以及成功订单表，不包含历史订单及已移除到未支付表里的订单)
	 * @param idList
	 * @return
	 * @author leo
	 * @addTime 2016年7月28日下午2:35:15
	 */
	ResultCode<List<GewaOrderVo>> getOrderByIdList(List<Long> idList);
	
	/**
	 * 根据订单号查询订单信息(包含历史订单，但不包含已移除到未支付表里的订单)
	 * @param id
	 * @return
	 * @author leo
	 * @addTime 2016年6月28日下午4:45:46
	 */
	ResultCode<GewaOrderVo> getGewaOrderAndHis(Long id);

	/**
	 * 根据订单号查询订单信息(全部订单)
	 * @param id
	 * @return
	 */
	ResultCode<GewaOrderVo> getAllOrderById(Long id);
	
	/**
	 * 根据订单号查询订单信息(用户正在进行操作的订单（下单完成、去支付等）)
	 * @param tradeNo
	 * @return
	 */
	ResultCode<GewaOrderVo> getCurOrderByTradeNo(String tradeNo);
	
	/**
	 * 根据订单号查询订单信息(不包含历史订单及已移除到未支付表里的订单)
	 * @param tradeNo
	 * @return
	 */
	ResultCode<GewaOrderVo> getOrderByTradeNo(String tradeNo);
	
	/**
	 * 根据订单号查询订单信息(不包含已移除到未支付表里的订单)
	 * @param tradeNo
	 * @return
	 * @author leo
	 * @addTime 2016年8月4日下午5:58:01
	 */
	ResultCode<GewaOrderVo> getGewaOrderAndHis(String tradeNo);
	
	/**
	 * 根据订单号查询订单信息(全部订单)
	 * @param tradeNo
	 * @return
	 */
	ResultCode<GewaOrderVo> getAllOrderByTradeNo(String tradeNo);
	/**
	 * 刷新缓存中锁定的座位
	 * @param mpid
	 * @param secid
	 */
	ResultCode refreshLockSeatList(Long mpid, String secid);

	/**
	 * 处理paid_failure订单
	 * @param tradeNo
	 * @return
	 * @author leo
	 * @addTime 2015年8月27日下午5:32:58
	 */
	ResultCode processPaidFailureOrder(String tradeNo);
	
	/**
	 * 确认订单成功，将订单状态从paid_failure，paid_failure_unfix置为paid_success
	 * @param tradeNo
	 * @return
	 * @author leo
	 * @addTime 2015年9月1日下午2:20:13
	 */
	ResultCode confirmSuccess(String tradeNo);
	/**
	 * 取消订单
	 * @param tradeNo
	 * @param memberId
	 * @return
	 */
	ResultCode cancelOrder(String tradeNo, Long memberId);
	
	ResultCode cancelOrder(String tradeNo, String ukey, String reason);
	
	/**
	 * 创建包场订单
	 * @param req
	 * @return
	 */
	ResultCode<GewaOrderVo> createBaoChangOrder(CreateBaoChangOrderReq req);
	/**
	 * 更新商城订单的成本价
	 * @param tradeNo
	 * @param totalcost
	 * @return
	 */
	ResultCode updateMallOrderTotalcost(String tradeNo, Integer totalcost);
	
	/**
	 * 更新订单（只包括：GewaOrder）的一个或多个字段的值</br>
	 * 返回被修改的字段个数
	 * @param orderId		订单ID
	 * @param properties	字段，多个用“,”隔开，只支持以下几个属性：otherinfo,mobile,taketime,restatus
	 * @param values		值
	 * @return
	 * @author leo
	 * @addTime 2016年6月7日上午11:26:29
	 */
	ResultCode<Integer> updateCurOrder(Long orderId, String properties, Serializable... values);
	
	/**
	 * 更新订单（只包括：GewaOrder,PostOrder）的一个或多个字段的值</br>
	 * 返回被修改的字段个数
	 * @param orderId		订单ID
	 * @param properties	字段，多个用“,”隔开，只支持以下几个属性：otherinfo,mobile,taketime,restatus
	 * @param values		值
	 * @return
	 * @author leo
	 * @addTime 2016年6月7日上午11:26:29
	 */
	ResultCode<Integer> updateGewaOrder(Long orderId, String properties, Serializable... values);
	
	/**
	 * 更新订单（只包括：GewaOrder,PostOrder,HisOrder）的一个或多个字段的值</br>
	 * 返回被修改的字段个数
	 * @param orderId		订单ID
	 * @param properties	字段，多个用“,”隔开，只支持以下几个属性：otherinfo,mobile,taketime,restatus
	 * @param values		值
	 * @return
	 * @author leo
	 * @addTime 2016年6月7日上午11:26:29
	 */
	ResultCode<Integer> updateGewaOrderAndHis(Long orderId, String properties, Serializable... values);
	
	/**
	 * 更新订单（只包括：GewaOrder,PostOrder,HisOrder,CurFailureOrder）的一个或多个字段的值</br>
	 * 返回被修改的字段个数
	 * @param orderId		订单ID
	 * @param properties	字段，多个用“,”隔开，只支持以下几个属性：otherinfo,mobile,taketime,restatus
	 * @param values		值
	 * @return
	 * @author leo
	 * @addTime 2016年6月7日上午11:26:29
	 */
	ResultCode<Integer> updateAllOrder(Long orderId, String properties, Serializable... values);
	
	ResultCode<Long> stopPubSale(PubSaleVo sale);
	
}

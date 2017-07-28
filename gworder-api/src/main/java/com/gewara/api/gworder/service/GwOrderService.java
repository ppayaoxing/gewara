/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gworder.service;

import com.gewara.api.gworder.service.ContextManagerService;
import com.gewara.api.gworder.vo.CreateBaoChangOrderReq;
import com.gewara.api.gworder.vo.CreateDramaOrderReq;
import com.gewara.api.gworder.vo.CreateMallOrderReq;
import com.gewara.api.gworder.vo.CreateMovieOrderReq;
import com.gewara.api.gworder.vo.CreateOrderReq;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.order.GewaOrderVo;
import com.gewara.api.vo.pay.PubSaleVo;
import java.io.Serializable;
import java.util.List;

public interface GwOrderService extends ContextManagerService {
	ResultCode asynCreateOrder(CreateOrderReq arg0);

	ResultCode asynCreateMovieOrder(CreateMovieOrderReq arg0);

	ResultCode<GewaOrderVo> synCreateMovieOrder(CreateMovieOrderReq arg0);

	ResultCode<GewaOrderVo> createMallOrder(CreateMallOrderReq arg0);

	ResultCode asynCreateDramaOrder(CreateDramaOrderReq arg0);

	ResultCode<GewaOrderVo> synCreateDramaOrder(CreateDramaOrderReq arg0);

	ResultCode<GewaOrderVo> getCurOrderById(Long arg0);

	ResultCode<GewaOrderVo> getOrderById(Long arg0);

	ResultCode<List<GewaOrderVo>> getOrderByIdList(List<Long> arg0);

	ResultCode<GewaOrderVo> getGewaOrderAndHis(Long arg0);

	ResultCode<GewaOrderVo> getAllOrderById(Long arg0);

	ResultCode<GewaOrderVo> getCurOrderByTradeNo(String arg0);

	ResultCode<GewaOrderVo> getOrderByTradeNo(String arg0);

	ResultCode<GewaOrderVo> getGewaOrderAndHis(String arg0);

	ResultCode<GewaOrderVo> getAllOrderByTradeNo(String arg0);

	ResultCode refreshLockSeatList(Long arg0, String arg1);

	ResultCode processPaidFailureOrder(String arg0);

	ResultCode confirmSuccess(String arg0);

	ResultCode cancelOrder(String arg0, Long arg1);

	ResultCode cancelOrder(String arg0, String arg1, String arg2);

	ResultCode<GewaOrderVo> createBaoChangOrder(CreateBaoChangOrderReq arg0);

	ResultCode updateMallOrderTotalcost(String arg0, Integer arg1);

	ResultCode<Integer> updateCurOrder(Long arg0, String arg1, Serializable... arg2);

	ResultCode<Integer> updateGewaOrder(Long arg0, String arg1, Serializable... arg2);

	ResultCode<Integer> updateGewaOrderAndHis(Long arg0, String arg1, Serializable... arg2);

	ResultCode<Integer> updateAllOrder(Long arg0, String arg1, Serializable... arg2);

	ResultCode<Long> stopPubSale(PubSaleVo arg0);
}
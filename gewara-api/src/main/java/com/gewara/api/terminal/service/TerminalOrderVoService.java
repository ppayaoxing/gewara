package com.gewara.api.terminal.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gewara.api.terminal.vo.CustomPaperVo;
import com.gewara.api.terminal.vo.DpiLayoutVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.order.GewaOrderVo;

public interface TerminalOrderVoService {
	/**
	 * 查询电影订单
	 * @param tradeno
	 * @return
	 */
	ResultCode<GewaOrderVo> getTicketOrderByTradeno(String tradeno);
	/**
	 * 查询电影物品订单
	 * @param tradeno
	 * @return
	 */
	ResultCode<GewaOrderVo> getGoodsOrderByTradeno(String tradeno);
	/**
	 * 查询演出订单,由于可以选择多个场次，所以返回一个对象集合
	 * @param tradeno
	 * @return
	 */
	ResultCode<List<GewaOrderVo>> getDramaOrderByTradeno(String tradeno);
	/**
	 * 获取已退款的订单号
	 * @param goodsid
	 * @param relatedid
	 * @param addtime
	 * @return
	 */
	ResultCode<List<String>> getRefundOrderList(Timestamp refundtime);
	/**
	 * 出票高峰的场次时段 包括电影和演出
	 * @param placeid
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	ResultCode<List<Map>> getPeakPeriodByTag(Long placeid, Timestamp starttime, Timestamp endtime, String tag);
	
	/**
	 * 查询演出场次的打印布局
	 * @param cinemaid
	 * @param playtime
	 * @param addtime
	 * @return
	 */
	ResultCode<DpiLayoutVo> getDpiLayoutVo(Long dpid);
	/**
	 * 票面实际需要打印的信息
	 * @param tradeno
	 * @return
	 */
	ResultCode<String> getDramaOrderPrintInfo(String tradeno);
	ResultCode<List<CustomPaperVo>> customPaperVoList(String tag, Date startdate, Date enddate);
	/**
	 * 获取所有交易成功的订单号，不在区分订单类型，后期删除其他的方法
	 * @param addtime
	 * @return
	 */
	ResultCode<List<String>> getSuccessTradenoList(Timestamp addtime);
	/**
	 * 根据订单号，查询自定义票纸
	 * @return
	 */
	ResultCode<CustomPaperVo> getCustomPaperVoByTradeNo(String tradeno);
	/**
	 * 根据时间段拉取现有订单
	 * @param addtimeFrom
	 * @param addtimeTo
	 * @return
	 */
	ResultCode<List<String>> getSuccessTradenoList(Timestamp addtimeFrom, Timestamp addtimeTo);
}

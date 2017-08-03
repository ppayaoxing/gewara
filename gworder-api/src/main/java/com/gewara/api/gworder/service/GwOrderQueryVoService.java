package com.gewara.api.gworder.service;

import java.sql.Timestamp;
import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.order.GewaOrderVo;

public interface GwOrderQueryVoService {
	/**
	 * 查询Postorder的商城订单
	 * @param memberid
	 * @param startTime
	 * @param endTime
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<GewaOrderVo>> getMallPostOrderListByMemberId(Long memberid, Timestamp startTime, Timestamp endTime, int from, int maxnum);
	/**
	 * 查询GewaOrder中的商城订单
	 * @param memberid
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	ResultCode<List<GewaOrderVo>> getMallOrderListByMemberId(Long memberid, Timestamp startTime, Timestamp endTime);
	
	/**
	 * 查询用户订单，包括当前的
	 * @param memberId
	 * @param from
	 * @param maxnum
	 * @return
	 * @author leo
	 * @addTime 2016年3月23日上午11:22:59
	 */
	ResultCode<List<GewaOrderVo>> getOrderScheduleList(Long memberId, int from, int maxnum);
	
	/**
	 * 查询用户当天的订单
	 * @param memberId
	 * @param from
	 * @param maxnum
	 * @return
	 * @author leo
	 * @addTime 2016年3月23日上午11:23:15
	 */
	ResultCode<List<GewaOrderVo>> getCurrentTicketOrderByMemberId(Long memberId, int from, int maxnum);
	
	/**
	 * 根据用户ID，影院IDlist，查询用户的物品订单
	 * @param memberId
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<GewaOrderVo>> getCurrentGoodsOrderList(Long memberId, List<Long> cinemaIdList, Timestamp addTime);
	/**
	 * 根据用户ID查询用户的物品订单
	 * @param memberId
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<GewaOrderVo>> getCurrentGoodsOrderByMemberId(Long memberId, int from, int maxnum);


	ResultCode<List<GewaOrderVo>> getCurrentBaoChangOrderByMemberId(Long memberId, int from, int maxnum);

	
	/**
	 * 根据合作商id查询订单，只查询一天之内的成功订单
	 * @param memberid
	 * @param partnerid
	 * @param startTime
	 * @return
	 */
	ResultCode<List<GewaOrderVo>> getOrderListByPartnerId(Long memberid, Long partnerid, Timestamp startTime, Integer from, Integer maxnum);
	
	/**
	 * 
	 * 查询用户当天，在放映时间playtime以后的订单，只在PostOrder中查询
	 * @param memberId
	 * @param playtime	放映时间
	 * @return
	 * @author leo
	 * @addTime 2016年5月26日上午11:41:13
	 */
	ResultCode<List<GewaOrderVo>> getCurrentTicketOrderByMemberId(Long memberId, Timestamp playtime);
	
	ResultCode<List<GewaOrderVo>> getNewGewaOrderListToMovieApp(Long memberId);
	
	/**
	 * 
	 * @param memberId
	 * @param isM5V
	 * @param orderType, 多个请用","号隔开
	 * @param days
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<GewaOrderVo>> getOrderListByMemberId(Long memberId, boolean isM5V, String orderType, int days, int from, int maxnum);
}

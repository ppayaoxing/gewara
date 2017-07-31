package com.gewara.api.service.movie;

import java.sql.Timestamp;
import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.movie.TakeInfoVo;
import com.gewara.api.vo.order.GewaOrderVo;

public interface TicketOrderVoService {
	/**
	 * 根据场次查询订单
	 * @param mpid 
	 * @param timeType //值为addtime时表示下单时间
	 * @return
	 */
	ResultCode<List<GewaOrderVo>> getTicketOrderListByMpid(Long mpid,Timestamp startTime,Timestamp endTime,String timeType,String openType);
	
	/**
	 * 根据订单号获取电影票订单关联表
	 * @param tradeno
	 * @deprecated 见gworder接口
	 * @see com.gewara.api.gworder.service.GwOrderService.getOrderByTradeNo
	 * @return
	 */
	@Deprecated
	ResultCode<GewaOrderVo> getTicketOrderByTradeno(String tradeno);
	/**
	 * 查询自定义票纸信息
	 * @param tradeNo
	 * @return
	 */
	ResultCode<List<TakeInfoVo>> getTakeInfoList(String tradeNo);
}

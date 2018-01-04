package com.gewara.api.terminal.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.order.GewaOrderVo;

public interface TerminalFilmVoService {
	/**
	 * 查询电影场次的打印布局
	 * @param mpid
	 * @return
	 */
	ResultCode<Map<String, Object>> getMpiLayoutVoByMpid(Long mpid);
	
	ResultCode<String> getMpiLayoutVo(Long mpid);
	/**
	 * 查询电影节订单集合
	 * @param cinemaid
	 * @param playtime
	 * @param addtime
	 * @return
	 */
	ResultCode<List<String>> getSuccessFilmOrderList(Long cinemaid, Timestamp playtime, Timestamp addtime);
	/**
	 * 更加影院获取订单
	 * @param cinemaid
	 * @param addtime
	 * @return
	 */
	ResultCode<List<String>> getMovieSuccessTradenoList(Long cinemaid, Timestamp addtime);
	/**
	 * 查询电影订单
	 * @param tradeno
	 * @return
	 */
	ResultCode<GewaOrderVo> getTicketOrderByTradeno(String tradeno);
}

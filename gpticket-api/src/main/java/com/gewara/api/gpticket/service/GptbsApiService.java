package com.gewara.api.gpticket.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;

public interface GptbsApiService {
	/**
	 * 获取订单信息，无限限控制(所有的订单)
	 * @param tOrderNo
	 * @param entry
	 * @return
	 */
	ResultCode<Map> getOrderPrintInfo2(String tOrderNo);
	
	/**
	 * 根据更新时间批量获取订单信息，无限限控制(所有的订单)
	 * @param updatetime
	 * @param endtime
	 * @param entry
	 * @return
	 */
	ResultCode<List<Map>> getOrderPrintInfo(Timestamp updatetime, Timestamp endtime);
	/**
	 * 场次票版，无限限控制(所有的场次票版)
	 * @param scheduleId
	 * @return
	 */
	ResultCode<String> getTicketFaceExp(String scheduleId);
	
	/**
	 * 通过更新时间获取场馆信息
	 * @param updatetime
	 * @return
	 */
	ResultCode<List<Map>> getStadiumListByUpdate(Timestamp updatetime);
	
	/**
	 * 通知更新取状态
	 * @param requestData
	 * @return
	 */
	ResultCode updateTakeTicketStatus(String requestData);
}

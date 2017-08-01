package com.gewara.api.terminal.service;

import java.sql.Timestamp;
import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.order.OrderResultVo;

public interface OrderResultVoService {

	ResultCode<OrderResultVo> getOrderResult(String tradeno);

	ResultCode<List<OrderResultVo>> getOrderResultListByTaketime(Long placeid, Timestamp taketime);

	ResultCode<List<OrderResultVo>> getOrderResultListByUpdatetime(Long placeid, Timestamp updatetime);

	ResultCode<List<OrderResultVo>> getOrderResultListByPlaceids(List<Long> placeidList, Timestamp updatetime);

	ResultCode<List<OrderResultVo>> getOrderResultListByPlaceids(List<Long> placeidList, Timestamp starttime,
			Timestamp endtime);

	ResultCode<List<OrderResultVo>> getOrderResultListByPlaceids(List<Long> placeidList, String ordertype,
			Timestamp starttime, Timestamp endtime);

}

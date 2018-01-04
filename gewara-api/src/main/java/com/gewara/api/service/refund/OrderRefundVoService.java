package com.gewara.api.service.refund;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.cmd.order.SearchRefundCommandVo;
import com.gewara.api.vo.pay.OrderRefundVo;

public interface OrderRefundVoService {
	
	/**
	 * 查询订单退款列表
	 * @param command
	 * @param order
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<OrderRefundVo>> getOrderRefundList(SearchRefundCommandVo command, String order, int from, int maxnum);
	
	/**
	 * 查询订单退款数量
	 * @param command
	 * @return
	 */
	ResultCode<Integer> getOrderRefundCount(SearchRefundCommandVo command);
	
	/**
	 * 根据订单号查询订单退款
	 * @param tradeNo
	 * @return
	 */
	ResultCode<OrderRefundVo> getOrderRefundByTradeNo(String tradeNo);
	
	ResultCode<List<String>> getRefundTemplateList2();
}

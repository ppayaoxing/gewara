package com.gewara.api.gpticket.service;

import com.gewara.api.gpticket.vo.command.OrderCommandVo;
import com.gewara.api.gpticket.vo.command.OrderIdVo;
import com.gewara.api.gpticket.vo.ticket.DramaRemoteOrderVo;
import com.gewara.api.vo.ResultCode;

public interface GpticketOrderApiService {
	/**
	 * 获取区域锁定座位
	 * @param usertype
	 * @param areaseqno
	 * @return	1:1,1:2(座位号)
	 */
	ResultCode<String> getLockSeat(final String areaseqno);
	ResultCode<String> getLockSeatByUsertype(final String usertype, final String areaseqno);
	
	/**
	 * 获取区域未锁定价格数量
	 * @param usertype
	 * @param areaseqno
	 * @return 1001:200,1002:200  (价格编号:未锁定数)
	 */
	ResultCode<String> getUnLockPrice(final String areaseqno);
	ResultCode<String> getUnLockPriceByUsertype(final String usertype, final String areaseqno);

	/**
	 * 创建订单
	 * @param orderCommand
	 * @return
	 */
	ResultCode<DramaRemoteOrderVo> createOrder(final OrderCommandVo orderCommand);
	
	/**
	 * 锁定价格
	 * @param orderCommand
	 * @return
	 */
	ResultCode<DramaRemoteOrderVo> lockPrice(final OrderCommandVo orderCommand);
	
	/**
	 * 锁定座位
	 * @param orderCommand
	 * @return
	 */
	ResultCode<DramaRemoteOrderVo> lockSeat(final OrderCommandVo orderCommand);
	
	/**
	 * 确认订单出票
	 * @param orderCommand
	 * @return
	 */
	ResultCode<DramaRemoteOrderVo> fixOrder(final OrderCommandVo orderCommand);
	
	/**
	 * 解锁订单
	 * @param orderIdVo
	 * @return
	 */
	ResultCode<DramaRemoteOrderVo> unLockOrder(final OrderIdVo orderIdVo);
	
	ResultCode<DramaRemoteOrderVo> backOrder(final OrderIdVo orderIdVo);
	
	ResultCode<DramaRemoteOrderVo> qryOrder(final OrderIdVo orderIdVo);
	
	ResultCode<DramaRemoteOrderVo> checkOrder(final OrderIdVo orderIdVo);
	
	/**
	 * 获取场次票面
	 * @param seqno
	 * @return
	 */
	ResultCode<String> qryTicketFace(final String seqno);

	/**
	 * 获取订单打票信息
	 * @param orderIdVo
	 * @return
	 */
	ResultCode<String> qryOrderInfo(final OrderIdVo orderIdVo);

	/**
	 * 修改订单个性化数据
	 * @param orderIdVo
	 * @return
	 */
	ResultCode updateOrderGreetings(final OrderIdVo orderIdVo);
}

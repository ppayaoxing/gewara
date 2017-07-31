package com.gewara.api.gworder.service;

import com.gewara.api.gworder.vo.ProcessOrderPayVo;
import com.gewara.api.vo.ResultCode;

public interface AvatarGworderService {

	/**
	 * 
	 * 如果订单状态是：paid_failure，去做以下事情：<br/>
	 * 1、处理订单支付，确认支付过的订单，优惠，票券，积分<br/>
	 * 2、验证成功，返回订单状态标识，注明订单状态可置为：paid_failure_unfix<br/>
	 * 
	 * 同时返回取票密码，订单中已经有的直接返回，没有的生成个返回
	 * 
	 * @param tradeNo
	 * @return
	 * @author leo
	 * @addTime 2016年8月29日下午16:13:48
	 */
	ResultCode<ProcessOrderPayVo> processOrderPay(String tradeNo);
}

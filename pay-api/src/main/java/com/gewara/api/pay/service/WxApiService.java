package com.gewara.api.pay.service;

import com.gewara.api.pay.request.wx.CheckfirstbindByTradeNoRequest;
import com.gewara.api.pay.response.wx.CheckfirstbindByTradeNoResponse;
import com.gewara.api.vo.ResultCode;

/**
 * 微信服务接口
 * @author leo
 *
 */
public interface WxApiService {

	/**
	 * 根据订单号检查是否首次邦定，调用该接口将立即返回，结果用jms异步通知
	 * 
	 * jms消息队列名：wxCheckfirstbindQueue
	 * 返回参数：
	 * 	tradeNo : 订单号
	 * 	retcode ：执行结果，0：成功；非0时，对应错误码
	 * 	isFirstBind ：是否邦定，0：为首次绑定，1：非首次绑定
	 *  retmsg ：retcode非0时的错误提示
	 * 
	 * @param request
	 * @return
	 * @author leo
	 * @addTime 2014年6月4日下午4:24:51
	 */
	ResultCode<CheckfirstbindByTradeNoResponse> checkfirstbindByTradeNo(CheckfirstbindByTradeNoRequest request);
	
}

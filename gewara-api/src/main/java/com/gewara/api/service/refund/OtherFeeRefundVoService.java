package com.gewara.api.service.refund;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.pay.OtherFeeRefundVo;

public interface OtherFeeRefundVoService {
	/**
	 * 查询订单其它费用退款信息
	 * @param origin	其它费用来源(参考OtherFeeRefundConstant类)
	 * @param tradeno	订单号
	 * @param status	退款状态
	 * @param memberid	用户ID
	 * @param mobile	手机号
	 * @param from		
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<OtherFeeRefundVo>> getOtherFeeRefundList(String origin, String tradeno, String status, Long memberid, String mobile, int from, int maxnum);
	
	/**
	 * 查询订单其它费用退款数量
	 * @param origin	其它费用来源(参考OtherFeeRefundConstant类)
	 * @param tradeno	订单号
	 * @param status	退款状态
	 * @param memberid	用户ID
	 * @param mobile	手机号
	 * @return
	 */
	ResultCode<Integer> getOtherFeeRefundCount(String origin, String tradeno, String status, Long memberid, String mobile);
	
	/**
	 * 查询订单其它费用退款信息
	 * @param origin	其它费用来源(参考OtherFeeRefundConstant类)
	 * @param tradeno	订单号
	 * @return
	 */
	ResultCode<OtherFeeRefundVo> getOtherFeeRefund(String origin, String tradeno);
}

package com.gewara.api.gworder.service;

import java.sql.Timestamp;
import java.util.Map;

import com.gewara.api.gworder.vo.CinemaMerchantGoodsStatisVo;
import com.gewara.api.gworder.vo.ProcessOrderPayVo;
import com.gewara.api.gworder.vo.ValidateOpenApiPayVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.order.CheckAddOrderGoodsGiftRes;


public interface SHGwOrderVoService {
	/**
	 * 下单的时候，在订单信息otherinfo里记录强制绑定的套餐
	 * @param tradeNo
	 * @return
	 */
	ResultCode bindOrderGoodsGift(String tradeNo);
	/**
	 * 下单的时候用户选择的套餐信息
	 * @param tradeNo
	 * @param goodsid
	 * @param quantity
	 * @return
	 */
	ResultCode addOrderGoodsGift(String tradeNo, Long goodsid, Integer quantity);
	/**
	 * 增加订单增加特价活动id到订单otherinfo中
	 * @param spkey
	 * @param tradeNo
	 * @param mpid
	 * @return
	 */
	ResultCode addSpid2OrderOtherinfo(String spkey, String tradeNo, Long mpid);
	
	/**
	 * 如果订单状态是：paid_failure，去做以下事情：<br/>
	 * 1、处理订单支付，确认支付过的订单，优惠，票券，积分
	 * 2、验证成功，返回订单状态标识，注明订单状态可置为：paid_failure_unfix
	 * 
	 * 同时返回取票密码，订单中已经有的直接返回，没有的生成个返回
	 * 
	 * @param tradeNo
	 * @return
	 * @author leo
	 * @addTime 2015年8月12日下午4:26:15
	 */
	ResultCode<ProcessOrderPayVo> processOrderPay(String tradeNo);
	/**
	 * 根据影院ID和日期获取统计数据
	 * @param cinemaid
	 * @param dateStr
	 * @return
	 */
	ResultCode<Map<String, CinemaMerchantGoodsStatisVo>> getCinemaStatisData(String token, Long cinemaid, Timestamp sdate);
	
	/**
	 * 合作商通知，合作商验证，支付结果反查询
	 * 
	 * @param appkey
	 * @param tradeno
	 * @param paidAmount
	 * @param payseqno
	 * @return
	 * @author leo
	 * @addTime 2015年9月7日下午4:50:01
	 */
	ResultCode<ValidateOpenApiPayVo> validateOpenApiPay(String appkey, String partnerServerIp, String tradeno, String paidAmount, String payseqno);
	
	/**
	 * 给订单新增礼品时，须先检查一些逻辑，然后根据返回的CheckAddOrderGoodsGiftRes，给订单新增礼品或者赠品
	 * @param tradeNo
	 * @param goodsid
	 * @param quantity
	 * @return
	 * @author leo
	 * @addTime 2016年9月12日下午4:10:18
	 */
	ResultCode<CheckAddOrderGoodsGiftRes> checkAddOrderGoodsGift(String tradeNo, Long goodsid, Integer quantity);
}

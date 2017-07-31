package com.gewara.api.service.goods;

import java.sql.Timestamp;
import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.goods.PreSalesOrderParams;
import com.gewara.api.vo.order.GewaOrderVo;

public interface GoodsOrderVoService {
	
	ResultCode<GewaOrderVo> addActivityGoodsOrder(Long goodsid, Long memberid, String realname, String address, String mobile, String origin, Integer quantity, String citycode);
	/**
	 * 增加partnerkey参数
	 * @param goodsid
	 * @param memberid
	 * @param realname
	 * @param address
	 * @param mobile
	 * @param origin
	 * @param quantity
	 * @param citycode
	 * @param partnerkey
	 * @return
	 */
	ResultCode<GewaOrderVo> addActivityGoodsOrderWithParnter(Long goodsid, Long memberid, String realname, String address, String mobile, String origin, Integer quantity, String citycode, String partnerkey);	

	/**
	 * 购买预售产品  (其中参数售以下字段)
	 * @param goodsid must
	 * @param memberid must
	 * @param addressId 地址id, optional
	 * @param category 分类, optional
	 * @param realname 用户名 optional
	 * @param address  送货地址 optional
	 * @param remark 备注
	 * @param mobile  must
	 * @param origin  来源，监控用, optional
	 * @param quantity must
	 * @param citycode must
	 * @return
	 * @throws Exception 
	 */
	ResultCode<GewaOrderVo> addPreGoodsOrder(PreSalesOrderParams params);
	
	/**
	 * 预售下单
	 * @param params
	 * @return
	 */
	ResultCode<GewaOrderVo> addPreGoodsOrderForWap(PreSalesOrderParams params);
	/**
	 * 物品交易成功订单数量
	 * @param tag
	 * @param relatedid
	 * @return
	 */
	ResultCode<Integer> getPaidSuccessOrderCount(String tag, Long relatedid);
	/**
	 * 物品交易成功和退款的订单
	 * @param activityid
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	ResultCode<List<GewaOrderVo>> getPaidSuccessAndReturnOrderList(String tag, Long activityid, Timestamp starttime, Timestamp endtime);
	
	/**
	 * 取消上一个未支付的物品订单
	 * @param params
	 * @return
	 */
	ResultCode cancelLastNotPaidGoodsOrder(Long memberid);
	/**
	 * 根据商品id、用户id获取订单信息
	 * @param goodsId
	 * @param memberid
	 * @return
	 */
	ResultCode<GewaOrderVo> getGewaOrderByGoods(Long goodsId, Long memberid);
	/**
	 * 查询订单成功数量
	 * @param goodsId
	 * @param memberid
	 * @param status
	 * @return
	 */
	ResultCode<Integer> getGewaOrderCount(Long goodsId, Long memberid, String status);
	/**
	 * 根据订单号查询订单信息
	 * @param tradeNo
	 * @deprecated 见gworder接口
	 * @see com.gewara.api.gworder.service.GwOrderService.getOrderByTradeNo
	 * @return
	 */
	@Deprecated
	ResultCode<GewaOrderVo> getGewaOrderByTradeNo(String tradeNo);
	/**
	 * 物品交易成功的订单
	 * @param tag
	 * @param activityid
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	ResultCode<List<GewaOrderVo>> getPaidSuccessOrderList(String tag, Long activityid, Timestamp starttime, Timestamp endtime);
	/**
	 * 查询订单信息
	 * @param goodsId
	 * @param status
	 * @return
	 */
	ResultCode<List<GewaOrderVo>> getOrderList(List<Long> goodsId, String status,String mobile, Integer from,Integer maxnum);
}

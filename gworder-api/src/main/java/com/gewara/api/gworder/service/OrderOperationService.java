package com.gewara.api.gworder.service;

import com.gewara.api.gworder.vo.CreateGoodsOrderReq;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.order.GewaOrderVo;
import com.gewara.api.vo.pay.OtherFeeDetailVo;

public interface OrderOperationService {
	
	/**
	 * 创建物品订单
	 * @param req 不可以为空
	 * @return
	 * @author leo
	 * @addTime 2016年8月3日下午5:32:42
	 */
	ResultCode<GewaOrderVo> createGoodsOrder(CreateGoodsOrderReq req);
	
	/**
	 * 保存快递费信息
	 * @param orderid 不可以为空
	 * @param otherfee 不可以为空
	 * @param expressPrice 不可以为空,快递费
	 * @param express 不可以为空
	 * @param otherFeeDetail 不可以为空
	 * @return
	 * @author leo
	 * @addTime 2016年8月3日下午5:32:56
	 */
	ResultCode<OtherFeeDetailVo> saveExpressFee(Long orderid, int otherfee, int expressPrice, String express, OtherFeeDetailVo otherFeeDetail);
	
	/**
	 * Drama,团销订单
	 * 物品拼团购买，团销时，设置快递express
	 * 
	 * @param orderid
	 * @param express
	 * @return
	 * @author leo
	 * @addTime 2016年8月3日下午6:23:29
	 */
	ResultCode changeDramaPreTypeTExpress(Long orderid, String express);
	

	/**
	 * 清除快递信息
	 * @param orderId 不可以为空
	 * @param takemethodID 可以为空
	 * @param express 可以为空
	 * @param otherfee 可以为空，大于等0时，修改
	 * @param otherFeeDetailId 可以为空
	 * @return
	 * @author leo
	 * @addTime 2016年8月4日下午2:20:19
	 */
	ResultCode clearExpressFee(Long orderId, String takemethodID, String express, int otherfee, Long otherFeeDetailId);
	
	/**
	 * 处理合作商支付结果通知
	 * @param appkey 合作商key
	 * @param partnerServerIp 合作商IP
	 * @param tradeno
	 * @param paidAmount
	 * @param payseqno
	 * @return
	 * @author leo
	 * @addTime 2016年8月8日下午2:26:57
	 */
	ResultCode partnerPayNotify(String appkey, String partnerServerIp, String tradeno, String paidAmount, String payseqno);
	
	/**
	 * 如果订单状态是STATUS_NEW，将修改成STATUS_NEW_CONFIRM</br>
	 * 同时修改payMethod为gewaPay
	 * @param orderid
	 * @return
	 * @author leo
	 * @addTime 2016年9月5日下午16:05:32
	 */
	ResultCode gewaPayToConfirm(Long orderid);
	
	/**
	 * 退电影票
	 * 
	 * @param tradeNo
	 * @return
	 * @author leo
	 * @addTime 2016年9月12日上午10:49:33
	 */
	ResultCode cancelRemoteTicket(String tradeNo);
	
	/**
	 * 删除电影订单BuyItem
	 * @param memberid
	 * @param itemid
	 * @return
	 * @author leo
	 * @addTime 2016年9月12日下午2:32:10
	 */
	ResultCode<GewaOrderVo> removeTicketOrderBuyItem(Long memberid, Long itemid);
}

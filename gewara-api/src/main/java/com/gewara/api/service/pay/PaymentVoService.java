package com.gewara.api.service.pay;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.pay.BSCardVo;
import com.gewara.api.vo.pay.DiscountVo;
import com.gewara.api.vo.pay.ElecCardBatchVo;
import com.gewara.api.vo.pay.ElecCardVo;
import com.gewara.api.vo.pay.OtherFeeDetailVo;
import com.gewara.api.vo.pay.PayMethodInfoVo;
import com.gewara.api.vo.pay.PayMethodVo;
import com.gewara.api.vo.pay.SpCodeVo;
import com.gewara.api.vo.pay.SpecialDiscountTagVo;

public interface PaymentVoService {
	
	/**
	 * 根据订单ID查询折扣
	 * @param orderId
	 * @return
	 */
	ResultCode<List<DiscountVo>> getDiscountByOrderId(Long orderId);
	
	/**
	 * 根据订单号查询折扣
	 * @param orderId
	 * @return
	 */
	ResultCode<List<DiscountVo>> getDiscountByTradeNo(String tradeNo);
	

	/**
	 * 根据订单ID查询其他费用明细
	 * @param orderId
	 * @return
	 */
	ResultCode<List<OtherFeeDetailVo>> getOtherFeeDetailByOrderId(Long orderId);
	
	
	/**
	 * 查询用户券数量
	 * @param memberid
	 * @return
	 */
	ResultCode<Integer> getCardCountByMemberid(Long memberid, String tag);
	
	/**
	 * 查询活动获得的券数量
	 * @param memberid
	 * @return
	 */
	ResultCode<Integer> getSpCodeCountByMemberid(Long memberid);
	/**
	 * 查询特价活动是否开始
	 * @param spid
	 * @return
	 */
	ResultCode<String> getSpdEnabledCommon(String citycode,Long spid);
	/**
	 * 获取用户有效的活动码
	 * @param memberid
	 * @param spid
	 * @param fromnum
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<SpCodeVo>> getSpCodeList(Long memberid, Long spid, int fromnum, int maxnum);
	
	/**
	 * 查询用户券列表
	 * @param memberid
	 * @param spid
	 * @param fromnum
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<ElecCardVo>> getCardListByMemberid(Long memberid, String tag, int fromnum, int maxnum);
	
	/**
	 * 查询优惠券
	 * @param cardid
	 * @return
	 */
	ResultCode<ElecCardVo> getElecCardVo(Long cardid);
	/**
	 * 查询活动码
	 * @param spCodeid
	 * @return
	 */
	ResultCode<SpCodeVo> getSpCodeVo(Long spCodeid);
	/**
	 * 查询特价活动的可下单数量
	 * @param spid
	 * @return
	 */
	ResultCode<Integer> getSpecialDiscountAllowaddnum(Long spid);
	
	/**
	 * 查询特价活动的可下单数量
	 * @param spid
	 * @return
	 */
	ResultCode<Integer> getSpecialDiscountAllowaddnumByFlag(String flag);
	
	/**
	 * 获取支付方式（使用优惠）
	 * @param appkey
	 * @param tradeNo
	 * @param discountId
	 * @param ukey
	 * @param remoteIp
	 * @param commonMap
	 * @return
	 */
	ResultCode<PayMethodInfoVo> showPayMethodList(String appkey, String tradeNo, Long discountId, String ukey, String remoteIp, Map<String, String> commonMap);
	
	ResultCode<PayMethodVo> getPayMethodById(String id);
	
	ResultCode<List<PayMethodVo>> getPayMethodListByIdList(String ... ids);
	
	/**
	 * 检查特价活动可购买数量
	 * @param appkey		appkey
	 * @param discountid	活动ID
	 * @param citycode		城市代码
	 * @param quantity		购买数量
	 * @return
	 */
	ResultCode<Integer> checkSpdiscountQuantity(String appkey, Long discountid, String citycode, Integer quantity);
	/**
	 * 估算当前选择的座位价格
	 * @param mpid
	 * @param seatLabel
	 * @param goodsid
	 * @param quantity
	 * @param discountid
	 * @return
	 */
	ResultCode<Integer> computerSeatAmount(String appkey,Long mpid, String seatLabel, Long goodsid, Integer quantity, Long discountid);
	/**
	 *  选座位是如果通过优惠频道进入，选座位时进行校验 计算价格
	 * @param appkey
	 * @param mpid
	 * @param seatLabel
	 * @param discountid
	 * @param memberEncode
	 * @return
	 */
	ResultCode<Integer> validateSpdiscountIsUse(String appkey, Long mpid, String seatLabel, Long discountid, String mobile, Integer totalfee,String secid, String encodeOrSessid, String remoteIps);
	/**
	 * 通过微信公众好支付，给用户充值
	 * @param toMemberid
	 * @param fromMemberid
	 * @param amount
	 * @param remoteIp
	 * @return
	 */
	ResultCode<Map<String, String>> getWxChargeParams(Long toMemberid, Long fromMemberid, Integer amount, String remoteIp);
	/**
	 * 获取SpecialDiscountTagList
	 * @return
	 */
	ResultCode<List<SpecialDiscountTagVo>> getSpecialDiscountTagList();
	
	/**
	 * 功能简述：获取可延期优惠券
	 * @param ebatchidList
	 * @return
	 */
	ResultCode<Map<String, String>> getDelayElecCardNoMap(List<Long> ebatchidList);
	
	/**
	 * 返回实际售出的名额控制数量
	 * spidList<=1000
	 * @param spidList
	 * @param citycode
	 * @return
	 */
	ResultCode<Map<Long, String>> spcounterSpecialDiscountStatus(List<Long> spidList, String citycode);
	
	/**
	 * 返回电子券批次列表
	 * spidList<=1000
	 * @param spidList
	 * @param citycode
	 * @return
	 */
	ResultCode<List<ElecCardBatchVo>> getElecCardBatchList(List<Long> batchidList);
	/**
	 * 根据用户ID获取商户联盟券
	 * @param memberid
	 * @return
	 */
	ResultCode<List<BSCardVo>> getBsCardListByMemberid(Long memberid, int fromnum, int maxnum);
	/**
	 * 根据用户ID获取商户联盟券
	 * @param id
	 * @return
	 */
	ResultCode<BSCardVo> getBsCardById(Long id);
	
	/**
	 * 根据特价的修改时间，查询特价
	 * @param updateStartTime
	 * @param updateEndTime
	 * @return
	 * @author leo
	 * @addTime 2015年11月24日下午2:56:48
	 */
	ResultCode<List<Map<String, Object>>> findPromotionList(Timestamp updateStartTime, Timestamp updateEndTime);
	/**
	 * 根据卡密找卡
	 * @param cardpass
	 */
	ResultCode<ElecCardVo> getElecCardByPass(String cardpass); 
	/**
	 * 根据卡号找卡
	 * @param cardno
	 */
	ResultCode<ElecCardVo> getElecCardByNo(String cardno);
}

package com.gewara.api.service.pay;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.pay.PromotionVo;

public interface PromotionVoService {
	/**
	 * 查询特殊优惠方案
	 * @param relatedid
	 * @return
	 */
	ResultCode<PromotionVo> getSpecialDiscount(Long relatedid);
	/**
	 * 查询特殊优惠方案
	 * @param relatedid
	 * @return
	 */
	ResultCode<PromotionVo> getSpecialDiscountByFlag(String flag);
	/**
	 * 手机端推荐的特价活动
	 * @param citycode
	 * @param partnerid
	 * @return
	 */
	ResultCode<List<PromotionVo>> getDefaultMobileSpecialDiscountList(String citycode, Long partnerid);
	/**
	 * 根据tag和开放类型查询特价活动
	 * @param tag
	 * @param opentype
	 * @return
	 */
	ResultCode<List<PromotionVo>> getSpecialDiscountList(String tag, String opentype);
	/**
	 * 查询一组
	 * @param relatedid
	 * @return
	 */
	ResultCode<List<PromotionVo>> getSpecialDiscountListByIds(Long ... relatedid);
	
	/**
	 * 查询一组
	 * @param relatedid
	 * @return
	 */
	ResultCode<List<PromotionVo>> getSpecialDiscountListByIdList(List<Long> idList);
	
}

package com.gewara.api.service.promotion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.pay.PromotionVo;
import com.gewara.cons.SalesPromotionConstant;

/**
 * Avatar提供的API
 * @author leo
 *
 */
public interface PromotionVoService {
	List<String> SUPPORT_TAGS = Arrays.asList("dramaSalesPromotion", "goodsBindMovieSalesPromotion", 
			"goodsSalesPromotion", "mallSalesPromotion","movieSalesPromotion","salesPromotion");
		
	public static final String TAG_PROMOTION_MAIN = "main";
	
	public static final Map<String, String> TAG_MAP = new HashMap<String, String>(){
		private static final long serialVersionUID = -2279863354234536215L;

		{
			put("dramaSalesPromotion", SalesPromotionConstant.TAG_DRAMA);
			put("goodsBindMovieSalesPromotion", SalesPromotionConstant.TAG_GOODSBINDMOVIE);
			put("goodsSalesPromotion", SalesPromotionConstant.TAG_GOODS);
			put("mallSalesPromotion", SalesPromotionConstant.TAG_MALL);
			put("movieSalesPromotion", SalesPromotionConstant.TAG_MOVIE);
			put("salesPromotion", TAG_PROMOTION_MAIN);
		}
		
	};
	
	
	/**
	 * 查询特价
	 * @param id 特价ID
	 * @return
	 * @author leo
	 * @addTime 2016年3月9日上午10:49:55
	 */
	ResultCode<PromotionVo> getPromotion(Long id);
	
	/**
	 * 
	 * 查询特价
	 * @param tag SalesPromotionConstant.TAG_*, PromotionVoService.TAG_PROMOTION_MAIN
	 * @param id 相关表ID
	 * 
	 * @author leo
	 * @addTime 2016年6月24日下午14:53:16
	 */
	ResultCode<PromotionVo> getPromotionByTag(String tag, Long id);
}

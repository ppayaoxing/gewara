/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.promotion;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.pay.PromotionVo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PromotionVoService {
	List<String> SUPPORT_TAGS = Arrays.asList(new String[] { "dramaSalesPromotion", "goodsBindMovieSalesPromotion",
			"goodsSalesPromotion", "mallSalesPromotion", "movieSalesPromotion", "salesPromotion" });
	String TAG_PROMOTION_MAIN = "main";
	Map<String, String> TAG_MAP = new HashMap() {
		private static final long serialVersionUID = -2279863354234536215L;

		{
			this.put("dramaSalesPromotion", "drama");
			this.put("goodsBindMovieSalesPromotion", "goodsbindmovie");
			this.put("goodsSalesPromotion", "goods");
			this.put("mallSalesPromotion", "mall");
			this.put("movieSalesPromotion", "movie");
			this.put("salesPromotion", "main");
		}
	};

	ResultCode<PromotionVo> getPromotion(Long arg0);

	ResultCode<PromotionVo> getPromotionByTag(String arg0, Long arg1);
}
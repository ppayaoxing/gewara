/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.pay;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.pay.PromotionVo;
import java.util.List;

public interface PromotionVoService {
	ResultCode<PromotionVo> getSpecialDiscount(Long arg0);

	ResultCode<PromotionVo> getSpecialDiscountByFlag(String arg0);

	ResultCode<List<PromotionVo>> getDefaultMobileSpecialDiscountList(String arg0, Long arg1);

	ResultCode<List<PromotionVo>> getSpecialDiscountList(String arg0, String arg1);

	ResultCode<List<PromotionVo>> getSpecialDiscountListByIds(Long... arg0);

	ResultCode<List<PromotionVo>> getSpecialDiscountListByIdList(List<Long> arg0);
}
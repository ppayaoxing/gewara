package com.gewara.api.gewampi.service;

import java.util.List;

import com.gewara.api.gewampi.vo.GoodsGiftVo;
import com.gewara.api.gewampi.vo.PartnerCloseRuleVo;
import com.gewara.api.vo.ResultCode;

public interface GewaMpiVoService {
	/**
	 * 获取屏蔽场次的规则
	 * @return
	 */
	ResultCode<PartnerCloseRuleVo> getPartnerCloseRuleVoById(Long id);
	/**
	 * 获取绑定的套餐列表
	 * @return
	 */
	ResultCode<List<GoodsGiftVo>> getGoodsGiftList();
	/**
	 * 获取绑定的套餐
	 * @param id
	 * @return
	 */
	ResultCode<GoodsGiftVo> getGoodsGiftById(Long id);
}

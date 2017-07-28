/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gewampi.service;

import com.gewara.api.gewampi.vo.GoodsGiftVo;
import com.gewara.api.gewampi.vo.PartnerCloseRuleVo;
import com.gewara.api.vo.ResultCode;
import java.util.List;

public interface GewaMpiVoService {
	ResultCode<PartnerCloseRuleVo> getPartnerCloseRuleVoById(Long arg0);

	ResultCode<List<GoodsGiftVo>> getGoodsGiftList();

	ResultCode<GoodsGiftVo> getGoodsGiftById(Long arg0);
}
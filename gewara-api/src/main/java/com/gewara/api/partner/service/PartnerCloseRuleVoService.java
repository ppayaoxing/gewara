/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.service;

import com.gewara.api.partner.res.vo.PartnerCloseRuleVo;
import com.gewara.api.vo.ResultCode;
import java.util.List;

public interface PartnerCloseRuleVoService {
	ResultCode<List<PartnerCloseRuleVo>> getCloseRuleListByCurrentTime();

	ResultCode<PartnerCloseRuleVo> getCloseRuleByRuleId(Long arg0);
}
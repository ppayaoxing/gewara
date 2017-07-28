/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.drama;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaCloseRuleVo;
import java.util.List;

public interface DramaCloseRuleAdminVoService {
	ResultCode<DramaCloseRuleVo> saveDramaCloseRule(RequestParamVo arg0);

	ResultCode<List<DramaCloseRuleVo>> getDramaCloseRuleList();

	ResultCode<DramaCloseRuleVo> getDramaCloseRuleById(Long arg0);

	ResultCode<String> validRule(String arg0, Long arg1, Long arg2);
}
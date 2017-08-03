package com.gewara.drama.admin.dubbo.drama;

import java.util.List;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaCloseRuleVo;

public interface DramaCloseRuleAdminVoService {
	
	ResultCode<DramaCloseRuleVo> saveDramaCloseRule(RequestParamVo paramVo);
	
	ResultCode<List<DramaCloseRuleVo>> getDramaCloseRuleList ();
	
	ResultCode<DramaCloseRuleVo> getDramaCloseRuleById(Long id);
	
	ResultCode<String> validRule(String appkey, Long dpid, Long ruleId);
	

}

package com.gewara.api.partner.service;

import java.util.List;

import com.gewara.api.partner.res.vo.PartnerCloseRuleVo;
import com.gewara.api.vo.ResultCode;



/**
 * 商户关闭规则
 */
public interface PartnerCloseRuleVoService {
	
	/**
	 * 获取大于当前时间的商户关闭规则
	 * @return
	 */
	ResultCode<List<PartnerCloseRuleVo>> getCloseRuleListByCurrentTime();
	
	/**
	 * 根据ID查询商户关闭规则
	 * @param ruleId
	 * @return
	 */
	ResultCode<PartnerCloseRuleVo> getCloseRuleByRuleId(Long ruleId);
}

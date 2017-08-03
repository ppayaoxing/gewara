package com.gewara.drama.dubbo.partner;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaCloseRuleVo;

public interface PartnerCloseVoService {

	/**
	 * 获取当前所有生效的过滤规则
	 * @return
	 */
	ResultCode<List<DramaCloseRuleVo>> getCloseList();
	
}

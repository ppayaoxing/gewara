package com.gewara.api.sns.qq;

import com.gewara.api.sns.vo.qq.TemplateMsgVo;
import com.gewara.api.vo.ResultCode;

public interface QQMessageApiService {
	
	ResultCode sendTemplateMsgByMobile(TemplateMsgVo template);

}

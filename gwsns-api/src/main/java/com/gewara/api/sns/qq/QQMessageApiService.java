/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.qq;

import com.gewara.api.sns.vo.qq.TemplateMsgVo;
import com.gewara.api.vo.ResultCode;

public interface QQMessageApiService {
	ResultCode sendTemplateMsgByMobile(TemplateMsgVo arg0);
}
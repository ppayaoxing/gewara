/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api.mobile;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.MobileUpData4SecurityVo;

public interface MobileUpData4SecurityVoService {
	ResultCode<MobileUpData4SecurityVo> getMobileUpData4SecurityByKey(String arg0);

	ResultCode saveOrUpdataMobileUpData4Security(MobileUpData4SecurityVo arg0);
}
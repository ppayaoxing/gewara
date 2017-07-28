/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.MemberVo;

public interface PartnerPinganfuVoService {
	ResultCode<MemberVo> pinganfuLogin(String arg0, String arg1, String arg2, String arg3);

	ResultCode<String> getLoginToken(Long arg0, String arg1);
}
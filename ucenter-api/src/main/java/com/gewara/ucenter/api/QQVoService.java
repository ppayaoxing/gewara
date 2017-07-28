/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.MemberVo;
import com.gewara.ucenter.vo.sns.QQUserVo;

public interface QQVoService {
	ResultCode<MemberVo> bindQQGewa(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5);

	ResultCode<MemberVo> getUserByCode(String arg0, String arg1, String arg2);

	ResultCode<QQUserVo> getQQUserByCode(String arg0, String arg1);

	ResultCode<QQUserVo> getQQUserByUserid(String arg0, String arg1, String arg2);

	ResultCode cancelQQUser(String arg0, String arg1);

	ResultCode<String> getAccessToken(String arg0);
}
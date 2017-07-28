/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api.member;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.MemberVo;
import com.gewara.ucenter.vo.member.WeixinUserVo;
import java.util.Map;

public interface WeixinVoService {
	ResultCode<MemberVo> bindWeixin2Gewa(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5);

	ResultCode<MemberVo> getUserByCode(String arg0, String arg1, String arg2);

	ResultCode<WeixinUserVo> getWeixinUserByCodeOnlyGet(String arg0, String arg1);

	ResultCode<WeixinUserVo> getWeixinUserByCode(String arg0, String arg1);

	ResultCode<WeixinUserVo> getWeixinUserByUserid(String arg0, String arg1, String arg2);

	ResultCode cancelWeixinUser(String arg0, String arg1);

	ResultCode<MemberVo> createMemberAndBindWeixinUser(String arg0, String arg1, String arg2, String arg3, String arg4);

	ResultCode<MemberVo> bindOpenMember2Member(String arg0, String arg1, String arg2, String arg3, String arg4,
			String arg5, String arg6);

	ResultCode<MemberVo> createOpenmemberByCodeOnlyOpenid(String arg0, String arg1, String arg2, String arg3);

	ResultCode<Map<String, Object>> bindMemberByCode(String arg0, String arg1, String arg2, String arg3);

	ResultCode<Map<String, Object>> mergerMember(String arg0, String arg1, String arg2);
}
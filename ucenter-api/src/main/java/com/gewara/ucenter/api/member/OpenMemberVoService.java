/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api.member;

import com.gewara.api.vo.ResultCode;
import com.gewara.support.ErrorCode;
import com.gewara.ucenter.vo.member.MemberRegInfoVo;
import com.gewara.ucenter.vo.member.MemberVo;
import com.gewara.ucenter.vo.member.OpenMemberVo;
import java.util.List;
import java.util.Map;

public interface OpenMemberVoService {
	ResultCode<OpenMemberVo> getOpenMemberByLoginname(String arg0, String arg1);

	ResultCode<MemberVo> partnerJointLogin(String arg0, String arg1, String arg2, String arg3);

	ResultCode<List<OpenMemberVo>> getOpenMemberListByMemberid(Long arg0);

	ResultCode<Map<Long, Map>> getOpenMemberByUidList(String arg0, List<String> arg1);

	ResultCode<List<OpenMemberVo>> getOpenMemberListByMemberidSource(Long arg0, String arg1);

	ResultCode<OpenMemberVo> updateOpenMember(OpenMemberVo arg0, String arg1, String[] arg2);

	@Deprecated
	ErrorCode<MemberRegInfoVo> regMemberWithMobile1(String arg0, String arg1, String arg2, String arg3, Long arg4,
			String arg5, String arg6, String arg7);

	@Deprecated
	ErrorCode<MemberRegInfoVo> createMemberWithBindMobile1(String arg0, String arg1, String arg2);

	ResultCode<MemberRegInfoVo> regMemberWithMobile2(String arg0, String arg1, String arg2, String arg3, Long arg4,
			String arg5, String arg6, String arg7);

	ResultCode<MemberRegInfoVo> createMemberWithBindMobile2(String arg0, String arg1, String arg2);

	ResultCode cancelOpenMemberBySource(Long arg0, String arg1, String arg2, Long arg3, String arg4);
}
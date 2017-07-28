/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api.member;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.MemberMergerHisVo;

public interface BindMemberVoService {
	ResultCode<MemberMergerHisVo> checkMemberApply(Long arg0);

	ResultCode mergerMember(Long arg0, Long arg1);

	ResultCode<MemberMergerHisVo> getMemberMergerHisVo(Long arg0);

	ResultCode updateMemberMergerHisBindStep(Long arg0, Long arg1, String arg2);
}
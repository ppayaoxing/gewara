/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api.member;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.MemberOperationVo;
import com.gewara.ucenter.vo.member.MemberVo;
import java.util.List;

public interface MemberAdminVoService {
	ResultCode<List<MemberOperationVo>> getMemberOperationVoList(MemberOperationVo arg0, Integer arg1, Integer arg2);

	ResultCode<String> getFixedKeywords();

	ResultCode<String> getManualKeywords();

	ResultCode<String> getMemberKeywords();

	ResultCode<Integer> getApplyMemberOperationCount();

	ResultCode saveOrUpdateMemberOperationVo(MemberOperationVo arg0);

	ResultCode<MemberVo> updateMemberPassword(MemberOperationVo arg0, Long arg1, String arg2);
}
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api.member;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.ShareMemberVo;
import java.util.List;

public interface ShareVoService {
	ResultCode sendShareInfo(String arg0, Long arg1, Long arg2, String arg3);

	ResultCode sendShareInfo(String arg0, Long arg1, Long arg2, String arg3, String arg4);

	ResultCode<List<ShareMemberVo>> getShareMemberByMemberid(List<String> arg0, Long arg1);

	ResultCode createShareMember(Long arg0, String arg1, String arg2, String arg3, String arg4, String arg5);

	ResultCode updateShareMemberRights(Long arg0, String arg1, String arg2);

	ResultCode removeShareMember(Long arg0);
}
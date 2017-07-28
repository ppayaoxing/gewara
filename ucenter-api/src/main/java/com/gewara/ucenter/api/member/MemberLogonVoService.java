/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api.member;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.MemberVo;
import java.sql.Timestamp;

public interface MemberLogonVoService {
	ResultCode<MemberVo> getLogonMemberBySessid(String arg0, String arg1);

	ResultCode<MemberVo> getLogonMemberByMemberEncodeAndIp(String arg0, String arg1);

	ResultCode<Long> getMemberIdByMemberEncode(String arg0);

	ResultCode<MemberVo> loginByNameAndPwd(String arg0, String arg1, String arg2, String arg3, String arg4);

	ResultCode<MemberVo> mobileReg(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5);

	ResultCode getRegDynamicNumber(String arg0, String arg1);

	ResultCode getModifyPwdDynamicNumber(String arg0, String arg1);

	ResultCode modifyPwdByDynamicNumber(String arg0, String arg1, String arg2, String arg3);

	ResultCode<String> sendLoginDynamiccode(String arg0, String arg1);

	ResultCode<MemberVo> loginByDynamiccode(String arg0, String arg1, String arg2, String arg3);

	ResultCode<MemberVo> openMemberLoginBySina(String arg0, String arg1, String arg2);

	ResultCode<MemberVo> openMemberLoginByBankcomm(String arg0, String arg1);

	ResultCode<MemberVo> openMemberLoginByJson(String arg0, String arg1, String arg2);

	ResultCode<MemberVo> openMemberLoginByEncrypt(String arg0, String arg1, String arg2);

	ResultCode<MemberVo> chubaoMemberLogin(String arg0, String arg1);

	ResultCode<MemberVo> doLoginByMemberEncode(String arg0, String arg1);

	ResultCode<MemberVo> doLoginByMemberEncode(String arg0, String arg1, String arg2);

	ResultCode<MemberVo> doMemberLogin4Api(String arg0, String arg1, String arg2);

	ResultCode<MemberVo> doMemberLogin4Api(String arg0, String arg1, String arg2, String arg3);

	ResultCode<MemberVo> doLoginByOpenMember(Long arg0, String arg1);

	ResultCode updateMemberAuth(String arg0, Long arg1);

	ResultCode doLogout(String arg0, String arg1);

	ResultCode<MemberVo> openMemberLoginByMD5(String arg0, String arg1, Timestamp arg2, String arg3, String arg4,
			String arg5);
}
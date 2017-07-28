/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.movie;

import com.gewara.api.vo.ResultCode;

public interface MemberSecurityVoService {
	ResultCode<Boolean> isSecurityVerify(String arg0, String arg1);

	ResultCode getSecurityVerifyCode(String arg0, String arg1, String arg2);

	ResultCode preCheckBindMobile(String arg0, String arg1, String arg2, String arg3);

	ResultCode addMemberSecurityVerify(String arg0, String arg1, String arg2);

	ResultCode getSecurityVerifyCode4NotBindMobile(String arg0, String arg1, String arg2);

	ResultCode getSecurityVerifyCode4BindMobile(String arg0, String arg1, String arg2);

	ResultCode checkSecurityVerify4Mobile(String arg0, String arg1, String arg2, String arg3);
}
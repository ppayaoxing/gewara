/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api.member;

import com.gewara.api.vo.ResultCode;

public interface BindMobileVoService {
	ResultCode refreshDynamicCode(String arg0, String arg1, String arg2);

	ResultCode refreshDynamicCode(String arg0, String arg1, String arg2, Long arg3);

	ResultCode refreshBindMobile1(String arg0, Long arg1, String arg2);

	ResultCode refreshBindMobile2(String arg0, Long arg1, String arg2, String arg3);

	ResultCode refreshChangeMobile(String arg0, Long arg1, String arg2);

	ResultCode checkBindMobile(String arg0, String arg1, Long arg2, String arg3);

	ResultCode checkDynamicCode(String arg0, String arg1, String arg2);

	ResultCode preCheckBindMobile(String arg0, String arg1, Long arg2, String arg3);

	ResultCode<Boolean> getAndUpdateToken(String arg0, String arg1, int arg2);

	ResultCode<Boolean> isNeedToken(String arg0, String arg1, int arg2);

	ResultCode refreshSMSValid(String arg0, String arg1);

	ResultCode refreshDynamicCode(String arg0, String arg1, String arg2, Long arg3, String arg4);
}
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api.member;

import com.gewara.support.ErrorCode;

public interface MobilVosByDubboService {
	ErrorCode<String> validateMobileCheckByTag(String arg0, String arg1, String arg2);

	ErrorCode<String> sendMobileCheckByTag(String arg0, String arg1, String arg2);
}
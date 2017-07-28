/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api.mobile;

import com.gewara.api.vo.ResultCode;

public interface ChangeCodeOptionVoService {

	@Deprecated
	void updateSendOptionsMessage(String arg0);

	ResultCode updateSendOptionsMessage2(String arg0);

	ResultCode resendMessageByAdmin(String arg0, String arg1);

	ResultCode resetSendCount(String arg0, Long arg1, boolean arg2);
}
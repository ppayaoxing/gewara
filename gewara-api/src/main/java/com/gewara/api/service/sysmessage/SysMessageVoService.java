/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.sysmessage;

import com.gewara.api.vo.ResultCode;

public interface SysMessageVoService {
	ResultCode<String> getSysMessageContentById(String arg0);

	ResultCode<String> reloadAcl();
}
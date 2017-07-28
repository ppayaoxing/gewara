/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.matrix;

import com.gewara.api.vo.ResultCode;

public interface WalaProcessVoService {
	ResultCode<Boolean> recogniseWala(String arg0);

	ResultCode<Boolean> addWalaSpam(Long arg0, String arg1, String arg2, String arg3);
}
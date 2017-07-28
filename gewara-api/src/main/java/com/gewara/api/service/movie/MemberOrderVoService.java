/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.movie;

import com.gewara.api.vo.ResultCode;

public interface MemberOrderVoService {
	ResultCode<Integer> getMemberOrderHis(Long arg0, String arg1);
}
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.membermerge;

import com.gewara.api.vo.ResultCode;
import java.util.Map;

public interface MemberMergeVoService {
	ResultCode<Map<String, Object>> getBindMemberInfo(Long arg0);

	ResultCode<String> bindSpCode(Long arg0, Long arg1, Long arg2);

	ResultCode<String> bindElecard(Long arg0, Long arg1, Long arg2);

	ResultCode<String> bindTreasure(Long arg0, Long arg1, Long arg2);

	ResultCode<String> bindMemberCount(Long arg0, Long arg1, Long arg2);

	ResultCode<Map<String, Object>> createCardTicket(String arg0, String arg1, String arg2);
}
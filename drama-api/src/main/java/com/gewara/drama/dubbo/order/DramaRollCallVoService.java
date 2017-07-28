/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.dubbo.order;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.req.CheckMultiDramaRollCallReq;
import com.gewara.drama.vo.req.CheckSimpleDramaRollCallReq;
import java.util.List;
import java.util.Map;

public interface DramaRollCallVoService {
	ResultCode dramaRollCallByDpid(String arg0, Long arg1, Long arg2, Long arg3, String arg4, Long arg5, Integer arg6);

	ResultCode checkSimpleDramaRollCall(CheckSimpleDramaRollCallReq arg0);

	ResultCode dramaRollCallByDpidList(String arg0, Long arg1, Long arg2, Long arg3, String arg4, List<Long> arg5,
			Map<Long, Integer> arg6);

	ResultCode checkMultiDramaRollCall(CheckMultiDramaRollCallReq arg0);

	ResultCode isDramaSpecialRollCallByPlaytime(Long arg0, Long arg1, Long arg2, String arg3, String arg4);
}
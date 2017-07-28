/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.movie;

import com.gewara.api.vo.ResultCode;
import java.util.List;

public interface QryResponseVoService {
	ResultCode removeLockSeatFromQryResponse(Long arg0, String arg1, List<String> arg2);

	ResultCode addLockSeatToQryResponse(Long arg0, String arg1, List<String> arg2);

	ResultCode<List<String>> updateRemoteLockSeat1(Long arg0, String arg1, String arg2, String arg3);

	ResultCode<List<String>> updateRemoteLockSeat2(Long arg0, String arg1, String arg2, String arg3, int arg4,
			boolean arg5);
}
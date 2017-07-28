/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.dubbo.order;

import com.gewara.api.vo.ResultCode;
import java.util.List;

public interface LockSeatVoService {
	ResultCode addLockSeatToSellDramaSeatResponse(Long arg0, List<String> arg1);

	ResultCode removeLockSeatToSellDramaSeatResponse(Long arg0, List<String> arg1);

	ResultCode addLockSeatToQryItemResponse(Long arg0, List<String> arg1);

	ResultCode addLockSeatToQryItemResponse(String arg0, Long arg1, List<String> arg2);

	ResultCode removeLockSeatFromQryItemResponse(Long arg0, List<String> arg1);

	ResultCode removeLockSeatFromQryItemResponse(String arg0, Long arg1, List<String> arg2);

	ResultCode<List<String>> updateRemoteLockSeat(Long arg0, int arg1, boolean arg2);

	ResultCode<List<String>> updateRemoteLockSeat(String arg0, Long arg1, int arg2, boolean arg3);

	ResultCode<List<String>> updateRemoteUnLockPrice(Long arg0, int arg1, boolean arg2);

	ResultCode<List<String>> updateRemoteUnLockPrice(String arg0, Long arg1, int arg2, boolean arg3);
}
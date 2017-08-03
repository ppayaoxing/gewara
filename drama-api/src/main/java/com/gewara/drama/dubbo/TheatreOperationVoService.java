package com.gewara.drama.dubbo;

import java.util.Collection;
import java.util.List;

import com.gewara.api.vo.ResultCode;

public interface TheatreOperationVoService {
	
	
	ResultCode<List<String>> updateRemoteLockSeat(Long areaid, int expireSeconds, boolean refresh);
	ResultCode<List<String>> updateRemoteLockSeat(String usertype, Long areaid, int expireSeconds, boolean refresh);
	
	ResultCode<List<String>> updateRemoteUnLockPrice(Long areaid, int expireSeconds, boolean refresh);
	ResultCode<List<String>> updateRemoteUnLockPrice(String usertype, Long areaid, int expireSeconds, boolean refresh);
	
	ResultCode addLockSeatToQryItemResponse(Long areaid, Collection<String> seatList);
	ResultCode addLockSeatToQryItemResponse(String usertype, Long areaid, Collection<String> seatList);

	ResultCode removeLockSeatFromQryItemResponse(Long areaid, List<Long> seatList);
	ResultCode removeLockSeatFromQryItemResponse(String usertype, Long areaid, List<Long> seatList);


}

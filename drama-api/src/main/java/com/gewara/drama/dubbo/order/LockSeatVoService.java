package com.gewara.drama.dubbo.order;

import java.util.List;

import com.gewara.api.vo.ResultCode;

public interface LockSeatVoService {
	
	
	ResultCode addLockSeatToSellDramaSeatResponse(Long areaid, List<String> sellSeatList);
	ResultCode removeLockSeatToSellDramaSeatResponse(Long areaid, List<String> sellSeatList);
	
	ResultCode addLockSeatToQryItemResponse(Long areaid, List<String> seatList);
	ResultCode addLockSeatToQryItemResponse(String usertype, Long areaid, List<String> seatList);
	
	ResultCode removeLockSeatFromQryItemResponse(Long areaid, List<String> seatList);
	ResultCode removeLockSeatFromQryItemResponse(String usertype, Long areaid, List<String> seatList);
	
	ResultCode<List<String>> updateRemoteLockSeat(Long areaid, int expireSeconds, boolean refresh);
	ResultCode<List<String>> updateRemoteLockSeat(String usertype, Long areaid, int expireSeconds, boolean refresh);
	
	ResultCode<List<String>> updateRemoteUnLockPrice(Long areaid, int expireSeconds, boolean refresh);
	ResultCode<List<String>> updateRemoteUnLockPrice(String usertype, Long areaid, int expireSeconds, boolean refresh);
	
}

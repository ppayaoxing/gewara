package com.gewara.drama.dubbo.untrans;

import java.util.List;

import com.gewara.drama.vo.untrans.TheatreSeatAreaVo;
import com.gewara.support.ErrorCode;

public interface LockSeatCacheVoService {
	ErrorCode<List<String>> updateRemoteUnLockPrice(String usertype, TheatreSeatAreaVo seatArea, int expireSeconds, boolean refresh);
}

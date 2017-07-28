/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.dubbo.untrans;

import com.gewara.drama.vo.untrans.TheatreSeatAreaVo;
import com.gewara.support.ErrorCode;
import java.util.List;

public interface LockSeatCacheVoService {
	ErrorCode<List<String>> updateRemoteUnLockPrice(String arg0, TheatreSeatAreaVo arg1, int arg2, boolean arg3);
}
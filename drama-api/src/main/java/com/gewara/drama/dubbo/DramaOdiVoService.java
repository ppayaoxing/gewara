/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.dubbo;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaVo;
import java.util.List;

public interface DramaOdiVoService {
	ResultCode<Integer> getDramaCountByCitycode(String arg0);

	ResultCode<List<DramaVo>> getDramaListByCitycode(String arg0, int arg1, int arg2);

	ResultCode<List<Long>> getDramaIdListByCitycode(String arg0, String arg1);

	ResultCode<List<DramaVo>> getDramaListByTheatreid(Long arg0, int arg1, int arg2);
}
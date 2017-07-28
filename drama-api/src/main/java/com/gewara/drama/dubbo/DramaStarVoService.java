/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.dubbo;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaStarVo;
import java.util.Collection;
import java.util.List;

public interface DramaStarVoService {
	ResultCode<DramaStarVo> getDramaStarById(Long arg0);

	ResultCode<List<DramaStarVo>> getDramaStarList(Collection<Long> arg0);

	ResultCode<List<DramaStarVo>> getStarListByStateAndName(String arg0, String arg1, String arg2, int arg3, int arg4);

	ResultCode<List<DramaStarVo>> getDramaStarListByDramaid(Long arg0, String arg1, int arg2, int arg3, String... arg4);
}
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.dubbo;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.cmd.DramaOpusVo;
import java.util.List;

public interface DramaOpusVoService {
	ResultCode<DramaOpusVo> getOpusById(Long arg0);

	ResultCode<List<DramaOpusVo>> getOpusListByDramaId(Long arg0);
}
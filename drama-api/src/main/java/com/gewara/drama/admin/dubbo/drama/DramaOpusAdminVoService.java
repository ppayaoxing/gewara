/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.drama;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.cmd.DramaOpusVo;
import java.util.List;

public interface DramaOpusAdminVoService {
	ResultCode<DramaOpusVo> getDramaOpusById(Long arg0);

	ResultCode<List<DramaOpusVo>> getDramaOpusListByDramaid(Long arg0);

	ResultCode<DramaOpusVo> saveDramaOpus(RequestParamVo arg0);

	ResultCode delDramaOpus(Long arg0);
}
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.drama;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaRaidersVo;
import java.util.List;

public interface DramaRaidersAdminVoService {
	ResultCode<DramaRaidersVo> getDramaRaidersById(Long arg0);

	ResultCode<List<DramaRaidersVo>> getDramaRaidersListByDramaid(Long arg0);

	ResultCode<DramaRaidersVo> saveDramaRaiders(RequestParamVo arg0);

	ResultCode delDramaRaiders(Long arg0);
}
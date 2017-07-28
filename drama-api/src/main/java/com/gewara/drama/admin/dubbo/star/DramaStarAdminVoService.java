/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.star;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaStarVo;
import java.util.List;

public interface DramaStarAdminVoService {
	ResultCode<DramaStarVo> getDramaStarById(Long arg0);

	ResultCode<List<DramaStarVo>> getDramaStarList(Long... arg0);

	ResultCode<List<DramaStarVo>> getStarListByStateAndName(RequestParamVo arg0);

	ResultCode<List<DramaStarVo>> getDramaStarListByDramaid(RequestParamVo arg0);

	ResultCode setStarHotValue(RequestParamVo arg0);

	ResultCode<Integer> getStarCountByName(RequestParamVo arg0);

	ResultCode<List<DramaStarVo>> getStarListByName(RequestParamVo arg0);

	ResultCode<DramaStarVo> saveStar(RequestParamVo arg0);

	ResultCode<List<DramaStarVo>> saveAttachTroupe(RequestParamVo arg0);

	ResultCode<List<DramaStarVo>> getTroupeStarList();
}
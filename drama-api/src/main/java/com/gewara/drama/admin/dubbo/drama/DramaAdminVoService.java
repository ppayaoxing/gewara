/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.drama;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaVo;
import java.util.Collection;
import java.util.List;

public interface DramaAdminVoService {
	ResultCode saveDramaProperty(RequestParamVo arg0);

	ResultCode setDramaHotValue(RequestParamVo arg0);

	ResultCode delDramaProperty(RequestParamVo arg0);

	ResultCode<DramaVo> saveDrama(RequestParamVo arg0);

	ResultCode<DramaVo> refreshDramaOtherinfo(Long arg0);

	ResultCode refreshDramaList(String arg0);

	ResultCode refreshDramaPrice(Long arg0);

	ResultCode<List<DramaVo>> getDramaListByIdList(Collection<Long> arg0);

	ResultCode<DramaVo> getDramaById(Long arg0);

	ResultCode<List<DramaVo>> getDramaListByName(String arg0);

	ResultCode<List<DramaVo>> getDramaListByCitycode(RequestParamVo arg0);

	ResultCode<List<DramaVo>> getDramaListByPlace(Long arg0);

	ResultCode<List<Long>> getDramaIdListByReserve();

	ResultCode<DramaVo> getDramaByName(String arg0);

	ResultCode<List<Long>> getDramaIdExpireListByTheatreidCache(Long arg0);
}
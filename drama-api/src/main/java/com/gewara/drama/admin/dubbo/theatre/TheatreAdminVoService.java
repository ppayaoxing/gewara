/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.theatre;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreProfileVo;
import com.gewara.drama.vo.TheatreToDramaVo;
import com.gewara.drama.vo.TheatreVo;
import java.util.Collection;
import java.util.List;

public interface TheatreAdminVoService {
	ResultCode setTheatreHotValue(RequestParamVo arg0);

	ResultCode<TheatreVo> saveOrUpdateTheatre(RequestParamVo arg0);

	ResultCode<TheatreVo> getTheatreById(Long arg0);

	ResultCode<List<TheatreVo>> getTheatreListByCitycode(RequestParamVo arg0);

	ResultCode<Integer> getTheatreToDramaCountByTheatreid(Long arg0);

	ResultCode<List<TheatreToDramaVo>> getTheatreToDramaListByTheatreid(RequestParamVo arg0);

	ResultCode<List<TheatreVo>> getTheatreList(Collection<Long> arg0);

	ResultCode<TheatreProfileVo> getTheatreProfileById(Long arg0);

	ResultCode<List<TheatreProfileVo>> getTheatreProfileList(Collection<Long> arg0);

	ResultCode<TheatreProfileVo> saveOrUpdateTheatreProfile(RequestParamVo arg0);

	ResultCode<List<Long>> getRermoteTheatreProfileIdList(String arg0);

	ResultCode<List<TheatreVo>> getTheatreListOrderByDramaNum(String arg0, int arg1, int arg2);

	ResultCode<List<TheatreVo>> getTheatreList(String arg0, boolean arg1, int arg2, int arg3);
}
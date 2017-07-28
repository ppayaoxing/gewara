/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.schedule;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreToDramaVo;
import java.io.Serializable;
import java.util.List;

public interface TheatreToDramaAdminVoService {
	ResultCode<TheatreToDramaVo> getTheatreToDramaById(Long arg0);

	ResultCode delTheatreToDrama(Long arg0);

	ResultCode changeSortnum(Long arg0, Integer arg1);

	ResultCode<TheatreToDramaVo> saveTheatreToDrama(RequestParamVo arg0);

	ResultCode<List<TheatreToDramaVo>> getTheatreToDramaByField(String arg0, Serializable arg1);

	ResultCode<List<TheatreToDramaVo>> getTheatreToDramaListByTheatreid(Long arg0, Integer arg1, Integer arg2);
}
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.admin;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.CinemaProfileVo;
import java.io.Serializable;
import java.util.List;

public interface CinemaProfileAdminVoService {
	ResultCode<CinemaProfileVo> saveOrUpdateCinemaProfile(RequestParamVo arg0);

	ResultCode<CinemaProfileVo> updateCinemaProfileProperties(Long arg0, Long arg1, String[] arg2, Serializable[] arg3);

	ResultCode<List<CinemaProfileVo>> batchSetCinemaInsureStatus(Long arg0, String arg1, String arg2);

	ResultCode<CinemaProfileVo> setCinemaInsureStatus(Long arg0, Long arg1, String arg2);

	ResultCode<CinemaProfileVo> cleanCinemaInfo(Long arg0);

	ResultCode<CinemaProfileVo> getCinemaProfileById(Long arg0);
}
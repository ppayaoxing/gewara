/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gewampi.service;

import com.gewara.api.gewampi.vo.MovieItemVo;
import com.gewara.api.vo.ResultCode;
import java.util.Date;
import java.util.List;

public interface GewampiPartnerPlayItemVoService {
	ResultCode<List<MovieItemVo>> getMpiVoList(String arg0, Long arg1, Long arg2, Date arg3, Long arg4);

	ResultCode<List<Date>> openDateList(String arg0, String arg1, Long arg2, Long arg3, Long arg4);

	ResultCode<List<Long>> getCurMovieByCinemaId(String arg0, String arg1, Long arg2, Long arg3);

	ResultCode<List<MovieItemVo>> get0AmOpiList(Long arg0, Long arg1, Long arg2, Date arg3);
}
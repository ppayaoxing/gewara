/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.admin;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.MovieVo;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface MovieAdminVoService {
	ResultCode<List<MovieVo>> getOpiMovieList(String arg0, Long arg1, Date arg2);

	ResultCode<List<MovieVo>> getMovieListFirstLetterSort(Long arg0);

	ResultCode<MovieVo> saveOrUpdateMovie(RequestParamVo arg0, boolean arg1);

	ResultCode<MovieVo> updateMovieProperties(Long arg0, String[] arg1, Serializable[] arg2);

	ResultCode<MovieVo> saveMovieAndRelatedObject(RequestParamVo arg0);

	ResultCode<List<MovieVo>> getMovieListByUpdateTimeLeDateTime(Timestamp arg0);

	ResultCode updateOtherInfoByMovieIds(String arg0, String arg1);
}
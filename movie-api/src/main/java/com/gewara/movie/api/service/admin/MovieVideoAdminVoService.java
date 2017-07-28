/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.admin;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.MovieVideoVo;

public interface MovieVideoAdminVoService {
	ResultCode<MovieVideoVo> saveOrUpdateMovieVideo(Long arg0, String arg1, String arg2);

	ResultCode<MovieVideoVo> removeMovieVideoByVideoid(String arg0);

	ResultCode<MovieVideoVo> getMovieVideoByVideoid(String arg0);
}
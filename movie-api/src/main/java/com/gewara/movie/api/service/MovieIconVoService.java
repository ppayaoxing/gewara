/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.MovieIconVo;
import java.util.List;

public interface MovieIconVoService {
	ResultCode<List<MovieIconVo>> getMovieIconListByMovieId(Long arg0);

	ResultCode<MovieIconVo> getMovieIconById(String arg0);

	ResultCode removieMovieIconById(String arg0);

	ResultCode<MovieIconVo> saveOrUpdateMovieIcon(MovieIconVo arg0);
}
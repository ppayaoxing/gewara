/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.admin;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.CinemaVo;
import com.gewara.movie.vo.MovieVo;
import java.util.List;

public interface MovieChkDataVoService {
	ResultCode<List<CinemaVo>> getCinemaListByCountyisnull();

	ResultCode<List<MovieVo>> getMovieListByPrevideoisnull();
}
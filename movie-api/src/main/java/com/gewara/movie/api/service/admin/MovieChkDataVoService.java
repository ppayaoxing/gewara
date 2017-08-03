package com.gewara.movie.api.service.admin;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.CinemaVo;
import com.gewara.movie.vo.MovieVo;

public interface MovieChkDataVoService {

	/**
	 * 查询未设置区县的影院
	 * @return
	 */
	ResultCode<List<CinemaVo>> getCinemaListByCountyisnull();
	
	/**
	 * 查询未设置视频的影片
	 * @return
	 */
	ResultCode<List<MovieVo>> getMovieListByPrevideoisnull();
}

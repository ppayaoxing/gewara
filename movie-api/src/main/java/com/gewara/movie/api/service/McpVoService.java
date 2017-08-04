package com.gewara.movie.api.service;

import java.util.Date;
import java.util.List;

import com.gewara.api.vo.BaseVo;
import com.gewara.api.vo.ResultCode;

/**
 * @author sunder
 *
 */
public interface McpVoService {

	<T extends BaseVo> ResultCode<T> getOpenPlayItemVoById(Long mpid);

	<T extends BaseVo> ResultCode<List<T>> getCurCinemaPlayDate(long cinemaId, boolean includeMcpCount);

	<T extends BaseVo> ResultCode<List<T>> getMovieList(Long cinemaId, Date playDate);

	<T extends BaseVo> ResultCode<List<T>> getCinemaMoviePlayItem(long cinemaId, Long movieId, Date playDate);

	<T extends BaseVo> ResultCode<List<T>> getCurMovieList();

}

package com.gewara.movie.api.service;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.MovieIconVo;

public interface MovieIconVoService {
	/**
	 * 根据movieId获取IconList
	 * @param movieid
	 * @return
	 */
	ResultCode<List<MovieIconVo>> getMovieIconListByMovieId(Long movieId);
	/**
	 *根据ID获取MovieIcon
	 * @param id
	 * @return
	 */
	ResultCode<MovieIconVo> getMovieIconById(String id);
	/**
	 * 根据ID删除MovieIcon
	 * @param id
	 * @return
	 */
	ResultCode removieMovieIconById(String id);
	/**
	 * 增加或者删除MovieIcon
	 * @param movieIconVo
	 * @return
	 */
	ResultCode<MovieIconVo> saveOrUpdateMovieIcon(MovieIconVo movieIconVo);
	
}

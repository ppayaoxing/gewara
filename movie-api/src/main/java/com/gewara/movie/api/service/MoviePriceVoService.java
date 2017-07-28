/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.MoviePriceVo;
import com.gewara.movie.vo.MovieTierPriceVo;
import com.gewara.movie.vo.MovieVo;
import java.util.List;
import java.util.Map;

public interface MoviePriceVoService {
	ResultCode<List<MoviePriceVo>> getMoviePriceListByMovieIdList(List<Long> arg0);

	ResultCode<List<MoviePriceVo>> getMoviePriceListByCinemaIdAndMovieIdList(Long arg0, List<Long> arg1);

	ResultCode<List<MovieVo>> getMovieListAndCheckMovieTierPriceIsNotNull(List<Long> arg0);

	ResultCode<Map> getMovieTierPriceTypeMapByMovieidList(List<Long> arg0);

	ResultCode<List<MoviePriceVo>> getDiffMoviePriceList(String arg0);

	ResultCode<Map<Long, MovieTierPriceVo>> getMovieTierPriceMapByCitycode(String arg0);

	ResultCode<MoviePriceVo> getMoviePriceByMovieidAndCinemaId(Long arg0, Long arg1);

	ResultCode<Map<String, MoviePriceVo>> getMoviePriceDataMap(List<Map<String, Long>> arg0);

	ResultCode<MoviePriceVo> getMoviePriceByMovieIdAndCityCode(Long arg0, String arg1);

	ResultCode<List<MovieTierPriceVo>> getMovieTierPriceList(Long arg0);

	ResultCode<MovieTierPriceVo> getMovieTierPriceByMovieIdAndType(Long arg0, String arg1);

	ResultCode saveMovieTierPrice(MovieTierPriceVo arg0);

	ResultCode saveMovieTierPriceList(List<MovieTierPriceVo> arg0);

	ResultCode saveMoviePrice(MoviePriceVo arg0);

	ResultCode<List<String>> syncMoviePriceToCinema(MovieVo arg0, List<Map> arg1, String arg2, Long arg3);

	ResultCode<List<String>> synchMoviePrice(MovieVo arg0, List<Map> arg1, String arg2, Long arg3);
}
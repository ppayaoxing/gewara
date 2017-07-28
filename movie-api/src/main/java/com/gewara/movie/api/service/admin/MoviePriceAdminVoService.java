/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.admin;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.MoviePriceVo;
import com.gewara.movie.vo.MovieTierPriceVo;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface MoviePriceAdminVoService {
	ResultCode<MoviePriceVo> saveMovieLowestPrice(RequestParamVo arg0);

	ResultCode<MoviePriceVo> setMoviePrice(RequestParamVo arg0);

	ResultCode<List<String>> syncMoviePriceByCurMovieIdList(List<Long> arg0, Long arg1, String arg2, Long arg3);

	ResultCode<Integer> upgradeCinemaPrice(List<Map> arg0);

	ResultCode<List<String>> batchSyncMoviePriceByMids(String arg0, String arg1, Long arg2);

	ResultCode<List<String>> syncMoviePriceToCinemaByCurMovieIdList(List<Long> arg0, String arg1);

	ResultCode<List<String>> batchSyncMoviePriceToCinemaByMids(String arg0, String arg1, Long arg2);

	ResultCode<MovieTierPriceVo> saveMovieTierPrice(Long arg0, String arg1, Map<String, String> arg2);

	ResultCode<List<MovieTierPriceVo>> saveMoviePriceTierTime(Long arg0, Timestamp arg1, Timestamp arg2);
}
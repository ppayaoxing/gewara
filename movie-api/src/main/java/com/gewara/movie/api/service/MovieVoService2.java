/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.MovieVideoVo;
import com.gewara.movie.vo.MovieVo;
import com.gewara.movie.vo.common.EntityClobVo;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface MovieVoService2 {
	ResultCode<MovieVo> getMovieById(Long arg0);

	ResultCode<MovieVo> getMovieByUkey(String arg0, Serializable arg1);

	ResultCode<List<MovieVo>> getMovieListByIdList(List<Long> arg0);

	ResultCode<List<MovieVo>> getMovieListByIdListWithOutCache(List<Long> arg0);

	ResultCode<EntityClobVo> getMovieEntityClob(Long arg0);

	ResultCode<List<MovieVo>> getFutureMovieList(int arg0, int arg1, String arg2);

	ResultCode<List<MovieVo>> getCurMovieList();

	ResultCode<List<MovieVo>> getCurMovieListByCitycode(String arg0, int arg1, int arg2);

	ResultCode<List<Long>> getMovieListByReleasedate(Date arg0, Date arg1);

	ResultCode<List<MovieVo>> getCurMovieListByCitycodeOrderClickedtimes(String arg0);

	ResultCode<Long> refreshQzMovieid();

	ResultCode<Integer> getMovieCountByidAndName(Long arg0, String arg1);

	ResultCode<List<MovieVo>> getMovieListByMovieName(String arg0);

	ResultCode<List<MovieVo>> getMovieListByLikeMovieName(String arg0);

	ResultCode<List<MovieVo>> getOffLineMoveList(String arg0, String arg1);

	ResultCode<List<MovieVo>> getAdminMovieList(String arg0, String arg1, Date arg2, Date arg3);

	ResultCode<List<MovieVo>> getMovieListByDate(String arg0, String arg1);

	ResultCode<List<MovieVo>> getCurMovieListByCinemaId(Long arg0);

	ResultCode<List<MovieVo>> getCurMovieListByCinemaIdAndDate(Long arg0, Date arg1);

	ResultCode<List<MovieVo>> getMovieListByDateAndPage(String arg0, String arg1, int arg2, int arg3);

	ResultCode<Integer> countMovieListByDate(String arg0, String arg1);

	ResultCode<MovieVideoVo> getMovieVideoByMovieId(Long arg0);

	ResultCode<MovieVideoVo> getMovieVideoByVideoid(String arg0);

	ResultCode<List<Long>> checkMovieExist(List<Long> arg0);

	ResultCode<List<Long>> getFilmFestMovieIdList(String arg0);

	ResultCode<Map<String, Object>> getHotMovieAndStar(String arg0, Long arg1, Date arg2);

	ResultCode<List<MovieVo>> getMovieList(Integer arg0, Integer arg1);

	ResultCode<Integer> getAllMovieCount();

	ResultCode<List<Long>> getMpidListByMovieidAndStarmeet(Long arg0);

	ResultCode<List<Map>> getFieldsMapByUpdate(String arg0, Timestamp arg1, int arg2, int arg3);

	ResultCode<List<Map<String, Object>>> getStarListByMovieId(Long arg0);

	ResultCode<MovieVo> updateMovieProperties(Long arg0, String[] arg1, Serializable[] arg2);

	ResultCode<List<MovieVo>> getCurMovieListByDate(Date arg0);

	ResultCode<List<MovieVo>> getCurMovieListByDate(String arg0, Date arg1, int arg2, int arg3);

	ResultCode<List<MovieVo>> getMovieListBetweenPlaydate(String arg0, String arg1);

	ResultCode<List<MovieVo>> getMovieListBetweenReleasedate(Date arg0, Date arg1, String arg2);

	ResultCode<String> getSearchMovieOrderReleasedate();

	ResultCode<String> getMovieMark(Long arg0);

	ResultCode<Long> getCacheMovieIdByMoviename(String arg0);

	ResultCode<List<Long>> getMovieListByUpdatetime(Timestamp arg0, int arg1, int arg2);
}
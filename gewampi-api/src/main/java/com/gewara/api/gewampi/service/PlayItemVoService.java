/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gewampi.service;

import com.gewara.api.gewampi.vo.MovieItemVo;
import com.gewara.api.vo.ResultCode;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PlayItemVoService {
	ResultCode<List<Date>> findPlayDateByCityCodeAndMovieId(String arg0, Long arg1);

	ResultCode<List<Long>> findCinemaIdByCityCodeAndMovieIdAndPlayDate(String arg0, Long arg1, Date arg2);

	ResultCode<List<MovieItemVo>> findByMovieIdAndPlayDateAndCinemaId(Long arg0, Date arg1, Long arg2);

	ResultCode<List<MovieItemVo>> findByCitycodeCinemaidMovieidPlaydate(String arg0, Long arg1, Long arg2, Date arg3);

	ResultCode<List<Date>> findPlayDateByCinemaId(Long arg0);

	ResultCode<List<Long>> findMovieIdByCinemaIdAndPlayDate(Long arg0, Date arg1);

	ResultCode<List<Date>> findPlayDateByCityCode(String arg0);

	ResultCode<List<Long>> findMovieIdByCityCode(String arg0);

	ResultCode<List<Long>> findAllMovieIdList();

	ResultCode<List<MovieItemVo>> findMidNightByMovieIdAndPlayDateAndCinemaId(Long arg0, Date arg1, Long arg2);

	ResultCode<Map<String, Integer>> findPriceInfoByMovieIdAndCinemaIdAndCityCode(Long arg0, Long arg1, String arg2);

	ResultCode<Integer> findMovieCountByCityCode(String arg0);

	ResultCode<Integer> findMovieCount(String arg0, Long arg1, Date arg2);

	ResultCode<List<Long>> findCinemaIdByCountycodeAndMovieIdAndPlayDate(String arg0, Long arg1, Date arg2);

	ResultCode<Integer> findCinemaCountByCityCodeAndMovieId(String arg0, Long arg1);

	ResultCode<Integer> findCinemaCount(String arg0, Long arg1, Date arg2);

	ResultCode<List<Long>> findOpiMovieIdList(String arg0, Long arg1, Date arg2);

	ResultCode<List<Date>> findPlayDateByCinemaIdAndMovieId(Long arg0, Long arg1);

	ResultCode<Integer> findPlayItemCount(String arg0, Long arg1, Long arg2, Date arg3);

	@Deprecated
	ResultCode<Integer> findPlayItemCount(String arg0, Long arg1, Long arg2, Date arg3, Date arg4);

	ResultCode<Integer> findPlayItemCount2(String arg0, Long arg1, Long arg2, Date arg3, Date arg4);

	ResultCode<List<Map<String, Long>>> findMovieMpiCountList(String arg0, Date arg1, Long arg2);

	ResultCode<List<MovieItemVo>> findOpiByRoomid(Long arg0);

	ResultCode<List<MovieItemVo>> findByCityCodeAndCinemaIdAndMovieId(String arg0, Long arg1, Long arg2, Timestamp arg3,
			Timestamp arg4);

	ResultCode<List<Long>> findCharacteristicRoomIdList(Long arg0);

	ResultCode<List<Long>> findOpiCinemaIdList(String arg0, Long arg1, Date arg2);

	ResultCode<List<Long>> findOpiCinemaIdList(String arg0, Long arg1, Date arg2, String arg3);

	ResultCode<List<Date>> findOpiPlayDateByCityCodeAndMovieId(String arg0, Long arg1);

	ResultCode<List<Date>> findOpiPlayDateByCinemaIdAndMovieId(Long arg0, Long arg1);

	ResultCode<List<Long>> findOpiMovieIdByCityCode(String arg0);

	ResultCode<Integer> findOpiPlayItemCount(String arg0, Long arg1, Long arg2, Date arg3);

	ResultCode<List<Map<String, Object>>> findMpiCountGroupByPlaydate(String arg0, Long arg1, Long arg2);

	ResultCode<MovieItemVo> findByMpid(Long arg0);

	ResultCode<List<MovieItemVo>> findByMpidList(List<Long> arg0);

	@Deprecated
	ResultCode<List<Long>> findCharacteristicRoomIdList(String arg0, Long arg1, Date arg2);

	ResultCode<List<Long>> findCharacteristicRoomIdList2(String arg0, Long arg1, Date arg2);

	ResultCode<List<MovieItemVo>> findOpiList(Long arg0, Date arg1, Long arg2);

	@Deprecated
	ResultCode<List<MovieItemVo>> findOpiList(Long arg0, Timestamp arg1);

	ResultCode<List<MovieItemVo>> findOpiListByCinemaidAndStartPlaytime(Long arg0, Timestamp arg1);

	ResultCode<List<Long>> getCinemaidListByCitycode(Long arg0, String arg1);

	ResultCode<List<Long>> getMovieidListByCinemaid(Long arg0, Long arg1);

	ResultCode<List<Date>> getPlaydatedListByCinemaidAndMovieid(Long arg0, Long arg1, Long arg2);

	ResultCode<List<MovieItemVo>> findListByUpdateTime(Long arg0, Timestamp arg1);

	ResultCode<List<Long>> findCinemaIdByCharacteristic(String arg0, String arg1, Long arg2, Date arg3);
}
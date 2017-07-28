/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gewampi.service;

import com.gewara.api.gewampi.vo.MovieItemVo;
import com.gewara.api.vo.ResultCode;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface FilmfestMovieItemVoService {
	ResultCode<Integer> findMovieCountByCitycodeMovieIdCinemaIdPlaydate(String arg0, Long arg1, Long arg2, Date arg3);

	ResultCode<List<Long>> findMovieIdByCitycodeMovieIdCinemaIdPlaydate(String arg0, Long arg1, Long arg2, Date arg3);

	ResultCode<List<Long>> findCinemaIdByCountycode(String arg0);

	ResultCode<List<Long>> findCinemaIdByCitycode(String arg0);

	ResultCode<List<Long>> findRoomIdByCitycode(String arg0);

	ResultCode<Integer> findCountByCitycodeMovieIdCinemaIdPlaydate(String arg0, Long arg1, Long arg2, Date arg3);

	ResultCode<List<MovieItemVo>> findByCitycode(String arg0);

	ResultCode<List<MovieItemVo>> findByCitycodePlaytime(String arg0, Timestamp arg1, Timestamp arg2);

	ResultCode<List<MovieItemVo>> findByCitycodeMovieid(String arg0, Long arg1);

	ResultCode<Integer> findCinemaCount(String arg0, Long arg1, Date arg2);

	ResultCode<List<Map<String, Object>>> findMoiveidAndOpentime(String arg0);
}
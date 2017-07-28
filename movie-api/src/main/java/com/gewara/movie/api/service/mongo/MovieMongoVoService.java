/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.mongo;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.FilmFestTicketOrderVo;
import com.gewara.movie.vo.MovieDetailTabVo;
import com.gewara.movie.vo.SeatTypeVo;
import java.util.List;
import java.util.Map;

public interface MovieMongoVoService {
	ResultCode<List<Map>> getFilmfestDateListByFilmfestCodeAndDayNumber(String arg0, Integer arg1);

	ResultCode<Map> getFilmfestDateListByRecordId(String arg0);

	ResultCode saveOrUpdateFilmfestDateList(Map arg0);

	ResultCode removeFilmfestDateListByRecordId(String arg0);

	ResultCode<Map> getFilmfestMovieIdsByRecordId(String arg0);

	ResultCode saveOrUpdateFilmfestMovieIds(Map arg0);

	ResultCode<List<MovieDetailTabVo>> getMovieDetailTabListByMovieId(Long arg0);

	ResultCode<MovieDetailTabVo> getMovieDetailTabById(String arg0);

	ResultCode removeMovieDetailTabById(String arg0);

	ResultCode saveOrUpdateMovieDetailTab(MovieDetailTabVo arg0);

	ResultCode<Integer> getFilmFestTicketOrderCount(Long arg0, Long arg1);

	ResultCode saveFilmFestTicketOrder(FilmFestTicketOrderVo arg0);

	ResultCode<SeatTypeVo> getSeatTypeById(String arg0);

	ResultCode saveOrUpdateSeatType(SeatTypeVo arg0);
}
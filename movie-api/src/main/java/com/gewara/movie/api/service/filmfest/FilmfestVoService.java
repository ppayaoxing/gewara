/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.filmfest;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.filmfest.FilmfestKindVo;
import com.gewara.movie.vo.filmfest.FilmfestMovieVo;
import com.gewara.movie.vo.filmfest.SetTicketVo;
import com.gewara.movie.vo.filmfest.ViewFilmScheduleVo;
import java.util.List;
import java.util.Map;

public interface FilmfestVoService {
	ResultCode<FilmfestKindVo> getFilmfestKindVoById(Long arg0);

	ResultCode<FilmfestKindVo> getFilmfestKindVoByKindCode(String arg0);

	ResultCode<List<FilmfestMovieVo>> getFilmfestMovieVoListByKindId(Long arg0);

	ResultCode<List<FilmfestMovieVo>> getFilmfestMovieVoListByBelongToId(Long arg0);

	ResultCode<List<FilmfestKindVo>> getFirstLevelChildrenByParentId(Long arg0);

	ResultCode<List<FilmfestKindVo>> getChildrenByParentId(Long arg0);

	ResultCode<String> getPreMobilePath();

	ResultCode<List<Long>> getNewMovieids();

	ResultCode<List<Long>> getCurOpenMovieids(String arg0);

	ResultCode<List<Long>> getCurOpenMovieids2(String arg0);

	ResultCode<List<Map<Object, Object>>> getCurCinemaVoList(String arg0);

	ResultCode<List<Long>> getCurRoomidsList(String arg0);

	ResultCode<Map<String, Map<Object, Object>>> getFilterCondition(String arg0);

	ResultCode<List<Map>> getFilmfestDateList(String arg0);

	ResultCode<ViewFilmScheduleVo> saveOrUpdateViewFilmSchedule(Long arg0, Long arg1, String arg2, String arg3,
			Integer arg4, String arg5, String arg6);

	ResultCode<List<ViewFilmScheduleVo>> getViewFilmScheduleList(Long arg0, String arg1, String arg2);

	ResultCode<Boolean> delViewFilmSchedule(String arg0);

	ResultCode<Boolean> copyViewFilmSchedule(Long arg0, Long arg1, String arg2, String arg3, String arg4);

	ResultCode<List<Map>> getMyTicketList(Long arg0, String arg1);

	ResultCode<List<SetTicketVo>> getSetTicketListByFilmTagUseCache(String arg0);

	ResultCode<Map<Long, Integer>> getFilmScheduleCountMap(String arg0);
}
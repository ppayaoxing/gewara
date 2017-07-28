/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.admin.filmfest;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.filmfest.FilmfestKindVo;
import com.gewara.movie.vo.filmfest.FilmfestMovieVo;
import java.util.List;
import java.util.Map;

public interface FilmfestAdminVoService {
	ResultCode<List<FilmfestKindVo>> getFirstLevelChildrenByParentId(Long arg0);

	ResultCode<Integer> delFilmfestKindById(Long arg0);

	ResultCode<Integer> delFilmfestMovieById(Long arg0);

	ResultCode<List<FilmfestMovieVo>> getFilmfestMovieListByKindId2(Long arg0);

	ResultCode<FilmfestKindVo> getFilmfestKindByKindCode(String arg0);

	ResultCode<Boolean> hasMoreKindCode(String arg0);

	ResultCode<FilmfestKindVo> saveFilmfestKind(RequestParamVo arg0);

	ResultCode<FilmfestMovieVo> saveFilmfestMovie(RequestParamVo arg0);

	ResultCode<Map<Long, Integer>> getFilmScheduleCountMap(String arg0);

	ResultCode<FilmfestKindVo> getFilmfestKindById(Long arg0);

	ResultCode<FilmfestMovieVo> getFilmfestMovieById(Long arg0);
}
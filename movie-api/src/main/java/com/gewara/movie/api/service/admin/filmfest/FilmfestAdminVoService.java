package com.gewara.movie.api.service.admin.filmfest;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.filmfest.FilmfestKindVo;
import com.gewara.movie.vo.filmfest.FilmfestMovieVo;

public interface FilmfestAdminVoService {
	ResultCode<List<FilmfestKindVo>> getFirstLevelChildrenByParentId(Long parentId);
	ResultCode<Integer> delFilmfestKindById(Long id);
	ResultCode<Integer> delFilmfestMovieById(Long id);
	ResultCode<List<FilmfestMovieVo>> getFilmfestMovieListByKindId2(Long kindId);
	ResultCode<FilmfestKindVo> getFilmfestKindByKindCode(String kindCode);
	ResultCode<Boolean> hasMoreKindCode(String kindCode);
	ResultCode<FilmfestKindVo> saveFilmfestKind(RequestParamVo paramVo);
	ResultCode<FilmfestMovieVo> saveFilmfestMovie(RequestParamVo paramVo);
	ResultCode<Map<Long, Integer>> getFilmScheduleCountMap(String filmTag);
	ResultCode<FilmfestKindVo> getFilmfestKindById(Long id);
	ResultCode<FilmfestMovieVo> getFilmfestMovieById(Long id);
	
}

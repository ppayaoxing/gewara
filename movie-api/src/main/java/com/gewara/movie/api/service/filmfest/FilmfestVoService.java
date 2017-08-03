package com.gewara.movie.api.service.filmfest;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.filmfest.FilmfestKindVo;
import com.gewara.movie.vo.filmfest.FilmfestMovieVo;
import com.gewara.movie.vo.filmfest.SetTicketVo;
import com.gewara.movie.vo.filmfest.ViewFilmScheduleVo;
public interface FilmfestVoService {
	ResultCode<FilmfestKindVo> getFilmfestKindVoById(Long id);
	ResultCode<FilmfestKindVo> getFilmfestKindVoByKindCode(String kindCode);
	ResultCode<List<FilmfestMovieVo>> getFilmfestMovieVoListByKindId(Long kindId);
	ResultCode<List<FilmfestMovieVo>> getFilmfestMovieVoListByBelongToId(Long belongToId);
	ResultCode<List<FilmfestKindVo>> getFirstLevelChildrenByParentId(Long parentId);
	ResultCode<List<FilmfestKindVo>> getChildrenByParentId(Long parentId);
	ResultCode<String> getPreMobilePath();
	ResultCode<List<Long>> getNewMovieids();
	ResultCode<List<Long>> getCurOpenMovieids(String cityCode);
	ResultCode<List<Long>> getCurOpenMovieids2(String cityCode);
	ResultCode<List<Map<Object,Object>>> getCurCinemaVoList(String cityCode);
	ResultCode<List<Long>> getCurRoomidsList(String cityCode);
	ResultCode<Map<String,Map<Object, Object>>> getFilterCondition(String cityCode);
	ResultCode<List<Map>> getFilmfestDateList(String filmfestCode);
	ResultCode<ViewFilmScheduleVo> saveOrUpdateViewFilmSchedule(Long memberid, Long movieid, String source,String filmTag,Integer score, String like, String shareReason);
	ResultCode<List<ViewFilmScheduleVo>> getViewFilmScheduleList(Long memberid,String type,String filmTag);
	ResultCode<Boolean> delViewFilmSchedule(String id);
	ResultCode<Boolean> copyViewFilmSchedule(Long fromMemberId,Long toMemberId,String type,String filmTag,String source);
	ResultCode<List<Map>> getMyTicketList(Long memberid,String filmTag);
	ResultCode<List<SetTicketVo>> getSetTicketListByFilmTagUseCache(String filmTag);
	ResultCode<Map<Long, Integer>> getFilmScheduleCountMap(String filmTag);
	
}

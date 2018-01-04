package com.gewara.movie.api.service.mongo;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.FilmFestTicketOrderVo;
import com.gewara.movie.vo.MovieDetailTabVo;
import com.gewara.movie.vo.SeatTypeVo;

public interface MovieMongoVoService {
	
	/**
	 * 查询FilmfestDateList列表
	 * @param filmfestCode 必填
	 * @param dayNumber 可为null
	 * @return
	 */
	ResultCode<List<Map>> getFilmfestDateListByFilmfestCodeAndDayNumber(String filmfestCode,Integer dayNumber);
	
	/**
	 * 根据recordId查询FilmfestDateList
	 * @param recordId
	 * @return
	 */
	ResultCode<Map> getFilmfestDateListByRecordId(String recordId);
	
	/**
	 * 新增/更新 FilmfestDateList
	 * @param param
	 * @return
	 */
	ResultCode saveOrUpdateFilmfestDateList(Map param);
	
	/**
	 * 根据recordId删除FilmfestDateList
	 * @param recordId
	 * @return
	 */
	ResultCode removeFilmfestDateListByRecordId(String recordId);
	
	
	/**
	 * 根据recordId查询Filmfest_MovieIds
	 * @param recordId
	 * @return
	 */
	ResultCode<Map> getFilmfestMovieIdsByRecordId(String recordId);
	
	/**
	 * 新增/更新Filmfest_MovieIds
	 * @param param
	 * @return
	 */
	ResultCode saveOrUpdateFilmfestMovieIds(Map param);
	
	
	/**
	 * 根据电影ID查询 MovieDetailTab列表
	 * @param movieId
	 * @return
	 */
	ResultCode<List<MovieDetailTabVo>> getMovieDetailTabListByMovieId(Long movieId);
	
	/**
	 * 根据ID查询 MovieDetailTab
	 * @param id
	 * @return
	 */
	ResultCode<MovieDetailTabVo> getMovieDetailTabById(String id);
	
	/**
	 * 根据ID删除MovieDetailTab
	 * @param id
	 * @return
	 */
	ResultCode removeMovieDetailTabById(String id);
	
	/**
	 * 新增 MovieDetailTab
	 * @param detailTab
	 * @return
	 */
	ResultCode saveOrUpdateMovieDetailTab(MovieDetailTabVo detailTab);
	
	/**
	 * 查询FilmFestTicketOrder数量
	 * @param memberId
	 * @param relatedId
	 * @return
	 */
	ResultCode<Integer> getFilmFestTicketOrderCount(Long memberId, Long relatedId);
	
	
	/**
	 * 新增FilmFestTicketOrder
	 * @param order
	 * @return
	 */
	ResultCode saveFilmFestTicketOrder(FilmFestTicketOrderVo order);
	
	/**
	 * 根据ID查询SeatType
	 * @param id
	 * @return
	 */
	ResultCode<SeatTypeVo> getSeatTypeById(String id);
	
	/**
	 * 新增/更新 SeatType
	 * @param seatType
	 * @return
	 */
	ResultCode saveOrUpdateSeatType(SeatTypeVo seatTypeVo);
}

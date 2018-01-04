package com.gewara.movie.api.service.partner;


import java.util.Date;
import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.CinemaVo;
import com.gewara.movie.vo.MovieVo;
import com.gewara.movie.vo.partner.PartnerCinemaQueryReqVo;
import com.gewara.movie.vo.partner.PartnerCommonReqVo;
import com.gewara.movie.vo.partner.PartnerMovieReqVo;

/**
 * 合作商电影，包括WAP
 * 
 */
public interface PartnerMCPVoService2 {
	
	/**
	 * 热映影片
	 * 
	 * @return
	 */
	ResultCode<List<MovieVo>> getHotMovies(PartnerMovieReqVo reqVo);

	/**
	 * 获得影院列表
	 * 
	 * @return
	 */	
	ResultCode<List<CinemaVo>> getCinemaList(PartnerCinemaQueryReqVo reqVo);

	/**
	 * 待上映影片
	 * 
	 * @return
	 */
	ResultCode<List<MovieVo>> getFutureMovies(String appkey, String citycode, Integer from, Integer maxnum);
	/**
	 * 影片详情
	 * 
	 * @return
	 */
	ResultCode<MovieVo> getMovieDetail(String appkey, Long movieId);

	/**
	 * 特效厅
	 * 
	 * @param citycode
	 * @param movieId
	 * @return
	 */
	ResultCode<String> characteristicList(String appkey, String citycode, Long movieId);

	/**
	 * 影院详情
	 * 
	 * @return
	 */
	ResultCode<CinemaVo> getCinemaDetail(String appkey, Long cinemaId);
	/**
	 * 获取影院列表，包含评分等
	 * @param appkey
	 * @param movieidList
	 * @return
	 */
	ResultCode<List<MovieVo>> getMovieVoList(String appkey, List<Long> movieidList);
	/**
	 * 影院正在热映的电影
	 * @param appkey
	 * @param citycode
	 * @param cinemaId
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<MovieVo>> getCurMovieByCinemaId(String appkey, String citycode, Long cinemaId, Long discountid, Integer from, Integer maxnum);
	/**
	 * 根据城市和影片获取购票影院列表
	 * @param reqVo
	 * @return
	 */
	ResultCode<List<CinemaVo>> getCinemaListByCitycodeAndMovieid(PartnerCommonReqVo reqVo);
	/**
	 * 获取电影特效厅
	 * @param reqVo
	 * @return
	 */
	ResultCode<String> getMovieCharacteristic(String citycode,Long movieId);
	/**
	 * 根据特效厅查找影院
	 * @param reqVo
	 * @return
	 */
	ResultCode<List<CinemaVo>> getSpecailRoomCinemaList(PartnerCommonReqVo reqVo);
	/**
	 * 电影特效厅
	 * @param reqVo
	 * @return
	 */
	ResultCode<String> getMovieCharacteristic(PartnerCommonReqVo reqVo);
	
	ResultCode<String> getMovieCharacteristic2(PartnerCommonReqVo reqVo,Date playdate);
	
	/**
	 * 根据特效厅查找影院
	 * @param reqVo
	 * @return
	 */
	ResultCode<List<CinemaVo>> getCinemaListByCountyAndMovieidAndPlaydate(PartnerCommonReqVo reqVo);
	/**
	 * 特价模板影院列表查询方法
	 * @param paramsVo
	 * @return
	 */
	ResultCode<List<CinemaVo>> getCinemaVoList4Advert(PartnerCinemaQueryReqVo paramsVo);
}

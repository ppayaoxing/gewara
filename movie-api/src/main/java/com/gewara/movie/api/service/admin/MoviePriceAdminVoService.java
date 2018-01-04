package com.gewara.movie.api.service.admin;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.MoviePriceVo;
import com.gewara.movie.vo.MovieTierPriceVo;

public interface MoviePriceAdminVoService {
	/**
	 * 保存movieprice对象
	 * @param paramVo
	 * @return
	 */
	ResultCode<MoviePriceVo> saveMovieLowestPrice(RequestParamVo paramVo);
	/**
	 * 保存movieprice对象
	 * @param paramVo
	 * @return
	 */
	ResultCode<MoviePriceVo> setMoviePrice(RequestParamVo paramVo);
	/**
	 * 根据开放场次影片，同步movieprice对象
	 * @param curMovieIdList
	 * @param cinemaid
	 * @param synchFlag
	 * @param userid
	 * @return
	 */
	ResultCode<List<String>> syncMoviePriceByCurMovieIdList(List<Long> curMovieIdList, Long cinemaid, String synchFlag, Long userid);
	/**
	 * 修改cinemaPrice对象
	 * @param cinemaPriceList
	 * @return
	 */
	ResultCode<Integer> upgradeCinemaPrice(List<Map> cinemaPriceList);
	/**
	 * 批量同步movieprice对象
	 * @param mids
	 * @param synchFlag
	 * @param userid
	 * @return
	 */
	ResultCode<List<String>> batchSyncMoviePriceByMids(String mids, String synchFlag, Long userid);
	/**
	 * 根据开放场次影片，同步movieprice对象
	 * @param curMovieIdList
	 * @param synchFlag
	 * @return
	 */
	ResultCode<List<String>> syncMoviePriceToCinemaByCurMovieIdList(List<Long> curMovieIdList, String synchFlag);
	/**
	 * 根据开放场次影片，同步movieprice对象
	 * @param mids
	 * @param synchFlag
	 * @param userid
	 * @return
	 */
	ResultCode<List<String>> batchSyncMoviePriceToCinemaByMids(String mids, String synchFlag, Long userid);
	/**
	 * 保存MovieTierPrice对象
	 * @param movieid
	 * @param type
	 * @return
	 */
	ResultCode<MovieTierPriceVo> saveMovieTierPrice(Long movieid, String type, Map<String, String> dataMap);
	/**
	 * 更新movietierprice的starttime、endtime
	 * @param movieid
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	ResultCode<List<MovieTierPriceVo>> saveMoviePriceTierTime(Long movieid, Timestamp startTime, Timestamp endTime);
}

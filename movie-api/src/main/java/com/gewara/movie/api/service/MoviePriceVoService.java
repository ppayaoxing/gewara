package com.gewara.movie.api.service;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.MoviePriceVo;
import com.gewara.movie.vo.MovieTierPriceVo;
import com.gewara.movie.vo.MovieVo;

public interface MoviePriceVoService {
	/**
	 * 根据movieIdList，查询movieprice
	 * @param midList
	 * @return
	 */
	ResultCode<List<MoviePriceVo>> getMoviePriceListByMovieIdList(List<Long> midList);
	/**
	 * 根据cinemaid、movieIdList，查询movieprice
	 * @param cinemaid
	 * @param midList
	 * @return
	 */
	ResultCode<List<MoviePriceVo>> getMoviePriceListByCinemaIdAndMovieIdList(Long cinemaid, List<Long> midList);
	/**
	 * 根据movieidList，查询MovieTierPrice
	 * @param movieidList
	 * @return
	 */
	ResultCode<List<MovieVo>> getMovieListAndCheckMovieTierPriceIsNotNull(List<Long> movieidList);
	/**
	 * 根据movieidList，查询MovieTierPrice
	 * @param movieidList
	 * @return
	 */
	ResultCode<Map> getMovieTierPriceTypeMapByMovieidList(List<Long> movieidList);
	/**
	 *	根据城市获取当前价格不同的电影最低价格
	 *	@param 城市代码
	 * @return 电影最低价格
	 */
	ResultCode<List<MoviePriceVo>> getDiffMoviePriceList(String citycode);
	/**
	 * 根据movieidList，查询MovieTierPrice
	 * @param movieidList
	 * @return
	 */
	ResultCode<Map<Long, MovieTierPriceVo>> getMovieTierPriceMapByCitycode(String citycode);
	/**
	 * 根据movieid、cinemaid，查询movieprice
	 * @param movieid
	 * @param cinemaid
	 * @return
	 */
	ResultCode<MoviePriceVo> getMoviePriceByMovieidAndCinemaId(Long movieid, Long cinemaid);
	/**
	 * 
	 * @param paramsList
	 * @return
	 */
	ResultCode<Map<String, MoviePriceVo>> getMoviePriceDataMap(List<Map<String, Long>> paramsList);
	
	
	/**
	 * 根据movieid 和citycode查询MoviePriceVo
	 * @param movieid
	 * @param citycode
	 * @return
	 */
	ResultCode<MoviePriceVo> getMoviePriceByMovieIdAndCityCode(Long movieid, String citycode);
	
	/**
	 * @param movieid
	 * @return
	 */
	ResultCode<List<MovieTierPriceVo>> getMovieTierPriceList(Long movieid);
	
	/**
	 * 通过电影ID与类别查询价格
	 * @param movieid	电影ID
	 * @param type	价格类别
	 * @return	电影类别的价格
	 */
	ResultCode<MovieTierPriceVo> getMovieTierPriceByMovieIdAndType(Long movieid, String type);
	
	/**
	 * 保存电影movieTierPrice
	 * @param movieTierPrice
	 */
	ResultCode saveMovieTierPrice(MovieTierPriceVo movieTierPrice);
	
	/**
	 * 保存电影movieTierPriceList
	 * @param movieTierPriceList
	 */
	ResultCode saveMovieTierPriceList(List<MovieTierPriceVo> movieTierPriceList);
	
	/**
	 * 保存电影MoviePrice
	 */
	ResultCode saveMoviePrice(MoviePriceVo moviePrice);

	ResultCode<List<String>> syncMoviePriceToCinema(MovieVo movie, List<Map> cityTierMapList, String synchFlag, Long userid);
	
	ResultCode<List<String>> synchMoviePrice(MovieVo movie, List<Map> cityTierMapList, String synchFlag, Long userid);
}

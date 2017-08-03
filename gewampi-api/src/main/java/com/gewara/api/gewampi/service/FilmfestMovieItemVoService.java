package com.gewara.api.gewampi.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gewara.api.gewampi.vo.MovieItemVo;
import com.gewara.api.vo.ResultCode;

/**
 * 电影节场次接口
 * @author leo
 * @addTime 2015年9月11日下午2:58:21
 *
 */
public interface FilmfestMovieItemVoService {
	
	/**
	 * 查询正在上映的影片数量</br>
	 * 该方法已加入缓存，缓存5分钟</br>
	 * <b>参数不可以全空<b>
	 * @param citycode 可以为空
	 * @param movieId  可以为空
	 * @param cinemaId 可以为空
	 * @param playdate 可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年9月11日下午2:58:21
	 */
	ResultCode<Integer> findMovieCountByCitycodeMovieIdCinemaIdPlaydate(String citycode, Long movieId, Long cinemaId, Date playdate);
	
	/**
	 * 查询影片ID</br>
	 * 该方法已加入缓存，缓存5分钟</br>
	 * <b>参数不可以全空<b>
	 * @param citycode 可以为空
	 * @param movieId  可以为空
	 * @param cinemaId 可以为空
	 * @param playdate 可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年9月11日下午3:16:05
	 */
	ResultCode<List<Long>> findMovieIdByCitycodeMovieIdCinemaIdPlaydate(String citycode, Long movieId, Long cinemaId, Date playdate);

	/**
	 * 查询影院ID</br>
	 * 该方法已加入缓存，缓存5分钟
	 * @param countycode 不可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年9月11日下午3:16:31
	 */
	ResultCode<List<Long>> findCinemaIdByCountycode(String countycode);
	
	/**
	 * 查询影院ID</br>
	 * 该方法已加入缓存，缓存5分钟
	 * @param citycode 不可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年9月11日下午4:04:23
	 */
	ResultCode<List<Long>> findCinemaIdByCitycode(String citycode);
	
	/**
	 * 查询影厅ID</br>
	 * 该方法已加入缓存，缓存5分钟
	 * @param citycode 不可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年9月11日下午4:04:23
	 */
	ResultCode<List<Long>> findRoomIdByCitycode(String citycode);
	
	/**
	 * 查询正在上映的场次数量</br>
	 * 该方法已加入缓存，缓存5分钟</br>
	 * <b>参数不可以全空<b>
	 * @param citycode 可以为空
	 * @param movieId  可以为空
	 * @param cinemaId 可以为空
	 * @param playdate 可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年9月11日下午2:58:21
	 */
	ResultCode<Integer> findCountByCitycodeMovieIdCinemaIdPlaydate(String citycode, Long movieId, Long cinemaId, Date playdate);
	
	/**
	 * 查询某城市电影节所有场次</br>
	 * 返回的场次集按放映时间正序排列</br>
	 * @param citycode 不可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年9月11日下午3:55:56
	 */
	ResultCode<List<MovieItemVo>> findByCitycode(String citycode);
	
	/**
	 * 查询某城市电影节场次</br>
	 * 返回的场次集按放映时间正序排列</br>
	 * @param citycode     不可以为空
	 * @param playtimeGte  不可以为空 放映时间大于等于该时间
	 * @param playtimeLt   不可以为空 放映时间小于该时间	
	 * @return
	 * @author leo
	 * @addTime 2015年9月11日下午3:59:02
	 */
	ResultCode<List<MovieItemVo>> findByCitycodePlaytime(String citycode, Timestamp playtimeGte, Timestamp playtimeLt);
	
	/**
	 * 查询某电影节场次</br>
	 * 返回的场次集按放映时间正序排列
	 * @param citycode 不可以为空
	 * @param movieid  不可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年9月15日下午3:10:37
	 */
	ResultCode<List<MovieItemVo>> findByCitycodeMovieid(String citycode, Long movieid);	
	
	/**
	 * 查询影院数量</br>
	 * @param citycode citycode，movieid，playdate不可以全为空
	 * @param movieid  citycode，movieid，playdate不可以全为空
	 * @param playdate citycode，movieid，playdate不可以全为空
	 * @return
	 * @author leo
	 * @addTime 2016年3月18日下午2:38:09
	 */
	ResultCode<Integer> findCinemaCount(String citycode, Long movieid, Date playdate);
	
	/**
	 * 查找电影节所有电影ID，以及对应的最早开放的场次</br>
	 * @param citycode 不可以为空
	 * @return Mp<key, value> : "movieid" -> movieid; "earliestOpentime" -> opentime;
	 * @author leo
	 * @addTime 2016年3月29日下午2:51:58
	 */
	ResultCode<List<Map<String, Object>>> findMoiveidAndOpentime(String citycode);
}

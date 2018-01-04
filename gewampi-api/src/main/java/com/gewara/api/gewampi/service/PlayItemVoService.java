package com.gewara.api.gewampi.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gewara.api.gewampi.vo.MovieItemVo;
import com.gewara.api.vo.ResultCode;

public interface PlayItemVoService {
	
	/**
	 * 根据城市（citycode）、影片（movieid）查询日期Date playdate
	 * 该方法已加入缓存，缓存5分钟
	 * @param citycode	citycode,movieid至少一个不为空
	 * @param movieid	citycode,movieid至少一个不为空
	 * @return
	 * @author leo
	 * @addTime 2015年5月18日下午5:48:06
	 */
	ResultCode<List<Date>> findPlayDateByCityCodeAndMovieId(String citycode,Long movieid);
	
	/**
	 * 根据城市（citycode）、影片（movieid）、日期（playdate）获取影院idLong cinemaid
	 * 该方法已加入缓存，playdate为空时，缓存10分钟，不为空时，缓存5分钟
	 * @param citycode	可以为空
	 * @param movieid	可以为空
	 * @param playdate	可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年5月18日下午5:48:34
	 */
	ResultCode<List<Long>> findCinemaIdByCityCodeAndMovieIdAndPlayDate(String citycode,Long movieid,Date playdate);
	
	/**
	 * 根据影片（movieid）、日期（playdate）、影院id（cinemaid）获取场次</br>
	 * 返回的场次集按放映时间正序排列
	 * @param movieid	movieid,playdate,cinemaid，不可以同时为空，至少有一个有值
	 * @param playdate	movieid,playdate,cinemaid，不可以同时为空，至少有一个有值
	 * @param cinemaid	movieid,playdate,cinemaid，不可以同时为空，至少有一个有值
	 * @return
	 * @author leo
	 * @addTime 2015年5月18日下午5:50:35
	 */
	ResultCode<List<MovieItemVo>> findByMovieIdAndPlayDateAndCinemaId(Long movieid,Date playdate,Long cinemaid);
	
	/**
	 * 
	 * 根据城市（citycode）、影片（movieid）、日期（playdate）、影院id（cinemaid）获取场次</br>
	 * 返回的场次集按放映时间正序排列
	 * @param citycode	citycode, cinemaid, movieid, playdate，不可以同时为空，至少有一个有值
	 * @param cinemaid	citycode, cinemaid, movieid, playdate，不可以同时为空，至少有一个有值
	 * @param movieid	citycode, cinemaid, movieid, playdate，不可以同时为空，至少有一个有值
	 * @param playdate	citycode, cinemaid, movieid, playdate，不可以同时为空，至少有一个有值
	 * @return
	 * @author leo
	 * @addTime 2015年7月1日上午11:12:17
	 */
	ResultCode<List<MovieItemVo>> findByCitycodeCinemaidMovieidPlaydate(String citycode, Long cinemaid, Long movieid, Date playdate);
	
	/**
	 * 根据城市影院（cinemaid）查询排片日期
	 * 该方法已加入缓存，缓存5分钟
	 * @param cinemaid	不以为空
	 * @return
	 * @author leo
	 * @addTime 2015年5月18日下午5:52:40
	 */
	ResultCode<List<Date>> findPlayDateByCinemaId(Long cinemaid);
	
	/**
	 * 根据城市影院（cinemaid）、日期（playdate）获取影片id
	 * 该方法已加入缓存，缓存5分钟
	 * @param cinemaid	可以为空
	 * @param playdate	可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年5月18日下午5:53:04
	 */
	ResultCode<List<Long>> findMovieIdByCinemaIdAndPlayDate(Long cinemaid,Date playdate);
	
	/**
	 * 根据城市（citycode）获取放映日期（playdate）
	 * 该方法已加入缓存，缓存5分钟
	 * @param citycode	不可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年5月18日下午5:53:44
	 */
	ResultCode<List<Date>> findPlayDateByCityCode(String citycode);
	
	/**
	 * 根据城市（citycode）获取购票影片id
	 * 该方法已加入缓存，缓存5分钟
	 * @param citycode 	不可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年5月18日下午5:54:32
	 */
	ResultCode<List<Long>> findMovieIdByCityCode(String citycode);
	
	/**
	 * 查询所有影片Id
	 * 此方法自动缓存20分钟
	 * @return
	 * @author leo
	 * @addTime 2015年7月2日下午4:08:35
	 */
	ResultCode<List<Long>> findAllMovieIdList();

	/**
	 * 根据影片（movieid）、日期（playdate）、影院id（cinemaid）获取午夜场次</br>
	 * 午夜场次的时间段为放映时间00:00-05:00</br>
	 * openStatus 值为 : open</br>
	 * 返回的场次集按放映时间正序排列
	 * @param movieid	 	不可以为空
	 * @param playdate	 	不可以为空
	 * @param cinemaid 		不可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年5月18日下午5:54:51
	 */
	ResultCode<List<MovieItemVo>> findMidNightByMovieIdAndPlayDateAndCinemaId(Long movieid,Date playdate,Long cinemaid);
		
	/**
	 * 根据citycode、电影（movieid）、影院（cinemaid）获取购票场次平均价格、最小价格、最大价格
	 * 该方法已加入缓存，缓存5分钟
	 * 返回Map中的key，是价格标识，min，最小值；max最大值；avg：平均值
	 * value，对应价格
	 * 
	 * @param movieid	movieid，cinemaid，citycode至少一个不为空
	 * @param cinemaid	movieid，cinemaid，citycode至少一个不为空
	 * @param citycode	movieid，cinemaid，citycode至少一个不为空
	 * @return
	 * @author leo
	 * @addTime 2015年5月18日下午5:46:07
	 */
	ResultCode<Map<String, Integer>> findPriceInfoByMovieIdAndCinemaIdAndCityCode(Long movieid,Long cinemaid,String citycode);

	/**
	 * 查询正上映的影片数量
	 * 该方法已加入缓存，缓存10分钟
	 * @param citycode 可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年5月15日下午3:10:43
	 */
	ResultCode<Integer> findMovieCountByCityCode(String citycode);
	
	/**
	 * 查询正上映的影片数量
	 * 该方法已加入缓存，缓存10分钟
	 * @param citycode 可以为空
	 * @param cinemaId 可以为空
	 * @param playdate 可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年5月15日下午3:10:43
	 */
	ResultCode<Integer> findMovieCount(String citycode, Long cinemaId, Date playdate);
	
	/**
	 * 查询影院ID
	 * 该方法已加入缓存，缓存5分钟
	 * @param countycode 影院所在区、县，不可以为空
	 * @param movieId	  可以为空
	 * @param playdate   可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年5月15日下午3:58:14
	 */
	ResultCode<List<Long>> findCinemaIdByCountycodeAndMovieIdAndPlayDate(String countycode, Long movieId, Date playdate);
	
	/**
	 * 查询影院数量
	 * 两个参数至少有一个不为空
	 * 该方法已加入缓存，缓存10分钟
	 * @param citycode
	 * @param movieId
	 * @return
	 * @author leo
	 * @addTime 2015年5月15日下午4:16:57
	 */
	ResultCode<Integer> findCinemaCountByCityCodeAndMovieId(String citycode, Long movieId);
	

	/**
	 * 查询影院数量
	 * 三个参数至少有一个不为空
	 * 该方法已加入缓存，缓存10分钟
	 * @param citycode
	 * @param movieId
	 * @param playdate
	 * @return
	 * @author leo
	 * @addTime 2015年5月15日下午4:16:57
	 */
	ResultCode<Integer> findCinemaCount(String citycode, Long movieId, Date playdate);
	
	/**
	 * 根据影院查询影片Id
	 * 限已开放的场次，查询聚合表：OpiCount
	 * 该方法已加入缓存，playdate为空时，缓存10分钟，不为空时，缓存5分钟
	 * @param citycode  可以为空
	 * @param cinemaId  可以为空
	 * @param playdate  可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年5月15日下午4:25:14
	 */
	ResultCode<List<Long>> findOpiMovieIdList(String citycode, Long cinemaId, Date playdate);
	
	/**
	 * 查询放映日期
	 * 该方法已加入缓存，缓存5分钟
	 * @param cinemaId	cinemaId,movieid至少一个不为空
	 * @param movieid	cinemaId,movieid至少一个不为空
	 * @return
	 * @author leo
	 * @addTime 2015年5月15日下午4:41:33
	 */
	ResultCode<List<Date>> findPlayDateByCinemaIdAndMovieId(Long cinemaId,Long movieid);
	
	/**
	 * 查询排片数量</br>
	 * 某些情况下使用缓存：citycode，movieId不为空，cinemaId，playdate为空时，缓存10分钟，其它情况下不缓存5分钟
	 * @param citycode	可以为空
	 * @param cinemaId	可以为空
	 * @param movieId	可以为空
	 * @param playdate	可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年5月15日下午4:47:29
	 */
	ResultCode<Integer> findPlayItemCount(String citycode, Long cinemaId, Long movieId, Date playdate);
	
	/**
	 * 查询排片数量	 * 
	 * endDate startDate，至少有一个不为空
	 * 该方法已加入缓存，缓存5分钟
	 * 
	 * @param citycode	可以为空
	 * @param cinemaId	可以为空
	 * @param movieId	可以为空
	 * @param startDate endDate startDate，至少有一个不为空
	 * @param endDate 	endDate startDate，至少有一个不为空
	 * @return
	 * @author leo
	 * @addTime 2015年5月15日下午6:49:31
	 * 
     * @see     PlayItemVoService.findPlayItemCount2
     * @deprecated 方法名变更，请尽快使用新方法名：findPlayItemCount2
	 */
	@Deprecated
	ResultCode<Integer> findPlayItemCount(String citycode, Long cinemaId, Long movieId, Date startDate, Date endDate);
	

	/**
	 * 查询排片数量	 * 
	 * endDate startDate，至少有一个不为空
	 * 该方法已加入缓存，缓存5分钟
	 * 
	 * @param citycode	可以为空
	 * @param cinemaId	可以为空
	 * @param movieId	可以为空
	 * @param startDate endDate startDate，至少有一个不为空
	 * @param endDate 	endDate startDate，至少有一个不为空
	 * @return
	 * @author leo
	 * @addTime 2015年5月15日下午6:49:31
	 */
	ResultCode<Integer> findPlayItemCount2(String citycode, Long cinemaId, Long movieId, Date startDate, Date endDate);
	
	
	/**
	 * 获取影片场次数量
	 * 返回List，里面是Map, 每个map的结构如下：
	 * map.put("movieid", 111);
	 * map.put("count", 12354);
	 * 按排片数量count，倒序排
	 * 该方法已加入缓存，缓存5分钟
	 * 
	 * @param citycode	城市，可以为空
	 * @param date		放映日期，可以为空
	 * @param cinemaId	影院id，可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年5月15日下午2:18:29
	 */
	ResultCode<List<Map<String, Long>>> findMovieMpiCountList(String citycode, Date playdate, Long cinemaId);

	/**
	 * 查询影片场次</br>
	 * status 要为 : Y</br>
	 * 放映时间大于当前时间</br>
	 * 按放映时间正序排</br>
	 * 返回的场次集按放映时间正序排列
	 * 
	 * @param roomid 影厅ID 不可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年5月18日下午2:51:19
	 */
	ResultCode<List<MovieItemVo>> findOpiByRoomid(Long roomid);
	
	/**
	 * 查询影片场次</br>
	 * 排片放映时间在from与to之间</br>
	 * 返回的场次集按放映时间正序排列
	 * @param citycode		citycode,cinemaId,movieid，必须传一个值
	 * @param cinemaId		citycode,cinemaId,movieid，必须传一个值
	 * @param movieid		citycode,cinemaId,movieid，必须传一个值
	 * @param from			不可以为空，影片放映开始时间
	 * @param to			不可以为空，影片放映结束时间
	 * @return
	 * @author leo
	 * @addTime 2015年5月18日下午3:49:25
	 */
	ResultCode<List<MovieItemVo>> findByCityCodeAndCinemaIdAndMovieId(String citycode, Long cinemaId, Long movieid, Timestamp from, Timestamp to);
	
	/**
	 * 查询有场次的特效影厅</br>
	 * 场次表中字段characteristic，不为空则认为所在影厅为特效影厅</br>
	 * status 值要为：Y</br>
	 * 放映时间要大于（当前时间 + 1小时）</br>
	 * 
	 * 该方法已加入缓存，缓存5分钟
	 * 
	 * @param cinemaid 不可以为空
	 * @return 返回影厅ID  List
	 * @author leo
	 * @addTime 2015年5月19日下午3:37:25
	 */
	ResultCode<List<Long>> findCharacteristicRoomIdList(Long cinemaid);
	
	
	/**
	 * 根据城市（citycode）、影片（movieid）、日期（playdate）获取影院idLong cinemaid
	 * 限已开放的场次，查询聚合表：OpiCount
	 * 该方法已加入缓存，缓存5分钟
	 * @param citycode	可以为空
	 * @param movieid	可以为空
	 * @param playdate	可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年5月18日下午5:48:34
	 */
	ResultCode<List<Long>> findOpiCinemaIdList(String citycode,Long movieid,Date playdate);
	
	/**
	 * 
	 * 根据城市（citycode）、影片（movieid）、日期（playdate）、时间段（timeRange：am,pm,night）获取影院idLong cinemaid
	 * 限已开放的场次，查询聚合表：OpiCount
	 * 该方法已加入缓存，缓存5分钟
	 * 
	 * @param citycode 不可以为空
	 * @param movieid   可以为空
	 * @param playdate  可以为空
	 * @param timeRange 可以为空： am,pm,night
	 * @return
	 */
	ResultCode<List<Long>> findOpiCinemaIdList(String citycode, Long movieid, Date playdate, String timeRange);
	
	/**
	 * 根据城市（citycode）、影片（movieid）查询日期Date playdate
	 * 限已开放的场次，查询聚合表：OpiCount
	 * 该方法已加入缓存，缓存5分钟
	 * @param citycode	citycode,movieid至少一个不为空
	 * @param movieid	citycode,movieid至少一个不为空
	 * @return
	 * @author leo
	 * @addTime 2015年5月18日下午5:48:06
	 */
	ResultCode<List<Date>> findOpiPlayDateByCityCodeAndMovieId(String citycode,Long movieid);
	
	/**
	 * 查询放映日期
	 * 限已开放的场次，查询聚合表：OpiCount
	 * 该方法已加入缓存，缓存5分钟
	 * @param cinemaId	cinemaId,movieid至少一个不为空
	 * @param movieid	cinemaId,movieid至少一个不为空
	 * @return
	 * @author leo
	 * @addTime 2015年5月15日下午4:41:33
	 */
	ResultCode<List<Date>> findOpiPlayDateByCinemaIdAndMovieId(Long cinemaId,Long movieid);
	
	/**
	 * 根据城市（citycode）获取购票影片id
	 * 限已开放的场次，查询聚合表：OpiCount
	 * 该方法使用了缓存，缓存10分钟
	 * @param citycode 	不可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年5月18日下午5:54:32
	 */
	ResultCode<List<Long>> findOpiMovieIdByCityCode(String citycode);

	/**
	 * 查询排片数量</br>
	 * 限已开放的场次，查询聚合表：OpiCount
	 * 该方法已加入缓存，缓存5分钟
	 * @param citycode	可以为空
	 * @param cinemaId	可以为空
	 * @param movieId	可以为空
	 * @param playdate	可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年5月15日下午4:47:29
	 */
	ResultCode<Integer> findOpiPlayItemCount(String citycode, Long cinemaId, Long movieId, Date playdate);
	
	/**
	 * 查询每天放映的排片数量
	 * 
	 * 返回的Map结构：key:value
	 * playdate:java.util.Date
	 * count:Integer
	 * 
	 * 该方法已加入缓存，缓存5分钟
	 * 
	 * @param citycode	可以为空
	 * @param cinemaid	可以为空
	 * @param movieid	可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年6月17日下午6:51:58
	 */
	ResultCode<List<Map<String, Object>>> findMpiCountGroupByPlaydate(String citycode, Long cinemaid, Long movieid);
	
	/**
	 * 查询场次
	 * @param mpid mpid
	 * @return
	 * @author leo
	 * @addTime 2015年6月19日下午6:18:51
	 */
	ResultCode<MovieItemVo> findByMpid(Long mpid);
	
	/**
	 * 查询场次</br>
	 * 返回的场次集按放映时间正序排列
	 * @param mpidList
	 * @return
	 * @author leo
	 * @addTime 2015年6月23日下午5:06:48
	 */
	ResultCode<List<MovieItemVo>> findByMpidList(List<Long> mpidList);
	
	/**
	 * 查询特效影厅
	 * 结果缓存20分钟
	 * @param citycode 不可以为空
	 * @param movieid
	 * @param playdate
	 * @return
	 * @author leo
	 * @addTime 2015年6月25日上午11:37:50
	 * 
     * @see     PlayItemVoService.findCharacteristicRoomIdList2
     * @deprecated 方法名变更，请尽快使用新方法名：findCharacteristicRoomIdList2
	 */
	@Deprecated
	ResultCode<List<Long>> findCharacteristicRoomIdList(String citycode, Long movieid, Date playdate);
	
	/**
	 * 查询特效影厅
	 * 结果缓存20分钟
	 * @param citycode 不可以为空
	 * @param movieid
	 * @param playdate
	 * @return
	 * @author leo
	 * @addTime 2015年6月25日上午11:37:50
	 */
	ResultCode<List<Long>> findCharacteristicRoomIdList2(String citycode, Long movieid, Date playdate);
	
	/**
	 * 查询已开放场次
	 * openid不为空</br>
	 * 返回的场次集按放映时间正序排列
	 * @param movieid  movieid,playdate,cinemaid，不可以同时为空，至少有一个有值
	 * @param playdate movieid,playdate,cinemaid，不可以同时为空，至少有一个有值
	 * @param cinemaid movieid,playdate,cinemaid，不可以同时为空，至少有一个有值
	 * @return
	 * @author leo
	 * @addTime 2015年6月25日下午5:49:55
	 */
	ResultCode<List<MovieItemVo>> findOpiList(Long movieid, Date playdate, Long cinemaid);

	/**
	 * 查询已开放的场次，放映时间大于startPlaytime
	 * openid不为空</br>
	 * 返回的场次集按放映时间正序排列
	 * @param cinemaid		不可以为空
	 * @param startPlaytime	不可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年7月2日上午11:31:42
	 * 
     * @see     PlayItemVoService.findOpiListByCinemaidAndStartPlaytime
     * @deprecated 方法名变更，请尽快使用新方法名：findOpiListByCinemaidAndStartPlaytime
	 */
	@Deprecated
	public ResultCode<List<MovieItemVo>> findOpiList(Long cinemaid, Timestamp startPlaytime);
	
	/**
	 * 查询已开放的场次，放映时间大于startPlaytime
	 * openid不为空</br>
	 * 返回的场次集按放映时间正序排列
	 * @param cinemaid		不可以为空
	 * @param startPlaytime	不可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年7月2日上午11:31:42
	 */
	public ResultCode<List<MovieItemVo>> findOpiListByCinemaidAndStartPlaytime(Long cinemaid, Timestamp startPlaytime);
	
	/**
	 * 获取某个城市下适合该特价活动的影院id列表
	 * @author qilun
	 * Jul 23, 2015
	 * @param sdid 不可为空
	 * @param citycode 不可为空
	 * @return
	 */
	ResultCode<List<Long>> getCinemaidListByCitycode(Long sdid, String citycode);
	/**
	 * 获取在该影院适合该特价活动的影片id列表
	 * @author qilun
	 * Jul 23, 2015
	 * @param sdid 不可为空
	 * @param cinemaId 不可为空
	 * @return
	 */
	ResultCode<List<Long>> getMovieidListByCinemaid(Long sdid, Long cinemaId);
	/**
	 * 获取特价活动在影院下放映某个电影的日期
	 * @author qilun
	 * Jul 23, 2015
	 * @param sdid 不可为空
	 * @param cinemaId 不可为空
	 * @param movieid 不可为空
	 * @return
	 */
	ResultCode<List<Date>> getPlaydatedListByCinemaidAndMovieid(Long sdid, Long cinemaId, Long movieid);
	
	/**
	 * 根据修改时间查询，及修改时间大于updateTime的所有排片</br>
	 * 返回的场次集按放映时间正序排列
	 * 
	 * @param cinemaid   不可以为空
	 * @param updateTime 不可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年8月14日下午4:07:18
	 */
	ResultCode<List<MovieItemVo>> findListByUpdateTime(Long cinemaid, Timestamp updateTime);
	
	/**
	 * 查询具有特效影厅的影院ID</br>
	 * 结果缓存10分钟
	 * @param characteristic    不可以为空
	 * @param citycode   		不可以为空
	 * @param movieid			可以为空
	 * @param playdate			可以为空
	 * @return
	 * @author leo
	 * @addTime 2015年9月15日下午3:50:02
	 */
	ResultCode<List<Long>> findCinemaIdByCharacteristic(String characteristic, String citycode, Long movieid, Date playdate);
}

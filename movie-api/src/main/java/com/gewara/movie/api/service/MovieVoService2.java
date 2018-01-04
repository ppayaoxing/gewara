package com.gewara.movie.api.service;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.MovieVideoVo;
import com.gewara.movie.vo.MovieVo;
import com.gewara.movie.vo.common.EntityClobVo;

public interface MovieVoService2 {
	/**
	 * 根据影片ID获得影片详情
	 * 
	 * @param movieId
	 * @return MovieVo
	 */
	ResultCode<MovieVo> getMovieById(Long movieId);
	/**
	 * 根据影片ukey获得影片详情
	 * 
	 * @param ukey
	 * @return MovieVo
	 */
	ResultCode<MovieVo> getMovieByUkey(String ukeyName, Serializable ukeyValue);
	/**
	 * 根据影片ID集合获得影片集合
	 * 
	 * @param movieIds
	 * @return List<MovieVo>
	 */
	ResultCode<List<MovieVo>> getMovieListByIdList(List<Long> idList);
	
	/**
	 * 根据影片ID集合获得影片集合
	 * 注意：该方法用于jms同步movie数据到avatar,直接查mysql数据库，不走缓存，慎用。
	 * @param movieIds
	 * @return List<MovieVo>
	 */
	ResultCode<List<MovieVo>> getMovieListByIdListWithOutCache(List<Long> idList);
	
	/**
	 * 根据影片ID获得影片描述
	 * 
	 * @param movieId
	 * @return EntityClobVo
	 */
	ResultCode<EntityClobVo> getMovieEntityClob(Long movieId);
	/**
	 * 根据即将上映的影片
	 * 
	 * @param from
	 * @param maxnum
	 * @param order
	 * @return List<MovieVo>
	 */
	ResultCode<List<MovieVo>> getFutureMovieList(int from, int maxnum, String order);
	/**
	 * 查询热映影片
	 * @return
	 */
	ResultCode<List<MovieVo>> getCurMovieList();
	/**
	 * 根据城市查询热映电影，带分页
	 * @param citycode
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<MovieVo>> getCurMovieListByCitycode(String citycode, int from,int maxnum);
	/**
	 * 根据releasedate查询电影ID列表
	 * @param startDate 起始时间
	 * @param endDate 结束时间
	 * @return
	 */
	ResultCode<List<Long>> getMovieListByReleasedate(Date startDate, Date endDate);
	/**
	 * 根据城市查询热映电影，按照clickedtimes、ASC排序
	 * @param citycode
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<MovieVo>> getCurMovieListByCitycodeOrderClickedtimes(String citycode);
	/**
	 * 刷新前置电影ID
	 * @return
	 */
	ResultCode<Long> refreshQzMovieid();
	/**
	 * 根据影片id，影片名称获得影片条数
	 * @param movieid
	 * @param movieName
	 * @return
	 */
	ResultCode<Integer> getMovieCountByidAndName(Long movieid, String movieName);
	/**
	 * 根据影片名称查询影片
	 * @param moviename
	 * @return
	 */
	ResultCode<List<MovieVo>> getMovieListByMovieName(String moviename);
	/**
	 * 根据影片名称查询影片
	 * @param moviename
	 * @return
	 */
	ResultCode<List<MovieVo>> getMovieListByLikeMovieName(String moviename);
	/**
	 * 获取下线的影片列表
	 * @param citycode
	 * @param order
	 * @return
	 */
	ResultCode<List<MovieVo>> getOffLineMoveList(String citycode, String order);
	/**
	 * 后台管理影片列表
	 * @param hot
	 * @param moviename
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	ResultCode<List<MovieVo>> getAdminMovieList(String hot, String moviename, Date fromDate, Date toDate);
	/**
	 * 根据放映日期和结束时间查询影片信息
	 * @param playdate
	 * @param endDate
	 * @return
	 */
	ResultCode<List<MovieVo>> getMovieListByDate(String playdate, String endDate);
	/**
	 * 更具影院ID查询当前热门影片
	 * @param cinemaId
	 * @return 当前电影院的放映影片列表
	 */
	ResultCode<List<MovieVo>> getCurMovieListByCinemaId(Long cinemaId);
	/**
	 * 某影院某天的影片
	 * @param cinemaId
	 * @param playdate
	 * @return
	 */
	ResultCode<List<MovieVo>> getCurMovieListByCinemaIdAndDate(Long cinemaId, Date playdate);
	/**
	 * 按照电影的开始时间和结束时间查询影片信息有分页
	 * @param playdate
	 * @param endDate
	 * @return
	 */
	ResultCode<List<MovieVo>> getMovieListByDateAndPage(String playdate, String endDate,int from,int maxnum);
	/**
	 * 根据放映日期和结束时间查询影片数
	 * @param playdate
	 * @param endDate
	 * @return
	 */
	ResultCode<Integer> countMovieListByDate(String playdate, String endDate);
	/**
	 * 获取当前电影关联的视频
	 * @param movieid
	 * @return
	 */
	ResultCode<MovieVideoVo> getMovieVideoByMovieId(Long movieid);
	/**
	 * 获取视频
	 * @param videoid
	 * @return
	 */
	ResultCode<MovieVideoVo> getMovieVideoByVideoid(String videoid);
	/**
	 * 校验movie是否存在
	 * @param idList
	 * @return 返回不存在的id
	 */
	ResultCode<List<Long>> checkMovieExist(List<Long> idList);
	/**
	 * 查询电影节电影
	 * @param flag
	 * @return
	 */
	ResultCode<List<Long>> getFilmFestMovieIdList(String flag);
	/**
	 * 获得热门电影和影人
	 * @param citycode
	 * @param cinemaid
	 * @param playdate
	 * @return
	 */
	ResultCode<Map<String,Object>> getHotMovieAndStar(String citycode,Long cinemaid, Date playdate);
	/**
	 * 获取影片列表
	 * @param from 开始记录数
	 * @param rows 获取记录数
	 * @return
	 */
	ResultCode<List<MovieVo>> getMovieList(Integer from, Integer rows);
	/**
	 * 影片的总记录数
	 * @return
	 */
	ResultCode<Integer> getAllMovieCount();
	/**
	 * 根据电影ID查询明星见面会
	 * @param movieid 电影ID，不能为空
	 * @return 返回符合条件的场次ID列表
	 */
	ResultCode<List<Long>> getMpidListByMovieidAndStarmeet(final Long movieid);
	/**
	 * 根据更新时间获取需要字段的ListMap
	 * @param fields
	 * @param updatetime
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<Map>> getFieldsMapByUpdate(String fields, Timestamp updatetime, int from, int maxnum);
	/**
	 * 根据电影ID获取影人接口
	 * @param movieId
	 * @return Map<key, value> 
	 * key:startid(角色ID),relename(饰演角色),chinesename(中文名),engname(英文名),headPicUrl(头像),role
	 * 
	 */
	ResultCode<List<Map<String, Object>>> getStarListByMovieId(Long movieId);
	ResultCode<MovieVo> updateMovieProperties(Long movieId, String[] properties, Serializable[] values);
	// TODO 专题发版后删除该接口
	/**
	 * 查询当日放映的电影
	 * @param playdate 日期类型 
	 * @return
	 */
	ResultCode<List<MovieVo>> getCurMovieListByDate(Date playdate );
	/**
	 * 查询当日放映的电影
	 * @param playdate 日期类型 
	 * @return
	 */
	ResultCode<List<MovieVo>> getCurMovieListByDate(String citycode, Date playdate, int from, int maxnum);
	/**
	 * 查询放映日期在时间段内的影片
	 * @param startPlayDate 必输
	 * @param endPlayDate 必输
	 * @return
	 */
	ResultCode<List<MovieVo>> getMovieListBetweenPlaydate(String startPlayDate, String endPlayDate);
	/**
	 * 查询全球首映日期在时间段内的影片
	 * @param startReleasedate 必输
	 * @param endReleasedate 必输
	 * @param offlineDate 可以为空
	 * @return
	 */
	ResultCode<List<MovieVo>> getMovieListBetweenReleasedate(Date startReleasedate, Date endReleasedate, String offlineDate);
	/**
	 * 获取可搜索的电影列表
	 * @return
	 */
	ResultCode<String> getSearchMovieOrderReleasedate();
	
	/**
	 * 获取电影评分
	 * @param movieId
	 * @return
	 */
	ResultCode<String> getMovieMark(Long movieId);
	/**
	 * 根据电影名称获取电影ID，缓存2小时
	 * @param moviename
	 * @return
	 */
	ResultCode<Long> getCacheMovieIdByMoviename(String moviename);
	
	/**
	 * 获取指定更新时间之后的电影ID列表
	 * @return
	 */
	ResultCode<List<Long>> getMovieListByUpdatetime(Timestamp updatetime, int from,int maxnum);
}

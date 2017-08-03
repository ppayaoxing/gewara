package com.gewara.movie.api.service.admin;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.MovieVo;

public interface MovieAdminVoService {
	/**
	 * 获取某天开放购票的影片
	 * @param citycode
	 * @param cinemaid
	 * @param playdate
	 * @return
	 */
	ResultCode<List<MovieVo>> getOpiMovieList(String citycode, Long cinemaid, Date playdate);
	/**
	 * 获得首字母排序的影片
	 * @param movieid
	 * @return
	 */
	ResultCode<List<MovieVo>> getMovieListFirstLetterSort(Long movieid);
	/**
	 * 保存影片对象
	 * @param paramVo
	 * @return
	 */
	ResultCode<MovieVo> saveOrUpdateMovie(RequestParamVo paramVo, boolean isPushSearchKey);
	/**
	 * 修改movie属性
	 * @param userid
	 * @param movieId
	 * @param properties
	 * @param values
	 * @return
	 */
	ResultCode<MovieVo> updateMovieProperties(Long movieId, String[] properties, Serializable[] values);
	/**
	 * 保存movie对象，及相关联对象
	 * @param paramVo
	 * @return
	 */
	ResultCode<MovieVo> saveMovieAndRelatedObject(RequestParamVo paramVo);
	/**
	 * 查询出updateTime小于等于datatime的影片
	 * @param dateTime
	 * @return
	 */
	ResultCode<List<MovieVo>> getMovieListByUpdateTimeLeDateTime(Timestamp dateTime);
	/**
	 * 电影节服务，根据id修改flag
	 * @param paramVo
	 * @return
	 */
	ResultCode updateOtherInfoByMovieIds(String ids, String type);
	
}

package com.gewara.movie.api.service.admin;

import java.io.Serializable;
import java.util.List;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.CinemaProfileVo;

public interface CinemaProfileAdminVoService {
	/**
	 * 保存CinemaProfile对象
	 * @param userid
	 * @param cinemaId
	 * @param dataMap
	 * @return
	 */
	ResultCode<CinemaProfileVo> saveOrUpdateCinemaProfile(RequestParamVo paramVo);
	/**
	 * 修改cinemaprofile属性
	 * @param userid
	 * @param movieId
	 * @param properties
	 * @param values
	 * @return
	 */
	ResultCode<CinemaProfileVo> updateCinemaProfileProperties(Long userid, Long cinemaId, String[] properties, Serializable[] values);
	/**
	 * 批量设置Insure
	 * @param userid
	 * @param cityCode
	 * @param status
	 * @return
	 */
	ResultCode<List<CinemaProfileVo>> batchSetCinemaInsureStatus(Long userid, String cityCode, String status);
	/**
	 * 设置Insure
	 * @param userid
	 * @param cinemaId
	 * @param status
	 * @return
	 */
	ResultCode<CinemaProfileVo> setCinemaInsureStatus(Long userid, Long cinemaId, String status);
	/**
	 * 清空cinemaprof 的opentype
	 * @param cinemaid
	 * @return
	 */
	ResultCode<CinemaProfileVo> cleanCinemaInfo(Long cinemaid);
	
	/**
	 * 根据id获取CinemaProfileVo
	 * @param cinemaid
	 * @return
	 */
	ResultCode<CinemaProfileVo> getCinemaProfileById(Long cinemaId);
}

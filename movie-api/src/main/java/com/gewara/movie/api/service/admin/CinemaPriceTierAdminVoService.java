package com.gewara.movie.api.service.admin;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;

public interface CinemaPriceTierAdminVoService {
	
	/**
	 * 根据影院id查询影院价格类型
	 * @param cinemaId 影院id
	 * @return
	 */
	ResultCode<Map> getCinemaPriceTierByCinemaId(Long cinemaId);
	
	/**
	 * 根据影院id查询影院价格类型列表
	 * @param cinemaId 影院id
	 * @return
	 */
	ResultCode<List<Map>> getCinemaPriceTierListByCinemaId(Long cinemaId);
	
	/**
	 * 根据影院id列表查询影院价格类型
	 * @param cinemaId 影院id
	 * @return
	 */
	ResultCode<List<Map>> getCinemaPriceTierByCinemaIdList(List<Long> cinemaIdList);
	
	
	/**
	 * 根据城市编码查询影院价格类型
	 * @param cityCode
	 * @return
	 */
	ResultCode<List<Map>> getCinemaPriceTierByCityCode(String cityCode);
	
	/**
	 *根据城市编码查询影院价格类型并排序
	 *@param cityCode 城市编码
	 * @return
	 */
	ResultCode<List<Map>> getCinemaPriceTierByCityCodeAsc(String cityCode);
	
	/**
	 * 根据cinemaId删除影院价格类型
	 * @param cinemaId
	 * @return
	 */
	ResultCode removeCinemaPriceTierByCinemaId(Long cinemaId);
	
	
	/**
	 * 新增影院价格类型 CinemaId
	 * @param cinemaPriceTier
	 */
	ResultCode addCinemaPriceTierByCinemaId(Map cinemaPriceTier);
	
	/**
	 * 新增影院价格类型  _id
	 * @param cinemaPriceTier
	 */
	ResultCode addCinemaPriceTierBySystemId(Map cinemaPriceTier);
	
	/**
	 * 新增/更新影院价格类型
	 */
	ResultCode saveOrUpdateByCinemaId(Map cinemaPriceTier);

}

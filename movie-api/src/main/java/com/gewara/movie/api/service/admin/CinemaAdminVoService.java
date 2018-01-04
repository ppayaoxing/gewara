package com.gewara.movie.api.service.admin;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.CinemaRoomVo;
import com.gewara.movie.vo.CinemaVo;
/**
 * 后台影院查询服务，只有后台可以调用
 * @author gewara
 *
 */
public interface CinemaAdminVoService {
	/**
	 * 获得热门城市影院ID
	 * @return
	 */
	ResultCode<List<Long>> getBookingOpenCinemaIdListByCityCodes(List<String> cityCodes);
	/**
	 * 获得城市影院列表(ID NAME)
	 * @return
	 */
	ResultCode<List<Map>> getCinemaNameAndIdListByCityCodes(List<String> cityCodes);
	/**
	 * 根据城市代码查询影院信息（分页）
	 * @param citycode
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<CinemaVo>> getCinemaListByCitycodeForPage(String citycode, int from, int maxnum);
	/**
	 * 根据城市代码、名称，查询影院信息
	 * @param citycode
	 * @param name
	 * @return
	 */
	ResultCode<List<CinemaVo>> getCinemaPlaceByName(String citycode, String name);
	/**
	 * 获取某天开放购票的影院
	 * @param citycode
	 * @param cinemaid
	 * @param playdate
	 * @return
	 */
	ResultCode<List<CinemaVo>> getOpiCinemaList(String citycode, Long movieid, Date playdate);
	/**
	 * 保存cinema对象
	 * @param paramVo
	 * @param isPushSearchKey
	 * @return
	 */
	ResultCode<CinemaVo> saveOrUpdateCinema(RequestParamVo paramVo, boolean isPushSearchKey);
	/**
	 * 修改cinema属性
	 * @param cinemaId
	 * @param properties
	 * @param values
	 * @return
	 */
	ResultCode<CinemaVo> updateCinemaProperties(Long cinemaId, String[] properties, Serializable[] values);
	/**
	 * 查询影院信息，根据key和citycode
	 * @param citycode
	 * @param key
	 * @return
	 */
	ResultCode<List<CinemaVo>> getCinemaListByKeyAndCityCode(String citycode, String key);
	/**
	 * 修改cinema对象中，关联的roomId
	 * @param cinemaId
	 * @param cinemaRoomId
	 * @param isAdd
	 * @return
	 */
	ResultCode<CinemaVo> updateRecommendRoom(Long cinemaId, Long cinemaRoomId, boolean isAdd);
	/**
	 * 查询影院信息（分页）
	 * @param orderField
	 * @param asc
	 * @param from
	 * @param rows
	 * @return
	 */
	ResultCode<List<CinemaVo>> getCinemaListForPage(String orderField, boolean asc, int from, int rows);
	/**
	 * 导入pcid
	 * @param pcidData
	 * @return
	 */
	ResultCode<LinkedList<String>> initImportCinemaPcid(String pcidData);
	/**
	 * 查询cinemaRoom信息
	 * @param cinemaid
	 * @param citycode
	 * @param provincecode
	 * @return
	 */
	ResultCode<List<CinemaRoomVo>> getReportCinemaRoomList(Long cinemaid, String citycode, String provincecode, Integer pageNo, Integer pageSize);
	
	ResultCode<CinemaVo> getCinemaById(Long cinemaId);
}

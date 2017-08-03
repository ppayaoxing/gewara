package com.gewara.drama.dubbo;

import java.sql.Timestamp;
import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreProfileVo;
import com.gewara.drama.vo.TheatreRoomVo;
import com.gewara.drama.vo.TheatreToDramaVo;
import com.gewara.drama.vo.TheatreVo;

public interface TheatreVoService {
	
	/**
	 * 通过城市代码查询是场馆信息
	 * @param citycode
	 * @param order
	 * @param asc
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<TheatreVo>> getTheatreList(String citycode, String order, boolean asc, int from, int maxnum);
	
	/**
	 * 根据城市代码获取可购票场地列表(可购票)
	 * @param citycode
	 * @return
	 */
	ResultCode<List<TheatreVo>> getTheatreList(String citycode);
	
	/**
	 * 根据id获取演出场馆
	 * @param placeId
	 * @return
	 */
	ResultCode<TheatreVo> getTheatreById(Long id);
	
	ResultCode<List<TheatreVo>> getTheatreListByIdList(Long ... id);

	/**
	 * 更新时间查询场馆数据
	 * @param updatetime
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<TheatreVo>> getTheatreListByUpdatetime(Timestamp updatetime, int from, int maxnum);
	
	/**
	 * 根据城市编码与项目编码查询有排期的场馆
	 * @param citycode
	 * @param dramaid
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<TheatreVo>> getTheatreListByCitycodeAndDramaid(String citycode, Long dramaid, int from, int maxnum);
	
	/**
	 * 查询场馆演出项目信息
	 * @param theatreid
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<TheatreToDramaVo>> getTheatreToDramaListByTheatreid(Long theatreid, int from, int maxnum);
	
	ResultCode<List<TheatreToDramaVo>> getTheatreToDramaListByDramaid(Long dramaid);
	
	/**
	 * 根据hotvalue查询theatre列表
	 * @param hotvalue
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<TheatreVo>> getTheatreListByHotvalue(String citycode, Integer hotvalue, int from, int maxnum);
	
	ResultCode<TheatreVo> getTheatreByName(String theatreName);
	
	ResultCode<Integer> getTheatreCountByBooking(String booking);
	
	ResultCode<TheatreRoomVo> getTheatreRoomById(Long id);
	
	ResultCode<TheatreProfileVo> getTheatreProfileById(Long theatreid);
	
	/**
	 * 根据citycode和演出结束时间加offsetDays偏移天数查询theatre列表
	 * @param citycode
	 * @param offsetDays
	 * @return
	 */
	ResultCode<List<TheatreVo>> getTheatreListByCityCodeAndEndTime(String citycode, int offsetDays);
	
	ResultCode<List<Long>> getTheatreIdList(String citycode, Long dramaid, boolean isBooking);
}

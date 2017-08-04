package com.gewara.drama.dubbo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaProfileVo;
import com.gewara.drama.vo.DramaRaidersVo;
import com.gewara.drama.vo.DramaVo;
import com.gewara.drama.vo.OpenDramaItemVo;
import com.gewara.drama.vo.TheatreVo;

public interface DramaVoService {
	
	/**
	 * 根据场地id获取演出列表
	 * @param placeId
	 * @return
	 */
	ResultCode<List<DramaVo>> getDramaList (Long placeId);
	
	/**
	 * 根据id获取演出项目
	 * @param placeId
	 * @return
	 */
	ResultCode<DramaVo> getDramaById(Long id);
	
	/**
	 * 根据id获取演出项目
	 * @param placeId
	 * @return
	 */
	ResultCode<List<DramaVo>> getDramaListByIdList(Long ... id);
	
	/**
	 * 项目ID是否可购票
	 * @param dramaid
	 * @return
	 */
	ResultCode<Boolean> getDramaBooking(Long dramaid);
	
	/**
	 * 查询项目的价格
	 * @param dramaid
	 * @return
	 */
	ResultCode<List<Integer>> getDramaPriceListByDramaid(Long dramaid);
	
	/**
	 * 更新时间查询演出项目
	 * @param updatetime
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<DramaVo>> getDramaListByUpdatetime(Timestamp updatetime, int from, int maxnum);
	
	/**
	 * 根据演出详情增加演出攻略
	 * @param dramaid
	 * @return
	 */
	ResultCode<List<DramaRaidersVo>> getDramaRaidersListByDramaid(Long dramaid);
	
	/**
	 * 获取项目基础信息
	 * @param dramaid
	 * @return
	 */
	ResultCode<DramaProfileVo> getDramaProfileByDramaid(Long dramaid);
	
	/**
	 * 获取项目基础信息列表
	 * @param dramaids
	 * @return
	 */
	ResultCode<List<DramaProfileVo>> getDramaProfileByDramaidList(Long... dramaids);
	
	ResultCode<List<DramaVo>> getHotDrama(String citycode, String order, int from,int maxnum);
	
	/**
	 *  查询某明星关联的话剧
	 *  starid : 明星ID
	 *  isCurrent: 是否正在上映
	 */
	ResultCode<List<DramaVo>> getDramaListByStarid(Long starid, boolean isCurrent, int from, int maxnum);
	
	ResultCode<Integer> getDramaCountByStarid(Long starid, boolean isCurrent);
	
	ResultCode<List<DramaVo>> getFutureDramaList(String citycode, Date fromDate, int from, int maxnum);
	
	/**
	 * 项目名称精确查询项目
	 * @param dramaName
	 * @return
	 */
	ResultCode<DramaVo> getDramaByName(String dramaName);
	
	/**
	 * 项目名称模糊查询项目
	 * @param dramaName
	 * @return
	 */
	ResultCode<List<DramaVo>> getDramaListByName(String dramaName);
	
	
	ResultCode<List<Long>> getDramaIdListByReserve();
	
	/**
	 * 
	* @Description: 根据城市code和某一天日期获取项目
	* @param citycode
	* @param someDay
	* @param from maxnum
	 */
	ResultCode<List<DramaVo>> getDramaSomeDayCalendar(String citycode,Date someDay,int from,int maxnum);

	ResultCode<TheatreVo> getTheatreVoById(Long theatreid);

	ResultCode<OpenDramaItemVo> getOpenDramaItemVoById(Long dpid);

}

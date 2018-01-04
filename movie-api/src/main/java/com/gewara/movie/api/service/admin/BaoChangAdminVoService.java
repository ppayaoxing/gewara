package com.gewara.movie.api.service.admin;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.baochang.BaoChangMpiInfoVo;
import com.gewara.movie.vo.baochang.BaoChangOrderInfoVo;

public interface BaoChangAdminVoService {
	/**
	 * 保存包场信息
	 * @param cinemaid
	 * @param roomid
	 * @param params
	 * @return
	 */
	ResultCode saveOrUpdateBaoChangCinemaInfo(Long cinemaid, Long roomid, 
			Map<String, String> cinemaRoomParams, List<Map<String, String>> baoChangTimeList);
	/**
	 * 删除包场影厅信息
	 * @param cinemaid
	 * @param roomid
	 * @return
	 */
	ResultCode deleteBaoChangCinemaRoom(Long cinemaid, Long roomid);
	/**
	 * 删除包场影院信息
	 * @param cinemaid
	 * @return
	 */
	ResultCode<List<Long>> deleteBaoChangCinema(Long cinemaid);
	/**
	 * 保存包场场次ID和状态
	 * @param id
	 * @param mpid
	 * @param status
	 * @return
	 */
	ResultCode<BaoChangOrderInfoVo> saveMpidToBaoChangOrder(Long id, Long mpid, String status, String remark, Integer successPrice);
	/**
	 * 保存包场短信模版
	 * @param tag
	 * @param content
	 * @return
	 */
	ResultCode saveBaoChangMsgContent(String mobileType, String tag, String content);
	/**
	 * 刷新包场信息缓存
	 * @param cinemaid
	 * @return
	 */
	ResultCode refreshBaoChangInfoCacheByCinemaid(Long cinemaid);
	/**
	 * 刷新包场信息缓存
	 * @param cinemaid
	 * @param roomid
	 * @return
	 */
	ResultCode refreshBaoChangInfoCacheByCinemaidAndRoomid(Long cinemaid, Long roomid);
	/**
	 * 保存包场场次信息
	 * @param mpid
	 * @return
	 */
	ResultCode saveOrUpdateBaoChangMpiInfo(Long mpid);
	/**
	 * 删除包场场次信息
	 * @param cinemaid
	 * @param mpid
	 * @return
	 */
	ResultCode<BaoChangMpiInfoVo> deleteBaoChangMpiInfo(Long cinemaid, Long mpid);

}

package com.gewara.movie.api.service.admin;

import java.io.Serializable;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.CinemaRoomVo;

public interface CinemaRoomAdminVoService {
	/**
	 * 保存cinemaRoom对象
	 * @param roomId
	 * @param seatStyle
	 * @param seatMark
	 * @return
	 */
	ResultCode<CinemaRoomVo> addOuterRingSeat(Long roomId, String seatStyle, String seatMark);
	/**
	 * 修改cinemaRoom属性值
	 * @param userid 不能为空
	 * @param roomid
	 * @param properties
	 * @param values
	 * @return
	 */
	ResultCode<CinemaRoomVo> updateCinemaRoomProperties(Long userid, Long roomid, String[] properties, Serializable[] values);
	/**
	 * 保存cinemaRoom对象
	 * @param userid 不能为空
	 * @param roomid
	 * @param dataMap
	 * @return
	 */
	ResultCode<CinemaRoomVo> saveOrUpdateCinemaRoom(RequestParamVo paramVo);
	/**
	 * 影厅特效数据升级
	 * @return
	 */
	ResultCode<String> updateCinemaRoomData();
	/**
	 * 修改cinemaRoom对象
	 * @param paramVo
	 * @return
	 */
	ResultCode<String> updateRoom(RequestParamVo paramVo);
		
	/**
	 * 根据TicketRoom更新CinemaRoom
	 * @param cinemaid
	 * @return
	 */
	ResultCode updateCinemaRoomByTicketRoom(Long cinemaid);
}

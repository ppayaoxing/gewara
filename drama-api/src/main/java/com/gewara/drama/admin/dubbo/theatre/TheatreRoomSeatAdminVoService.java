package com.gewara.drama.admin.dubbo.theatre;

import java.util.List;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreRoomSeatVo;
import com.gewara.drama.vo.TheatreRoomVo;
/**
 * 基础区域座位操作(后台)
 * @author john
 *
 */
public interface TheatreRoomSeatAdminVoService {

	/**
	 * 通过区域查询区域座位信息
	 * @param roomid
	 * @return
	 */
	ResultCode<List<TheatreRoomSeatVo>> getTheatreRoomSeatList(Long roomid);

	/**
	 * 区域增加一行
	 * @param roomId
	 * @return
	 */
	ResultCode<TheatreRoomVo> addRowSeat(Long roomId);

	/**
	 * 区域增加一列
	 * @param roomId
	 * @return
	 */
	ResultCode<TheatreRoomVo> addRankSeat(Long roomId);

	/**
	 * 区域删除一列
	 * @param roomId
	 * @return
	 */
	ResultCode<Boolean> deleteRankSeatByRoomid(Long roomId);

	/**
	 * 区域删除一行
	 * @param roomId
	 * @return
	 */
	ResultCode<Boolean> deleteRowSeatByRoomid(Long roomId);

	/**
	 * 通过区域ID与座位物理坐标查询座位
	 * @param roomid
	 * @param lineno
	 * @param rankno
	 * @return
	 */
	ResultCode<TheatreRoomSeatVo> getTheatreRoomSeatByPosition(Long roomid, int lineno, int rankno);

	/**
	 * 通过区域ID与物理座标行号更新座位行号
	 * @param roomid
	 * @param lineno
	 * @param seatline
	 * @return
	 */
	ResultCode<Boolean> updateSeatlineByRoomSeatLineno(Long roomid, int lineno, String seatline);

	/**
	 * 
	 * 通过区域ID与物理座标列号更新座位列号
	 * @param roomid
	 * @param rankno
	 * @param seatrank
	 * @return
	 */
	ResultCode<Boolean> updateSeatrankByRoomSeatRankno(Long roomid, int rankno, String seatrank);

	/**
	 * 通过区域ID批量增加座位
	 * @param roomid
	 * @param linelist
	 * @param ranklist
	 * @param userid
	 * @return
	 */
	ResultCode batchAddTheatreRoomSeat(Long roomid, String linelist, String ranklist);

	/**
	 * 通过区域ID批量删除座位
	 * @param roomid
	 * @param linelist
	 * @param ranklist
	 * @param userid
	 * @return
	 */
	ResultCode batchDeleteTheatreRoomSeat(Long roomid, String linelist, String ranklist);

	/**
	 * 通过座位ID更新座位状态
	 * @param seatid
	 * @param initstatus
	 * @return
	 */
	ResultCode updateTheatreRoomSeatInitStatus(Long seatid, String initstatus);

	/**
	 * 通过座位ID设置情侣座
	 * @param seatid
	 * @param loveInd
	 * @return
	 */
	ResultCode updateTheatreRoomSeatLoveInd(Long seatid, String loveInd);

	/**
	 * 获取场地区域座位图的字符串，行与行用“@@”分隔，列用“,”分隔
	 * @param roomid
	 * @return
	 */
	ResultCode<TheatreRoomVo> updateTheatreRoomSeatMapStr(Long roomid);
	
	/**
	 * 获取TheatreRoomVo
	 * @param id
	 * @return
	 */
	ResultCode<TheatreRoomVo> getTheatreRoomById(Long id);
	
	/**
	 * 添加TheatreRoom
	 * @param RequestParamVo
	 * @return
	 */
	ResultCode addBaseSeat(RequestParamVo paramVo);

	/**
	 * 清除TheatreRoom
	 * @param RequestParamVo
	 * @return
	 */
	ResultCode clearBaseSeat(RequestParamVo paramVo);

	/**
	 * 更新RankNo
	 * @param RequestParamVo
	 * @return
	 */
	ResultCode updateBaseSeatRankNo(RequestParamVo paramVo);

}

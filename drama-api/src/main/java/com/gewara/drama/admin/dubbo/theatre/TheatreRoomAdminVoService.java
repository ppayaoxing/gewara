package com.gewara.drama.admin.dubbo.theatre;

import java.util.List;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreRoomVo;

public interface TheatreRoomAdminVoService {
	
	ResultCode<TheatreRoomVo> saveOrUpdateTheatreRoom(RequestParamVo params);
	
	ResultCode<TheatreRoomVo> getTheatreRoomById(Long id);
	
	ResultCode<List<TheatreRoomVo>> getTheatreRoomListByTheatreId(Long theatreid);
	
	ResultCode<List<TheatreRoomVo>> getTheatreRoomListByFieldId(Long fieldid);
	
	ResultCode delTheatreRoom(Long id);
	
	ResultCode<String> setHotzone(RequestParamVo params);
	
	ResultCode<TheatreRoomVo> updateTheatreRoom(RequestParamVo params);
	
	ResultCode<List<TheatreRoomVo>> getTheatreRoomListByFieldnum(Long theatreid, String fieldnum);
	
	ResultCode<String> setSvgData(Long fieldid, String svgData);
	
}

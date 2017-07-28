/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.theatre;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreRoomVo;
import java.util.List;

public interface TheatreRoomAdminVoService {
	ResultCode<TheatreRoomVo> saveOrUpdateTheatreRoom(RequestParamVo arg0);

	ResultCode<TheatreRoomVo> getTheatreRoomById(Long arg0);

	ResultCode<List<TheatreRoomVo>> getTheatreRoomListByTheatreId(Long arg0);

	ResultCode<List<TheatreRoomVo>> getTheatreRoomListByFieldId(Long arg0);

	ResultCode delTheatreRoom(Long arg0);

	ResultCode<String> setHotzone(RequestParamVo arg0);

	ResultCode<TheatreRoomVo> updateTheatreRoom(RequestParamVo arg0);

	ResultCode<List<TheatreRoomVo>> getTheatreRoomListByFieldnum(Long arg0, String arg1);

	ResultCode<String> setSvgData(Long arg0, String arg1);
}
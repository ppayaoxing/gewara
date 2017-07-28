/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.theatre;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreFieldVo;
import java.util.List;

public interface TheatreFieldAdminVoService {
	ResultCode<TheatreFieldVo> saveOrUpdateTheatreField(RequestParamVo arg0);

	ResultCode<TheatreFieldVo> getTheatreFieldById(Long arg0);

	ResultCode<List<TheatreFieldVo>> getTheatreFieldList(List<Long> arg0);

	ResultCode<List<TheatreFieldVo>> getTheatreFieldListById(Long arg0);

	@Deprecated
	ResultCode<List<Long>> getTheatreFieldIdList(String arg0, Long arg1, boolean arg2);

	ResultCode<List<Long>> getTheatreIdList(String arg0, Long arg1, boolean arg2);

	ResultCode delTheatreField(Long arg0);

	ResultCode<TheatreFieldVo> getTheatreFieldByRoomnum(Long arg0, String arg1);
}
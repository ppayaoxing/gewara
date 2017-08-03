package com.gewara.drama.admin.dubbo.theatre;

import java.util.List;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreFieldVo;

public interface TheatreFieldAdminVoService {
	
	ResultCode<TheatreFieldVo> saveOrUpdateTheatreField(RequestParamVo params);
	
	ResultCode<TheatreFieldVo> getTheatreFieldById(Long id);
	
	ResultCode<List<TheatreFieldVo>> getTheatreFieldList(List<Long> idlist);
	
	ResultCode<List<TheatreFieldVo>> getTheatreFieldListById(Long theatreid);
	
	@Deprecated
	ResultCode<List<Long>> getTheatreFieldIdList(String citycode, Long dramaid, boolean isBooking);
	
	ResultCode<List<Long>> getTheatreIdList(String citycode, Long dramaid, boolean isBooking);
	
	ResultCode delTheatreField(Long id);
	
	ResultCode<TheatreFieldVo> getTheatreFieldByRoomnum(Long theatreid, String roomnum);
	
}

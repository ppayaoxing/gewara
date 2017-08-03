package com.gewara.drama.dubbo;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreFieldVo;

public interface TheatreFieldVoService {
	
	ResultCode<TheatreFieldVo> getTheatreFieldById(Long id);
	
	ResultCode<List<TheatreFieldVo>> getTheatreFieldList(List<Long> ids);
	
	@Deprecated
	ResultCode<List<Long>> getTheatreFieldList(String citycode, Long dramaid, boolean isBooking);
	
}

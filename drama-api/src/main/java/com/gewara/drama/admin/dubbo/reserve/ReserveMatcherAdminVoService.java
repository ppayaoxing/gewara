package com.gewara.drama.admin.dubbo.reserve;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.ReserveMatcherVo;

public interface ReserveMatcherAdminVoService {
	
	ResultCode<ReserveMatcherVo> getReserveMatcher(Long id);
	
	ResultCode<List<ReserveMatcherVo>> getReserveMatcherListByField(String fieldname, Serializable fieldvalue);
	
	ResultCode<ReserveMatcherVo> saveReserveMatcher(RequestParamVo paramVo);
	
	ResultCode removeReserveMatcher(Long id);
	
	ResultCode saveReserveMatcher(List<Map> matchDataList);


}

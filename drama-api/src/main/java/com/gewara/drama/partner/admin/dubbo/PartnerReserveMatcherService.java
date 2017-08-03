package com.gewara.drama.partner.admin.dubbo;

import java.util.List;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.ReserveMatcherVo;

public interface PartnerReserveMatcherService {

	ResultCode<List<ReserveMatcherVo>> getReserveMatchersForCooperUser(List<Long> dramaIdList);
	
	ResultCode<ReserveMatcherVo> getReserveMatcherById(Long id);
	
	ResultCode<ReserveMatcherVo> saveReserveMatcher(RequestParamVo paramsVo);
}

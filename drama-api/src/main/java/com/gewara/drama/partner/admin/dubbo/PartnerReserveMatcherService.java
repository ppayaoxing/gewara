/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.partner.admin.dubbo;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.ReserveMatcherVo;
import java.util.List;

public interface PartnerReserveMatcherService {
	ResultCode<List<ReserveMatcherVo>> getReserveMatchersForCooperUser(List<Long> arg0);

	ResultCode<ReserveMatcherVo> getReserveMatcherById(Long arg0);

	ResultCode<ReserveMatcherVo> saveReserveMatcher(RequestParamVo arg0);
}
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.reserve;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.ReserveMatcherVo;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ReserveMatcherAdminVoService {
	ResultCode<ReserveMatcherVo> getReserveMatcher(Long arg0);

	ResultCode<List<ReserveMatcherVo>> getReserveMatcherListByField(String arg0, Serializable arg1);

	ResultCode<ReserveMatcherVo> saveReserveMatcher(RequestParamVo arg0);

	ResultCode removeReserveMatcher(Long arg0);

	ResultCode saveReserveMatcher(List<Map> arg0);
}
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.activity.service;

import com.gewara.api.activity.domain.ActivityFeeVo;
import com.gewara.api.vo.ResultCode;
import java.util.List;

public interface ActivityOpenApiService {
	ResultCode<String> updateOrder(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5,
			String arg6);

	ResultCode<List<ActivityFeeVo>> formula(Long arg0);

	ResultCode<ActivityFeeVo> getFee(Long arg0);

	ResultCode<List<ActivityFeeVo>> getActivityFeesByActivityIDAllStatus(Long arg0);
}
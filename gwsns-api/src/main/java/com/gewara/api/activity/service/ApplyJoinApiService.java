/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.activity.service;

import com.gewara.api.activity.domain.ActivityInfoVo;
import com.gewara.api.activity.domain.ActivityJoinFormVo;
import com.gewara.api.activity.domain.ApplyJoinVo;
import com.gewara.api.vo.ResultCode;
import java.util.List;

public interface ApplyJoinApiService {
	ResultCode<List<ApplyJoinVo>> getApplyJoinListByActivityid(Long arg0, int arg1, int arg2);

	ResultCode<ApplyJoinVo> getApplyJoin(Long arg0, Long arg1);

	ResultCode saveApplyJoin(Long arg0, Long arg1, String arg2, String arg3, String arg4, String arg5, String arg6,
			Integer arg7, String arg8, String arg9);

	void addActivityInfo(ActivityInfoVo arg0);

	void updateActivityInfo(ActivityInfoVo arg0);

	ResultCode<ActivityInfoVo> getActivityInfoByMemberid(Long arg0);

	ResultCode<ActivityJoinFormVo> getJoinFormByActivityId(Long arg0);
}
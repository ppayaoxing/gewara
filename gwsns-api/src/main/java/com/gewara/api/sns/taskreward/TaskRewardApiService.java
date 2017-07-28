/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.taskreward;

import com.gewara.api.sns.vo.taskreward.TaskRewardVo;
import com.gewara.api.vo.ResultCode;
import java.util.List;

public interface TaskRewardApiService {
	ResultCode<List<TaskRewardVo>> getTaskRewardList(String arg0, String arg1, Integer arg2, String arg3);

	ResultCode<List<Long>> getUnFinishedTaskRewardList(Long arg0, List<Long> arg1);

	void saveFinishedTask(Long arg0, String arg1);

	ResultCode<Boolean> checkHasFinishedTask(Long arg0, String arg1);

	ResultCode<TaskRewardVo> getTaskRewardDetail(String arg0);

	ResultCode<List> getTaskRewardBatch(String arg0, int arg1, int arg2);

	ResultCode<List<TaskRewardVo>> getTaskRewardListByIds(List<Long> arg0);

	ResultCode<String> getScoreDesc();
}
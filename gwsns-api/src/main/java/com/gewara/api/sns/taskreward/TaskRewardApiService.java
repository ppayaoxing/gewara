package com.gewara.api.sns.taskreward;

import java.util.List;

import com.gewara.api.sns.vo.taskreward.TaskRewardVo;
import com.gewara.api.vo.ResultCode;

public interface TaskRewardApiService {

	/**
	 * 获取任务列表
	 * 
	 * @param type
	 * @param name
	 * @param score
	 * @param status
	 * @return
	 */
	ResultCode<List<TaskRewardVo>> getTaskRewardList(String type, String name, Integer score, String status);

	/**
	 * 获取为完成的任务
	 * 
	 * @param memberid
	 * @param taskid
	 * @return
	 */
	ResultCode<List<Long>> getUnFinishedTaskRewardList(Long memberid, List<Long> taskid);

	/**
	 * 完成任务
	 * 
	 * @param memberid
	 * @param type
	 */
	void saveFinishedTask(Long memberid, String type);
	
	/**
	 * 判断是否做过该任务
	 * @param memberid
	 * @param type
	 * @return
	 */
	ResultCode<Boolean> checkHasFinishedTask(Long memberid, String type);
	
	/**
	 * 获取详情
	 * @param type
	 * @return
	 */
	ResultCode<TaskRewardVo> getTaskRewardDetail(String type);
	
	/**
	 * 获取任务批次信息
	 * @param status
	 * @return
	 */
	ResultCode<List> getTaskRewardBatch(String status, int from, int maxnum);
	
	/**
	 * 根据id查找任务
	 * @param taskids
	 * @return
	 */
	ResultCode<List<TaskRewardVo>> getTaskRewardListByIds(List<Long> taskids);
	
	/**
	 * 积分赠送提示语
	 * @return
	 */
	ResultCode<String> getScoreDesc();

}

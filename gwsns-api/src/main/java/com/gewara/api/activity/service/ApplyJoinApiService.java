package com.gewara.api.activity.service;

import java.util.List;

import com.gewara.api.activity.domain.ActivityInfoVo;
import com.gewara.api.activity.domain.ActivityJoinFormVo;
import com.gewara.api.activity.domain.ApplyJoinVo;
import com.gewara.api.vo.ResultCode;

public interface ApplyJoinApiService {


	/**
	 * 获取活动的参与信息
	@RequestMapping("/api/applyjoin/list/byActivityId.xhtml")
	 * @param activityid
	 * @param from
	 * @param maxnum
	 * @return
	 */
	public ResultCode<List<ApplyJoinVo>> getApplyJoinListByActivityid(
			Long activityid, int from, int maxnum);


	/**
	 * 获取用户参加的活动信息
	@RequestMapping("/api/applyjoin/getByMemberIdAndActivityId.xhtml")
	 * @param memberid
	 * @param activityid
	 * @return
	 */
	public ResultCode<ApplyJoinVo> getApplyJoin(Long memberid, Long activityid);

	/**
	 * 保存活动地址信息
	 * @param applyJoinVo
	 * @return
	 */
	public ResultCode saveApplyJoin(Long activityid,Long memberid, String mobile,String realName,String sex,String address,String birthData,Integer joinnum, String TradeNo,String jsonString);
	
	/**
	 * 添加活动报名基础信息
	 * @param activityInfo
	 * @return
	 */
	public void addActivityInfo(ActivityInfoVo activityInfo);
	/**
	 * 修改活动报名基础信息
	 * @param activityInfo
	 * @return
	 */
	public void updateActivityInfo(ActivityInfoVo activityInfo);
	/**
	 * 根据用户编号获取用户活动基础信息
	 * @param memberid
	 * @return
	 */
	public ResultCode<ActivityInfoVo> getActivityInfoByMemberid(Long memberid);
	/**
	 * 获取活动报名信息选项
	 * @param activityid
	 * @return
	 */
	public ResultCode<ActivityJoinFormVo> getJoinFormByActivityId(Long activityid);
}
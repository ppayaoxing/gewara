package com.gewara.api.activity.service;

import java.util.List;

import com.gewara.api.vo.ResultCode;

public interface ActivityMappingApiService {
	/**
	 * 获取活动关联的对象列表
	 * @param activityid 活动ID
	 * @param tag 活动关联类型
	 */
	public ResultCode<List<Long>> getRelatedIds(Long activityid, String tag);
}

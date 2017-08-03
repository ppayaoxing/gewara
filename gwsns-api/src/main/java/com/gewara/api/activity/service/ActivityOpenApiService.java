package com.gewara.api.activity.service;

import java.util.List;

import com.gewara.api.activity.domain.ActivityFeeVo;
import com.gewara.api.vo.ResultCode;

public interface ActivityOpenApiService {

	//@RequestMapping("/openapi/activity/updateOrder.xhtml")
	public ResultCode<String> updateOrder(String memberEncode, String mobile,
			String realname, String address, String jsonString, String tradeNo,
			String sex);


	//@RequestMapping("/openapi/activity/getFeeList.xhtml")
	public ResultCode<List<ActivityFeeVo>> formula(Long activityId);

	//@RequestMapping("/openapi/activity/getRecommendActivityList.xhtml")
	public ResultCode<ActivityFeeVo> getFee(Long feeid);
	
	public ResultCode<List<ActivityFeeVo>> getActivityFeesByActivityIDAllStatus(Long activityid);

}
package com.gewara.api.activity.response;

import com.gewara.api.activity.ApiResponse;
import com.gewara.api.activity.domain.ActivityVo;


public class GetActivitByIdResponse extends ApiResponse {
	private static final long serialVersionUID = 291317996292156297L;
	
	/**活动信息*/
	private ActivityVo activityVo;

	public GetActivitByIdResponse(){
		super();
	}

	public ActivityVo getActivityVo() {
		return activityVo;
	}

	public void setActivityVo(ActivityVo activityVo) {
		this.activityVo = activityVo;
	}

}

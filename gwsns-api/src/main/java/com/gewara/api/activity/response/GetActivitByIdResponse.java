/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.activity.response;

import com.gewara.api.activity.ApiResponse;
import com.gewara.api.activity.domain.ActivityVo;

public class GetActivitByIdResponse extends ApiResponse {
	private static final long serialVersionUID = 291317996292156297L;
	private ActivityVo activityVo;

	public ActivityVo getActivityVo() {
		return this.activityVo;
	}

	public void setActivityVo(ActivityVo activityVo) {
		this.activityVo = activityVo;
	}
}
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.activity.request;

import com.gewara.api.activity.ApiRequest;
import java.util.HashMap;
import java.util.Map;

public class GetActivitByIdRequest extends ApiRequest {
	private static final long serialVersionUID = 6111593872840003414L;
	private Long activityId;

	public GetActivitByIdRequest() {
	}

	public GetActivitByIdRequest(Long activityId) {
		this.activityId = activityId;
	}

	public Map<String, String> getTextParams() {
		HashMap params = new HashMap();
		params.put("activityId", "" + this.activityId);
		return params;
	}

	public boolean checkParams() {
		return this.activityId != null;
	}

	public Long getActivityId() {
		return this.activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
}
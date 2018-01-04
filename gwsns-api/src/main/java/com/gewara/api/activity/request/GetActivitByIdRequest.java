package com.gewara.api.activity.request;

import java.util.HashMap;
import java.util.Map;

import com.gewara.api.activity.ApiRequest;


public class GetActivitByIdRequest extends ApiRequest {
	private static final long serialVersionUID = 6111593872840003414L;
	
	/**活动Id*/
	private Long activityId;
	
	public GetActivitByIdRequest(){
		
	}
	
	public GetActivitByIdRequest(Long activityId){
		this.activityId = activityId;
	}

	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("activityId", "" + activityId);
		return params;
	}

	@Override
	public boolean checkParams() {
		if(activityId == null){
			return false;
		}
		return true;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

}

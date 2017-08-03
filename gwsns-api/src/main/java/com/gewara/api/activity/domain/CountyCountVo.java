package com.gewara.api.activity.domain;

import java.io.Serializable;

import com.gewara.api.activity.ApiObject;

public class CountyCountVo extends ApiObject{
	private static final long serialVersionUID = -4697385805820683405L;
	private String countycode;
	private Integer count;
	
	public String getCountycode() {
		return countycode;
	}
	public void setCountycode(String countycode) {
		this.countycode = countycode;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public Serializable realId() {
		// TODO Auto-generated method stub
		return countycode;
	}
}

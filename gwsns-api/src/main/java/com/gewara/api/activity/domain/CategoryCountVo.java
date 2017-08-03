package com.gewara.api.activity.domain;

import java.io.Serializable;

import com.gewara.api.activity.ApiObject;

public class CategoryCountVo extends ApiObject{
	private static final long serialVersionUID = -6786003194714145755L;
	private String category;
	private Integer count;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public Serializable realId() {
		// TODO Auto-generated method stub
		return category;
	}
}

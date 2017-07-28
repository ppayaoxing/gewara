/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.activity.domain;

import com.gewara.api.activity.ApiObject;
import java.io.Serializable;

public class CountyCountVo extends ApiObject {
	private static final long serialVersionUID = -4697385805820683405L;
	private String countycode;
	private Integer count;

	public String getCountycode() {
		return this.countycode;
	}

	public void setCountycode(String countycode) {
		this.countycode = countycode;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Serializable realId() {
		return this.countycode;
	}
}
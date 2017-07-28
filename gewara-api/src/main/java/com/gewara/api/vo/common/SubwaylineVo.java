/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.common;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class SubwaylineVo extends BaseVo implements Serializable {
	private static final long serialVersionUID = -1449397931879372657L;
	private Long id;
	private String citycode;
	private String linename;
	private String remark;

	public Serializable realId() {
		return this.id;
	}

	public SubwaylineVo(String linename, String remark) {
		this.linename = linename;
		this.remark = remark;
	}

	public SubwaylineVo() {
	}

	public String getLinename() {
		return this.linename;
	}

	public void setLinename(String linename) {
		this.linename = linename;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
}
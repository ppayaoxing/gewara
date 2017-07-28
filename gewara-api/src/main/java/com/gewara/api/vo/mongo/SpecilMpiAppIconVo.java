/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.mongo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class SpecilMpiAppIconVo extends BaseVo {
	private static final long serialVersionUID = -531528601969796373L;
	private String _id;
	private List<Map<String, Object>> specialMpiList;

	public Serializable realId() {
		return this._id;
	}

	public String get_id() {
		return this._id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public List<Map<String, Object>> getSpecialMpiList() {
		return this.specialMpiList;
	}

	public void setSpecialMpiList(List<Map<String, Object>> specialMpiList) {
		this.specialMpiList = specialMpiList;
	}
}
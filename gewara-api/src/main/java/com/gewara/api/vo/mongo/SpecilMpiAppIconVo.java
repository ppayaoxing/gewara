package com.gewara.api.vo.mongo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gewara.api.vo.BaseVo;

/**
 * 电影APP特殊场次打标
 */
public class SpecilMpiAppIconVo extends BaseVo{
	
	private static final long serialVersionUID = -531528601969796373L;
	private String _id;
	private List<Map<String, Object>> specialMpiList;
	
	@Override
	public Serializable realId() {
		return _id;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public List<Map<String, Object>> getSpecialMpiList() {
		return specialMpiList;
	}
	public void setSpecialMpiList(List<Map<String, Object>> specialMpiList) {
		this.specialMpiList = specialMpiList;
	}

}

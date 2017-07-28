/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.guess;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class BettingOptionCountVo extends BaseVo {
	private static final long serialVersionUID = -9005024924759160315L;
	private Long _id;
	private Long stepid;
	private Integer userCount;
	private Integer point;
	private Integer numCount;

	public Integer getPoint() {
		return this.point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Long getStepid() {
		return this.stepid;
	}

	public void setStepid(Long stepid) {
		this.stepid = stepid;
	}

	public Long get_id() {
		return this._id;
	}

	public void set_id(Long _id) {
		this._id = _id;
	}

	public Serializable realId() {
		return this._id;
	}

	public Integer getUserCount() {
		return this.userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}

	public Integer getNumCount() {
		return this.numCount;
	}

	public void setNumCount(Integer numCount) {
		this.numCount = numCount;
	}
}
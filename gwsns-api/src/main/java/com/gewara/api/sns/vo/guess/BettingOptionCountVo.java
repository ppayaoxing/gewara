package com.gewara.api.sns.vo.guess;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

/**
 * 
 * 猜票房投注选项统计(MongoDB)  
 *
 */
public class BettingOptionCountVo extends BaseVo{
	private static final long serialVersionUID = -9005024924759160315L;
	private Long _id; //主键投注选项ID
	private Long stepid; //设置ID
	private Integer userCount;//投注总人数
	private Integer point;//投注总积分
	private Integer numCount;//投注总倍数
	
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public Long getStepid() {
		return stepid;
	}

	public void setStepid(Long stepid) {
		this.stepid = stepid;
	}
	public Long get_id() {
		return _id;
	}
	public void set_id(Long _id) {
		this._id = _id;
	}
	@Override
	public Serializable realId() {
		return _id;
	}
	public Integer getUserCount() {
		return userCount;
	}
	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}
	public Integer getNumCount() {
		return numCount;
	}
	public void setNumCount(Integer numCount) {
		this.numCount = numCount;
	}
}

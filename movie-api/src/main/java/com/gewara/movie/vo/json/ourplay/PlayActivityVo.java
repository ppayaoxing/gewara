/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.json.ourplay;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class PlayActivityVo extends BaseVo {
	private static final long serialVersionUID = 2677478173649308488L;
	private String activityId;
	private Long playMovieId;
	private Timestamp activityTime;
	private String cinemaAddress;
	private Integer limitPersonCount;
	private Integer limitPonitValue;
	private Timestamp startTime;
	private Timestamp endTime;
	private Timestamp addTime;
	private Timestamp updateTime;
	private Integer applyNum;

	public String getActivityId() {
		return this.activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public Long getPlayMovieId() {
		return this.playMovieId;
	}

	public void setPlayMovieId(Long playMovieId) {
		this.playMovieId = playMovieId;
	}

	public String getCinemaAddress() {
		return this.cinemaAddress;
	}

	public void setCinemaAddress(String cinemaAddress) {
		this.cinemaAddress = cinemaAddress;
	}

	public Integer getLimitPersonCount() {
		return this.limitPersonCount;
	}

	public void setLimitPersonCount(Integer limitPersonCount) {
		this.limitPersonCount = limitPersonCount;
	}

	public Serializable realId() {
		return this.activityId;
	}

	public Timestamp getActivityTime() {
		return this.activityTime;
	}

	public void setActivityTime(Timestamp activityTime) {
		this.activityTime = activityTime;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getApplyNum() {
		return this.applyNum;
	}

	public void setApplyNum(Integer applyNum) {
		this.applyNum = applyNum;
	}

	public Integer getLimitPonitValue() {
		return this.limitPonitValue;
	}

	public void setLimitPonitValue(Integer limitPonitValue) {
		this.limitPonitValue = limitPonitValue;
	}
}
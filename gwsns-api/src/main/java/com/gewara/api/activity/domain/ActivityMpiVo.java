package com.gewara.api.activity.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.activity.ApiObject;

public class ActivityMpiVo extends ApiObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2611222926161020343L;
	private Long id;
	private Long activityid;	//活动id
	private Long mpid;			//场次id
	private Timestamp addtime;
	private String otherinfo;
	
	private String guest;
	
	@Override
	public Serializable realId() {
		// TODO Auto-generated method stub
		return id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getActivityid() {
		return activityid;
	}
	public void setActivityid(Long activityid) {
		this.activityid = activityid;
	}
	public Long getMpid() {
		return mpid;
	}
	public void setMpid(Long mpid) {
		this.mpid = mpid;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	public String getGuest() {
		return guest;
	}
	public void setGuest(String guest) {
		this.guest = guest;
	}
}

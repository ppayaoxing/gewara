/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.activity.domain;

import com.gewara.api.activity.ApiObject;
import java.io.Serializable;
import java.sql.Timestamp;

public class ActivityMpiVo extends ApiObject {
	private static final long serialVersionUID = 2611222926161020343L;
	private Long id;
	private Long activityid;
	private Long mpid;
	private Timestamp addtime;
	private String otherinfo;
	private String guest;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getActivityid() {
		return this.activityid;
	}

	public void setActivityid(Long activityid) {
		this.activityid = activityid;
	}

	public Long getMpid() {
		return this.mpid;
	}

	public void setMpid(Long mpid) {
		this.mpid = mpid;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getGuest() {
		return this.guest;
	}

	public void setGuest(String guest) {
		this.guest = guest;
	}
}
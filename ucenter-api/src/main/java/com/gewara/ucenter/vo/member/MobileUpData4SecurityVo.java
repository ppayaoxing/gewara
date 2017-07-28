/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.vo.member;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class MobileUpData4SecurityVo extends BaseVo {
	private String _id;
	private Long memberid;
	private String deviceId;
	private String yys;
	private String mobile;
	private String checkpass;
	private Timestamp addtime;
	private String status;
	private Timestamp replytime;

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getYys() {
		return this.yys;
	}

	public void setYys(String yys) {
		this.yys = yys;
	}

	public String getCheckpass() {
		return this.checkpass;
	}

	public void setCheckpass(String checkpass) {
		this.checkpass = checkpass;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getReplytime() {
		return this.replytime;
	}

	public void setReplytime(Timestamp replytime) {
		this.replytime = replytime;
	}

	public String get_id() {
		return this._id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Serializable realId() {
		return this._id;
	}
}
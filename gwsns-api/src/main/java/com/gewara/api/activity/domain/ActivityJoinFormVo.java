/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.activity.domain;

import com.gewara.api.activity.ApiObject;
import java.io.Serializable;

public class ActivityJoinFormVo extends ApiObject {
	private int realname;
	private int sex;
	private int joinnum;
	private int joindate;
	private int contactway;
	private int address;
	private int desp;
	private int birthday;

	public int getRealname() {
		return this.realname;
	}

	public void setRealname(int realname) {
		this.realname = realname;
	}

	public int getSex() {
		return this.sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getJoinnum() {
		return this.joinnum;
	}

	public void setJoinnum(int joinnum) {
		this.joinnum = joinnum;
	}

	public int getJoindate() {
		return this.joindate;
	}

	public void setJoindate(int joindate) {
		this.joindate = joindate;
	}

	public int getContactway() {
		return this.contactway;
	}

	public void setContactway(int contactway) {
		this.contactway = contactway;
	}

	public int getAddress() {
		return this.address;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public int getDesp() {
		return this.desp;
	}

	public void setDesp(int desp) {
		this.desp = desp;
	}

	public int getBirthday() {
		return this.birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}

	public Serializable realId() {
		return null;
	}
}
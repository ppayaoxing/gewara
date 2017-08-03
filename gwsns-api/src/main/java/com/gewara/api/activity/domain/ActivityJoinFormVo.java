package com.gewara.api.activity.domain;

import java.io.Serializable;

import com.gewara.api.activity.ApiObject;

public class ActivityJoinFormVo extends ApiObject{
	private int realname;	//真实姓名 0,1
	private int sex;		//性别0,1
	private int joinnum;	//参加人数0,1
	private int joindate;	//参加日期0,1
	private int contactway;	//联系方式0,1
	private int address;	//地址0,1
	private int desp;		//备注0,1
	private int birthday;	//生日0,1
	
	public int getRealname() {
		return realname;
	}
	public void setRealname(int realname) {
		this.realname = realname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getJoinnum() {
		return joinnum;
	}
	public void setJoinnum(int joinnum) {
		this.joinnum = joinnum;
	}
	public int getJoindate() {
		return joindate;
	}
	public void setJoindate(int joindate) {
		this.joindate = joindate;
	}
	public int getContactway() {
		return contactway;
	}
	public void setContactway(int contactway) {
		this.contactway = contactway;
	}
	public int getAddress() {
		return address;
	}
	public void setAddress(int address) {
		this.address = address;
	}
	public int getDesp() {
		return desp;
	}
	public void setDesp(int desp) {
		this.desp = desp;
	}
	public int getBirthday() {
		return birthday;
	}
	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	@Override
	public Serializable realId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

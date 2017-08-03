package com.gewara.api.activity.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.activity.ApiObject;

public class ActivityInfoVo extends ApiObject{
	private Long memberid; //用户id
	private String mobile; //手机号
	private String realname;//真实姓名
	private String sex; //性别
	private String address;//地址
	private Timestamp updatetime;//更新时间 
	private String birthday;//出生年月
	private String otherinfo;//备用字段
	
	public Long getMemberid() {
		return memberid;
	}
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	@Override
	public Serializable realId() {
		return memberid;
	}
	
	
}

/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.activity.domain;

import com.gewara.api.activity.ApiObject;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class ApplyJoinVo extends ApiObject {
	public static final String O = "O";
	public static final String MARK_WIN = "win";
	public static final String MARK_LOSE = "lose";
	public static final String MARK_TIE = "tie";
	private static final long serialVersionUID = -4502423276846683786L;
	private Long id;
	private Long relatedid;
	private Timestamp addtime;
	private Integer joinnum;
	private String contactway;
	private Integer admin;
	private Long memberid;
	private String realname;
	private String sex;
	private Integer needpay;
	private Date joindate;
	private Integer score;
	private String mark;
	private String status;
	private String headpicUrl;
	private String nickName;
	private String address;
	private String otherinfo;
	private String birthday;

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getHeadpicUrl() {
		return this.headpicUrl;
	}

	public void setHeadpicUrl(String headpicUrl) {
		this.headpicUrl = headpicUrl;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getJoindate() {
		return this.joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public ApplyJoinVo() {
	}

	public ApplyJoinVo(Long memberid) {
		this.joinnum = Integer.valueOf(1);
		this.admin = Integer.valueOf(0);
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.memberid = memberid;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Integer getJoinnum() {
		return this.joinnum;
	}

	public void setJoinnum(Integer joinnum) {
		this.joinnum = joinnum;
	}

	public String getContactway() {
		return this.contactway;
	}

	public void setContactway(String contactway) {
		this.contactway = contactway;
	}

	public Serializable realId() {
		return this.id;
	}

	public Integer getAdmin() {
		return this.admin;
	}

	public void setAdmin(Integer admin) {
		this.admin = admin;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Integer getNeedpay() {
		if (this.needpay == null) {
			this.needpay = Integer.valueOf(0);
		}

		return this.needpay;
	}

	public void setNeedpay(Integer needpay) {
		this.needpay = needpay;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}
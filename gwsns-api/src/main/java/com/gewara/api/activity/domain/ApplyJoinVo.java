package com.gewara.api.activity.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.gewara.api.activity.ApiObject;

public class ApplyJoinVo extends ApiObject{

	public static final String O = "O";//未记录胜负关系的比分
	public static final String MARK_WIN = "win";//约战胜
	public static final String MARK_LOSE = "lose";//约战输
	public static final String MARK_TIE = "tie";//约战平
	private static final long serialVersionUID = -4502423276846683786L;
	private Long id;
	private Long relatedid;		//活动id
	private Timestamp addtime;	//报名时间
	private Integer joinnum;	//参加人数
	private String contactway;	//联系方式
	private Integer admin;		//1参与人是发起人，memberid和活动的memberid相同，0是普通参与者
	private Long memberid;		//参加
	private String realname;	//真实姓名
	private String sex; 		//性别
	private Integer needpay;	//需要支付费用
	private Date joindate;		//参加活动日期
	private Integer score;		//约战用
	private String mark;		//约战用
	private String status;		//只在约战中用到 N：未填写比分记录，O单方面填写比分记录，Y双方都填写了比分记录
	private String headpicUrl;  //用户头像地址
	private String nickName;	//用户昵称
	private String address;		//地址
	private String otherinfo;	
	private String birthday;    //出生年月
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getHeadpicUrl() {
		return headpicUrl;
	}
	public void setHeadpicUrl(String headpicUrl) {
		this.headpicUrl = headpicUrl;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
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
	
	
	public ApplyJoinVo() {}
	
	public ApplyJoinVo(Long memberid){
		this.joinnum = 1;
		this.admin = 0;
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.memberid = memberid;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRelatedid() {
		return relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Integer getJoinnum() {
		return joinnum;
	}

	public void setJoinnum(Integer joinnum) {
		this.joinnum = joinnum;
	}

	public String getContactway() {
		return contactway;
	}

	public void setContactway(String contactway) {
		this.contactway = contactway;
	}
	@Override
	public Serializable realId() {
		return id;
	}
	public Integer getAdmin() {
		return admin;
	}
	public void setAdmin(Integer admin) {
		this.admin = admin;
	}
	public Long getMemberid() {
		return memberid;
	}
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	public Integer getNeedpay() {
		if(needpay == null) needpay = 0;
		return needpay;
	}
	public void setNeedpay(Integer needpay) {
		this.needpay = needpay;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}

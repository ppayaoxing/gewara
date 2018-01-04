package com.gewara.api.activity.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.gewara.api.activity.ApiObject;

public class ApplyJoinVo extends ApiObject{

	public static final String O = "O";//未锟斤拷录胜锟斤拷锟斤拷系锟侥比凤拷
	public static final String MARK_WIN = "win";//约战胜
	public static final String MARK_LOSE = "lose";//约战锟斤拷
	public static final String MARK_TIE = "tie";//约战平
	private static final long serialVersionUID = -4502423276846683786L;
	private Long id;
	private Long relatedid;		//锟筋动id
	private Timestamp addtime;	//锟斤拷锟斤拷时锟斤拷
	private Integer joinnum;	//锟轿硷拷锟斤拷锟斤拷
	private String contactway;	//锟斤拷系锟斤拷式
	private Integer admin;		//1锟斤拷锟斤拷锟斤拷锟角凤拷锟斤拷锟剿ｏ拷memberid锟酵活动锟斤拷memberid锟斤拷同锟斤拷0锟斤拷锟斤拷通锟斤拷锟斤拷锟斤拷
	private Long memberid;		//锟轿硷拷
	private String realname;	//锟斤拷实锟斤拷锟斤拷
	private String sex; 		//锟皆憋拷
	private Integer needpay;	//锟斤拷要支锟斤拷锟斤拷锟斤拷
	private Date joindate;		//锟轿加活动锟斤拷锟斤拷
	private Integer score;		//约战锟斤拷
	private String mark;		//约战锟斤拷
	private String status;		//只锟斤拷约战锟斤拷锟矫碉拷 N锟斤拷未锟斤拷写锟饺分硷拷录锟斤拷O锟斤拷锟斤拷锟斤拷锟斤拷写锟饺分硷拷录锟斤拷Y双锟斤拷锟斤拷锟斤拷写锟剿比分硷拷录
	private String headpicUrl;  //锟矫伙拷头锟斤拷锟街�
	private String nickName;	//锟矫伙拷锟角筹拷
	private String address;		//锟斤拷址
	private String otherinfo;	
	private String birthday;    //锟斤拷锟斤拷锟斤拷锟斤拷
	
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
		if(needpay == null) {
            needpay = 0;
        }
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

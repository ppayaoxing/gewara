package com.gewara.api.vo.filmfest;

import java.io.Serializable;
import java.util.Date;

import com.gewara.api.vo.BaseVo;

public class MemberApplyVo extends BaseVo {
	private static final long serialVersionUID = -211000489988251450L;
	private String recordid; //唯一标示
	private Long memberid; //申请人的id
	private String mobile; //手机号
	private String moviename; //电影名称
	private Long movieid;	//电影id
	private String reason; //申请理由 140个字
//	private Date playtime; //放映时间
	private Boolean isWin; //是否中奖
	private Date addTime; //addTime
	private String nickname;//昵称
	private Date updateTime; //更新时间
	public String getRecordid() {
		return recordid;
	}
	public void setRecordid(String recordid) {
		this.recordid = recordid;
	}
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
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public Long getMovieid() {
		return movieid;
	}
	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Boolean getIsWin() {
		return isWin;
	}
	public void setIsWin(Boolean isWin) {
		this.isWin = isWin;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public Serializable realId() {
		return recordid;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	

}

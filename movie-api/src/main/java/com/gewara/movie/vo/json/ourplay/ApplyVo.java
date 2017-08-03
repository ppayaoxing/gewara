package com.gewara.movie.vo.json.ourplay;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;


public class ApplyVo extends BaseVo{
	private static final long serialVersionUID = -5401784424476256109L;
	private String id; //主键 memberid+"_"+activityId
	private Long memberId; //用户id
	private Long movieId; //电影id
	private String activityId; //活动id
	private String userName; //姓名
	private Integer age;	//年龄
	private String constellation; //星座
	private String phone; //手机号
	private String reason; //理由
	private String gender;//性别
	private String isOk;//申请是否通过，
	private Timestamp addtime; //添加时间
	private Timestamp updatetime;//修改时间
	private String friendname;//表示由哪位好友推荐进来的
	private String isReturnPoint;//是否返回积分
	
	public String getIsReturnPoint() {
		return isReturnPoint;
	}

	public void setIsReturnPoint(String isReturnPoint) {
		this.isReturnPoint = isReturnPoint;
	}

	public String getFriendname() {
		return friendname;
	}

	public void setFriendname(String friendname) {
		this.friendname = friendname;
	}

	// 查询此人写过写个哇啦，memberid movieid starttime endtime 点映开始时间 结束时间，活动开始时间，结束时间，影院上映时间
	public ApplyVo(){}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getConstellation() {
		return constellation;
	}
	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public Serializable realId() {
		return this.id;
	}
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public String getIsOk() {
		return isOk;
	}
	public void setIsOk(String isOk) {
		this.isOk = isOk;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	



}

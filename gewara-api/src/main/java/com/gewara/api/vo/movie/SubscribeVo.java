package com.gewara.api.vo.movie;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class SubscribeVo extends BaseVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2766848283011728638L;
	public static final String ALEARY_PUSH_N = "N";
	public static final String ALEARY_PUSH_Y = "Y";
	public static final String ALEARY_OPEN_N = "N";
	public static final String ALEARY_OPEN_Y = "Y";
	
    private Long memberid;
	private Long cinemaid;
    private Long movieid;
    private String addtime;//预约日期
    private String special;//特效
    private String timeindex;//时段
    private String aleryPush;
    
    private String _id;
    private Integer isSub;
    private String citycode;
    private String time;//添加时间
    private String isopen;//是否开放场次
    
    
	@Override
	public Serializable realId() {
		return _id;
	}


	public Long getMemberid() {
		return memberid;
	}


	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}


	public Long getCinemaid() {
		return cinemaid;
	}


	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}


	public Long getMovieid() {
		return movieid;
	}


	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}


	public String getAddtime() {
		return addtime;
	}


	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}


	public String getSpecial() {
		return special;
	}


	public void setSpecial(String special) {
		this.special = special;
	}


	public String getTimeindex() {
		return timeindex;
	}


	public void setTimeindex(String timeindex) {
		this.timeindex = timeindex;
	}


	public String getAleryPush() {
		return aleryPush;
	}


	public void setAleryPush(String aleryPush) {
		this.aleryPush = aleryPush;
	}


	public String get_id() {
		return _id;
	}


	public void set_id(String _id) {
		this._id = _id;
	}


	public Integer getIsSub() {
		return isSub;
	}


	public void setIsSub(Integer isSub) {
		this.isSub = isSub;
	}


	public String getCitycode() {
		return citycode;
	}


	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getIsopen() {
		return isopen;
	}


	public void setIsopen(String isopen) {
		this.isopen = isopen;
	}
}

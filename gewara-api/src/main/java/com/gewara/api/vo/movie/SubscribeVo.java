/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.movie;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class SubscribeVo extends BaseVo {
	private static final long serialVersionUID = -2766848283011728638L;
	public static final String ALEARY_PUSH_N = "N";
	public static final String ALEARY_PUSH_Y = "Y";
	public static final String ALEARY_OPEN_N = "N";
	public static final String ALEARY_OPEN_Y = "Y";
	private Long memberid;
	private Long cinemaid;
	private Long movieid;
	private String addtime;
	private String special;
	private String timeindex;
	private String aleryPush;
	private String _id;
	private Integer isSub;
	private String citycode;
	private String time;
	private String isopen;

	public Serializable realId() {
		return this._id;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Long getCinemaid() {
		return this.cinemaid;
	}

	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}

	public Long getMovieid() {
		return this.movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getSpecial() {
		return this.special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public String getTimeindex() {
		return this.timeindex;
	}

	public void setTimeindex(String timeindex) {
		this.timeindex = timeindex;
	}

	public String getAleryPush() {
		return this.aleryPush;
	}

	public void setAleryPush(String aleryPush) {
		this.aleryPush = aleryPush;
	}

	public String get_id() {
		return this._id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Integer getIsSub() {
		return this.isSub;
	}

	public void setIsSub(Integer isSub) {
		this.isSub = isSub;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getIsopen() {
		return this.isopen;
	}

	public void setIsopen(String isopen) {
		this.isopen = isopen;
	}
}
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.baochang;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class BaoChangCinemaInfoVo extends BaseVo {
	private static final long serialVersionUID = 2668138927290077502L;
	private Long id;
	private Long cinemaid;
	private String cinemaName;
	private String citycode;
	private List<Long> roomIdList;
	private Map<Long, String> roomNameMap;
	private Integer applyCount;
	private Integer roomnum;
	private Integer mpinum;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCinemaid() {
		return this.cinemaid;
	}

	public String getCinemaName() {
		return this.cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public List<Long> getRoomIdList() {
		return this.roomIdList;
	}

	public void setRoomIdList(List<Long> roomIdList) {
		this.roomIdList = roomIdList;
	}

	public Map<Long, String> getRoomNameMap() {
		return this.roomNameMap;
	}

	public void setRoomNameMap(Map<Long, String> roomNameMap) {
		this.roomNameMap = roomNameMap;
	}

	public Integer getApplyCount() {
		return this.applyCount;
	}

	public void setApplyCount(Integer applyCount) {
		this.applyCount = applyCount;
	}

	public Integer getRoomnum() {
		return this.roomnum;
	}

	public void setRoomnum(Integer roomnum) {
		this.roomnum = roomnum;
	}

	public Integer getMpinum() {
		return this.mpinum;
	}

	public void setMpinum(Integer mpinum) {
		this.mpinum = mpinum;
	}
}
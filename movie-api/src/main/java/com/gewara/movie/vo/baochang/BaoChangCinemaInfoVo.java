package com.gewara.movie.vo.baochang;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gewara.api.vo.BaseVo;

public class BaoChangCinemaInfoVo extends BaseVo  {
	private static final long serialVersionUID = 2668138927290077502L;
	
	private Long id;
	private Long cinemaid; //影院ID
	private String cinemaName;//影院名称
	private String citycode;
	private List<Long> roomIdList;//影厅ID
	private Map<Long, String> roomNameMap;//影厅信息
	private Integer applyCount;//申请人数
	private Integer roomnum;//影院个数
	private Integer mpinum;//场次个数
	
	public BaoChangCinemaInfoVo(){}
	
	@Override
	public Serializable realId() {
		return id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getCinemaid() {
		return cinemaid;
	}
	
	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public List<Long> getRoomIdList() {
		return roomIdList;
	}

	public void setRoomIdList(List<Long> roomIdList) {
		this.roomIdList = roomIdList;
	}

	public Map<Long, String> getRoomNameMap() {
		return roomNameMap;
	}

	public void setRoomNameMap(Map<Long, String> roomNameMap) {
		this.roomNameMap = roomNameMap;
	}

	public Integer getApplyCount() {
		return applyCount;
	}

	public void setApplyCount(Integer applyCount) {
		this.applyCount = applyCount;
	}

	public Integer getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(Integer roomnum) {
		this.roomnum = roomnum;
	}

	public Integer getMpinum() {
		return mpinum;
	}

	public void setMpinum(Integer mpinum) {
		this.mpinum = mpinum;
	}
	
}

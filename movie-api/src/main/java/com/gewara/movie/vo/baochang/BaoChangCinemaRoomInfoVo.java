package com.gewara.movie.vo.baochang;

import java.util.List;

public class BaoChangCinemaRoomInfoVo extends BaoChangBasePriceInfoVo {
	private static final long serialVersionUID = 6153941174564232485L;
	
	private String roomName;//Ó°ÌüÃû³Æ
	private String remark;
	private List<BaoChangTimeInfoVo> timeInfoList;
	
	public BaoChangCinemaRoomInfoVo(){}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<BaoChangTimeInfoVo> getTimeInfoList() {
		return timeInfoList;
	}

	public void setTimeInfoList(List<BaoChangTimeInfoVo> timeInfoList) {
		this.timeInfoList = timeInfoList;
	}

}

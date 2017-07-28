/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.baochang;

import com.gewara.movie.vo.baochang.BaoChangBasePriceInfoVo;
import com.gewara.movie.vo.baochang.BaoChangTimeInfoVo;
import java.util.List;

public class BaoChangCinemaRoomInfoVo extends BaoChangBasePriceInfoVo {
	private static final long serialVersionUID = 6153941174564232485L;
	private String roomName;
	private String remark;
	private List<BaoChangTimeInfoVo> timeInfoList;

	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<BaoChangTimeInfoVo> getTimeInfoList() {
		return this.timeInfoList;
	}

	public void setTimeInfoList(List<BaoChangTimeInfoVo> timeInfoList) {
		this.timeInfoList = timeInfoList;
	}
}
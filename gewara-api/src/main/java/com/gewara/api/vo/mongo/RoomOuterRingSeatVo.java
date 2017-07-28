/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.mongo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class RoomOuterRingSeatVo extends BaseVo {
	private static final long serialVersionUID = -423096761881065659L;
	private String _id;
	private String addTime;
	private Long roomId;
	private String outerRingSeat;

	public String get_id() {
		return this._id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getAddTime() {
		return this.addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public Long getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public String getOuterRingSeat() {
		return this.outerRingSeat;
	}

	public void setOuterRingSeat(String outerRingSeat) {
		this.outerRingSeat = outerRingSeat;
	}

	public Serializable realId() {
		return this._id;
	}
}
package com.gewara.json;

import com.gewara.mongo.support.MGObject;

public class RoomOuterRingSeat extends MGObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3306874986995671638L;

	private String _id;

	private String addTime;

	private Long roomId;

	private String outerRingSeat;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public String getOuterRingSeat() {
		return outerRingSeat;
	}

	public void setOuterRingSeat(String outerRingSeat) {
		this.outerRingSeat = outerRingSeat;
	}

}

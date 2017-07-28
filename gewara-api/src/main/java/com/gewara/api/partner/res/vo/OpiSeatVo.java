/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.res.vo;

import com.gewara.api.partner.res.vo.RoomSeatVo;
import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class OpiSeatVo extends BaseVo {
	private static final long serialVersionUID = -7108809287484191737L;
	private Long roomid;
	private String cacheseat;
	private Integer linenum;
	private Integer ranknum;
	private String secid;
	private Map<Integer, String> rowMap = new HashMap();
	private Map<String, RoomSeatVo> seatMap = new HashMap();

	public String getCacheseat() {
		return this.cacheseat;
	}

	public void setCacheseat(String cacheseat) {
		this.cacheseat = cacheseat;
	}

	public Integer getLinenum() {
		return this.linenum;
	}

	public void setLinenum(Integer linenum) {
		this.linenum = linenum;
	}

	public Integer getRanknum() {
		return this.ranknum;
	}

	public void setRanknum(Integer ranknum) {
		this.ranknum = ranknum;
	}

	public String getSecid() {
		return this.secid;
	}

	public void setSecid(String secid) {
		this.secid = secid;
	}

	public Map<Integer, String> getRowMap() {
		return this.rowMap;
	}

	public void setRowMap(Map<Integer, String> rowMap) {
		this.rowMap = rowMap;
	}

	public Map<String, RoomSeatVo> getSeatMap() {
		return this.seatMap;
	}

	public void setSeatMap(Map<String, RoomSeatVo> seatMap) {
		this.seatMap = seatMap;
	}

	public Serializable realId() {
		return this.roomid;
	}

	public Long getRoomid() {
		return this.roomid;
	}

	public void setRoomid(Long roomid) {
		this.roomid = roomid;
	}
}
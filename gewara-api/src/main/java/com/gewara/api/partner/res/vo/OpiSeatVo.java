package com.gewara.api.partner.res.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.gewara.api.vo.BaseVo;

public class OpiSeatVo extends BaseVo{
	private static final long serialVersionUID = -7108809287484191737L;
	private Long roomid;
	private String cacheseat;
	//private Integer maxseat;
	private Integer linenum;
	private Integer ranknum;
	private String secid;
	private Map<Integer, String> rowMap = new HashMap<Integer, String>();
	private Map<String, RoomSeatVo> seatMap = new HashMap<String, RoomSeatVo>();
	public OpiSeatVo(){
		
	}
	public String getCacheseat() {
		return cacheseat;
	}

	public void setCacheseat(String cacheseat) {
		this.cacheseat = cacheseat;
	}

	public Integer getLinenum() {
		return linenum;
	}

	public void setLinenum(Integer linenum) {
		this.linenum = linenum;
	}

	public Integer getRanknum() {
		return ranknum;
	}

	public void setRanknum(Integer ranknum) {
		this.ranknum = ranknum;
	}

	public String getSecid() {
		return secid;
	}

	public void setSecid(String secid) {
		this.secid = secid;
	}
	public Map<Integer, String> getRowMap() {
		return rowMap;
	}
	public void setRowMap(Map<Integer, String> rowMap) {
		this.rowMap = rowMap;
	}
	public Map<String, RoomSeatVo> getSeatMap() {
		return seatMap;
	}
	public void setSeatMap(Map<String, RoomSeatVo> seatMap) {
		this.seatMap = seatMap;
	}
	@Override
	public Serializable realId() {
		return roomid;
	}
	public Long getRoomid() {
		return roomid;
	}
	public void setRoomid(Long roomid) {
		this.roomid = roomid;
	}
}

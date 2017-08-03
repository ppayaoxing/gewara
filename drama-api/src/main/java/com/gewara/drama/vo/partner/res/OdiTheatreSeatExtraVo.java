package com.gewara.drama.vo.partner.res;

import java.util.HashMap;
import java.util.Map;

public class OdiTheatreSeatExtraVo extends OdiTheatreSeatVo {
	
	private static final long serialVersionUID = -4834357819492057436L;
	private String cacheSeat;																//»º´æ×ùÎ»
	private Map<Integer, String> rowMap = new HashMap<Integer, String>();	//×ùÎ»ÐÐºÅ
	private Map<String, OpenTheatreSeatExtraVo> seatMap = new HashMap<String, OpenTheatreSeatExtraVo>();
	
	public String getCacheSeat() {
		return cacheSeat;
	}
	
	public void setCacheSeat(String cacheSeat) {
		this.cacheSeat = cacheSeat;
	}
	
	public Map<Integer, String> getRowMap() {
		return rowMap;
	}
	
	public void setRowMap(Map<Integer, String> rowMap) {
		this.rowMap = rowMap;
	}
	
	public Map<String, OpenTheatreSeatExtraVo> getSeatMap() {
		return seatMap;
	}
	
	public void setSeatMap(Map<String, OpenTheatreSeatExtraVo> seatMap) {
		this.seatMap = seatMap;
	}
}

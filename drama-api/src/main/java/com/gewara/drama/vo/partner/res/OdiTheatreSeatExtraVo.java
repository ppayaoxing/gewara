/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.partner.res;

import com.gewara.drama.vo.partner.res.OdiTheatreSeatVo;
import com.gewara.drama.vo.partner.res.OpenTheatreSeatExtraVo;
import java.util.HashMap;
import java.util.Map;

public class OdiTheatreSeatExtraVo extends OdiTheatreSeatVo {
	private static final long serialVersionUID = -4834357819492057436L;
	private String cacheSeat;
	private Map<Integer, String> rowMap = new HashMap();
	private Map<String, OpenTheatreSeatExtraVo> seatMap = new HashMap();

	public String getCacheSeat() {
		return this.cacheSeat;
	}

	public void setCacheSeat(String cacheSeat) {
		this.cacheSeat = cacheSeat;
	}

	public Map<Integer, String> getRowMap() {
		return this.rowMap;
	}

	public void setRowMap(Map<Integer, String> rowMap) {
		this.rowMap = rowMap;
	}

	public Map<String, OpenTheatreSeatExtraVo> getSeatMap() {
		return this.seatMap;
	}

	public void setSeatMap(Map<String, OpenTheatreSeatExtraVo> seatMap) {
		this.seatMap = seatMap;
	}
}
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.cmd;

import java.io.Serializable;

public class AreaSeatParamsVo implements Serializable {
	private static final long serialVersionUID = 3032766935494905571L;
	private Long itemid;
	private Long areaid;
	private Long priceid;
	private Long disid;
	private String spkey;

	public AreaSeatParamsVo() {
	}

	public AreaSeatParamsVo(Long itemid) {
		this.itemid = itemid;
	}

	public Long getItemid() {
		return this.itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public Long getAreaid() {
		return this.areaid;
	}

	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}

	public Long getPriceid() {
		return this.priceid;
	}

	public void setPriceid(Long priceid) {
		this.priceid = priceid;
	}

	public Long getDisid() {
		return this.disid;
	}

	public void setDisid(Long disid) {
		this.disid = disid;
	}

	public String getSpkey() {
		return this.spkey;
	}

	public void setSpkey(String spkey) {
		this.spkey = spkey;
	}
}
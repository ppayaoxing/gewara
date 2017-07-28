/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class SeatTypeVo extends BaseVo {
	private static final long serialVersionUID = 3496007931623453141L;
	private String type;
	private String seaturl;
	private String ratio;
	private String id;
	private String addtime;

	public Serializable realId() {
		return this.id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSeaturl() {
		return this.seaturl;
	}

	public void setSeaturl(String seaturl) {
		this.seaturl = seaturl;
	}

	public String getRatio() {
		return this.ratio;
	}

	public void setRatio(String ratio) {
		this.ratio = ratio;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
}
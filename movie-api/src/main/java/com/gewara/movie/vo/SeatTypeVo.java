package com.gewara.movie.vo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class SeatTypeVo extends BaseVo{

	private static final long serialVersionUID = 3496007931623453141L;
	private String type;
	private String seaturl;//以逗号分开
	private String ratio;
	private String id;
	private String addtime;
	
	@Override
	public Serializable realId() {
		return id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSeaturl() {
		return seaturl;
	}
	public void setSeaturl(String seaturl) {
		this.seaturl = seaturl;
	}
	public String getRatio() {
		return ratio;
	}
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

}

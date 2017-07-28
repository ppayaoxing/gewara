/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.baochang;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class BaoChangMpiSeatPicVo extends BaseVo {
	private static final long serialVersionUID = 470350044405929777L;
	private String id;
	private Long mpid;
	private String seatline;
	private String seatrank;
	private String nickname;
	private String picUrl;
	private String showFlag;

	public Serializable realId() {
		return null;
	}

	public BaoChangMpiSeatPicVo() {
	}

	public BaoChangMpiSeatPicVo(Long mpid, String seatline, String seatrank, String nickname, String picUrl) {
		this.mpid = mpid;
		this.seatline = seatline;
		this.seatrank = seatrank;
		this.nickname = nickname;
		this.picUrl = picUrl;
		this.showFlag = "Y";
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getMpid() {
		return this.mpid;
	}

	public void setMpid(Long mpid) {
		this.mpid = mpid;
	}

	public String getSeatline() {
		return this.seatline;
	}

	public void setSeatline(String seatline) {
		this.seatline = seatline;
	}

	public String getSeatrank() {
		return this.seatrank;
	}

	public void setSeatrank(String seatrank) {
		this.seatrank = seatrank;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getShowFlag() {
		return this.showFlag;
	}

	public void setShowFlag(String showFlag) {
		this.showFlag = showFlag;
	}
}
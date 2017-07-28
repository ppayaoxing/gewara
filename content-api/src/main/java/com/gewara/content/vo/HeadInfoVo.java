/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.content.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class HeadInfoVo extends BaseVo {
	private static final long serialVersionUID = 3715253179654623826L;
	public static final String TAG = "headinfo";
	private Long id;
	private String logobig;
	private String logosmall;
	private String title;
	private String css;
	private String link;
	private Long ordernum;
	private String isslide;
	private Timestamp addtime;
	private String board;
	private String citycode;
	private String track;
	private Timestamp starttime;
	private Timestamp stoptime;

	public HeadInfoVo() {
	}

	public HeadInfoVo(String title) {
		this.ordernum = Long.valueOf(0L);
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.isslide = "Y";
		this.title = title;
	}

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogobig() {
		return this.logobig;
	}

	public void setLogobig(String logobig) {
		this.logobig = logobig;
	}

	public String getLogosmall() {
		return this.logosmall;
	}

	public void setLogosmall(String logosmall) {
		this.logosmall = logosmall;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCss() {
		return this.css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Long getOrdernum() {
		return this.ordernum;
	}

	public void setOrdernum(Long ordernum) {
		this.ordernum = ordernum;
	}

	public String getIsslide() {
		return this.isslide;
	}

	public void setIsslide(String isslide) {
		this.isslide = isslide;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getBoard() {
		return this.board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getTrack() {
		return this.track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getStoptime() {
		return this.stoptime;
	}

	public void setStoptime(Timestamp stoptime) {
		this.stoptime = stoptime;
	}
}
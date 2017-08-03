package com.gewara.content.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

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
	private String board;	// 版块 eg. movie/suject...etc.
	private String citycode;
	private String track;		//跟踪图片
	private Timestamp starttime;	// 分享开始时间
	private Timestamp stoptime;		// 分享结束时间
	
	public HeadInfoVo(){}

	public HeadInfoVo(String title) {
		this.ordernum=0l;
		this.addtime=new Timestamp(System.currentTimeMillis());
		this.isslide="Y";
		this.title = title;
	}
	@Override
	public Serializable realId() {
		return id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogobig() {
		return logobig;
	}

	public void setLogobig(String logobig) {
		this.logobig = logobig;
	}

	public String getLogosmall() {
		return logosmall;
	}

	public void setLogosmall(String logosmall) {
		this.logosmall = logosmall;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Long getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Long ordernum) {
		this.ordernum = ordernum;
	}

	public String getIsslide() {
		return isslide;
	}

	public void setIsslide(String isslide) {
		this.isslide = isslide;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	public Timestamp getStarttime() {
		return starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getStoptime() {
		return stoptime;
	}

	public void setStoptime(Timestamp stoptime) {
		this.stoptime = stoptime;
	}

}

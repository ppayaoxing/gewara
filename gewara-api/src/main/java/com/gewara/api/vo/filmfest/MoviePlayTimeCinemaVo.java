package com.gewara.api.vo.filmfest;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class MoviePlayTimeCinemaVo extends BaseVo {
	private static final long serialVersionUID = -7485818227515627985L;
	private Long movieid; //Œ®“ª±Í æ
	private String playtime;
	private String cinemaname;
	private String isOpen;
	public Long getMovieid() {
		return movieid;
	}
	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}
	public String getPlaytime() {
		return playtime;
	}
	public void setPlaytime(String playtime) {
		this.playtime = playtime;
	}
	public String getCinemaname() {
		return cinemaname;
	}
	public void setCinemaname(String cinemaname) {
		this.cinemaname = cinemaname;
	}
	@Override
	public Serializable realId() {
		return movieid;
	}
	public String getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}

}

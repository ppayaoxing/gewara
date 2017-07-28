/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.filmfest;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class MoviePlayTimeCinemaVo extends BaseVo {
	private static final long serialVersionUID = -7485818227515627985L;
	private Long movieid;
	private String playtime;
	private String cinemaname;
	private String isOpen;

	public Long getMovieid() {
		return this.movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public String getPlaytime() {
		return this.playtime;
	}

	public void setPlaytime(String playtime) {
		this.playtime = playtime;
	}

	public String getCinemaname() {
		return this.cinemaname;
	}

	public void setCinemaname(String cinemaname) {
		this.cinemaname = cinemaname;
	}

	public Serializable realId() {
		return this.movieid;
	}

	public String getIsOpen() {
		return this.isOpen;
	}

	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}
}
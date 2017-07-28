/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.model;

import java.io.Serializable;
import java.util.List;

public class MemberViewInfo implements Serializable {
	private static final long serialVersionUID = -3363180767294549933L;
	private Long movieid;
	private Long cinemaid;
	private Long playtime;
	private Integer viewcounts;
	private List<Long> othermembers;

	public Long getMovieid() {
		return this.movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public Long getCinemaid() {
		return this.cinemaid;
	}

	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}

	public Long getPlaytime() {
		return this.playtime;
	}

	public void setPlaytime(Long playtime) {
		this.playtime = playtime;
	}

	public Integer getViewcounts() {
		return this.viewcounts;
	}

	public void setViewcounts(Integer viewcounts) {
		this.viewcounts = viewcounts;
	}

	public List<Long> getOthermembers() {
		return this.othermembers;
	}

	public void setOthermembers(List<Long> othermembers) {
		this.othermembers = othermembers;
	}
}
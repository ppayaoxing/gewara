/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.model;

import java.io.Serializable;

public class TrackVO implements Serializable {
	private static final long serialVersionUID = -1521577020936521352L;
	private String id;
	private String flag;
	private String addTime;
	private String movieId;
	private String movieMark;
	private String tag;

	public TrackVO(String id, String flag, String addTime, String movieId, String movieMark, String tag) {
		this.id = id;
		this.flag = flag;
		this.addTime = addTime;
		this.movieId = movieId;
		this.movieMark = movieMark;
		this.tag = tag;
	}

	public TrackVO() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getAddTime() {
		return this.addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getMovieId() {
		return this.movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieMark() {
		return this.movieMark;
	}

	public void setMovieMark(String movieMark) {
		this.movieMark = movieMark;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
}
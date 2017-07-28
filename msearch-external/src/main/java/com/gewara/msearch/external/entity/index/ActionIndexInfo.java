/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.msearch.external.entity.index;

import com.gewara.msearch.external.entity.index.IndexData;

public class ActionIndexInfo extends IndexData {
	private static final long serialVersionUID = -4506948954048617634L;
	private String name = null;
	private String content = null;
	private String movieID = null;
	private String cityID = null;

	public String getName() {
		return this.name;
	}

	public String getContent() {
		return this.content;
	}

	public String getMovieID() {
		return this.movieID;
	}

	public String getCityID() {
		return this.cityID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}

	public void setCityID(String cityID) {
		this.cityID = cityID;
	}
}
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.msearch.external.entity.index;

import com.gewara.msearch.external.entity.index.IndexData;
import java.util.List;

public class ActorIndexInfo extends IndexData {
	private static final long serialVersionUID = -4373138388897459750L;
	private String name = null;
	private String ename = null;
	private List<String> aliases = null;
	private List<String> shows = null;
	private List<String> directors = null;
	private String desc = null;

	public List<String> getAliases() {
		return this.aliases;
	}

	public String getName() {
		return this.name;
	}

	public String getEname() {
		return this.ename;
	}

	public List<String> getShows() {
		return this.shows;
	}

	public List<String> getDirectors() {
		return this.directors;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public void setShows(List<String> shows) {
		this.shows = shows;
	}

	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setAliases(List<String> aliases) {
		this.aliases = aliases;
	}
}
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.msearch.external.entity.index;

import com.gewara.msearch.external.entity.index.IndexData;
import java.util.List;

public class MovieIndexInfo extends IndexData {
	private static final long serialVersionUID = 7074469411495043856L;
	private String name = null;
	private String ename = null;
	private List<String> aliases = null;
	private List<String> directors = null;
	private List<String> protagonists = null;
	private List<String> actors = null;
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

	public List<String> getDirectors() {
		return this.directors;
	}

	public List<String> getProtagonists() {
		return this.protagonists;
	}

	public List<String> getActors() {
		return this.actors;
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

	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}

	public void setProtagonists(List<String> protagonists) {
		this.protagonists = protagonists;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setAliases(List<String> aliases) {
		this.aliases = aliases;
	}
}
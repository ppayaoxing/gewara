package com.gewara.msearch.external.entity.index;

import java.util.List;

/**
 * 电影的信息
 * 
 * @author 董明
 * @createDate 2015年6月3日
 */
public class MovieIndexInfo  extends IndexData {

	private static final long serialVersionUID = 7074469411495043856L;
	
	private String name = null;//中文名称
	private String ename = null;//英文名称
	private List<String> aliases=null;//电影别名
	

	private List<String> directors = null; //导演列表
	private List<String> protagonists = null;//演员列表
	private List<String> actors = null;//角色列表
	private String desc = null;//电影简介
	
	
	/**
	 * 影片的别名
	 * @return
	 */
	public List<String> getAliases() {
		return aliases;
	}

	
	
	/**
	 * 影片中文名称
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 影片英文名称
	 * @return
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * 影片的导演列表
	 * @return
	 */
	public List<String> getDirectors() {
		return directors;
	}

	/**
	 * 影片的演员列表
	 * @return
	 */
	public List<String> getProtagonists() {
		return protagonists;
	}

	/**
	 * 影片的角色列表
	 * @return
	 */
	public List<String> getActors() {
		return actors;
	}

	/**
	 * 影片的简介
	 * @return
	 */
	public String getDesc() {
		return desc;
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

package com.gewara.msearch.external.entity.index;

import java.util.List;

/**
 * 影人索引信息
 * @author 董明
 * @createDate 2015年6月3日
 */
public class ActorIndexInfo extends IndexData{
	
	private static final long serialVersionUID = -4373138388897459750L;
	private String name=null;
	private String ename=null;
	private List<String> aliases=null;
	private List<String> shows=null;
	private List<String> directors=null;
	private String desc=null;
	
	
	/**
	 * 曾用名，别名，艺名等等
	 * @return
	 */
	public List<String> getAliases() {
		return aliases;
	}
	
	/**
	 * 影人中文名称
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 影人英文名称
	 * @return
	 */
	public String getEname() {
		return ename;
	}
	/**
	 * 参加演出过的电影名称列表
	 * @return
	 */
	public List<String> getShows() {
		return shows;
	}
	/**
	 * 导演过的电影名称列表
	 * @return
	 */
	public List<String> getDirectors() {
		return directors;
	}
	/**
	 * 影人的简介
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

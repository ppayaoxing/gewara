package com.gewara.msearch.external.entity.index;

/**
 * 活动索引信息,
 * @author 董明
 * @createDate 2015年6月3日
 */
public class ActionIndexInfo extends IndexData{
	
	private static final long serialVersionUID = -4506948954048617634L;
	
	private String name=null;
	private String content=null;
	private String movieID=null;
	private String cityID=null;
	
	
	/**
	 * 活动名称
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 活动内容
	 * @return
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 活动关联的电影ID
	 * @return
	 */
	public String getMovieID() {
		return movieID;
	}
	
	/**
	 * 活动发起的城市ID，不参加模糊搜索，只用来进行精确搜索
	 * @return
	 */
	public String getCityID() {
		return cityID;
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

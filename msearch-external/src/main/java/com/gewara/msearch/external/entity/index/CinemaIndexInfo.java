package com.gewara.msearch.external.entity.index;

/**
 * 影院索引信息
 * @author 董明
 * @createDate 2015年6月3日
 */
public class CinemaIndexInfo extends IndexData{
	
	private static final long serialVersionUID = -5353503091696102130L;
	private String name=null;
	private String address=null;
	private String desc=null;
	private String cityID=null;
	
	/**
	 * 影院的名称
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 影院的地址
	 * @return
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 影院的简介
	 * @return
	 */
	public String getDesc() {
		return desc;
	}
	
	/**
	 * 影院所在的城市ID，不参加模糊搜索，只用来进行精确搜索
	 * @return
	 */
	public String getCityID() {
		return cityID;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void setCityID(String cityID) {
		this.cityID = cityID;
	}
	
}

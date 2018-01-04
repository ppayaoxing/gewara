package com.gewara.msearch.external.entity.index;

/**
 * 剧院索引信息
 */
public class TheatreIndexInfo extends IndexData{
	
	private static final long serialVersionUID = -5353503091696102130L;
	private String name=null;
	private String address=null;
	private String briefname=null;
	private String cityID=null;
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	/**
	 * 所在的城市ID，不参加模糊搜索，只用来进行精确搜索
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
	
	public void setCityID(String cityID) {
		this.cityID = cityID;
	}

	public String getBriefname() {
		return briefname;
	}

	public void setBriefname(String briefname) {
		this.briefname = briefname;
	}
	
}

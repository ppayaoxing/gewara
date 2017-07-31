package com.gewara.msearch.external.entity.index;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 原主站索引信息
 * @author quzhuping
 * @createDate 2015年11月4日
 */
public class GwSearchIndexInfo extends IndexData{
	
	private static final long serialVersionUID = -3071643178306274317L;
	
	private String name;
	private String tag;//类型标签
	private Long relatedid;
	private String category;
	private String skey;
	private List<String> citycode;

	public GwSearchIndexInfo(){
	}
	
	public GwSearchIndexInfo(String keycode, String name, String tag, Long relatedid, String category, String skey,String citycode){
		this.dataID = keycode;
		this.name = name;
		this.tag = tag;
		this.category = category;
		this.skey = skey;
		this.relatedid=relatedid;
		this.citycode = Arrays.asList(StringUtils.split(citycode, ","));
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTag() {
		return tag;
	}


	public void setTag(String tag) {
		this.tag = tag;
	}


	public Long getRelatedid() {
		return relatedid;
	}


	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getSkey() {
		return skey;
	}


	public void setSkey(String skey) {
		this.skey = skey;
	}


	public List<String> getCitycode() {
		return citycode;
	}


	public void setCitycode(List<String> citycode) {
		this.citycode = citycode;
	}


	@Override
	public String toString() {
		return "GwSearchIndexInfo [name=" + name
				+ ", tag=" + tag + ", relatedid=" + relatedid + ", category="
				+ category + ", skey=" + skey + ", citycode=" + citycode + "]";
	}
	
	
	
}

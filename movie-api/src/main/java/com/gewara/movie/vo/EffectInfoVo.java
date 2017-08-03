package com.gewara.movie.vo;


import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class EffectInfoVo extends BaseVo{
	private static final long serialVersionUID = -8456969167272896454L;
	private String key; //类别的key OR 图片路径picPath
	private Integer value; //排序序号
	private String description; //一句话描述
	private String picPathListJson; //[{key:picPath,value:picOrderNumber},{key:picPath,value:picOrderNumber}] key=图片路径 value=排序号
	private String walaids;
	private Integer showNumber; //显示到界面上的序号
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicPathListJson() {
		return picPathListJson;
	}
	public void setPicPathListJson(String picPathListJson) {
		this.picPathListJson = picPathListJson;
	}
	public String getWalaids() {
		return walaids;
	}
	public void setWalaids(String walaids) {
		this.walaids = walaids;
	}
	
	public Integer getShowNumber() {
		return showNumber;
	}
	public void setShowNumber(Integer showNumber) {
		this.showNumber = showNumber;
	}
	@Override
	public Serializable realId() {
		return key;
	}
	

}

package com.gewara.api.sns.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.model.BaseObject;

public class JsonDataVo extends BaseObject{
	private static final long serialVersionUID = -6086647828796487675L;
	private String dkey;
	private String data;
	private String tag;
	private Timestamp validtime;
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Timestamp getValidtime() {
		return validtime;
	}
	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}
	public JsonDataVo(){
		
	}
	public JsonDataVo(String dkey) {
		this.dkey = dkey;
	}
	public JsonDataVo(String dkey, String data) {
		this.dkey = dkey;
		this.data = data;
	}
	public String getDkey() {
		return dkey;
	}
	public void setDkey(String dkey) {
		this.dkey = dkey;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public Serializable realId() {
		return dkey;
	}
}

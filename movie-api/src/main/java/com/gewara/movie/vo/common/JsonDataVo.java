package com.gewara.movie.vo.common;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class JsonDataVo extends BaseVo {
	
	private static final long serialVersionUID = 9059059794052637090L;
	private String dkey;
	private String data;
	private String tag;
	private Timestamp validtime;
	
	@Override
	public Serializable realId() {
		return dkey;
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

}

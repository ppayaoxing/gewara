/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo;

import com.gewara.model.BaseObject;
import java.io.Serializable;
import java.sql.Timestamp;

public class JsonDataVo extends BaseObject {
	private static final long serialVersionUID = -6086647828796487675L;
	private String dkey;
	private String data;
	private String tag;
	private Timestamp validtime;

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Timestamp getValidtime() {
		return this.validtime;
	}

	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}

	public JsonDataVo() {
	}

	public JsonDataVo(String dkey) {
		this.dkey = dkey;
	}

	public JsonDataVo(String dkey, String data) {
		this.dkey = dkey;
		this.data = data;
	}

	public String getDkey() {
		return this.dkey;
	}

	public void setDkey(String dkey) {
		this.dkey = dkey;
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Serializable realId() {
		return this.dkey;
	}
}
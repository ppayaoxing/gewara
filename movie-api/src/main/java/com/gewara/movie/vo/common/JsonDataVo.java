/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.common;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class JsonDataVo extends BaseVo {
	private static final long serialVersionUID = 9059059794052637090L;
	private String dkey;
	private String data;
	private String tag;
	private Timestamp validtime;

	public Serializable realId() {
		return this.dkey;
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
}
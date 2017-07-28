/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.msearch.external.entity.index;

import com.gewara.msearch.external.entity.index.IndexData;

public class CinemaIndexInfo extends IndexData {
	private static final long serialVersionUID = -5353503091696102130L;
	private String name = null;
	private String address = null;
	private String desc = null;
	private String cityID = null;

	public String getName() {
		return this.name;
	}

	public String getAddress() {
		return this.address;
	}

	public String getDesc() {
		return this.desc;
	}

	public String getCityID() {
		return this.cityID;
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
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.msearch.external.entity.index;

import com.gewara.msearch.external.entity.index.IndexData;

public class TheatreIndexInfo extends IndexData {
	private static final long serialVersionUID = -5353503091696102130L;
	private String name = null;
	private String address = null;
	private String briefname = null;
	private String cityID = null;

	public String getName() {
		return this.name;
	}

	public String getAddress() {
		return this.address;
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

	public void setCityID(String cityID) {
		this.cityID = cityID;
	}

	public String getBriefname() {
		return this.briefname;
	}

	public void setBriefname(String briefname) {
		this.briefname = briefname;
	}
}
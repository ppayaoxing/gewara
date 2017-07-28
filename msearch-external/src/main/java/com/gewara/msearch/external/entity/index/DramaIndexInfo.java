/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.msearch.external.entity.index;

import com.gewara.msearch.external.entity.index.IndexData;

public class DramaIndexInfo extends IndexData {
	private static final long serialVersionUID = 7074469411495043856L;
	private String seotitle;
	private String dramaname;
	private String englishname;
	private String dramaalias;
	private String type;
	private String cityId;

	public String getSeotitle() {
		return this.seotitle;
	}

	public void setSeotitle(String seotitle) {
		this.seotitle = seotitle;
	}

	public String getDramaname() {
		return this.dramaname;
	}

	public void setDramaname(String dramaname) {
		this.dramaname = dramaname;
	}

	public String getEnglishname() {
		return this.englishname;
	}

	public void setEnglishname(String englishname) {
		this.englishname = englishname;
	}

	public String getDramaalias() {
		return this.dramaalias;
	}

	public void setDramaalias(String dramaalias) {
		this.dramaalias = dramaalias;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCityId() {
		return this.cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
}
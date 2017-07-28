/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.msearch.external.entity.index;

import com.gewara.msearch.external.entity.index.IndexData;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class GwSearchIndexInfo extends IndexData {
	private static final long serialVersionUID = -3071643178306274317L;
	private String name;
	private String tag;
	private Long relatedid;
	private String category;
	private String skey;
	private List<String> citycode;

	public GwSearchIndexInfo() {
	}

	public GwSearchIndexInfo(String keycode, String name, String tag, Long relatedid, String category, String skey,
			String citycode) {
		this.dataID = keycode;
		this.name = name;
		this.tag = tag;
		this.category = category;
		this.skey = skey;
		this.relatedid = relatedid;
		this.citycode = Arrays.asList(StringUtils.split(citycode, ","));
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSkey() {
		return this.skey;
	}

	public void setSkey(String skey) {
		this.skey = skey;
	}

	public List<String> getCitycode() {
		return this.citycode;
	}

	public void setCitycode(List<String> citycode) {
		this.citycode = citycode;
	}

	public String toString() {
		return "GwSearchIndexInfo [name=" + this.name + ", tag=" + this.tag + ", relatedid=" + this.relatedid
				+ ", category=" + this.category + ", skey=" + this.skey + ", citycode=" + this.citycode + "]";
	}
}
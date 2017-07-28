/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class EffectInfoVo extends BaseVo {
	private static final long serialVersionUID = -8456969167272896454L;
	private String key;
	private Integer value;
	private String description;
	private String picPathListJson;
	private String walaids;
	private Integer showNumber;

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getValue() {
		return this.value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicPathListJson() {
		return this.picPathListJson;
	}

	public void setPicPathListJson(String picPathListJson) {
		this.picPathListJson = picPathListJson;
	}

	public String getWalaids() {
		return this.walaids;
	}

	public void setWalaids(String walaids) {
		this.walaids = walaids;
	}

	public Integer getShowNumber() {
		return this.showNumber;
	}

	public void setShowNumber(Integer showNumber) {
		this.showNumber = showNumber;
	}

	public Serializable realId() {
		return this.key;
	}
}
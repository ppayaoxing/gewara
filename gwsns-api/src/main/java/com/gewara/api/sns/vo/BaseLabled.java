/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo;

public class BaseLabled {
	private Long id;
	private Integer sort;
	private Long code;
	private String tag = "movie";

	public BaseLabled() {
	}

	public BaseLabled(Long id, Integer sort) {
		this.id = id;
		this.sort = sort;
	}

	public BaseLabled(Long id, Integer sort, String tag, Long code) {
		this.id = id;
		this.sort = sort;
		this.tag = tag;
		this.code = code;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getCode() {
		return this.code;
	}

	public void setCode(Long code) {
		this.code = code;
	}
}
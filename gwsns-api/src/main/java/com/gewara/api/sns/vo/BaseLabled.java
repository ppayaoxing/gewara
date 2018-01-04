package com.gewara.api.sns.vo;


public class BaseLabled{

	private Long id;
	private Integer sort;//排序
	private Long code;//关联code
	private String tag = "movie";
	

	public BaseLabled(){}
	
	public BaseLabled(Long id, Integer sort){
		this.id = id;
		this.sort = sort;
	}
	
	public BaseLabled(Long id, Integer sort, String tag, Long code){
		this.id = id;
		this.sort = sort;
		this.tag = tag;
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}
	
	
}

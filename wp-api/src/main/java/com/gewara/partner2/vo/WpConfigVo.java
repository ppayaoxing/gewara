package com.gewara.partner2.vo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class WpConfigVo extends BaseVo{
	private static final long serialVersionUID = -4292219280916553956L;

	private Long id;//ID
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	private String description;
	
	private String content;

	@Override
	public Serializable realId() {
		return id;
	}
}

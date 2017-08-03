package com.gewara.movie.vo.common;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class EntityClobVo extends BaseVo{
	private static final long serialVersionUID = 1927358057371862949L;
	private String ekey;
	private String tag;
	private Long relatedid;
	private String content;

	@Override
	public Serializable realId() {
		return ekey;
	}

	public String getEkey() {
		return ekey;
	}

	public void setEkey(String ekey) {
		this.ekey = ekey;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getRelatedid() {
		return relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}

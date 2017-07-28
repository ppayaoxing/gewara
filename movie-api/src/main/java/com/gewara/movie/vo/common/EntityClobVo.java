/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.common;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class EntityClobVo extends BaseVo {
	private static final long serialVersionUID = 1927358057371862949L;
	private String ekey;
	private String tag;
	private Long relatedid;
	private String content;

	public Serializable realId() {
		return this.ekey;
	}

	public String getEkey() {
		return this.ekey;
	}

	public void setEkey(String ekey) {
		this.ekey = ekey;
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

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
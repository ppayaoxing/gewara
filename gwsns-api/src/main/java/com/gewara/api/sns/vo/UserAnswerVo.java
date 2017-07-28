/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class UserAnswerVo extends BaseVo {
	private String id;
	private Integer Index;
	private Integer num;
	private String content;
	private Integer total;
	private String relatedid;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getIndex() {
		return this.Index;
	}

	public void setIndex(Integer index) {
		this.Index = index;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getTotal() {
		return this.total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(String relatedid) {
		this.relatedid = relatedid;
	}

	public Serializable realId() {
		return this.id;
	}
}
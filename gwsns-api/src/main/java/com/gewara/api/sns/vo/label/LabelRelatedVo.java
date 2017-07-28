/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.label;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class LabelRelatedVo extends BaseVo {
	private static final long serialVersionUID = 8805363922912326243L;
	private String tag;
	private Long relatedId;

	public LabelRelatedVo() {
	}

	public LabelRelatedVo(String tag, Long relatedId) {
		this.tag = tag;
		this.relatedId = relatedId;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getRelatedId() {
		return this.relatedId;
	}

	public void setRelatedId(Long relatedId) {
		this.relatedId = relatedId;
	}

	public Serializable realId() {
		return this.tag + "_" + this.relatedId;
	}
}
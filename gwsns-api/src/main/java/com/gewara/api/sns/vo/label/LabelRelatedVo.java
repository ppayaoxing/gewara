package com.gewara.api.sns.vo.label;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;



public class LabelRelatedVo extends BaseVo{
	private static final long serialVersionUID = 8805363922912326243L;
	private String tag;
	private Long relatedId;
	
	public LabelRelatedVo(){}
	
	public LabelRelatedVo(String tag ,Long relatedId){
		this.tag = tag;
		this.relatedId = relatedId;
	}
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Long getRelatedId() {
		return relatedId;
	}
	public void setRelatedId(Long relatedId) {
		this.relatedId = relatedId;
	}
	
	@Override
	public Serializable realId() {
		return tag+"_"+relatedId;
	}
}

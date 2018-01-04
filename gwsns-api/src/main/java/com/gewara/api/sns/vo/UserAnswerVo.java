package com.gewara.api.sns.vo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class UserAnswerVo extends BaseVo{
	private String id;      //用户id+哇啦id
	private Integer Index;  //第几题
	private Integer num;    //答对题数
	private String content; //用户答题数据
	private Integer total;  //题目总计数
	private String relatedid;  //关联主题
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getIndex() {
		return Index;
	}
	public void setIndex(Integer index) {
		Index = index;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getRelatedid() {
		return relatedid;
	}
	public void setRelatedid(String relatedid) {
		this.relatedid = relatedid;
	}
	@Override
	public Serializable realId() {
		return id;
	}
	
	
}

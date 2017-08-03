package com.gewara.api.sns.vo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class AnswerCheckVo extends BaseVo{
	private Long id; //哇啦id
	private String title;//哇啦标题
	private String content;//文字
	private String link;//链接
	private String subject;//题目按逗号分隔
	private String updateTime;//时间
	private Integer totalNum;//题库数
	private Integer enable;//0-关闭：1-启动
	private String endTime;//结束时间
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public Serializable realId() {
		return id;
	}
	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	public Integer getEnable() {
		return enable;
	}
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
}

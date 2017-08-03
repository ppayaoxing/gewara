package com.gewara.api.sns.vo.comment;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class ModeratorTagVo  extends BaseVo{
	private static final long serialVersionUID = -2409632797041244599L;
	private Long id;					
	private Long memberid;		//添加的用户ID
	private String title;			//标签
	private String summary;			//介绍
	private Timestamp addtime;		//添加时间
	private Integer ordernum;		//排序
	private String status;			//状态
	private String tag;				//关联类型 哇啦 话题
	private Long relatedid;			//关联话题id
	private Integer flowernum;		//点赞数
	private Integer commentcount;	//哇啦数
	private Long parentid;			//标签类型
	private String correct;			//正确答案
	
	public String getCorrect() {
		return correct;
	}
	public void setCorrect(String correct) {
		this.correct = correct;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMemberid() {
		return memberid;
	}
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
	public Integer getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getRelatedid() {
		return relatedid;
	}
	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}
	public Integer getFlowernum() {
		return flowernum;
	}
	public void setFlowernum(Integer flowernum) {
		this.flowernum = flowernum;
	}
	public Integer getCommentcount() {
		return commentcount;
	}
	public void setCommentcount(Integer commentcount) {
		this.commentcount = commentcount;
	}
	public Integer getSupport(){
		return this.flowernum + this.commentcount;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public void addFlowernum(){
		this.flowernum += 1;
	}
	public void addCommentcount(){
		this.commentcount += 1;
	}
	@Override
	public Serializable realId() {
		return id;
	}
	public Long getParentid() {
		return parentid;
	}
	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}
	
	public Integer getFactorialCount(){
		return flowernum;
	}
}

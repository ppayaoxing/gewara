/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.comment;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class ModeratorTagVo extends BaseVo {
	private static final long serialVersionUID = -2409632797041244599L;
	private Long id;
	private Long memberid;
	private String title;
	private String summary;
	private Timestamp addtime;
	private Integer ordernum;
	private String status;
	private String tag;
	private Long relatedid;
	private Integer flowernum;
	private Integer commentcount;
	private Long parentid;
	private String correct;

	public String getCorrect() {
		return this.correct;
	}

	public void setCorrect(String correct) {
		this.correct = correct;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Integer getOrdernum() {
		return this.ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public Integer getFlowernum() {
		return this.flowernum;
	}

	public void setFlowernum(Integer flowernum) {
		this.flowernum = flowernum;
	}

	public Integer getCommentcount() {
		return this.commentcount;
	}

	public void setCommentcount(Integer commentcount) {
		this.commentcount = commentcount;
	}

	public Integer getSupport() {
		return Integer.valueOf(this.flowernum.intValue() + this.commentcount.intValue());
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void addFlowernum() {
		this.flowernum = Integer.valueOf(this.flowernum.intValue() + 1);
	}

	public void addCommentcount() {
		this.commentcount = Integer.valueOf(this.commentcount.intValue() + 1);
	}

	public Serializable realId() {
		return this.id;
	}

	public Long getParentid() {
		return this.parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public Integer getFactorialCount() {
		return this.flowernum;
	}
}
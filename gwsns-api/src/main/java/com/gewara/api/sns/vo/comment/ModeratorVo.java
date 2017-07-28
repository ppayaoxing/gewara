/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.comment;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class ModeratorVo extends BaseVo {
	private static final long serialVersionUID = -7731021100306840229L;
	private Long id;
	private String memberid;
	private String title;
	private String summary;
	private Integer ordernum;
	private Timestamp addtime;
	private String type;
	private Integer showfloor;
	private Integer showaddress;
	private String mstatus;
	private Integer commentcount;
	private Long parentid;
	private String tag;
	private Long relatedid;
	private String ispk;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMemberid() {
		return this.memberid;
	}

	public void setMemberid(String memberid) {
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

	public Integer getOrdernum() {
		return this.ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getShowfloor() {
		return this.showfloor;
	}

	public void setShowfloor(Integer showfloor) {
		this.showfloor = showfloor;
	}

	public Integer getShowaddress() {
		return this.showaddress;
	}

	public void setShowaddress(Integer showaddress) {
		this.showaddress = showaddress;
	}

	public String getMstatus() {
		return this.mstatus;
	}

	public void setMstatus(String mstatus) {
		this.mstatus = mstatus;
	}

	public Integer getCommentcount() {
		return this.commentcount;
	}

	public void setCommentcount(Integer commentcount) {
		this.commentcount = commentcount;
	}

	public Long getParentid() {
		return this.parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
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

	public String getIspk() {
		return this.ispk;
	}

	public void setIspk(String ispk) {
		this.ispk = ispk;
	}

	public Serializable realId() {
		return this.id;
	}
}
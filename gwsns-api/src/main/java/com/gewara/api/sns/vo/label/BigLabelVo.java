/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.label;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class BigLabelVo extends BaseVo {
	private static final long serialVersionUID = -573268711254641818L;
	private Long id;
	private String name;
	private String pinyin;
	private String remark;
	private String logo;
	private String cover;
	private Integer fanscount;
	private Integer clickedtimes;
	private Integer commentcount;
	private Integer relatedcount;
	private String status;
	private Long memberid;
	private Timestamp addTime;
	private Timestamp updateTime;
	private Integer attStatus = Integer.valueOf(0);
	private String showRelated;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPinyin() {
		return this.pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getCover() {
		return this.cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public Integer getFanscount() {
		return this.fanscount;
	}

	public void setFanscount(Integer fanscount) {
		this.fanscount = fanscount;
	}

	public Integer getClickedtimes() {
		return this.clickedtimes;
	}

	public void setClickedtimes(Integer clickedtimes) {
		this.clickedtimes = clickedtimes;
	}

	public Integer getCommentcount() {
		return this.commentcount;
	}

	public void setCommentcount(Integer commentcount) {
		this.commentcount = commentcount;
	}

	public Integer getRelatedcount() {
		return this.relatedcount;
	}

	public void setRelatedcount(Integer relatedcount) {
		this.relatedcount = relatedcount;
	}

	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Integer getAttStatus() {
		return this.attStatus;
	}

	public void setAttStatus(Integer attStatus) {
		this.attStatus = attStatus;
	}

	public String getShowRelated() {
		return this.showRelated;
	}

	public void setShowRelated(String showRelated) {
		this.showRelated = showRelated;
	}
}
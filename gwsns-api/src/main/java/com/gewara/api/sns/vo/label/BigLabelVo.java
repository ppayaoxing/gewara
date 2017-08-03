package com.gewara.api.sns.vo.label;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class BigLabelVo extends BaseVo {
	private static final long serialVersionUID = -573268711254641818L;
	private Long id; // 主键
	private String name; // 标签名称
	private String pinyin; // 标签拼音
	private String remark; // 简介
	private String logo; // 小图标（路径）
	private String cover; // 封面图片（路径）
	private Integer fanscount; // 粉丝数量
	private Integer clickedtimes; // 访问数量
	private Integer commentcount; // 哇啦数量
	private Integer relatedcount; // 关联的数量
	private String status; // 有效状态 Y--有效，N---无效
	private Long memberid; // 添加标签用户
	private Timestamp addTime; // 创建标签时间
	private Timestamp updateTime; // 最近更新标签时间
	private Integer attStatus = 0;//关注状态   0-未关注(默认)；1已关注
	
	private String showRelated; // 显示关联 Y--显示，N---不显示
	
	@Override
	public Serializable realId() {
		return id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public Integer getFanscount() {
		return fanscount;
	}

	public void setFanscount(Integer fanscount) {
		this.fanscount = fanscount;
	}

	public Integer getClickedtimes() {
		return clickedtimes;
	}

	public void setClickedtimes(Integer clickedtimes) {
		this.clickedtimes = clickedtimes;
	}

	public Integer getCommentcount() {
		return commentcount;
	}

	public void setCommentcount(Integer commentcount) {
		this.commentcount = commentcount;
	}

	public Integer getRelatedcount() {
		return relatedcount;
	}

	public void setRelatedcount(Integer relatedcount) {
		this.relatedcount = relatedcount;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Integer getAttStatus() {
		return attStatus;
	}

	public void setAttStatus(Integer attStatus) {
		this.attStatus = attStatus;
	}
	
	public String getShowRelated() {
		return showRelated;
	}

	public void setShowRelated(String showRelated) {
		this.showRelated = showRelated;
	}

}
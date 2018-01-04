package com.gewara.api.sns.vo.comment;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class ModeratorVo extends BaseVo {
	private static final long serialVersionUID = -7731021100306840229L;
	
	private Long id;
	private String memberid;
	private String title;
	private String summary;
	private Integer ordernum;
	private Timestamp addtime;
	private String type;
	private Integer showfloor;//是否显示楼层
	private Integer showaddress;//显示地址
	private String mstatus;//状态
	private Integer commentcount;
	private Long parentid;			//父话题id
	private String tag;				//关联板块
	private Long relatedid;			//关联id
	private String ispk;				//是否为pk话题
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
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
	public Integer getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getShowfloor() {
		return showfloor;
	}
	public void setShowfloor(Integer showfloor) {
		this.showfloor = showfloor;
	}
	public Integer getShowaddress() {
		return showaddress;
	}
	public void setShowaddress(Integer showaddress) {
		this.showaddress = showaddress;
	}
	public String getMstatus() {
		return mstatus;
	}
	public void setMstatus(String mstatus) {
		this.mstatus = mstatus;
	}
	public Integer getCommentcount() {
		return commentcount;
	}
	public void setCommentcount(Integer commentcount) {
		this.commentcount = commentcount;
	}
	public Long getParentid() {
		return parentid;
	}
	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Long getRelatedid() {
		return relatedid;
	}
	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}
	public String getIspk() {
		return ispk;
	}
	public void setIspk(String ispk) {
		this.ispk = ispk;
	}
	@Override
	public Serializable realId() {
		return id;
	}
	

}

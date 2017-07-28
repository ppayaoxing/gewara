/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.baochang;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class BaoChangRoomDescVo extends BaseVo {
	private static final long serialVersionUID = 4236339229733739735L;
	private String id;
	private Long cinemaid;
	private Long roomid;
	private String iconUrl;
	private String iconWidth;
	private String iconHeight;
	private String title;
	private String bigIconUrl;
	private String bigIconWidth;
	private String bigIconHeight;
	private String remark;
	private Integer rank;
	private String descType;
	private String top;
	private Timestamp startTime;
	private Timestamp endTime;
	private String otherinfo;
	private String status;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getCinemaid() {
		return this.cinemaid;
	}

	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}

	public Long getRoomid() {
		return this.roomid;
	}

	public void setRoomid(Long roomid) {
		this.roomid = roomid;
	}

	public String getIconUrl() {
		return this.iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getIconWidth() {
		return this.iconWidth;
	}

	public void setIconWidth(String iconWidth) {
		this.iconWidth = iconWidth;
	}

	public String getIconHeight() {
		return this.iconHeight;
	}

	public void setIconHeight(String iconHeight) {
		this.iconHeight = iconHeight;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBigIconUrl() {
		return this.bigIconUrl;
	}

	public void setBigIconUrl(String bigIconUrl) {
		this.bigIconUrl = bigIconUrl;
	}

	public String getBigIconWidth() {
		return this.bigIconWidth;
	}

	public void setBigIconWidth(String bigIconWidth) {
		this.bigIconWidth = bigIconWidth;
	}

	public String getBigIconHeight() {
		return this.bigIconHeight;
	}

	public void setBigIconHeight(String bigIconHeight) {
		this.bigIconHeight = bigIconHeight;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getDescType() {
		return this.descType;
	}

	public void setDescType(String descType) {
		this.descType = descType;
	}

	public String getTop() {
		return this.top;
	}

	public void setTop(String top) {
		this.top = top;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Serializable realId() {
		return this.id;
	}
}
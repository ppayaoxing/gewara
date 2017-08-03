package com.gewara.movie.vo.baochang;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class BaoChangRoomDescVo extends BaseVo{
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
	private String descType;	// big;small
	private String top;		// Y:N default:N
	private Timestamp startTime;
	private Timestamp endTime;
	private String otherinfo;
	private String status;		//Y
	
	public BaoChangRoomDescVo(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getCinemaid() {
		return cinemaid;
	}

	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}

	public Long getRoomid() {
		return roomid;
	}

	public void setRoomid(Long roomid) {
		this.roomid = roomid;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getIconWidth() {
		return iconWidth;
	}

	public void setIconWidth(String iconWidth) {
		this.iconWidth = iconWidth;
	}

	public String getIconHeight() {
		return iconHeight;
	}

	public void setIconHeight(String iconHeight) {
		this.iconHeight = iconHeight;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBigIconUrl() {
		return bigIconUrl;
	}

	public void setBigIconUrl(String bigIconUrl) {
		this.bigIconUrl = bigIconUrl;
	}

	public String getBigIconWidth() {
		return bigIconWidth;
	}

	public void setBigIconWidth(String bigIconWidth) {
		this.bigIconWidth = bigIconWidth;
	}

	public String getBigIconHeight() {
		return bigIconHeight;
	}

	public void setBigIconHeight(String bigIconHeight) {
		this.bigIconHeight = bigIconHeight;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	

	public String getDescType() {
		return descType;
	}

	public void setDescType(String descType) {
		this.descType = descType;
	}

	public String getTop() {
		return top;
	}

	public void setTop(String top) {
		this.top = top;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getOtherinfo() {
		return otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public Serializable realId() {
		return id;
	}
	
}

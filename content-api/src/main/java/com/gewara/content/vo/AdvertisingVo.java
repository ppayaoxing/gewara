/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.content.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class AdvertisingVo extends BaseVo {
	private static final long serialVersionUID = -4548062751031282415L;
	public static final String STATUS_UP = "up";
	public static final String STATUS_DOWN = "down";
	public static final String STATUS_DELETED = "deleted";
	private Long id;
	private Long adpositionid;
	private String link;
	private String title;
	private String ad;
	private String adtype;
	private String description;
	private Integer rang1;
	private Integer rang2;
	private Integer viewtimes;
	private Integer remaintimes;
	private Timestamp starttime;
	private Timestamp endtime;
	private Timestamp addtime;
	private String status;
	private String logicaldir;
	private boolean reassign;
	private String citycode;
	private String relateCity;
	private String tag;
	private Long relatedid;
	private String track;
	private Integer ordernum;

	public Integer getOrdernum() {
		return this.ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
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

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public boolean isReassign() {
		return this.reassign;
	}

	public void setReassign(boolean reassign) {
		this.reassign = reassign;
	}

	public AdvertisingVo() {
	}

	public AdvertisingVo(String title) {
		this.title = title;
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.status = "down";
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Serializable realId() {
		return this.id;
	}

	public String getAd() {
		return this.ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getAdtype() {
		return this.adtype;
	}

	public void setAdtype(String adtype) {
		this.adtype = adtype;
	}

	public String getStatus() {
		return this.status;
	}

	public String getRelateCity() {
		return this.relateCity;
	}

	public void setRelateCity(String relateCity) {
		this.relateCity = relateCity;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getViewtimes() {
		return this.viewtimes;
	}

	public void setViewtimes(Integer viewtimes) {
		this.viewtimes = viewtimes;
	}

	public Integer getRemaintimes() {
		return this.remaintimes;
	}

	public void setRemaintimes(Integer remaintimes) {
		this.remaintimes = remaintimes;
	}

	public Integer getRang2() {
		return this.rang2;
	}

	public void setRang2(Integer rang2) {
		this.rang2 = rang2;
	}

	public Integer getRang1() {
		return this.rang1;
	}

	public void setRang1(Integer rang1) {
		this.rang1 = rang1;
	}

	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public String getLogicaldir() {
		return this.logicaldir;
	}

	public void setLogicaldir(String logicaldir) {
		this.logicaldir = logicaldir;
	}

	public Long getAdpositionid() {
		return this.adpositionid;
	}

	public void setAdpositionid(Long adpositionid) {
		this.adpositionid = adpositionid;
	}

	public boolean getBooking() {
		if ((this.starttime == null) || (this.endtime == null))
			return false;
		if (this.starttime.after(new Timestamp(System.currentTimeMillis())))
			return false;
		return (!(this.endtime.before(new Timestamp(System.currentTimeMillis()))));
	}

	public String getTrack() {
		return this.track;
	}

	public void setTrack(String track) {
		this.track = track;
	}
}
package com.gewara.api.sns.vo.comment;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class RecommendVo extends BaseVo{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String signname;
	private String title;
	private String link;
	private String summary;
	private Long relatedid;
	private String logo;
	private Integer ordernum;
	private Timestamp addtime;
	private String citycode;
	private Timestamp starttime;
	private Timestamp endtime;
	private String tag;

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


	public String getSignname() {
		return signname;
	}


	public void setSignname(String signname) {
		this.signname = signname;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}


	public Long getRelatedid() {
		return relatedid;
	}


	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}


	public String getLogo() {
		return logo;
	}


	public void setLogo(String logo) {
		this.logo = logo;
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


	public String getCitycode() {
		return citycode;
	}


	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}


	public Timestamp getStarttime() {
		return starttime;
	}


	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}


	public Timestamp getEndtime() {
		return endtime;
	}


	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}


	public String getTag() {
		return tag;
	}


	public void setTag(String tag) {
		this.tag = tag;
	}

}

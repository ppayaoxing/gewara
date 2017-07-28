/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.content.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class NewsVo extends BaseVo {
	private static final long serialVersionUID = 4914995483381697551L;
	private Long id;
	private String tag;
	private String title;
	private String secondtitle;
	private String summary;
	private String logo;
	private String smallLogo;
	private String tplLogo;
	private String relatedlink;
	private String content;
	private String newstype;
	private String flag;
	private Timestamp releasetime;
	private Timestamp updatetime;
	private Timestamp addtime;
	private Long relatedid;
	private String category;
	private String linksource;
	private String countycode;
	private String newslabel;
	private String author;
	private Long categoryid;
	private String citycode;
	private Integer pagesize;
	private Integer clickedtimes = Integer.valueOf(0);
	private String otherinfo;

	public Serializable realId() {
		return this.id;
	}

	public Long getCategoryid() {
		return this.categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getNewslabel() {
		return this.newslabel;
	}

	public void setNewslabel(String newslabel) {
		this.newslabel = newslabel;
	}

	public String getCountycode() {
		return this.countycode;
	}

	public void setCountycode(String countycode) {
		this.countycode = countycode;
	}

	public Integer getPagesize() {
		return this.pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRelatedlink() {
		return this.relatedlink;
	}

	public void setRelatedlink(String relatedlink) {
		this.relatedlink = relatedlink;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSecondtitle() {
		return this.secondtitle;
	}

	public void setSecondtitle(String secondtitle) {
		this.secondtitle = secondtitle;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLogo() {
		if (StringUtils.isBlank(this.logo))
			return "img/default_logo.png";
		return this.logo;
	}

	public String getLimg() {
		if (StringUtils.isBlank(this.logo))
			return "img/default_head.png";
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getSmallLogo() {
		return this.smallLogo;
	}

	public String getSimg() {
		if (StringUtils.isBlank(this.smallLogo))
			return "img/default_logo.png";
		return this.smallLogo;
	}

	public void setSmallLogo(String smallLogo) {
		this.smallLogo = smallLogo;
	}

	public String getNewstype() {
		return this.newstype;
	}

	public void setNewstype(String newstype) {
		this.newstype = newstype;
	}

	public Timestamp getReleasetime() {
		return this.releasetime;
	}

	public void setReleasetime(Timestamp releasetime) {
		this.releasetime = releasetime;
	}

	public String getLink(String basePath) {
		if (StringUtils.isNotBlank(this.relatedlink))
			return this.relatedlink;
		return basePath + "news/" + this.id;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Long getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getLinksource() {
		return this.linksource;
	}

	public void setLinksource(String linksource) {
		this.linksource = linksource;
	}

	public String getCname() {
		return this.title;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getTplLogo() {
		return this.tplLogo;
	}

	public void setTplLogo(String tplLogo) {
		this.tplLogo = tplLogo;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public Integer getClickedtimes() {
		return this.clickedtimes;
	}

	public void setClickedtimes(Integer clickedtimes) {
		this.clickedtimes = clickedtimes;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
}
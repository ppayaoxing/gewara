/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.partner2.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class AdvertCommendVo extends BaseVo {
	private static final long serialVersionUID = -2755975263032699595L;
	private Long id;
	private String appkey;
	private String title;
	private String link;
	private String adlogo;
	private String citycodes;
	private Long userid;
	private Timestamp addtime;
	private Timestamp starttime;
	private Timestamp endtime;
	private Integer sortnum;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAppkey() {
		return this.appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getAdlogo() {
		return this.adlogo;
	}

	public void setAdlogo(String adlogo) {
		this.adlogo = adlogo;
	}

	public String getCitycodes() {
		return this.citycodes;
	}

	public void setCitycodes(String citycodes) {
		this.citycodes = citycodes;
	}

	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
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

	public Integer getSortnum() {
		return this.sortnum;
	}

	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}

	public String getLogo() {
		return this.adlogo;
	}
}
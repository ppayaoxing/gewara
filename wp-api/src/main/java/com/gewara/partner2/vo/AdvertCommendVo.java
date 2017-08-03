package com.gewara.partner2.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class AdvertCommendVo extends BaseVo{
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
	public String getAppkey() {
		return appkey;
	}
	public void setAppkey(String appkey) {
		this.appkey = appkey;
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
	public String getAdlogo() {
		return adlogo;
	}
	public void setAdlogo(String adlogo) {
		this.adlogo = adlogo;
	}
	public String getCitycodes() {
		return citycodes;
	}
	public void setCitycodes(String citycodes) {
		this.citycodes = citycodes;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
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
	public Integer getSortnum() {
		return sortnum;
	}
	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}
	public String getLogo(){
		return adlogo;
	}
}

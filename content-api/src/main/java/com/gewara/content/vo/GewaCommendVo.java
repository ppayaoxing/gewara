/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.content.vo;

import com.gewara.api.vo.BaseVo;
import com.gewara.model.BaseObject;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class GewaCommendVo extends BaseVo {
	private static final long serialVersionUID = -1637550881723667131L;
	private Long id;
	private String signname;
	private String title;
	private String link;
	private String tag;
	private String logo;
	private String smalllogo;
	private String summary;
	private Long relatedid;
	private Long parentid;
	private Integer ordernum;
	private Timestamp addtime;
	private Timestamp starttime;
	private Timestamp stoptime;
	private String citycode;
	private BaseObject relate;
	private BaseObject relate2;
	private String otherinfo;

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getSimpleLink() {
		String simpleLink = StringUtils.trim(this.link);
		if (StringUtils.startsWith(simpleLink, "http://www.gewara.com")) {
			return StringUtils.replace(simpleLink, "http://www.gewara.com", "");
		}
		return simpleLink;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public GewaCommendVo() {
	}

	public GewaCommendVo(String signname) {
		this.signname = signname;
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.ordernum = Integer.valueOf(0);
		this.starttime = new Timestamp(System.currentTimeMillis());
		this.stoptime = new Timestamp(System.currentTimeMillis());
	}

	public GewaCommendVo(String signname, String title, Long relatedid, Integer ordernum) {
		this(signname);
		this.title = title;
		this.relatedid = relatedid;
		this.ordernum = ordernum;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSignname() {
		return this.signname;
	}

	public void setSignname(String signname) {
		this.signname = signname;
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

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getLogo() {
		return this.logo;
	}

	public String getLimg() {
		if (StringUtils.isBlank(this.logo))
			return "img/default_head.png";
		return this.logo;
	}

	public String getLsmallimg() {
		if (StringUtils.isBlank(this.smalllogo))
			return "img/default_head.png";
		return this.smalllogo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
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

	public Long getParentid() {
		return this.parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public Integer getOrdernum() {
		return this.ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public Serializable realId() {
		return this.id;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getReallogo() {
		if (StringUtils.isBlank(this.logo))
			return "img/default_pic.png";
		return this.logo;
	}

	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getStoptime() {
		return this.stoptime;
	}

	public void setStoptime(Timestamp stoptime) {
		this.stoptime = stoptime;
	}

	public String getSmalllogo() {
		return this.smalllogo;
	}

	public void setSmalllogo(String smalllogo) {
		this.smalllogo = smalllogo;
	}

	public BaseObject getRelate() {
		return this.relate;
	}

	public void setRelate(BaseObject relate) {
		this.relate = relate;
	}

	public BaseObject getRelate2() {
		return this.relate2;
	}

	public void setRelate2(BaseObject relate2) {
		this.relate2 = relate2;
	}
}
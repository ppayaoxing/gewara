/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo;

import com.gewara.drama.vo.common.BaseEntityVo;
import java.util.Date;
import org.apache.commons.lang.StringUtils;

public class DramaStarVo extends BaseEntityVo {
	private static final long serialVersionUID = -505984720950483214L;
	public static final String TYPE_STAR = "star";
	public static final String TYPE_TROUPE = "troupe";
	public static final String TYPE_DIRECTOR = "director";
	public static final String TYPE_COMMENTATOR = "commentator";
	public static final String TAG_DRAMASTAR = "dramastar";
	private Date birthday;
	private String tag;
	private String state;
	private String bloodtype;
	private String constellation;
	private String height;
	private String hometown;
	private String graduated;
	private String job;
	private String website;
	private Long troupe;
	private Date establishtime;
	private String startype;
	private String representative;
	private String representativeRelate;
	private Integer starnum;
	private Integer worknum;
	private String describe;

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBloodtype() {
		return this.bloodtype;
	}

	public void setBloodtype(String bloodtype) {
		this.bloodtype = bloodtype;
	}

	public String getConstellation() {
		return this.constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	public String getHeight() {
		return this.height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getGraduated() {
		return this.graduated;
	}

	public void setGraduated(String graduated) {
		this.graduated = graduated;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Long getTroupe() {
		return this.troupe;
	}

	public void setTroupe(Long troupe) {
		this.troupe = troupe;
	}

	public String getHometown() {
		return this.hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getEstablishtime() {
		return this.establishtime;
	}

	public void setEstablishtime(Date establishtime) {
		this.establishtime = establishtime;
	}

	public String getStartype() {
		return this.startype;
	}

	public void setStartype(String startype) {
		this.startype = startype;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Integer getStarnum() {
		return this.starnum;
	}

	public void setStarnum(Integer starnum) {
		this.starnum = starnum;
	}

	public Integer getWorknum() {
		return this.worknum;
	}

	public void setWorknum(Integer worknum) {
		this.worknum = worknum;
	}

	public String getLimg() {
		return StringUtils.isBlank(this.logo) ? "img/default_pic.png" : this.logo;
	}

	public String getRepresentative() {
		return this.representative;
	}

	public void setRepresentative(String representative) {
		this.representative = representative;
	}

	public String getRepresentativeRelate() {
		return this.representativeRelate;
	}

	public void setRepresentativeRelate(String representativeRelate) {
		this.representativeRelate = representativeRelate;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getDescribe() {
		return this.describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}
}
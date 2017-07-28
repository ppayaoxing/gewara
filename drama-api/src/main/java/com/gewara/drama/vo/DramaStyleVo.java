/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo;

import com.gewara.drama.vo.common.BaseEntityVo;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class DramaStyleVo extends BaseEntityVo {
	private static final long serialVersionUID = 997773190722906162L;
	private Long recordid;
	private Long commentid;
	private Long dramaid;
	private Long starid;
	private Long memberid;
	private String type;
	private String state;
	private Integer sortnum;
	private String isrecommend;
	private String isfind;
	private String title;
	private String body;
	private Timestamp addTime;
	private String citycode;
	private String tag;
	private Timestamp recommendTime;
	private String logo;
	private String introduce;

	public Long getRecordid() {
		return this.recordid;
	}

	public void setRecordid(Long recordid) {
		this.recordid = recordid;
	}

	public Long getCommentid() {
		return this.commentid;
	}

	public void setCommentid(Long commentid) {
		this.commentid = commentid;
	}

	public Long getDramaid() {
		return this.dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public Long getStarid() {
		return this.starid;
	}

	public void setStarid(Long starid) {
		this.starid = starid;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getSortnum() {
		return this.sortnum;
	}

	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}

	public String getIsrecommend() {
		return this.isrecommend;
	}

	public void setIsrecommend(String isrecommend) {
		this.isrecommend = isrecommend;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Timestamp getRecommendTime() {
		return this.recommendTime;
	}

	public void setRecommendTime(Timestamp recommendTime) {
		this.recommendTime = recommendTime;
	}

	public String getIsfind() {
		return this.isfind;
	}

	public void setIsfind(String isfind) {
		this.isfind = isfind;
	}

	public String getLogo() {
		return StringUtils.isBlank(this.logo) ? "img/default_head.png" : this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getIntroduce() {
		return this.introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
}
package com.gewara.drama.vo;

import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.drama.vo.common.BaseEntityVo;

public class DramaStyleVo extends BaseEntityVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 997773190722906162L;
	private Long recordid;
	private Long commentid;
	private Long dramaid;
	private Long starid;// ������id
	private Long memberid;// �û�id
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
		return recordid;
	}

	public void setRecordid(Long recordid) {
		this.recordid = recordid;
	}

	public Long getCommentid() {
		return commentid;
	}

	public void setCommentid(Long commentid) {
		this.commentid = commentid;
	}

	public Long getDramaid() {
		return dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public Long getStarid() {
		return starid;
	}

	public void setStarid(Long starid) {
		this.starid = starid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getSortnum() {
		return sortnum;
	}

	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}

	public String getIsrecommend() {
		return isrecommend;
	}

	public void setIsrecommend(String isrecommend) {
		this.isrecommend = isrecommend;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Timestamp getRecommendTime() {
		return recommendTime;
	}

	public void setRecommendTime(Timestamp recommendTime) {
		this.recommendTime = recommendTime;
	}

	public String getIsfind() {
		return isfind;
	}

	public void setIsfind(String isfind) {
		this.isfind = isfind;
	}

	@Override
    public String getLogo() {
		if (StringUtils.isBlank(logo)) {
            return "img/default_head.png";
        }
		return logo;
	}

	@Override
    public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

}

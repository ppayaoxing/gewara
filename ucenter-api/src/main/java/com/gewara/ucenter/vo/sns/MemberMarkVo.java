package com.gewara.ucenter.vo.sns;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class MemberMarkVo extends BaseVo{
	private static final long serialVersionUID = 1095720111805257556L;
	private Long id;
	private String tag;
	private Long relatedid;
	private String markname;
	private Integer markvalue;
	private Timestamp addtime;
	private Long memberid;
	private String nickname;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Long getRelatedid() {
		return relatedid;
	}
	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}
	public String getMarkname() {
		return markname;
	}
	public void setMarkname(String markname) {
		this.markname = markname;
	}
	public Integer getMarkvalue() {
		return markvalue;
	}
	public void setMarkvalue(Integer markvalue) {
		this.markvalue = markvalue;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
	public Long getMemberid() {
		return memberid;
	}
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public Serializable realId() {
		return id;
	}
	
}

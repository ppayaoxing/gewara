/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.vo.sns;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class MemberMarkVo extends BaseVo {
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
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getMarkname() {
		return this.markname;
	}

	public void setMarkname(String markname) {
		this.markname = markname;
	}

	public Integer getMarkvalue() {
		return this.markvalue;
	}

	public void setMarkvalue(Integer markvalue) {
		this.markvalue = markvalue;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Serializable realId() {
		return this.id;
	}
}
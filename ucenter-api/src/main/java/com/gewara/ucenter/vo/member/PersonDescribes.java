package com.gewara.ucenter.vo.member;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;


public class PersonDescribes extends BaseVo{
	private static final long serialVersionUID = 2651425282834005458L;

	private Long memberid;
	
	private String describe;
	
	private String source;

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public Serializable realId() {
		return memberid;
	}
}

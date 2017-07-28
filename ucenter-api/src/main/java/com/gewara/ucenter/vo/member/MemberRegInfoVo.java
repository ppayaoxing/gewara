/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.vo.member;

import com.gewara.api.vo.BaseVo;
import com.gewara.ucenter.vo.member.MemberInfoVo;
import com.gewara.ucenter.vo.member.MemberVo;
import java.io.Serializable;

public class MemberRegInfoVo extends BaseVo {
	private static final long serialVersionUID = 8494912966229787884L;
	private MemberVo member;
	private MemberInfoVo memberInfo;
	private String memberEncode;
	private boolean onlyBind = false;

	public MemberRegInfoVo() {
	}

	public MemberRegInfoVo(MemberVo member, MemberInfoVo memberInfo, String memberEncode) {
		this.member = member;
		this.memberInfo = memberInfo;
		this.memberEncode = memberEncode;
	}

	public MemberVo getMember() {
		return this.member;
	}

	public void setMember(MemberVo member) {
		this.member = member;
	}

	public MemberInfoVo getMemberInfo() {
		return this.memberInfo;
	}

	public void setMemberInfo(MemberInfoVo memberInfo) {
		this.memberInfo = memberInfo;
	}

	public String getMemberEncode() {
		return this.memberEncode;
	}

	public void setMemberEncode(String memberEncode) {
		this.memberEncode = memberEncode;
	}

	public boolean isOnlyBind() {
		return this.onlyBind;
	}

	public void setOnlyBind(boolean onlyBind) {
		this.onlyBind = onlyBind;
	}

	public Serializable realId() {
		return this.memberEncode;
	}
}
package com.gewara.ucenter.vo.member;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;


public class MemberRegInfoVo extends BaseVo {

	private static final long serialVersionUID = 8494912966229787884L;
	
	private MemberVo member;
	private MemberInfoVo memberInfo;
	private String memberEncode;
	private boolean onlyBind = false; // 账户之前可能存在,只是重新动态码登录

	public MemberRegInfoVo() {
		super();
	}
	
	public MemberRegInfoVo(MemberVo member, MemberInfoVo memberInfo, String memberEncode){
		this.member = member;
		this.memberInfo = memberInfo;
		this.memberEncode = memberEncode;
	}
	
	public MemberVo getMember() {
		return member;
	}

	public void setMember(MemberVo member) {
		this.member = member;
	}

	public MemberInfoVo getMemberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(MemberInfoVo memberInfo) {
		this.memberInfo = memberInfo;
	}

	public String getMemberEncode() {
		return memberEncode;
	}

	public void setMemberEncode(String memberEncode) {
		this.memberEncode = memberEncode;
	}

	public boolean isOnlyBind() {
		return onlyBind;
	}

	public void setOnlyBind(boolean onlyBind) {
		this.onlyBind = onlyBind;
	}

	@Override
	public Serializable realId() {
		return memberEncode;
	}

}

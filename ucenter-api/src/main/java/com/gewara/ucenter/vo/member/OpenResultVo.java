/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.vo.member;

import com.gewara.api.vo.BaseVo;
import com.gewara.ucenter.vo.member.MemberVo;
import java.io.Serializable;
import java.util.Map;

public class OpenResultVo extends BaseVo {
	private static final long serialVersionUID = 6279877647000728944L;
	private MemberVo memberVo;
	private String type;
	private Map dataMap;

	public Map getDataMap() {
		return this.dataMap;
	}

	public void setDataMap(Map dataMap) {
		this.dataMap = dataMap;
	}

	public OpenResultVo() {
	}

	public OpenResultVo(MemberVo memberVo, String type) {
		this.memberVo = memberVo;
		this.type = type;
	}

	public MemberVo getMemberVo() {
		return this.memberVo;
	}

	public void setMemberVo(MemberVo memberVo) {
		this.memberVo = memberVo;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Serializable realId() {
		return null;
	}
}
package com.gewara.ucenter.vo.member;

import java.io.Serializable;
import java.util.Map;

import com.gewara.api.vo.BaseVo;

public class OpenResultVo extends BaseVo {

	private static final long serialVersionUID = 6279877647000728944L;
	
	private MemberVo memberVo;
	private String type;
	private Map dataMap;
	
	public Map getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map dataMap) {
		this.dataMap = dataMap;
	}
	public OpenResultVo(){}
	public OpenResultVo(MemberVo memberVo, String type){
		this.memberVo = memberVo;
		this.type = type;
	}

	public MemberVo getMemberVo() {
		return memberVo;
	}

	public void setMemberVo(MemberVo memberVo) {
		this.memberVo = memberVo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public Serializable realId() {
		return null;
	}
	
}

package com.gewara.ucenter.vo.member;

import java.io.Serializable;
import java.util.Date;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;

public class EncodeDataVo extends BaseVo {

	private static final long serialVersionUID = -3735272053708968031L;
	private long memberid;
	private long validMonth;
	private String passvalid;//密码验证结果：U 未做验证  Y 验证通过  N 验证未通过
	

	public long getMemberid() {
		return memberid;
	}


	public void setMemberid(long memberid) {
		this.memberid = memberid;
	}


	public long getValidMonth() {
		return validMonth;
	}


	public void setValidMonth(long validMonth) {
		this.validMonth = validMonth;
	}


	public String getPassvalid() {
		return passvalid;
	}


	public void setPassvalid(String passvalid) {
		this.passvalid = passvalid;
	}

	public boolean expire(){
		long curmon = Long.valueOf(DateUtil.format(new Date(), "yyyyMM"));
		return curmon>validMonth;
	}
	
	@Override
	public Serializable realId() {
		return null;
	}
	
}

/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.vo.member;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;
import java.io.Serializable;
import java.util.Date;

public class EncodeDataVo extends BaseVo {
	private static final long serialVersionUID = -3735272053708968031L;
	private long memberid;
	private long validMonth;
	private String passvalid;

	public long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(long memberid) {
		this.memberid = memberid;
	}

	public long getValidMonth() {
		return this.validMonth;
	}

	public void setValidMonth(long validMonth) {
		this.validMonth = validMonth;
	}

	public String getPassvalid() {
		return this.passvalid;
	}

	public void setPassvalid(String passvalid) {
		this.passvalid = passvalid;
	}

	public boolean expire() {
		long curmon = Long.valueOf(DateUtil.format(new Date(), "yyyyMM")).longValue();
		return curmon > this.validMonth;
	}

	public Serializable realId() {
		return null;
	}
}
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo;

import com.gewara.model.MemberViewInfo;
import java.io.Serializable;
import java.util.List;

public class MemberViewHistoryVo implements Serializable {
	private static final long serialVersionUID = 267793090821893655L;
	private Long memberid;
	private List<MemberViewInfo> viewHistory;

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public List<MemberViewInfo> getViewHistory() {
		return this.viewHistory;
	}

	public void setViewHistory(List<MemberViewInfo> viewHistory) {
		this.viewHistory = viewHistory;
	}
}
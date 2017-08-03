package com.gewara.api.vo;

import java.io.Serializable;
import java.util.List;

import com.gewara.model.MemberViewInfo;

/**
 * 用户观影记录
 * 
 * @author jeremylei
 * @date 2016/04/15
 */
public class MemberViewHistoryVo  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 267793090821893655L;
	private Long memberid; // 用户id
	private List<MemberViewInfo> viewHistory; // 观影历史

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public List<MemberViewInfo> getViewHistory() {
		return viewHistory;
	}

	public void setViewHistory(List<MemberViewInfo> viewHistory) {
		this.viewHistory = viewHistory;
	}
}

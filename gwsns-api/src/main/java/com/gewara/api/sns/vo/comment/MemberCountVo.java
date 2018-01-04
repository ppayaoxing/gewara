package com.gewara.api.sns.vo.comment;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

/**
 * com.gewara.service.impl.CommentServiceImpl.getHotMicroMemberList(String tag, Long memberid, int maxnum)方法中使用
 * @author quzhuping
 *
 */
public class MemberCountVo extends BaseVo {
	private static final long serialVersionUID = 2903848782660125848L;
	private Long memberId;
	private Integer memberCount;
	
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public Integer getMemberCount() {
		return memberCount;
	}
	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}
	@Override
	public Serializable realId() {
		return null;
	}
	
	
}

/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.comment;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class MemberCountVo extends BaseVo {
	private static final long serialVersionUID = 2903848782660125848L;
	private Long memberId;
	private Integer memberCount;

	public Long getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Integer getMemberCount() {
		return this.memberCount;
	}

	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}

	public Serializable realId() {
		return null;
	}
}
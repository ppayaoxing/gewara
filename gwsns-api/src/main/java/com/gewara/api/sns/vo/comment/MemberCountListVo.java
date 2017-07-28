/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.comment;

import com.gewara.api.sns.vo.comment.MemberCountVo;
import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MemberCountListVo extends BaseVo {
	private static final long serialVersionUID = 8626939130750247785L;
	private List<MemberCountVo> memberCountList = new ArrayList();

	public List<MemberCountVo> getMemberCountList() {
		return this.memberCountList;
	}

	public void setMemberCountList(List<MemberCountVo> memberCountList) {
		this.memberCountList = memberCountList;
	}

	public void addMemberCount(MemberCountVo memberCount) {
		this.memberCountList.add(memberCount);
	}

	public Serializable realId() {
		return null;
	}
}
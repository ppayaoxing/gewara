package com.gewara.api.sns.vo.comment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gewara.api.vo.BaseVo;

public class MemberCountListVo extends BaseVo {
	private static final long serialVersionUID = 8626939130750247785L;
	private List<MemberCountVo> memberCountList = new ArrayList<MemberCountVo>();

	public List<MemberCountVo> getMemberCountList() {
		return memberCountList;
	}

	public void setMemberCountList(List<MemberCountVo> memberCountList) {
		this.memberCountList = memberCountList;
	}
	
	public void addMemberCount(MemberCountVo memberCount)
	{
		this.memberCountList.add(memberCount);
	}

	@Override
	public Serializable realId() {
		return null;
	}

}

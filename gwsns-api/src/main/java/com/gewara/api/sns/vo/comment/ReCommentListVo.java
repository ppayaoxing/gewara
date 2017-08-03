package com.gewara.api.sns.vo.comment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gewara.api.vo.BaseVo;

public class ReCommentListVo extends BaseVo{
	private static final long serialVersionUID = 2763813344445652119L;
	private List<ReCommentVo> reCommentList = new ArrayList<ReCommentVo>();

	public List<ReCommentVo> getReCommentList() {
		return reCommentList;
	}

	public void setReCommentList(List<ReCommentVo> reCommentList) {
		this.reCommentList = reCommentList;
	}


	public void addReComment(ReCommentVo reComment)
	{
		this.reCommentList.add(reComment);
	}

	@Override
	public Serializable realId() {
		return null;
	}

}

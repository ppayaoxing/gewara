/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.comment;

import com.gewara.api.sns.vo.comment.ReCommentVo;
import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReCommentListVo extends BaseVo {
	private static final long serialVersionUID = 2763813344445652119L;
	private List<ReCommentVo> reCommentList = new ArrayList();

	public List<ReCommentVo> getReCommentList() {
		return this.reCommentList;
	}

	public void setReCommentList(List<ReCommentVo> reCommentList) {
		this.reCommentList = reCommentList;
	}

	public void addReComment(ReCommentVo reComment) {
		this.reCommentList.add(reComment);
	}

	public Serializable realId() {
		return null;
	}
}
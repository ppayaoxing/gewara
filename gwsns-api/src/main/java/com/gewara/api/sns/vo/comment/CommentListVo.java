/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.comment;

import com.gewara.api.sns.vo.comment.CommentVo;
import java.util.ArrayList;
import java.util.List;

public class CommentListVo {
	private List<CommentVo> commentList = new ArrayList();

	public List<CommentVo> getCommentList() {
		return this.commentList;
	}

	public void setCommentList(List commentList) {
		this.commentList = commentList;
	}

	public void addComment(CommentVo comment) {
		this.commentList.add(comment);
	}
}
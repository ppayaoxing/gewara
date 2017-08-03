package com.gewara.api.sns.vo.comment;

import java.util.ArrayList;
import java.util.List;

public class CommentListVo {
	private  List<CommentVo> commentList = new ArrayList<CommentVo>();

	public List<CommentVo> getCommentList() {
		return commentList;
	}

	public void setCommentList(List commentList) {
		this.commentList = commentList;
	}
	
	public void addComment(CommentVo comment)
	{
		this.commentList.add(comment);
	}

}

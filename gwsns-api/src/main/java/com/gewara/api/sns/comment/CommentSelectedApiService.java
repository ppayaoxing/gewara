/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.comment;

import com.gewara.api.sns.vo.comment.CommentVo;
import com.gewara.api.vo.ResultCode;
import java.sql.Timestamp;
import java.util.List;

public interface CommentSelectedApiService {
	ResultCode<List<CommentVo>> getCommentListByCommentSelected(String arg0, Long arg1, Timestamp arg2, Timestamp arg3,
			int arg4, int arg5);

	ResultCode<List<CommentVo>> getNextCommentListByCommentSelected(Long arg0, Timestamp arg1, Timestamp arg2,
			int arg3);

	ResultCode<List<CommentVo>> getMovieCommentSelected(String arg0, Long arg1, Long arg2, int arg3, int arg4);

	ResultCode<List<CommentVo>> getNextMovieCommentSelected(Long arg0, String arg1, Long arg2, int arg3, int arg4);

	ResultCode<List<CommentVo>> getAttentionCommentSelected(String arg0, List<Long> arg1, List<Long> arg2, int arg3,
			int arg4);

	ResultCode<Integer> getAttentionCommentSelectedCount(String arg0, List<Long> arg1);
}
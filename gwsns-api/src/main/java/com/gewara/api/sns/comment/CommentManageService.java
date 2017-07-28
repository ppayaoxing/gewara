/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.comment;

import com.gewara.api.sns.vo.comment.CommentVo;
import com.gewara.api.sns.vo.comment.ReCommentVo;
import com.gewara.api.sns.vo.comment.ReCommentVoCommand;
import com.gewara.api.vo.ResultCode;
import com.gewara.command.CommentVoCommand;
import java.sql.Timestamp;
import java.util.List;

public interface CommentManageService {
	ResultCode<Long> updateComment(String arg0);

	ResultCode<Long> saveReComment(ReCommentVoCommand arg0);

	ResultCode<String> saveModeratorTag(Long arg0, List<String> arg1);

	ResultCode<Integer> saveFlowerMember(Long arg0, String arg1, Long arg2, String arg3);

	ResultCode<Integer> saveAnonymFlowerMember(String arg0, Long arg1, String arg2);

	ResultCode<Long> saveComment(CommentVoCommand arg0);

	ResultCode<List<Long>> hasFlowerMemberList(Long arg0, String arg1, List<Long> arg2);

	ResultCode<Integer> hasAnonymFlowerMember(String arg0, Long arg1, String arg2);

	ResultCode<Integer> hasFlowerMember(Long arg0, String arg1, Long arg2);

	ResultCode<Integer> flowerMemberOperate(Long arg0, String arg1, Long arg2, Long arg3, String arg4);

	ResultCode<Integer> cancelFlowerMember(Long arg0, String arg1, Long arg2);

	ResultCode<Integer> cancelAnonymFlowerMember(String arg0, Long arg1, String arg2);

	ResultCode<List<CommentVo>> adminGetCommentList(Long arg0, Timestamp arg1, Timestamp arg2, String arg3, String arg4,
			String arg5, String arg6, int arg7, int arg8);

	ResultCode<Integer> adminGetCommentCount(Long arg0, Timestamp arg1, Timestamp arg2, String arg3, String arg4,
			String arg5, String arg6);

	ResultCode<Integer> deleteComment(Long arg0);

	ResultCode<Integer> deleteMicroReComment(Long arg0);

	ResultCode<Integer> updateReComment(String arg0);

	ResultCode<List<ReCommentVo>> adminGetReCommentList(Long arg0, Long arg1, Timestamp arg2, Timestamp arg3,
			String arg4, String arg5, int arg6, int arg7);

	ResultCode<Integer> adminGetReCommentCount(Long arg0, Long arg1, Timestamp arg2, Timestamp arg3, String arg4,
			String arg5);

	ResultCode saveCommentReport(Long arg0, Long arg1);

	ResultCode<Boolean> checkIsReportForId(Long arg0, Long arg1);
}
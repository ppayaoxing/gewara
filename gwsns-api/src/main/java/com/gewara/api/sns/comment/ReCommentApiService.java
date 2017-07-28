/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.comment;

import com.gewara.api.sns.vo.comment.CommentVo;
import com.gewara.api.sns.vo.comment.ReCommentVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;
import java.util.HashMap;
import java.util.List;

public interface ReCommentApiService {
	ResultCode<List<ReCommentVo>> getRecommentBycommentid(Long arg0, int arg1, int arg2);

	ResultCode<List<ReCommentVo>> getReplyMeReCommentList(Long arg0, int arg1, int arg2);

	ResultCode<Integer> getReCommentCountByMemberid(Long arg0, String arg1);

	ResultCode<List<ReCommentVo>> getReCommentByRelatedidAndTomemberid(Long arg0, Long arg1, Long arg2, int arg3,
			int arg4);

	ResultCode<List<ReCommentVo>> getReCommentByRelatedidAndTomemberid(Long arg0, Long arg1, Long arg2, Long arg3,
			int arg4, int arg5);

	ResultCode<List<ReCommentVo>> getReCommentByRelatedidAndTomemberid(Long arg0, Long arg1, Long arg2, Long arg3,
			boolean arg4, int arg5, int arg6);

	ResultCode<List<ReCommentVo>> getReplyCommentListByAtMe(String arg0, int arg1, int arg2);

	ResultCode<Integer> getReCommentCountByRelatedidAndTomemberid(Long arg0, Long arg1, Long arg2);

	ResultCode<ReCommentVo> getReCommentById(Long arg0);

	ResultCode<Integer> getReplyMeReCommentCount(Long arg0);

	ResultCode<Integer> getReCommentByRelatedidAndTomemberidCount(Long arg0, Long arg1, Long arg2);

	ResultCode<List<CommentVo>> getReCommentListByMemberid(Long arg0, String arg1, int arg2, int arg3);

	ResultCode<VoMap<Long, List<ReCommentVo>>> getReCommentVoMap(List<Long> arg0, int arg1);

	ResultCode<List<ReCommentVo>> getHotReCommentByRelatedidAndTomemberid(Long arg0, Long arg1, Long arg2, Long arg3,
			String arg4, Integer arg5, boolean arg6, boolean arg7, int arg8, int arg9);

	ResultCode<Integer> getHotReCommentByRelatedidAndTomemberidCount(Long arg0, Long arg1, Long arg2, Long arg3,
			String arg4, Integer arg5);

	ResultCode<List<ReCommentVo>> getReCommentWithOutHot(Long arg0, boolean arg1, List<Long> arg2, int arg3, int arg4);

	ResultCode<VoMap<Long, List<ReCommentVo>>> getReCommenReInfoVoMap(List<Long> arg0, List<Long> arg1, Long arg2);

	ResultCode<List<ReCommentVo>> getReCommentWithOutHotByParam(HashMap<String, Object> arg0, int arg1, int arg2);
}
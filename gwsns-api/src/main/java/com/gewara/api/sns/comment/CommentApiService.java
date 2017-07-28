/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.comment;

import com.gewara.api.sns.vo.comment.CommentVo;
import com.gewara.api.sns.vo.comment.RecommendVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;
import com.gewara.command.CommentVoCommand;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CommentApiService {
	ResultCode<CommentVo> getCommentId(Long arg0);

	ResultCode<List<CommentVo>> getCommentList(String arg0, Long arg1, String arg2, Long arg3, Long arg4, String arg5,
			String arg6, String arg7, String arg8, String arg9, String arg10, Long arg11, int arg12, int arg13);

	ResultCode<List<CommentVo>> getHotCommentList(String arg0, Long arg1, String arg2, Long arg3, Long arg4,
			String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, int arg12,
			int arg13);

	ResultCode<List<CommentVo>> getNotHotCommentList(String arg0, Long arg1, String arg2, Long arg3, Long arg4,
			String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, int arg11, int arg12);

	ResultCode<Integer> getCommentCount(String arg0, Long arg1, String arg2, String arg3, Long arg4, Long arg5,
			String arg6, String arg7, String arg8);

	ResultCode<List<CommentVo>> getCommentListByTags(String arg0, Long arg1, boolean arg2, int arg3, int arg4);

	ResultCode<Integer> getCommentCountByTags(String arg0, Long arg1, boolean arg2);

	ResultCode<Integer> getLongCommentCount(String arg0, Long arg1, String arg2);

	ResultCode<Integer> getCommentCount(String arg0, Long arg1, Long arg2, String arg3, String arg4, String arg5,
			String arg6);

	ResultCode<List<CommentVo>> getCommentList(String arg0, Long arg1, Long arg2, String arg3, String arg4, String arg5,
			String arg6, int arg7, int arg8);

	ResultCode<List<CommentVo>> getHotCommentList(int arg0, int arg1);

	ResultCode<Integer> searchCommentCount(String arg0, String arg1, String arg2);

	ResultCode<List<CommentVo>> searchCommentList(String arg0, String arg1, String arg2, int arg3, int arg4);

	ResultCode<List<CommentVo>> getReplyMeCommentList(Long arg0, int arg1, int arg2);

	ResultCode<List<CommentVo>> getLongCommentList(String arg0, Long arg1, String arg2, int arg3, int arg4);

	ResultCode<List<CommentVo>> getCommentLisyByIDs(String arg0);

	ResultCode<Integer> getCommentCountByTopic(String arg0);

	ResultCode<List<CommentVo>> getCommentListByTagMemberids(String arg0, String arg1, String arg2, String arg3,
			int arg4, int arg5);

	ResultCode<CommentVo> getLastComment(Long arg0);

	ResultCode<List<CommentVo>> pointByFreeBackCommentList(String arg0, int arg1, int arg2);

	ResultCode<List<CommentVo>> getRelateItemCommentList(Long arg0, int arg1, int arg2);

	ResultCode<Integer> getReplyMeCommentCount(Long arg0);

	ResultCode<List<Long>> getToFilmfestIntresetMember(String arg0, String arg1, int arg2, int arg3);

	ResultCode<Integer> pointByFreeBackCommentCount(String arg0);

	ResultCode<List<CommentVo>> getCommentListByTransfer(Long arg0, int arg1, int arg2);

	ResultCode<List<CommentVo>> searchCommentListByTopic(String arg0, String arg1, List<Long> arg2, Timestamp arg3,
			Timestamp arg4, String arg5, String arg6, int arg7, int arg8);

	ResultCode<Integer> getCommentCountByTransfer(Long arg0);

	ResultCode<String> getCreatedCommentMaxMemberIds(Integer arg0, String arg1);

	ResultCode<List<CommentVo>> getCommentList(CommentVoCommand arg0);

	ResultCode<Integer> getCommentCount(CommentVoCommand arg0);

	ResultCode<String> getCommentBody(Long arg0);

	ResultCode<List<CommentVo>> getCommentVoListByRecomment(String arg0, Long arg1, String arg2, String arg3,
			boolean arg4, int arg5, int arg6);

	ResultCode<List<CommentVo>> getCommentVoListByRecomment(String arg0, Long arg1, String arg2, String arg3,
			HashMap<String, Object> arg4, boolean arg5, int arg6, int arg7);

	ResultCode<List<CommentVo>> getWeightCommentList(Long arg0, Long arg1, String arg2, Long arg3, boolean arg4,
			Boolean arg5, int arg6, int arg7);

	ResultCode<String> getLottery(Long arg0, Long arg1, String arg2, String arg3, String arg4);

	ResultCode<List<RecommendVo>> getRecommentList(String arg0, Long arg1, String arg2, String arg3, boolean arg4,
			int arg5, int arg6);

	ResultCode bindMemberComment(Long arg0, Long arg1);

	ResultCode<List<CommentVo>> getCommentListByParamet(String[] arg0, Timestamp arg1, Timestamp arg2,
			HashMap<String, Object> arg3, int arg4, int arg5);

	ResultCode<Integer> getCommentListByParametCoun(String[] arg0, Timestamp arg1, Timestamp arg2,
			HashMap<String, Object> arg3);

	ResultCode<RecommendVo> getRecommendVoById(Long arg0);

	ResultCode<String> deleteComment(Long arg0, Long arg1);

	ResultCode<Integer> getCommentListCountByTags(Map<String, List<Long>> arg0, Timestamp arg1, Timestamp arg2,
			List<Long> arg3);

	ResultCode<List<Long>> getCommentListByTags(Map<String, List<Long>> arg0, Timestamp arg1, Timestamp arg2, int arg3,
			int arg4);

	ResultCode<List<CommentVo>> getStarCommentList(String arg0, Timestamp arg1, Timestamp arg2, Long arg3, int arg4,
			int arg5);

	ResultCode saveFriendRecommendComment(Long arg0, List<Long> arg1, List<Long> arg2, List<Long> arg3);

	ResultCode<List<Long>> getRecommendCommentIds(Long arg0, String arg1, int arg2, int arg3);

	ResultCode<List<CommentVo>> queryDebateRecommendComment(Timestamp arg0, Timestamp arg1, Integer arg2, Integer arg3);

	ResultCode saveWalaRedUrl(Long arg0, String arg1);

	ResultCode<VoMap<Long, String>> getWalaRedUrlVoMapByIds(List<Long> arg0);

	ResultCode<String> getWalaRedUrlById(Long arg0);

	ResultCode saveWalaRedUrl(Long arg0, String arg1, String arg2, String arg3);

	ResultCode<CommentVo> updateOtherInfo(Long arg0, Map arg1);

	ResultCode<Boolean> isVideoComment(Long arg0);

	ResultCode<VoMap<String, Object>> getCommenthVideoInfoVoMap(Long arg0);

	ResultCode<List<CommentVo>> getStarCommentByScreenTypeList(String arg0, Timestamp arg1, Timestamp arg2, Long arg3,
			Integer arg4, int arg5, int arg6);

	ResultCode<CommentVo> getCommentAndRedById(Long arg0);

	ResultCode<VoMap<String, Integer>> getStarCommentCountVoMap(String arg0, Timestamp arg1, Timestamp arg2, Long arg3,
			Integer arg4);

	ResultCode<List<VoMap<String, Object>>> getTaskCommentVoMapList();

	ResultCode<List<VoMap<String, Object>>> getCountVoMapByMovieIdAddDate(String arg0, Timestamp arg1, Timestamp arg2);

	ResultCode<List<VoMap<String, String>>> getCountVoMapByMovieIds(String arg0, Timestamp arg1, String arg2);

	ResultCode<VoMap<String, Object>> getCommentBodyVoMap(Long arg0);

	ResultCode<VoMap<Long, Map<String, String>>> getWalaRedlVoMapByIds(List<Long> arg0);

	ResultCode<VoMap<String, String>> getWalaRedVoMapById(Long arg0);

	ResultCode<List<RecommendVo>> getRecommendVoByIds(List<Long> arg0);

	ResultCode<List<CommentVo>> getCommentListForType(String arg0, int arg1, int arg2);
}
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.comment;

import com.gewara.api.sns.vo.comment.CommentVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;
import java.sql.Timestamp;
import java.util.List;

public interface BootRemaitApiService {
	ResultCode saveOrUpdate(Long arg0, Long arg1);

	ResultCode sendMsgToUser(Long arg0, Long arg1, Timestamp arg2, String arg3);

	ResultCode sendMsgToUser(Long arg0, Long arg1, Timestamp arg2, String arg3, String arg4);

	ResultCode<Integer> getMovieScore(Long arg0, Long arg1, boolean arg2, boolean arg3);

	ResultCode<List<Long>> getRereMemberids();

	ResultCode saveUserWalaPresent(Long arg0, Long arg1);

	ResultCode<Boolean> checkMember(Long arg0, Long arg1, boolean arg2, boolean arg3);

	ResultCode saveAppScoreRemain(Long arg0, Integer arg1);

	ResultCode<Boolean> checkIsPresent(Long arg0, Long arg1);

	ResultCode<VoMap<String, Long>> getBootRemaitVoMapById(Long arg0);

	ResultCode<VoMap<String, Integer>> getAppScoreRemainVoMap(Long arg0);

	ResultCode<String> getUserMsgContent(Long arg0, Long arg1);

	ResultCode<List<Long>> getRecommendWalaForSquare(String arg0, String arg1, int arg2, int arg3);

	ResultCode readyMemberSquareData(Long arg0);

	ResultCode<List<CommentVo>> getMemberSquareCommentVoList(Long arg0, Integer arg1, Integer arg2);

	ResultCode<VoMap<String, List<Long>>> getMalaCommentList(String arg0, String arg1);

	ResultCode<String> getMalaCommentFirstTime();
}
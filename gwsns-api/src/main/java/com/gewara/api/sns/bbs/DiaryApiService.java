/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.bbs;

import com.gewara.api.sns.vo.bbs.DiaryCommentVo;
import com.gewara.api.sns.vo.bbs.DiaryVo;
import com.gewara.api.sns.vo.bbs.VoteChooseVo;
import com.gewara.api.sns.vo.bbs.VoteOptionVo;
import com.gewara.api.vo.ResultCode;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DiaryApiService {
	ResultCode<DiaryVo> getDiary(Long arg0);

	ResultCode<List<VoteChooseVo>> getVoteChooseList(Long arg0);

	ResultCode<DiaryCommentVo> getDiaryComment(Long arg0);

	ResultCode<Integer> getDiaryCount(String arg0, String arg1, String arg2, Long arg3);

	ResultCode<Integer> getDiaryCountByKey(String arg0, String arg1, String arg2, Long arg3, String arg4,
			Timestamp arg5, Timestamp arg6);

	ResultCode<List<DiaryVo>> getDiaryList(String arg0, String arg1, String arg2, Long arg3, int arg4, int arg5);

	ResultCode<List<DiaryVo>> getDiaryList(String arg0, String arg1, String arg2, Long arg3, int arg4, int arg5,
			String arg6);

	ResultCode<List<DiaryVo>> getDiaryListByOrder(String arg0, String arg1, String arg2, Long arg3, Timestamp arg4,
			Timestamp arg5, String arg6, boolean arg7, int arg8, int arg9);

	ResultCode<List<DiaryVo>> getDiaryListByKey(String arg0, String arg1, String arg2, Long arg3, int arg4, int arg5,
			String arg6, Timestamp arg7, Timestamp arg8);

	ResultCode<List<DiaryVo>> getDiaryListByFlag(String arg0, String arg1, String arg2, String arg3, int arg4,
			int arg5);

	ResultCode<List<DiaryVo>> getTopDiaryList(String arg0, String arg1, String arg2, boolean arg3);

	ResultCode<List<Map>> getOneDayHotDiaryList(String arg0, String arg1);

	ResultCode<List<DiaryVo>> getDiaryListByMemberid(String arg0, String arg1, Long arg2, int arg3, int arg4);

	ResultCode<Integer> getDiaryCountByMemberid(String arg0, String arg1, Long arg2);

	ResultCode<List<DiaryCommentVo>> getDiaryCommentList(Long arg0, int arg1, int arg2);

	ResultCode<List<DiaryCommentVo>> getDiaryCommentList(Long arg0);

	ResultCode<List<VoteOptionVo>> getVoteOptionByVoteid(Long arg0);

	ResultCode<Integer> getVotecount(Long arg0);

	ResultCode<List<VoteChooseVo>> getVoteChooseByDiaryidAndMemberid(Long arg0, Long arg1);

	ResultCode<Integer> getDiaryCommentCount(String arg0, Long arg1);

	ResultCode<Boolean> isMemberVoted(Long arg0, Long arg1);

	ResultCode<List<DiaryVo>> getHotCommentDiary(String arg0, String arg1, String arg2, Long arg3, int arg4, int arg5);

	ResultCode<List<DiaryVo>> getHotCommuDiary(String arg0, boolean arg1, String arg2, int arg3, int arg4);

	ResultCode<List<DiaryVo>> getDiaryListByStatus(String arg0, String arg1, Date arg2, Date arg3, int arg4, int arg5);

	ResultCode<Integer> getDiaryCountByStatus(String arg0, String arg1, Date arg2, Date arg3);

	ResultCode<List<DiaryCommentVo>> getDiaryCommentListByStatus(String arg0, String arg1, Date arg2, Date arg3,
			int arg4, int arg5);

	ResultCode<Integer> getDiaryCommentCountByStatus(String arg0, String arg1, Date arg2, Date arg3);

	ResultCode<List<DiaryVo>> getRepliedDiaryList(Long arg0, int arg1, int arg2);

	ResultCode<Integer> getRepliedDiaryCount(Long arg0);

	ResultCode<List<Map>> getMDSDiaryListByKeyname(String arg0, String arg1, String arg2, String arg3, int arg4,
			int arg5);

	ResultCode<Integer> getMDSDiaryCountByKeyname(String arg0, String arg1, String arg2, String arg3);

	ResultCode<List<DiaryVo>> getDiaryBySearchkeyAndOrder(String arg0, String arg1, Timestamp arg2, Timestamp arg3,
			String arg4, int arg5, int arg6);

	ResultCode<List<DiaryVo>> getCommuDiaryListById(Long arg0, String[] arg1, Long arg2, int arg3, int arg4);

	ResultCode<List<DiaryVo>> getCommuDiaryListBySearch(Long arg0, String arg1, Long arg2, Date arg3, Integer arg4,
			String arg5, int arg6, int arg7);

	ResultCode<Integer> getCommuDiaryCountBySearch(Long arg0, String arg1, Long arg2, Date arg3, Integer arg4,
			String arg5);

	ResultCode<Integer> getCommuDiaryCount(Long arg0, String[] arg1, Long arg2);

	ResultCode<List<DiaryVo>> getAllCommuDiaryByCommuIds(List<Long> arg0, int arg1, int arg2);

	ResultCode<Integer> getAllCommuDiaryCountByCommuIds(List<Long> arg0);

	ResultCode<Map<String, Integer>> getDiaryReportList(Date arg0, Date arg1);

	ResultCode<List<DiaryVo>> queryDiary(Long arg0, Timestamp arg1, Timestamp arg2, String arg3, String arg4,
			String arg5, int arg6, int arg7);

	ResultCode<Integer> queryDiaryCount(Long arg0, Timestamp arg1, Timestamp arg2, String arg3, String arg4,
			String arg5);

	ResultCode<List<DiaryCommentVo>> queryDiaryComment(Long arg0, Long arg1, Timestamp arg2, Timestamp arg3,
			String arg4, String arg5, int arg6, int arg7);

	ResultCode<Integer> queryDiaryCommentCount(Long arg0, Long arg1, Timestamp arg2, Timestamp arg3, String arg4,
			String arg5);

	ResultCode<List<Map<String, Object>>> getDiary(Set<Long> arg0, String arg1, Date arg2);

	ResultCode<List<DiaryVo>> queryDiary(Timestamp arg0, String arg1);

	ResultCode<List<DiaryVo>> getDeletedDiaryList(boolean arg0);

	ResultCode<Integer> getDiaryCountByMovieid(Long arg0);

	ResultCode<List<Long>> getDiaryIdList(Date arg0, Date arg1);

	ResultCode<List<Long>> getDiaryIdList(Date arg0);

	ResultCode<List<Map>> getDiaryCountMapList();

	ResultCode<Integer> getDiaryCount(Date arg0);

	ResultCode<Integer> getComentDiaryCount(Date arg0);

	ResultCode<DiaryVo> saveDiary(DiaryVo arg0);

	ResultCode<DiaryCommentVo> saveDiaryComment(DiaryCommentVo arg0);

	ResultCode<List<DiaryVo>> getDiaryList(List<Long> arg0);

	ResultCode<DiaryVo> updateDiary(DiaryVo arg0);

	ResultCode<VoteOptionVo> getVoteOption(Long arg0);

	ResultCode saveVoteChooseList(List<VoteChooseVo> arg0);

	ResultCode saveVoteOptionList(List<VoteOptionVo> arg0);

	ResultCode<VoteChooseVo> saveVoteChoose(VoteChooseVo arg0);

	ResultCode<String> getDiaryBody(long arg0);

	ResultCode saveDiaryBody(long arg0, Timestamp arg2, String arg3);

	ResultCode<List<Map>> getDiaryMapList(Timestamp arg0, Timestamp arg1);

	ResultCode<List<DiaryVo>> getDiaryListByFlag(String arg0, String arg1, String arg2, String arg3, boolean arg4,
			String arg5, int arg6, int arg7);
}
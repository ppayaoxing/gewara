/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.qa;

import com.gewara.api.sns.vo.qa.GewaAnswerVo;
import com.gewara.api.sns.vo.qa.GewaQaExpertVo;
import com.gewara.api.sns.vo.qa.GewaQaPointVo;
import com.gewara.api.sns.vo.qa.GewaQuestionVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;
import com.gewara.command.QuestionCommand;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface QaApiService {
	ResultCode<List<GewaQuestionVo>> getQuestionListByQuestionstatus(String arg0, String arg1, String arg2, int arg3,
			int arg4);

	ResultCode<Integer> getQuestionCountByQuestionstatus(String arg0, String arg1);

	ResultCode<List<GewaQuestionVo>> getQuestionListByStatus(String arg0, Date arg1, Date arg2, int arg3, int arg4);

	ResultCode<Integer> getQuestionCountByStatus(String arg0, Date arg1, Date arg2);

	ResultCode<List<GewaQuestionVo>> getQuestionListByHotvalue(String arg0, int arg1, int arg2, int arg3);

	ResultCode<List<GewaAnswerVo>> getAnswerListByQuestionid(Long arg0);

	ResultCode<Integer> getAnswerCount(Long arg0);

	ResultCode<List<GewaAnswerVo>> getAnswerListByQuestionId(int arg0, int arg1, Long arg2);

	ResultCode<List<GewaAnswerVo>> getAnswerListByQuestionAndMemId(int arg0, int arg1, Long arg2, Long arg3);

	ResultCode<Integer> getAnswerCountByQuestionId(Long arg0);

	ResultCode<Integer> getAnswerCountByMemberidAndNStatus(Long arg0);

	ResultCode<Integer> getBestAnswerCountByMemberid(Long arg0);

	ResultCode<Boolean> isQuestion(Long arg0, Integer arg1);

	ResultCode<Boolean> isAnswerQuestion(Long arg0, Long arg1);

	ResultCode<GewaAnswerVo> getBestAnswerByQuestionid(Long arg0);

	ResultCode<GewaQaExpertVo> getQaExpertByMemberid(Long arg0);

	ResultCode<Boolean> updateQAHotValue(Long arg0, Integer arg1);

	ResultCode<Boolean> updateQAExpertHotValue(Long arg0, Integer arg1);

	ResultCode<Integer> getQAExpertCount();

	ResultCode<List<GewaQaExpertVo>> getQaExpertList();

	ResultCode<List<GewaQuestionVo>> getQuestionByTagAndRelatedid(String arg0, String arg1, Long arg2, int arg3,
			int arg4);

	ResultCode<List<GewaQuestionVo>> getQuestionByCategoryAndCategoryid(String arg0, String arg1, Long arg2, int arg3,
			int arg4);

	ResultCode<List<GewaQuestionVo>> getQuestionByCategoryAndCategoryid(String arg0, String arg1, Long arg2,
			boolean arg3, String arg4, int arg5, int arg6);

	ResultCode<Integer> getQuestionCountByCategoryAndCid(String arg0, String arg1, Long arg2);

	ResultCode<List<VoMap<String, Object>>> getTopMemberVoMapListByBestAnswer(int arg0, int arg1);

	ResultCode<Integer> getTopMemberCountByBestAnswer();

	ResultCode<GewaQaExpertVo> getQaExpertStatusById(Long arg0);

	ResultCode<List<GewaAnswerVo>> getAnswerByMemberId(Long arg0);

	ResultCode<List<VoMap<String, Object>>> getTopMemberVoMapListByAnswer(int arg0, int arg1);

	ResultCode<Integer> getTopMemberCountByAnswer();

	ResultCode<List<VoMap<String, Object>>> getTopMemberVoMapListByPoint(int arg0, int arg1);

	ResultCode<Integer> getTopMemberCountByPoint();

	ResultCode<List<GewaQuestionVo>> getQuestionListByMemberid(Long arg0, int arg1, int arg2);

	ResultCode<List<VoMap<String, Object>>> getQuestionVoMapListByTagGroup(String arg0, int arg1, int arg2);

	ResultCode<List<VoMap<String, Object>>> getQuestionVoMapListByCategoryGroup(String arg0, int arg1, int arg2);

	ResultCode<List<GewaQaExpertVo>> getExpertList(Integer arg0, int arg1, int arg2);

	ResultCode<GewaQaPointVo> getGewaQaPointByQuestionidAndTag(Long arg0, String arg1);

	ResultCode<Integer> getPointByMemberid(Long arg0);

	ResultCode<List<GewaQuestionVo>> getQuestionByQsAndTagList(String arg0, String arg1, String arg2, String arg3,
			int arg4);

	ResultCode<List<GewaQuestionVo>> getQuestionListByQsAndTagAndRelatedid(String arg0, Long arg1, String arg2,
			String arg3, int arg4);

	ResultCode<Integer> getQuestionCount(String arg0, String arg1, Long arg2, String arg3);

	ResultCode<List<GewaQuestionVo>> getQuestionList(String arg0, String arg1, Long arg2, String arg3, String arg4,
			int arg5, int arg6);

	ResultCode<Integer> getQuestionCountByHotvalue(String arg0, Integer arg1);

	ResultCode<Long> getGewaraAnswerByMemberid();

	ResultCode<List<GewaAnswerVo>> queryAnswersByMemberIdAndAnswerstatus(Long arg0, String arg1);

	ResultCode<VoMap<String, Integer>> getQaReportLstVoMap(Date arg0, Date arg1);

	ResultCode<List<GewaQuestionVo>> getQuestionByTitleAndStatus(String arg0, String arg1, int arg2, Integer arg3);

	ResultCode<Integer> getQuestionCountByTitleAndStatus(String arg0, String arg1);

	ResultCode<Integer> getAnswerCount(Long arg0, Long arg1, Timestamp arg2, Timestamp arg3, String arg4, String arg5);

	ResultCode<List<GewaAnswerVo>> getAnswer(Long arg0, Long arg1, Timestamp arg2, Timestamp arg3, String arg4,
			String arg5, int arg6, int arg7);

	ResultCode<Integer> getQuestionCount(Long arg0, Timestamp arg1, Timestamp arg2, String arg3, String arg4);

	ResultCode<List<GewaQuestionVo>> getQuestion(Long arg0, Timestamp arg1, Timestamp arg2, String arg3, String arg4,
			int arg5, Integer arg6);

	ResultCode<Integer> getQuestionCount(QuestionCommand arg0, String arg1);

	ResultCode<List<GewaQuestionVo>> getQuestion(QuestionCommand arg0, String arg1);

	ResultCode<List<GewaQuestionVo>> getDeletedQuestionList(boolean arg0);

	ResultCode<List<Long>> getQuestionIds();

	ResultCode<List<GewaQuestionVo>> getQuestionByMemberid(Long arg0, int arg1, int arg2);

	ResultCode<Integer> getQuestionCountByMemberid(Long arg0);

	ResultCode<List<GewaQuestionVo>> getAnswerByMemberid(Long arg0, int arg1, int arg2);

	ResultCode<Integer> getAnswerCountByMemberid(Long arg0);

	ResultCode<GewaAnswerVo> getGewaAnswerByAnswerid(Long arg0, Long arg1);

	ResultCode<GewaQuestionVo> getQuestion(Long arg0);

	ResultCode<GewaAnswerVo> getAnswer(Long arg0);

	ResultCode<GewaQuestionVo> saveQuestion(GewaQuestionVo arg0);

	ResultCode<GewaAnswerVo> saveAnswer(GewaAnswerVo arg0);

	ResultCode<GewaQaExpertVo> getQaExpert(Long arg0);

	ResultCode<GewaQaPointVo> saveQaPoint(GewaQaPointVo arg0);

	ResultCode<GewaQaPointVo> getQaPoint(Long arg0);

	ResultCode<GewaQaExpertVo> saveQaExpert(GewaQaExpertVo arg0);

	ResultCode removeQAPoint(Long arg0);

	ResultCode<GewaQaPointVo> removeQaPoint(GewaQaPointVo arg0);

	ResultCode saveAnswerList(List<GewaAnswerVo> arg0);

	ResultCode<GewaQuestionVo> getQuestionAndAddClickedtimes(Long arg0);
}
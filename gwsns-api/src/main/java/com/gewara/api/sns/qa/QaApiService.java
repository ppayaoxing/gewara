package com.gewara.api.sns.qa;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.gewara.api.sns.vo.qa.GewaAnswerVo;
import com.gewara.api.sns.vo.qa.GewaQaExpertVo;
import com.gewara.api.sns.vo.qa.GewaQaPointVo;
import com.gewara.api.sns.vo.qa.GewaQuestionVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;
import com.gewara.command.QuestionCommand;

public interface QaApiService {


	ResultCode<List<GewaQuestionVo>> getQuestionListByQuestionstatus(String citycode, String questionstatus, String order, int from,
			int maxnum);

	ResultCode<Integer> getQuestionCountByQuestionstatus(String citycode, String questionstatus);

	ResultCode<List<GewaQuestionVo>> getQuestionListByStatus(String status, Date fromDate, Date endDate, int from, int maxnum);

	ResultCode<Integer> getQuestionCountByStatus(String status, Date fromDate, Date endDate);

	ResultCode<List<GewaQuestionVo>> getQuestionListByHotvalue(String citycode, int hotvalue, int from, int maxnum);

	ResultCode<List<GewaAnswerVo>> getAnswerListByQuestionid(Long questionid);

	ResultCode<Integer> getAnswerCount(Long questionid);

	ResultCode<List<GewaAnswerVo>> getAnswerListByQuestionId(int start, int maxnum, Long questionid);

	ResultCode<List<GewaAnswerVo>> getAnswerListByQuestionAndMemId(int start, int maxnum, Long questionid, Long memberId);

	/**
	 * 根据问题查询回复 status=Y_NEW
	 */
	ResultCode<Integer> getAnswerCountByQuestionId(Long questionid);

	/**
	 * Ta回答的问题的数量
	 * 
	 * @param mid
	 * @return
	 */
	ResultCode<Integer> getAnswerCountByMemberidAndNStatus(Long mid);

	/**
	 * Ta回答的问题被采纳的数量
	 * 
	 * @param mid
	 * @return
	 */
	ResultCode<Integer> getBestAnswerCountByMemberid(Long mid);

	/**
	 * 用户是否可以提出问题
	 * 
	 * @param memberid
	 * @param maxdays
	 * @return
	 */
	ResultCode<Boolean> isQuestion(Long memberid, Integer maxdays);

	/**
	 * 用户是否已经回答了这个问题
	 * 
	 * @param qid
	 * @param mid
	 * @return
	 */
	ResultCode<Boolean> isAnswerQuestion(Long qid, Long mid);

	/**
	 * 问题的最佳答案
	 * 
	 * @param qid
	 * @return
	 */
	ResultCode<GewaAnswerVo> getBestAnswerByQuestionid(Long qid);

	/**
	 * 用户是否是专家
	 * 
	 * @param mid
	 * @return
	 */
	ResultCode<GewaQaExpertVo> getQaExpertByMemberid(Long mid);

	/**
	 * 更改问题的热度
	 * 
	 * @param id
	 * @param hotvalue
	 * @return 2009-10-29
	 */
	ResultCode<Boolean> updateQAHotValue(Long id, Integer hotvalue);

	/**
	 * 修改专家信息热度
	 * 
	 * @param id
	 * @param hotvalue
	 * @return 2009-10-30
	 */
	ResultCode<Boolean> updateQAExpertHotValue(Long id, Integer hotvalue);

	/**
	 * 查询专家信息数量
	 * 
	 * @return 2009-10-29
	 */

	ResultCode<Integer> getQAExpertCount();

	/**
	 * 查询专家信息
	 * 
	 * @return 2009-10-29
	 */
	ResultCode<List<GewaQaExpertVo>> getQaExpertList();

	/**
	 * 查找问题
	 * 
	 * @param tag
	 * @param relatedid
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<GewaQuestionVo>> getQuestionByTagAndRelatedid(String citycode, String tag, Long relatedid, int from, int maxnum);

	/**
	 * 查找问题
	 * 
	 * @param category
	 * @param categoryid
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<GewaQuestionVo>> getQuestionByCategoryAndCategoryid(String citycode, String category, Long categoryid, int from,
			int maxnum);

	ResultCode<List<GewaQuestionVo>> getQuestionByCategoryAndCategoryid(String citycode, String category, Long categoryid,
			boolean status, String questionstatus, int from, int maxnum);

	ResultCode<Integer> getQuestionCountByCategoryAndCid(String citycode, String category, Long categoryid);

	/**
	 * 用户最佳答案多少排行
	 * 
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<VoMap<String,Object>>> getTopMemberVoMapListByBestAnswer(int from, int maxnum);

	ResultCode<Integer> getTopMemberCountByBestAnswer();

	/**
	 * 查询专家信息表的状态
	 * 
	 * @return 2009-10-30
	 */
	ResultCode<GewaQaExpertVo> getQaExpertStatusById(Long id);

	ResultCode<List<GewaAnswerVo>> getAnswerByMemberId(Long id);

	/**
	 * 用户回答问题多少排行
	 * 
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<VoMap<String,Object>>> getTopMemberVoMapListByAnswer(int from, int maxnum);

	ResultCode<Integer> getTopMemberCountByAnswer();

	/**
	 * 用户经验值多少排行
	 */
	ResultCode<List<VoMap<String,Object>>> getTopMemberVoMapListByPoint(int from, int maxnum);

	ResultCode<Integer> getTopMemberCountByPoint();


	ResultCode<List<GewaQuestionVo>> getQuestionListByMemberid(Long memberid, int from, int maxnum);

	/**
	 * @param tag
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<VoMap<String,Object>>> getQuestionVoMapListByTagGroup(String tag, int from, int maxnum);

	/**
	 * @param category
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<VoMap<String,Object>>> getQuestionVoMapListByCategoryGroup(String category, int from, int maxnum); 

	ResultCode<List<GewaQaExpertVo>> getExpertList(Integer hotvalue, int from, int maxnum);

	ResultCode<GewaQaPointVo> getGewaQaPointByQuestionidAndTag(Long qid, String tag);

	/**
	 * 用户累计的问答经验值
	 * 
	 * @param mid
	 * @return
	 */
	ResultCode<Integer> getPointByMemberid(Long mid);

	ResultCode<List<GewaQuestionVo>> getQuestionByQsAndTagList(String citycode, String qs, String tag, String order, int maxnum);

	ResultCode<List<GewaQuestionVo>> getQuestionListByQsAndTagAndRelatedid(String tag, Long relatedid, String qs, String order,
			int maxnum);

	/**
	 * 查询问题总数量
	 * 
	 * @param citycode
	 *            城市代码
	 * @param tag
	 *            关联类型
	 * @param relatedid
	 *            关联对象id
	 * @param status
	 *            问题状态,可选值:N(待解决),Y(已解决),Z(零解决),noproper(无满意答案)
	 * @return
	 */
	ResultCode<Integer> getQuestionCount(String citycode, String tag, Long relatedid, String status);

	/**
	 * 分页查询问题
	 * 
	 * @param citycode
	 *            城市代码
	 * @param tag
	 *            关联类型
	 * @param relatedid
	 *            关联对象id
	 * @param status
	 *            问题状态,可选值:N(待解决),Y(已解决),Z(零解决),noproper(无满意答案)
	 * @param order
	 *            排序
	 * @param from
	 *            页码
	 * @param maxnum
	 *            结果条数
	 * @return
	 */
	ResultCode<List<GewaQuestionVo>> getQuestionList(String citycode, String tag, Long relatedid, String status, String order,
			int from, int maxnum);

	/**
	 * 根据hotvalue查询知道数量
	 */
	ResultCode<Integer> getQuestionCountByHotvalue(String citycode, Integer hotvalue);

	/**
	 * 获取演出管理人员回复的memberid;
	 * 
	 * @return
	 */
	ResultCode<Long> getGewaraAnswerByMemberid();

	/**
	 * 查询数据
	 * @param memberId
	 * @param answerstatus
	 * 
	 * @return
	 */
	ResultCode<List<GewaAnswerVo>> queryAnswersByMemberIdAndAnswerstatus(Long memberId, String answerstatus);

	

	/**
	 * 查询报表信息
	 * @param datefrom
	 *            开发日期
	 * @param dateto
	 *            结束日期
	 * @return
	 */
	ResultCode<VoMap<String, Integer>> getQaReportLstVoMap(Date datefrom, Date dateto);

	/**
	 * 根据tilte 和  状态 查询GewaQuestion
	 * @param keyname
	 * @param status
	 * @param i
	 * @param rowsPerPage
	 * @return
	 */
	ResultCode<List<GewaQuestionVo>> getQuestionByTitleAndStatus(String keyname, String status, int i, Integer rowsPerPage);
	
	/**
	 * 根据tilte 和  状态 查询 GewaQuestion页数
	 * @param keyname
	 * @param status
	 * @return
	 */
	ResultCode<Integer> getQuestionCountByTitleAndStatus(String keyname, String status);

	/**
	 * 查询 Answer页数
	 * @param qid
	 * @param memberid
	 * @param starttime
	 * @param endtime
	 * @param status
	 * @param keyname
	 * @return
	 */
	ResultCode<Integer> getAnswerCount(Long qid, Long memberid, Timestamp starttime, Timestamp endtime, String status,
			String keyname);

	/**
	 * 查询 Answer
	 * @param qid
	 * @param memberid
	 * @param starttime
	 * @param endtime
	 * @param status
	 * @param keyname
	 * @param rowsPerPage 
	 * @param firstRow 
	 * @return
	 */
	ResultCode<List<GewaAnswerVo>> getAnswer(Long qid, Long memberid, Timestamp starttime, Timestamp endtime, String status,
			String keyname, int firstRow, int rowsPerPage);
	
	/**
	 * 查询 Question页数
	 * @param memberid
	 * @param starttime
	 * @param endtime
	 * @param status
	 * @param keyname
	 * @return
	 */
	ResultCode<Integer> getQuestionCount(Long memberid, Timestamp starttime, Timestamp endtime, String status, String keyname);

	/**
	 * 查询 Question
	 * @param memberid
	 * @param starttime
	 * @param endtime
	 * @param status
	 * @param keyname
	 * @param i
	 * @param rowsPerPage
	 * @return
	 */
	ResultCode<List<GewaQuestionVo>> getQuestion(Long memberid, Timestamp starttime, Timestamp endtime, String status,
			String keyname, int firstRow, Integer rowsPerPage);

	/**
	 * 查询 Question数量
	 * @param command 查询参数
	 * @param order
	 * @return
	 */
	ResultCode<Integer> getQuestionCount(QuestionCommand command, String order);

	/**
	 * 查询Question
	 * @param qc 查询参数
	 * @param citycode
	 * @return
	 */
	ResultCode<List<GewaQuestionVo>> getQuestion(QuestionCommand command, String citycode);

	
	/**
	 * 查询已经删除索引的GewaQuestion
	 * @param isDeleteDbRecord TODO
	 * @return
	 */
	ResultCode<List<GewaQuestionVo>> getDeletedQuestionList(boolean isDeleteDbRecord);
    
    /**
     * 查询Question id列表
     * @return
     */
	ResultCode<List<Long>> getQuestionIds();
    
    
    /**
	 * 查询当前用户发表的知道
	 */
	ResultCode<List<GewaQuestionVo>> getQuestionByMemberid(Long memberid, int from, int maxnum);
	
	/**
	 * 查询当前用户发表的知道信息数量
	 */
	ResultCode<Integer> getQuestionCountByMemberid(Long memberid);
	
	/**
	 * 查询当前用户回复的知道
	 * page 当前页码
	 */
	ResultCode<List<GewaQuestionVo>> getAnswerByMemberid(Long memberid, int from, int maxnum);
	
	/**
	 * 查询当前用户回复的知道信息数量
	 */
	ResultCode<Integer> getAnswerCountByMemberid(Long memberid);
	
	/**
	 * 根据questionid查询gewaAnswer
	 * @return
	 */
	ResultCode<GewaAnswerVo> getGewaAnswerByAnswerid(Long questionid, Long memberid);

	/**
	 * 通过Id查询GewaQuestion
	 * @param id
	 * @return
	 */
	ResultCode<GewaQuestionVo> getQuestion(Long id);

	/**
	 * 通过Id查询GewaAnswer
	 * @param id
	 * @return
	 */
	ResultCode<GewaAnswerVo> getAnswer(Long id);

	/**
	 * 保存GewaQuestion
	 * @param question
	 * @return
	 */
	ResultCode<GewaQuestionVo> saveQuestion(GewaQuestionVo question);

	/**
	 * 保存GewaAnswer
	 * @param question
	 * @return
	 */
	ResultCode<GewaAnswerVo> saveAnswer(GewaAnswerVo answer);

	/**
	 * 通过Id查询GewaQaExpert
	 * @param id
	 * @return
	 */
	ResultCode<GewaQaExpertVo> getQaExpert(Long id);
	

	/**
	 * 保存GewaQaPoint
	 * @param qaPoint
	 * @return
	 */
	ResultCode<GewaQaPointVo> saveQaPoint(GewaQaPointVo qaPoint);

	/**
	 * 通过Id查询GewaQaPoint
	 * @param id
	 * @return
	 */
	ResultCode<GewaQaPointVo> getQaPoint(Long id);

	/**
	 * 保存GewaQaExpert
	 * @param expert
	 * @return
	 */
	ResultCode<GewaQaExpertVo> saveQaExpert(GewaQaExpertVo expert);

	/**
	 * 删除GewaQaPoint
	 * @param qaPoint
	 */
	ResultCode removeQAPoint(Long id);

	/**
	 * 删除GewaQaPoint
	 * @param qaPoint
	 * @return
	 */
	ResultCode<GewaQaPointVo> removeQaPoint(GewaQaPointVo qaPoint);

	/**
	 * 保存GewaAnswer List
	 * @param answerlist
	 */
	ResultCode saveAnswerList(List<GewaAnswerVo> answerlist);

	ResultCode<GewaQuestionVo> getQuestionAndAddClickedtimes(Long qid);
	
	  
	  
	  
	
	 
	
}

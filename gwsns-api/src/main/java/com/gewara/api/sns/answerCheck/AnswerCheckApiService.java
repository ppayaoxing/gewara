package com.gewara.api.sns.answerCheck;

import com.gewara.api.sns.vo.AnswerCheckVo;
import com.gewara.api.sns.vo.AnswerQuestionVo;
import com.gewara.api.sns.vo.UserAnswerVo;
import com.gewara.api.vo.ResultCode;

public interface AnswerCheckApiService {
	/**
	 * 获取主题信息
	 * @param id
	 * @return
	 */
	ResultCode<AnswerCheckVo> getAnswerCheckList(Long id);
	/**
	 * 获取主题题库数
	 * @param id
	 * @return
	 */
	ResultCode<Integer> getAnswerQuestionNum(Long id);
	/**
	 * 获取题库
	 * @param relatedid
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<AnswerQuestionVo> getAnswerQuestionList(Long relatedid,Integer from, Integer maxnum);
	/**
	 * 获取用户答题数据
	 * @param memberid
	 * @param id
	 * @return
	 */
	ResultCode<UserAnswerVo> getUserAnswer(Long memberid,Long id);
	/**
	 * 保存用户答题信息
	 * @param memberid
	 * @param id
	 * @param Index
	 * @param num
	 * @param content
	 * @param total
	 */
	ResultCode saveUserAnswer(Long memberid,Long relatedid,Integer index,Integer num,String content,Integer total, boolean flag, Long id,Integer answer);
	/**
	 * 根据id获取题库信息
	 * @param id
	 * @return
	 */
	ResultCode<AnswerQuestionVo> getAnswerQuestionById(Long id);
}

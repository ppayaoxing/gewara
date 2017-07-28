/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.answerCheck;

import com.gewara.api.sns.vo.AnswerCheckVo;
import com.gewara.api.sns.vo.AnswerQuestionVo;
import com.gewara.api.sns.vo.UserAnswerVo;
import com.gewara.api.vo.ResultCode;

public interface AnswerCheckApiService {
	ResultCode<AnswerCheckVo> getAnswerCheckList(Long arg0);

	ResultCode<Integer> getAnswerQuestionNum(Long arg0);

	ResultCode<AnswerQuestionVo> getAnswerQuestionList(Long arg0, Integer arg1, Integer arg2);

	ResultCode<UserAnswerVo> getUserAnswer(Long arg0, Long arg1);

	ResultCode saveUserAnswer(Long arg0, Long arg1, Integer arg2, Integer arg3, String arg4, Integer arg5, boolean arg6,
			Long arg7, Integer arg8);

	ResultCode<AnswerQuestionVo> getAnswerQuestionById(Long arg0);
}
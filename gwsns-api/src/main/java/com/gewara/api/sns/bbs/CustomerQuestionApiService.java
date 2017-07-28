/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.bbs;

import com.gewara.api.sns.vo.bbs.CustomerAnswerVo;
import com.gewara.api.sns.vo.bbs.CustomerQuestionVo;
import com.gewara.api.vo.ResultCode;
import java.util.List;

public interface CustomerQuestionApiService {
	ResultCode<List<CustomerQuestionVo>> getQuestionsBykey(String arg0, String arg1, String arg2, String arg3, int arg4,
			int arg5);

	ResultCode<Integer> getQuestionCountBykey(String arg0, String arg1, String arg2, String arg3);

	ResultCode<List<CustomerAnswerVo>> getAnswersByQid(Long arg0, int arg1, int arg2);

	ResultCode<Integer> getAnswerCountByQid(Long arg0);

	ResultCode<List<CustomerQuestionVo>> getCustomerQList(Long arg0, String arg1, String arg2, int arg3, int arg4);

	ResultCode<Integer> getCustometQCount(Long arg0, String arg1, String arg2);

	ResultCode<CustomerQuestionVo> addCustomerQuestion(String arg0, Long arg1, String arg2, String arg3, String arg4,
			String arg5);

	ResultCode updateQuestionStatus(Long arg0, String arg1);

	ResultCode<CustomerQuestionVo> getCustomerQuestion(Long arg0);

	ResultCode<CustomerAnswerVo> getCustomerAnswer(Long arg0);

	ResultCode<CustomerAnswerVo> saveCustomerAnswer(CustomerAnswerVo arg0);

	ResultCode<CustomerQuestionVo> updateCustomerQuestion(CustomerQuestionVo arg0);
}
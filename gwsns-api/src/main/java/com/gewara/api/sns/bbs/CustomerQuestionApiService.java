package com.gewara.api.sns.bbs;

import java.util.List;

import com.gewara.api.sns.vo.bbs.CustomerAnswerVo;
import com.gewara.api.sns.vo.bbs.CustomerQuestionVo;
import com.gewara.api.vo.ResultCode;

/**
 *    @function 用户建议收集Service
 * 	@author bob.hu
 *		@date	2011-03-11 14:32:11
 */
public interface CustomerQuestionApiService {
	
	ResultCode<List<CustomerQuestionVo>> getQuestionsBykey(String citycode, String tag, String searchkey, String status, int from, int maxnum);
	ResultCode<Integer> getQuestionCountBykey(String citycode, String tag, String searchkey, String status);
	
	/**
	 *  根据 qid, 查询某用户建议对应的回复
	 * */
	ResultCode<List<CustomerAnswerVo>> getAnswersByQid(Long qid, int from, int maxnum);
	ResultCode<Integer> getAnswerCountByQid(Long qid);
	ResultCode<List<CustomerQuestionVo>> getCustomerQList(Long memberid, String citycode, String tag, int from, int maxnum);
	ResultCode<Integer> getCustometQCount(Long memberid, String citycode, String tag);
	
	ResultCode<CustomerQuestionVo> addCustomerQuestion(String citycode, Long memberid, String email, String tag, String body, String type);
	
	/**
	 * 修改customerQuestion status
	 * @param qid 
	 * @param status
	 */
	ResultCode updateQuestionStatus(Long qid, String status);
	
	/**
	 * 获取CustomerQuestion
	 * @param qid
	 * @return
	 */
	ResultCode<CustomerQuestionVo> getCustomerQuestion(Long qid);
	
	/**
	 * 获取CustomerAnswer
	 * @param aid
	 * @return
	 */
	ResultCode<CustomerAnswerVo> getCustomerAnswer(Long aid);
	/**
	 * 保存CustomerAnswer
	 * @param answer
	 * @return
	 */
	ResultCode<CustomerAnswerVo> saveCustomerAnswer(CustomerAnswerVo answer);
	/**
	 * 修改CustomerQuestion
	 * @param customerQuestion
	 * @return
	 */
	ResultCode<CustomerQuestionVo> updateCustomerQuestion(CustomerQuestionVo customerQuestion);

}

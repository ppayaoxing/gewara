package com.gewara.api.sns.recommend;

import java.util.List;

import com.gewara.api.sns.vo.recommend.RecommendBatchDetailVo;
import com.gewara.api.sns.vo.recommend.RecommendBatchVo;
import com.gewara.api.vo.ResultCode;

/**
 * 推荐api
 * 
 * @author zxl
 * 
 */
public interface RecommendApiService {

	/**
	 * 获取最新的推荐
	 * @param type
	 * @return
	 */
	ResultCode<RecommendBatchVo> getLatestRecommendBatch(String type);

	/**
	 * 判断是否推荐
	 * @param condition
	 * @param memberid
	 * @return
	 */
	ResultCode<Boolean> checkRecommendCondition(String condition, Long memberid);

	/**
	 * 获取推荐的详细内容
	 * @param batchId
	 * @param tag
	 * @return
	 */
	ResultCode<List<RecommendBatchDetailVo>> getRecommendBatchDetails(Long batchId,String[] tag);

	/**
	 * 分页获取
	 * @param batchId
	 * @param tag
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<RecommendBatchDetailVo>> getRecommendBatchDetailsWithPage(Long batchId, String[] tag, Integer from, Integer maxnum);

}

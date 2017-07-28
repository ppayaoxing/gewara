/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.recommend;

import com.gewara.api.sns.vo.recommend.RecommendBatchDetailVo;
import com.gewara.api.sns.vo.recommend.RecommendBatchVo;
import com.gewara.api.vo.ResultCode;
import java.util.List;

public interface RecommendApiService {
	ResultCode<RecommendBatchVo> getLatestRecommendBatch(String arg0);

	ResultCode<Boolean> checkRecommendCondition(String arg0, Long arg1);

	ResultCode<List<RecommendBatchDetailVo>> getRecommendBatchDetails(Long arg0, String[] arg1);

	ResultCode<List<RecommendBatchDetailVo>> getRecommendBatchDetailsWithPage(Long arg0, String[] arg1, Integer arg2,
			Integer arg3);
}
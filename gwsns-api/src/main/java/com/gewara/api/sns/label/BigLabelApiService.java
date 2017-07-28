/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.label;

import com.gewara.api.activity.domain.TreasureVo;
import com.gewara.api.sns.vo.comment.CommentVo;
import com.gewara.api.sns.vo.label.BigLabelVo;
import com.gewara.api.sns.vo.label.LabelRelatedVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;
import java.sql.Timestamp;
import java.util.List;

public interface BigLabelApiService {
	ResultCode<List<BigLabelVo>> getBigLabelListByIds(List<Long> arg0);

	ResultCode<BigLabelVo> getBigLabelByName(String arg0);

	ResultCode<List<BigLabelVo>> getBigLabelListByMatchName(String arg0);

	ResultCode<List<BigLabelVo>> getBigLabelList(Long arg0, String arg1, Timestamp arg2, Timestamp arg3, String[] arg4,
			boolean arg5, int arg6, int arg7);

	ResultCode<BigLabelVo> addBigLabel(Long arg0, String arg1);

	ResultCode addRelatedBigLabel(Long arg0, String arg1, Long arg2);

	ResultCode cancelRelatedBigLabel(Long arg0, String arg1, Long arg2);

	ResultCode<List<LabelRelatedVo>> getRelatedBigLabelList(Long arg0, String arg1, Long arg2, int arg3, int arg4);

	ResultCode<Integer> getRelatedBigLabelCount(Long arg0, String arg1);

	ResultCode<List<Long>> getRelatedBeBigLabelList(String arg0, Long arg1, int arg2, int arg3);

	ResultCode<String> collectBigLabel(Long arg0, Long arg1);

	ResultCode<String> collectBigLabel(List<Long> arg0, Long arg1);

	ResultCode<String> cancelCollectBigLabel(Long arg0, Long arg1);

	ResultCode<TreasureVo> getCollectBigLabel(Long arg0, Long arg1);

	ResultCode<List<Long>> getCollectBigLabel(Long arg0, int arg1, int arg2);

	ResultCode<List<TreasureVo>> getBigLabelTreasureList(Long arg0, int arg1, int arg2);

	ResultCode<List<CommentVo>> getLabelCommentList(Long arg0, String arg1, int arg2, int arg3);

	ResultCode<List> getContributeFansList(Long arg0, Timestamp arg1, Timestamp arg2, int arg3, int arg4);

	ResultCode<List<BigLabelVo>> getRecommendBigLabelList(String arg0, Long arg1, Long arg2, int arg3, int arg4);

	ResultCode<VoMap<String, Integer>> getUnreadBigLabelNumVoMap(List<String> arg0);

	ResultCode cleanUnReadBigLabelNum(String arg0, Integer arg1);

	ResultCode<Integer> addLabelByMovie(List<Long> arg0);

	ResultCode<Integer> getRelatedCommentCount(Long arg0);

	ResultCode<VoMap<Long, Integer>> getCollectBigLabelVoMapByMemberid(Long arg0, int arg1, int arg2);

	ResultCode updateUnReadBigLabelByMemberid(Long arg0, Long arg1, Integer arg2, String arg3, String arg4);
}
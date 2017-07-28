/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.friend;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;
import java.util.List;

public interface AttentionUntransApiService {
	ResultCode addAttention(Long arg0, Long arg1);

	ResultCode cancelAttention(Long arg0, Long arg1);

	ResultCode<VoMap<String, Integer>> getUserAttentionTotalVoMap(Long arg0);

	ResultCode<Boolean> hasAttention(Long arg0, Long arg1);

	ResultCode<List> getUserAttention(Long arg0, int arg1, int arg2);

	ResultCode<List> getUserBeAttention(Long arg0, int arg1, int arg2);

	ResultCode<VoMap<Long, String>> relationShipVoMap(Long arg0, List<Long> arg1);

	ResultCode<Boolean> hasBeAttention(Long arg0, Long arg1);

	ResultCode<String> relationShip(Long arg0, Long arg1);

	ResultCode<List<Long>> getMemberTagCommentList(Long arg0);

	ResultCode addAttentions(Long arg0, List<Long> arg1);

	ResultCode addBlackForUser(Long arg0, Long arg1);

	ResultCode cancelBlackForUser(Long arg0, Long arg1);

	ResultCode<Boolean> checkIsBlackUser(Long arg0, Long arg1);

	ResultCode<List<Long>> getBlackUserByMemberid(Long arg0);
}
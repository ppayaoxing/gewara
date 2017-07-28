/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.guess;

import com.gewara.api.sns.vo.guess.BettingOptionCountVo;
import com.gewara.api.sns.vo.guess.BettingOptionVo;
import com.gewara.api.sns.vo.guess.GuessSetupVo;
import com.gewara.api.sns.vo.guess.UserBettingVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;
import java.util.List;

public interface GuessApiService {
	ResultCode<GuessSetupVo> getGuessById(Long arg0);

	ResultCode<List<BettingOptionVo>> getBettingOptionsByRelatedId(Long arg0);

	ResultCode<BettingOptionVo> getBettingOptionById(Long arg0);

	ResultCode<UserBettingVo> getUserBetting(Long arg0, Long arg1);

	ResultCode<Integer> getBettingCount(Long arg0);

	ResultCode<List<Long>> getUserIdBetting(Long arg0, int arg1, int arg2);

	ResultCode<BettingOptionCountVo> getBettingOptionCount(Long arg0);

	ResultCode<VoMap<Long, Integer>> getVoMapCount(Long arg0);

	ResultCode saveUserBetting(Long arg0, Long arg1, Long arg2, Integer arg3, Integer arg4);

	ResultCode rollBackUserBetting(Long arg0, Long arg1, Long arg2, Integer arg3, Integer arg4);
}
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api.member;

import com.gewara.api.vo.ResultCode;

public interface GuessRewardsVoService {
	ResultCode<String> assignGuessRewards(Long arg0, Integer arg1, String arg2, String arg3);
}
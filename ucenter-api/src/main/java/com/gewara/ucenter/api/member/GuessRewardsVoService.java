package com.gewara.ucenter.api.member;

import com.gewara.api.vo.ResultCode;

public interface GuessRewardsVoService {
	/**
	 * 猜票房送积分接口
	 * @param memberid
	 * @param pointvalue
	 * @param tag
	 * @param reason
	 * @return
	 */
	ResultCode<String> assignGuessRewards(Long memberid, Integer pointvalue, String tag, String reason);

}

/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.bbs;

import com.gewara.api.sns.vo.bbs.AccusationVo;
import com.gewara.api.sns.vo.bbs.BlackMemberVo;
import com.gewara.api.vo.ResultCode;
import java.util.List;

public interface BlogApiService {
	ResultCode<List<BlackMemberVo>> getBlackMemberList(Long arg0, int arg1, int arg2);

	ResultCode<Boolean> isBlackMember(Long arg0);

	ResultCode<Integer> getBlackMemberCount();

	ResultCode<Integer> getAccusationCount();

	ResultCode<List<AccusationVo>> getAccusationList(int arg0, int arg1);

	ResultCode<Integer> getBlackMemberCount(Long arg0);

	ResultCode<BlackMemberVo> saveBlackMember(BlackMemberVo arg0);

	ResultCode removeBlackMember(Long arg0);

	ResultCode<AccusationVo> saveAccusation(AccusationVo arg0);

	ResultCode<AccusationVo> getAccusation(Long arg0);

	ResultCode removeAccusation(Long arg0);
}
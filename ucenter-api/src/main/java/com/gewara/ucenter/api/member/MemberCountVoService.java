/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api.member;

import com.gewara.api.vo.ResultCode;
import java.util.List;
import java.util.Map;

public interface MemberCountVoService {
	ResultCode<List<Long>> getMemberOrderCinemaIdList(Long arg0, int arg1);

	ResultCode<List<Long>> getMemberOrderNotCancelCinemaIdList(Long arg0, int arg1);

	ResultCode<List<Long>> getMemberOrderMovieIdList(Long arg0, int arg1);

	ResultCode<List<String>> getMemberOrderMovieEffectList(Long arg0, Long arg1, int arg2);

	ResultCode<List<Map>> getMemberOrderMovieMapList(Long arg0, Long arg1, int arg2);

	ResultCode<Long> getMemberOrderList(Long arg0, Integer arg1);
}
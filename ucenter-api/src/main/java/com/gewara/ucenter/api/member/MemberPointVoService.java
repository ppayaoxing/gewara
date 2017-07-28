/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api.member;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.MemberPointVo;
import java.sql.Timestamp;
import java.util.List;

public interface MemberPointVoService {
	ResultCode<MemberPointVo> getWapPointType(String arg0, String arg1);

	ResultCode<List<MemberPointVo>> getLuckPoint(Integer arg0);

	ResultCode<List<MemberPointVo>> getMyPointList(String arg0, String arg1, Integer arg2, Integer arg3, Integer arg4);

	ResultCode<String> checkSharePointByWeixin(String arg0, String arg1, String arg2);

	ResultCode<MemberPointVo> getDayPoint(String arg0, String arg1, String arg2);

	ResultCode<Integer> getOrderPointByMemberIdAndTradeNo(Long arg0, String arg1);

	ResultCode getPointGiftByDay(Long arg0, Timestamp arg1);

	ResultCode<Integer> addLoginPointNew(Long arg0);

	ResultCode<Integer> getAnswerPoint(Long arg0, Timestamp arg1);

	ResultCode<String> reducePoint(Long arg0, Integer arg1, String arg2, String arg3);

	ResultCode<String> addPoint(Long arg0, Integer arg1, String arg2, String arg3);
}
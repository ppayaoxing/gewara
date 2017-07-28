/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.frontend.ourplay;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.json.ourplay.ApplyVo;
import com.gewara.movie.vo.json.ourplay.CompensateLogVo;
import com.gewara.movie.vo.json.ourplay.MemberPraiseVo;

public interface OurPlayFVoService {
	ResultCode<ApplyVo> saveApplyVo(ApplyVo arg0, String arg1);

	ResultCode<ApplyVo> saveApplyFriendVo(ApplyVo arg0);

	ResultCode<CompensateLogVo> saveCompensateLogVo(CompensateLogVo arg0);

	ResultCode<MemberPraiseVo> saveMemberPraiseWalaOrStatusById(MemberPraiseVo arg0);

	ResultCode<Integer> addApplyNumByActivityId(String arg0);
}
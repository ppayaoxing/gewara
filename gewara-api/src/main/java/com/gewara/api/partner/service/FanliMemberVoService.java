/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.service;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.partner.FanliMemberVo;

public interface FanliMemberVoService {
	ResultCode<FanliMemberVo> getFanliMemberById(Long arg0);

	ResultCode<Boolean> updateFanliMember(FanliMemberVo arg0);
}
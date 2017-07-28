/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.dubbo;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.schedule.PrivilegeMemberVo;

public interface PrivilegeMemberVoService {
	ResultCode<PrivilegeMemberVo> checkPrivilegeMember(String arg0, String arg1, Long arg2);

	ResultCode<PrivilegeMemberVo> getPrivilegeMemberById(Long arg0);

	ResultCode<PrivilegeMemberVo> getPrivilegeMemberByMobile(String arg0);

	ResultCode<PrivilegeMemberVo> getPrivilegeMemberByMemberid(Long arg0);
}
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.drama;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.schedule.PrivilegeMemberVo;
import java.util.List;

public interface PrivilegeMemberAdminVoService {
	ResultCode<List<PrivilegeMemberVo>> importPrivilegeMember(RequestParamVo arg0);

	ResultCode<PrivilegeMemberVo> savePrivilegeMember(RequestParamVo arg0);

	ResultCode<List<PrivilegeMemberVo>> getPrivilegeMemberList(RequestParamVo arg0);
}
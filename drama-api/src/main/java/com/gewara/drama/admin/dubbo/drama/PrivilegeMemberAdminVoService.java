package com.gewara.drama.admin.dubbo.drama;

import java.util.List;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.schedule.PrivilegeMemberVo;

public interface PrivilegeMemberAdminVoService {

	ResultCode<List<PrivilegeMemberVo>> importPrivilegeMember(RequestParamVo paramsVo);
	
	ResultCode<PrivilegeMemberVo> savePrivilegeMember(RequestParamVo paramsVo);
	
	ResultCode<List<PrivilegeMemberVo>> getPrivilegeMemberList(RequestParamVo requestParamVo);
}

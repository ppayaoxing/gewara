package com.gewara.drama.dubbo;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.schedule.PrivilegeMemberVo;

public interface PrivilegeMemberVoService {

	ResultCode<PrivilegeMemberVo>  checkPrivilegeMember(String mobile,String checkpass,Long memberId);
	
	ResultCode<PrivilegeMemberVo> getPrivilegeMemberById(Long id);
	
	ResultCode<PrivilegeMemberVo> getPrivilegeMemberByMobile(String mobile);
	
	ResultCode<PrivilegeMemberVo> getPrivilegeMemberByMemberid(Long memberid);
}

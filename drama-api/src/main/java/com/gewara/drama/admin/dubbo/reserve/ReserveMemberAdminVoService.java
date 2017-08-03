package com.gewara.drama.admin.dubbo.reserve;

import java.util.List;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.ReserveMemberVo;

public interface ReserveMemberAdminVoService {
	
	ResultCode<ReserveMemberVo> getReserveMember(Long id);
	
	ResultCode<List<ReserveMemberVo>> getReserveMemberList(RequestParamVo paramVo);
	
	ResultCode<ReserveMemberVo> saveOrUpdateReserveMember(RequestParamVo paramVo);
	
	ResultCode<List<ReserveMemberVo>> getReserveMemberList(Long dramaid, Long memberid);

}

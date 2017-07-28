/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.reserve;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.ReserveMemberVo;
import java.util.List;

public interface ReserveMemberAdminVoService {
	ResultCode<ReserveMemberVo> getReserveMember(Long arg0);

	ResultCode<List<ReserveMemberVo>> getReserveMemberList(RequestParamVo arg0);

	ResultCode<ReserveMemberVo> saveOrUpdateReserveMember(RequestParamVo arg0);

	ResultCode<List<ReserveMemberVo>> getReserveMemberList(Long arg0, Long arg1);
}
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.reserve;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.ReserveMemberDetailVo;
import java.util.List;

public interface ReserveMemberDetailAdminVoService {
	ResultCode<ReserveMemberDetailVo> saveReserveMemberDetail(RequestParamVo arg0);

	ResultCode<List<ReserveMemberDetailVo>> getDetailByReserveMemberId(Long arg0);

	ResultCode<List<ReserveMemberDetailVo>> getDetailByReserveMemberId(Long arg0, Long arg1);

	ResultCode<ReserveMemberDetailVo> getDetailById(Long arg0);
}
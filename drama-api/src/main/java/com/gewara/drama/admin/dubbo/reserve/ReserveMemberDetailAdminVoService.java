package com.gewara.drama.admin.dubbo.reserve;

import java.util.List;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.ReserveMemberDetailVo;


public interface ReserveMemberDetailAdminVoService {
	
	ResultCode<ReserveMemberDetailVo> saveReserveMemberDetail(RequestParamVo paramVo);
	
	ResultCode<List<ReserveMemberDetailVo>> getDetailByReserveMemberId(Long reserveMemberId);

	ResultCode<List<ReserveMemberDetailVo>> getDetailByReserveMemberId(Long reserveMemberId,Long priceId);
	
	ResultCode<ReserveMemberDetailVo> getDetailById(Long id);

}

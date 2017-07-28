/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.dubbo;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.ReserveMatcherVo;
import com.gewara.drama.vo.ReserveMemberVo;
import com.gewara.drama.vo.ReserveOrderVo;
import com.gewara.drama.vo.partner.req.CheckReserveOrderReqVo;
import com.gewara.drama.vo.partner.req.QueryReserveOrderReqVo;
import com.gewara.drama.vo.partner.req.ReserveOrderReqVo;
import java.util.Date;
import java.util.List;

public interface ReserveOrderVoService {
	ResultCode<ReserveOrderVo> addReserveOrder(ReserveOrderReqVo arg0);

	ResultCode<List<ReserveMatcherVo>> getReserveMatcherList(Long arg0, Date arg1);

	ResultCode<List<Date>> getTreatedReserveMatcherDateList(Long arg0);

	ResultCode<List<Date>> getTreatedReserveMatcherAndMemberDateList(Long arg0, Long arg1);

	ResultCode<Boolean> checkReserveRlimitnum(CheckReserveOrderReqVo arg0);

	ResultCode<List<ReserveOrderVo>> getReserveOrderList(QueryReserveOrderReqVo arg0);

	ResultCode<ReserveOrderVo> getReserveOrder(Long arg0);

	ResultCode<ReserveMemberVo> getReserveMember(Long arg0, Long arg1, Date arg2);

	ResultCode<List<ReserveMatcherVo>> getReserveMatcherList(Long arg0, Date arg1, Long arg2);
}
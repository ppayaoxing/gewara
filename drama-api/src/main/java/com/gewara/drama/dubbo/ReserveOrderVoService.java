package com.gewara.drama.dubbo;

import java.util.Date;
import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.ReserveMatcherVo;
import com.gewara.drama.vo.ReserveMemberVo;
import com.gewara.drama.vo.ReserveOrderVo;
import com.gewara.drama.vo.partner.req.CheckReserveOrderReqVo;
import com.gewara.drama.vo.partner.req.QueryReserveOrderReqVo;
import com.gewara.drama.vo.partner.req.ReserveOrderReqVo;

public interface ReserveOrderVoService {
	
	ResultCode<ReserveOrderVo> addReserveOrder(ReserveOrderReqVo reqVo);
	
	ResultCode<List<ReserveMatcherVo>> getReserveMatcherList(Long dramaid, Date reservedate);
	
	ResultCode<List<Date>> getTreatedReserveMatcherDateList(Long dramaid);
	
	ResultCode<List<Date>> getTreatedReserveMatcherAndMemberDateList(Long dramaid, Long memberid);
	
	ResultCode<Boolean> checkReserveRlimitnum(CheckReserveOrderReqVo reqVo);
	
	ResultCode<List<ReserveOrderVo>> getReserveOrderList(QueryReserveOrderReqVo reqVo);
	
	ResultCode<ReserveOrderVo> getReserveOrder(Long reserveOrderid);
	
	ResultCode<ReserveMemberVo> getReserveMember(Long dramaid, Long memberid, Date reservedate);
	
	ResultCode<List<ReserveMatcherVo>> getReserveMatcherList(Long dramaid, Date reservedate, Long memberid);
}

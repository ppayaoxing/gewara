package com.gewara.drama.dubbo;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.ReserveMemberVo;

public interface ReserveMemberVoService {
	
	ResultCode<List<ReserveMemberVo>> getReserveMemberList(Long dramaid, Long memberid);

}

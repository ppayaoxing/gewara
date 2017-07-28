/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.dubbo;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.ReserveMemberVo;
import java.util.List;

public interface ReserveMemberVoService {
	ResultCode<List<ReserveMemberVo>> getReserveMemberList(Long arg0, Long arg1);
}
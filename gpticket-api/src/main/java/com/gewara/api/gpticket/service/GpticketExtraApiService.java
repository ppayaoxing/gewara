package com.gewara.api.gpticket.service;

import java.util.List;
import java.util.Map;

import com.gewara.api.gpticket.vo.command.ReserveVo;
import com.gewara.api.vo.ResultCode;

public interface GpticketExtraApiService {
	
	ResultCode<List> syncFailOrderUuid();
	
	ResultCode<Boolean> removeFailOrderUuid();
	
	ResultCode notifyReserve(ReserveVo reserveVo);
	
	ResultCode<Map> checkTicket(String UUID);
	
	ResultCode<Map> queryQueueNums(String uuid, String openid);
}

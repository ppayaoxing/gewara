/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.order;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.ZeroGrabRosterVo;
import com.gewara.drama.vo.ZeroGrabTicketVo;
import com.gewara.drama.vo.ZgCounterVo;
import com.gewara.drama.vo.req.common.ZeroGrabReqVo;
import java.sql.Timestamp;
import java.util.List;

public interface ZeroGrabTicketAdminVoService {
	ResultCode<ZeroGrabTicketVo> getZeroGrabTicketById(Long arg0);

	ResultCode<ZeroGrabTicketVo> saveZeroGrabTicket(RequestParamVo arg0);

	ResultCode delZeroGrabTicket(Long arg0);

	ResultCode<List<ZeroGrabTicketVo>> getZeroGrabTicketList(String arg0, Timestamp arg1, Timestamp arg2, int arg3,
			int arg4);

	ResultCode<List<ZeroGrabRosterVo>> getZeroGrabRosterList(Long arg0, String arg1, String arg2);

	ResultCode<List<ZeroGrabRosterVo>> getZeroGrabRosterPageList(ZeroGrabReqVo arg0);

	ResultCode<ZeroGrabRosterVo> getZeroGrabRoster(Long arg0);

	ResultCode<List<ZgCounterVo>> getZgCounterList(Long... arg0);

	ResultCode<ZgCounterVo> getZgCounter(Long arg0);

	ResultCode<ZgCounterVo> saveZgCounter(RequestParamVo arg0);
}
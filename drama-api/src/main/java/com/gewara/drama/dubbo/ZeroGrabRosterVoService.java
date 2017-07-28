/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.dubbo;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.ZeroGrabRosterVo;
import com.gewara.drama.vo.ZeroGrabTicketVo;
import com.gewara.drama.vo.ZgCounterVo;
import com.gewara.drama.vo.cmd.GrabRosterParamsVo;
import java.util.List;

public interface ZeroGrabRosterVoService {
	ResultCode<ZeroGrabRosterVo> addPartnerZeroGrabRoster(GrabRosterParamsVo arg0);

	ResultCode<ZeroGrabRosterVo> addZeroGrabRoster(GrabRosterParamsVo arg0);

	ResultCode<Boolean> validZeroGrabTicket(Long arg0, Long arg1, String arg2);

	ResultCode<ZeroGrabTicketVo> getZeroGrabTicketByFlag(String arg0);

	ResultCode<List<ZeroGrabTicketVo>> getZeroGrabTicketListByFlag(String... arg0);

	ResultCode<ZgCounterVo> getZgCounterByPriceid(Long arg0);

	ResultCode<List<ZgCounterVo>> getZgCounterListByPriceid(Long... arg0);
}
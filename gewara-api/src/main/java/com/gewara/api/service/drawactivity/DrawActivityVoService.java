/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.drawactivity;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.cmd.order.ParamsVo;
import com.gewara.api.vo.draw.DrawActivityVo;
import com.gewara.api.vo.draw.PrizeVo;
import com.gewara.api.vo.draw.WinnerInfoVo;
import java.util.List;
import java.util.Map;

public interface DrawActivityVoService {
	ResultCode<List<DrawActivityVo>> getDrawActivityList(ParamsVo arg0);

	ResultCode<List<WinnerInfoVo>> getWinnerList(ParamsVo arg0);

	ResultCode<Integer> getWinnerCount(ParamsVo arg0);

	ResultCode<List<PrizeVo>> getPrizeByList(List<Long> arg0);

	ResultCode<DrawActivityVo> getDrawActivityById(Long arg0);

	ResultCode<Integer> getCurChanceNum(Long arg0, Long arg1);

	ResultCode<Integer> getInviteMemberCount(ParamsVo arg0);

	ResultCode<String> clickDrawByRelated(Long arg0, String arg1, String arg2, String arg3, Long arg4, String arg5);

	ResultCode<String> clickDraw(Long arg0, String arg1, String arg2, String arg3, String arg4, String arg5,
			String arg6);

	ResultCode<String> clickDrawWithCountControl(Long arg0, String arg1, String arg2, String arg3, String arg4,
			String arg5, String arg6, boolean arg7, Integer arg8);

	ResultCode<String> clickDrawByMobile(String arg0, String arg1, String arg2, String arg3, String arg4);

	ResultCode<String> clickDrawByMobileWithTag(String arg0, String arg1, String arg2, String arg3, String arg4,
			String arg5);

	ResultCode clickDrawByOrder(String arg0, String arg1, String arg2);

	ResultCode<List<Map>> getWinnerInfoList(String arg0, String arg1, String arg2, int arg3, int arg4);

	ResultCode<PrizeVo> clickDrawByPartnerUkeyPufa(String arg0, String arg1, String arg2, String arg3);

	ResultCode<PrizeVo> clickDrawByPartnerUkey(String arg0, String arg1, String arg2, String arg3);

	ResultCode<String> givePrize2Mobile(Long arg0, Long arg1, String arg2, String arg3);

	ResultCode<String> saveDrawDeviceInfo(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5);

	ResultCode<String> bindECard(Long arg0, String arg1, String arg2, String arg3, Integer arg4);

	ResultCode<PrizeVo> addLoginPointInFestival(Long arg0, Long arg1);

	ResultCode<DrawActivityVo> getDrawActivityByTag(String arg0);

	ResultCode<String> getDrawAllowNumber(String arg0, Long arg1, String arg2);

	ResultCode<List<DrawActivityVo>> getDrawActivityListByTickettype(String arg0);
}
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.baochang;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.baochang.BaoChangBasePriceInfoVo;
import com.gewara.movie.vo.baochang.BaoChangCinemaInfoVo;
import com.gewara.movie.vo.baochang.BaoChangCinemaRoomInfoVo;
import com.gewara.movie.vo.baochang.BaoChangMpiInfoVo;
import com.gewara.movie.vo.baochang.BaoChangMsgContentVo;
import com.gewara.movie.vo.baochang.BaoChangOrderInfoReq;
import com.gewara.movie.vo.baochang.BaoChangOrderInfoVo;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BaoChangVoService {
	ResultCode<List<BaoChangCinemaInfoVo>> getBaoChangCinemaInfoList();

	ResultCode<List<BaoChangCinemaRoomInfoVo>> getBaoChangCinemaRoomListByCinemaid(Long arg0);

	ResultCode<BaoChangCinemaRoomInfoVo> getBaoChangCinemaRoomListByCinemaidAndRoomid(Long arg0, Long arg1);

	ResultCode<List<BaoChangMpiInfoVo>> getBaoChangMpiInfoListByCinemaId(Long arg0);

	ResultCode<List<BaoChangOrderInfoVo>> getBaoChangOrderInfoListByCinemaid(Long arg0);

	ResultCode<BaoChangOrderInfoVo> getBaoChangOrderInfoById(Long arg0);

	ResultCode<String> getBaoChangMsgTemplate(String arg0, String arg1);

	ResultCode<BaoChangMsgContentVo> getBaoChangMsgContentByTag(String arg0, String arg1);

	ResultCode<BaoChangBasePriceInfoVo> getBaoChangPriceInfo(Long arg0, Long arg1, Long arg2);

	ResultCode<BaoChangOrderInfoVo> createBaoChangOrderInfo(BaoChangOrderInfoReq arg0);

	ResultCode<List<BaoChangOrderInfoVo>> cancelBaoChangOrderInfo(BaoChangOrderInfoReq arg0);

	ResultCode<List<BaoChangOrderInfoVo>> refundBaoChangOrderInfo(BaoChangOrderInfoReq arg0);

	ResultCode<BaoChangMpiInfoVo> lockBaoChangMpi(Long arg0, Long arg1);

	ResultCode<BaoChangMpiInfoVo> unlockBaoChangMpi(Long arg0, Long arg1);

	ResultCode<BaoChangMpiInfoVo> setBaoChangMpiSeccuss(Long arg0, Long arg1);

	ResultCode<BaoChangOrderInfoVo> getBaoChangOrderInfoByTradeNo(String arg0);

	ResultCode<BaoChangOrderInfoVo> getBaoChangOrderInfo(String arg0, String arg1, String arg2);

	ResultCode<BaoChangOrderInfoVo> setBaoChangOrderPaidSuccess(String arg0);

	ResultCode<Map<String, String>> getBaoChangMsgMap(Map<String, String> arg0, String arg1);

	ResultCode<BaoChangOrderInfoVo> getBaoChangPaidSuccessOrderByMpid(Long arg0);

	ResultCode<BaoChangMpiInfoVo> setBaoChangMpiRefund(Long arg0, Long arg1);

	ResultCode<BaoChangOrderInfoVo> getBaoChangOrderInfoByTradeNoUseCache(String arg0);

	ResultCode<String> getEncryptInfo(Long arg0, Long arg1);

	ResultCode<Boolean> isValidEncryptInfo(String arg0, Long arg1, Long arg2);

	ResultCode unlockBaoChangRoom(Long arg0, Long arg1, Long arg2, Date arg3, String arg4, String arg5);

	ResultCode<Integer> deleteBaoChangOtherInfo(Long arg0, Long arg1, List<Map<String, String>> arg2);

	ResultCode<List<BaoChangCinemaInfoVo>> getAllAppointmentCinemaList();

	ResultCode<List<BaoChangOrderInfoVo>> getValidBaoChangOrderByMemberid(Long arg0);
}
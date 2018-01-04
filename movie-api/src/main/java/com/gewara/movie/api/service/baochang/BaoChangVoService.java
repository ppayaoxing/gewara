package com.gewara.movie.api.service.baochang;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.baochang.BaoChangBasePriceInfoVo;
import com.gewara.movie.vo.baochang.BaoChangCinemaInfoVo;
import com.gewara.movie.vo.baochang.BaoChangCinemaRoomInfoVo;
import com.gewara.movie.vo.baochang.BaoChangMpiInfoVo;
import com.gewara.movie.vo.baochang.BaoChangMsgContentVo;
import com.gewara.movie.vo.baochang.BaoChangOrderInfoReq;
import com.gewara.movie.vo.baochang.BaoChangOrderInfoVo;

public interface BaoChangVoService {
	
	/**
	 * 查询包场影院信息
	 * @return
	 */
	ResultCode<List<BaoChangCinemaInfoVo>> getBaoChangCinemaInfoList();
	/**
	 * 根据影院ID，查询该影院下面可以包场的影厅
	 * @param cinemaid
	 * @return
	 */
	ResultCode<List<BaoChangCinemaRoomInfoVo>> getBaoChangCinemaRoomListByCinemaid(Long cinemaid);
	/**
	 * 查询包场影厅信息
	 * @param cinemaid
	 * @param roomid
	 * @return
	 */
	ResultCode<BaoChangCinemaRoomInfoVo> getBaoChangCinemaRoomListByCinemaidAndRoomid(Long cinemaid, Long roomid);
	/**
	 * 根据影院ID，查询包场场次
	 * @param cinemaid
	 * @return
	 */
	ResultCode<List<BaoChangMpiInfoVo>> getBaoChangMpiInfoListByCinemaId(Long cinemaid);
	/**
	 * 根据影院id，查询包场订单信息
	 * @param cinemaid
	 * @return
	 */
	ResultCode<List<BaoChangOrderInfoVo>> getBaoChangOrderInfoListByCinemaid(Long cinemaid);
	/**
	 * 根据包场订单id，查询保单订单信息
	 * @param id
	 * @return
	 */
	ResultCode<BaoChangOrderInfoVo> getBaoChangOrderInfoById(Long id);
	/**
	 * 根据tag，查询包场短信模版
	 * @param tag
	 * @return
	 */
	ResultCode<String> getBaoChangMsgTemplate(String tag, String mobileType);
	/**
	 * 根据tag，查询包场短信模版信息
	 * @param tag
	 * @return
	 */
	ResultCode<BaoChangMsgContentVo> getBaoChangMsgContentByTag(String tag, String mobileType);
	/**
	 * 查询包场价格信息，
	 * 当mpid为空时，查询BaoChangCinemaRoomInfo（影厅价格）
	 * 不为空时，查询BaoChangMpiInfo（场次价格）
	 * @param cinemaid
	 * @param roomid
	 * @param mpid 可以为空
	 * @return
	 */
	ResultCode<BaoChangBasePriceInfoVo> getBaoChangPriceInfo(Long cinemaid, Long roomid, Long mpid);
	/**
	 * 创建包场订单信息
	 * @param req
	 * @return
	 */
	ResultCode<BaoChangOrderInfoVo> createBaoChangOrderInfo(BaoChangOrderInfoReq req);
	/**
	 * 取消包场订单信息
	 * @param req
	 * @return
	 */
	ResultCode<List<BaoChangOrderInfoVo>> cancelBaoChangOrderInfo(BaoChangOrderInfoReq req);
	/**
	 * 退款包场订单
	 * @param req
	 * @return
	 */
	ResultCode<List<BaoChangOrderInfoVo>> refundBaoChangOrderInfo(BaoChangOrderInfoReq req);
	/**
	 * 下单锁定包场场次
	 * @param cinemaid
	 * @param mpid
	 * @return
	 */
	ResultCode<BaoChangMpiInfoVo> lockBaoChangMpi(Long cinemaid, Long mpid);
	/**
	 * 取消锁定场次
	 * @param cinemaid
	 * @param mpid
	 * @return
	 */
	ResultCode<BaoChangMpiInfoVo> unlockBaoChangMpi(Long cinemaid, Long mpid);
	/**
	 * 交易成功，更新场次状态
	 * @param cinemaid
	 * @param mpid
	 * @return
	 */
	ResultCode<BaoChangMpiInfoVo> setBaoChangMpiSeccuss(Long cinemaid, Long mpid);
	/**
	 * 根据订单号查询，包场订单信息
	 * @param tradeNo
	 * @return
	 */
	ResultCode<BaoChangOrderInfoVo> getBaoChangOrderInfoByTradeNo(String tradeNo);
	/**
	 * 根据订单号查询，包场订单信息（校验订单）
	 * @param tradeNo
	 * @param memberEncode
	 * @param remoteIp
	 * @return
	 */
	ResultCode<BaoChangOrderInfoVo> getBaoChangOrderInfo(String tradeNo, String memberEncode, String remoteIp);
	/**
	 * 交易成功，设置包场信息状态
	 * @param tradeNo
	 * @return
	 */
	ResultCode<BaoChangOrderInfoVo> setBaoChangOrderPaidSuccess(String tradeNo);
	/**
	 * 查询包场人交易成功短信、push内容
	 * @return
	 */
	ResultCode<Map<String, String>> getBaoChangMsgMap(Map<String, String> dataMap, String sendType);
	/**
	 * 根据场次ID，查询支付成功订单信息
	 * @param mpid
	 * @return
	 */
	ResultCode<BaoChangOrderInfoVo> getBaoChangPaidSuccessOrderByMpid(Long mpid);
	/**
	 * 退款处理，场次状态回退为开放
	 * @param cinemaid
	 * @param mpid
	 * @return
	 */
	ResultCode<BaoChangMpiInfoVo> setBaoChangMpiRefund(Long cinemaid, Long mpid);
	/**
	 * 根据订单号查询包场订单信息，使用缓存
	 * @param tradeNo
	 * @return
	 */
	ResultCode<BaoChangOrderInfoVo> getBaoChangOrderInfoByTradeNoUseCache(String tradeNo);
	/**
	 * 取得token
	 * @param memberid
	 * @param mpid
	 * @return
	 */
	ResultCode<String> getEncryptInfo(Long memberid, Long mpid);
	/**
	 * 校验token
	 * @param encryptbc
	 * @param memberid
	 * @param mpid
	 * @return
	 */
	ResultCode<Boolean> isValidEncryptInfo(String encryptbc, Long memberid, Long mpid);
	/**
	 * 取消包场影厅、时间段
	 * @param cinemaid
	 * @param roomid
	 * @param appointmentDate
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	ResultCode unlockBaoChangRoom(Long movieid, Long cinemaid, Long roomid, Date appointmentDate, String startTime, String endTime);
	/**
	 * 退款时，删除所选座位信息和留言
	 * @param mpid
	 * @param memberid
	 * @param seatsParams
	 * @return
	 */
	ResultCode<Integer> deleteBaoChangOtherInfo(Long mpid, Long memberid, List<Map<String, String>> seatsParamsList);
	
	ResultCode<List<BaoChangCinemaInfoVo>> getAllAppointmentCinemaList();
	
	ResultCode<List<BaoChangOrderInfoVo>>  getValidBaoChangOrderByMemberid(Long memberid);

}

package com.gewara.movie.api.service.baochang;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.baochang.BaoChangMpiSeatPicVo;
import com.gewara.movie.vo.baochang.BaoChangOrderInfoVo;


public interface BaoChangMpiVoService {
	/**
	 * 根据场次id，查询场次座位的微信图片
	 * @param mpid
	 * @return
	 */
	ResultCode<List<BaoChangMpiSeatPicVo>> getBaoChangMpiSeatPicListByMpid(Long mpid);
	
	ResultCode<BaoChangOrderInfoVo> getBaoChangOrderByTradeNo(String tradeNo);
	ResultCode<List<BaoChangOrderInfoVo>> getSuccessOrderByMemberid(Long memberid);

}

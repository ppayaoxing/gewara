/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.baochang;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.baochang.BaoChangMpiSeatPicVo;
import com.gewara.movie.vo.baochang.BaoChangOrderInfoVo;
import java.util.List;

public interface BaoChangMpiVoService {
	ResultCode<List<BaoChangMpiSeatPicVo>> getBaoChangMpiSeatPicListByMpid(Long arg0);

	ResultCode<BaoChangOrderInfoVo> getBaoChangOrderByTradeNo(String arg0);

	ResultCode<List<BaoChangOrderInfoVo>> getSuccessOrderByMemberid(Long arg0);
}
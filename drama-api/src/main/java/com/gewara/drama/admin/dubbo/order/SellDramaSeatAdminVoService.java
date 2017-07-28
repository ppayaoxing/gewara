/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.order;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.SellDramaSeatVo;
import java.util.List;

public interface SellDramaSeatAdminVoService {
	ResultCode<List<SellDramaSeatVo>> getDramaOrderSeatList(Long arg0);

	ResultCode<List<SellDramaSeatVo>> getSellDramaSeatList(Long arg0, Long arg1);
}
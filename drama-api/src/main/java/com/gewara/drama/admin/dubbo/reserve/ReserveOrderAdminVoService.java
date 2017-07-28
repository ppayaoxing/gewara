/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.reserve;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.ReserveOrderVo;
import java.util.List;

public interface ReserveOrderAdminVoService {
	ResultCode<List<ReserveOrderVo>> getReserveOrderList(RequestParamVo arg0);
}
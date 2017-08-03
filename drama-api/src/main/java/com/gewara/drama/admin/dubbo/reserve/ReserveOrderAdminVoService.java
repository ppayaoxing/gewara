package com.gewara.drama.admin.dubbo.reserve;

import java.util.List;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.ReserveOrderVo;

public interface ReserveOrderAdminVoService {
	
	ResultCode<List<ReserveOrderVo>> getReserveOrderList(RequestParamVo paramVo);


}

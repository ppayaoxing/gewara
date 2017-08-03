package com.gewara.drama.dubbo;

import java.sql.Timestamp;
import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.SupplierInfoVo;

public interface SupplierInfoVoService {
	
	public ResultCode<List<SupplierInfoVo>> getSupplierInfoListByUpdateTime(Timestamp startTime, Timestamp endTime);
}

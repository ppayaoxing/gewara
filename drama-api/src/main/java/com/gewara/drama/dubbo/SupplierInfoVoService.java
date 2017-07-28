/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.dubbo;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.SupplierInfoVo;
import java.sql.Timestamp;
import java.util.List;

public interface SupplierInfoVoService {
	ResultCode<List<SupplierInfoVo>> getSupplierInfoListByUpdateTime(Timestamp arg0, Timestamp arg1);
}
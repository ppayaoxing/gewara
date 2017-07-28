/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.drama;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.SupplierInfoVo;
import java.util.List;

public interface SupplierManageVoService {
	ResultCode<List<SupplierInfoVo>> getSupplierInfoList(String arg0, String arg1);

	ResultCode<SupplierInfoVo> getSupplierInfoByCode(String arg0);

	ResultCode<List<SupplierInfoVo>> getSupplierInfoListByCodes(List<String> arg0);
}
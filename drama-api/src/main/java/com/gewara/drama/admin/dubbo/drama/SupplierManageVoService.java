package com.gewara.drama.admin.dubbo.drama;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.SupplierInfoVo;

public interface SupplierManageVoService {
	
	public ResultCode<List<SupplierInfoVo>> getSupplierInfoList(String code,String name);
	
	public ResultCode<SupplierInfoVo> getSupplierInfoByCode(String code);

	public ResultCode<List<SupplierInfoVo>> getSupplierInfoListByCodes(List<String> codeList);
}

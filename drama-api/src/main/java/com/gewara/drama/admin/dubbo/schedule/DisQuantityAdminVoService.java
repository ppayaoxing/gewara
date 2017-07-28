/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.schedule;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DisQuantityVo;
import java.util.List;

public interface DisQuantityAdminVoService {
	ResultCode<DisQuantityVo> getDisQuantityById(Long arg0);

	ResultCode<List<DisQuantityVo>> getDisQuantityList(Long arg0);

	ResultCode<DisQuantityVo> saveDisQuantity(RequestParamVo arg0);

	ResultCode<DisQuantityVo> setDiscountStatus(Long arg0, String arg1);
}
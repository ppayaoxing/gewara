package com.gewara.drama.admin.dubbo.schedule;

import java.util.List;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DisQuantityVo;

public interface DisQuantityAdminVoService {

	ResultCode<DisQuantityVo> getDisQuantityById(Long discountid);
	
	ResultCode<List<DisQuantityVo>> getDisQuantityList(Long tspid);
	
	ResultCode<DisQuantityVo> saveDisQuantity(RequestParamVo paramVo);
	
	ResultCode<DisQuantityVo> setDiscountStatus(Long discountid, String status);
	
}

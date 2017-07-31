package com.gewara.api.service.api;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.api.ApiUserBusinessVo;
import com.gewara.api.vo.api.ApiUserVo;

public interface ApiUserVoService {
	ResultCode<ApiUserVo> getApiUserVoById(Long partnerid);
	ResultCode<ApiUserVo> getApiUserVoByKey(String appkey);

	ResultCode<ApiUserBusinessVo> getApiUserBusinessById(Long id);
	
	ResultCode<List<ApiUserBusinessVo>> getApiUserBusinessByIdList(Long ... ids);
	
	ResultCode<List<ApiUserVo>> getAllOpenApiUserVo();
}

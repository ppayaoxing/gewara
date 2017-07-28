/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.api;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.api.ApiUserBusinessVo;
import com.gewara.api.vo.api.ApiUserVo;
import java.util.List;

public interface ApiUserVoService {
	ResultCode<ApiUserVo> getApiUserVoById(Long arg0);

	ResultCode<ApiUserVo> getApiUserVoByKey(String arg0);

	ResultCode<ApiUserBusinessVo> getApiUserBusinessById(Long arg0);

	ResultCode<List<ApiUserBusinessVo>> getApiUserBusinessByIdList(Long... arg0);

	ResultCode<List<ApiUserVo>> getAllOpenApiUserVo();
}
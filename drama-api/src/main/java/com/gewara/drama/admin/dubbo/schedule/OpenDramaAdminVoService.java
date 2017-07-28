/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.schedule;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.OpenDramaItemVo;

public interface OpenDramaAdminVoService {
	ResultCode removeOpenDramaItem(Long arg0);

	ResultCode<OpenDramaItemVo> updateStatus(Long arg0, String arg1, Long arg2);

	ResultCode<OpenDramaItemVo> updatePartner(Long arg0, String arg1, Long arg2);

	ResultCode<String> validOpenDramaItem(Long arg0);

	ResultCode<OpenDramaItemVo> openDpi(Long arg0);

	ResultCode<OpenDramaItemVo> updateOdi(Long arg0, RequestParamVo arg1);
}
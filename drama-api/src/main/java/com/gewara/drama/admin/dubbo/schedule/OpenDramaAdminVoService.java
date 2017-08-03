package com.gewara.drama.admin.dubbo.schedule;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.OpenDramaItemVo;


public interface OpenDramaAdminVoService {
	
	ResultCode removeOpenDramaItem(Long id);
	
	ResultCode<OpenDramaItemVo> updateStatus(Long dpid, String status, Long userid);
	
	ResultCode<OpenDramaItemVo> updatePartner(Long dpid, String partner, Long userid);
	
	ResultCode<String> validOpenDramaItem(Long dpid);
	
	ResultCode<OpenDramaItemVo> openDpi(Long dpid);
	
	ResultCode<OpenDramaItemVo> updateOdi(Long dpid, RequestParamVo paramVo);
}

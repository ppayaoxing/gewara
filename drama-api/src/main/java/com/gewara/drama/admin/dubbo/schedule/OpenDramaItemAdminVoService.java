package com.gewara.drama.admin.dubbo.schedule;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.OpenDramaItemExtVo;
import com.gewara.drama.vo.OpenDramaItemVo;

public interface OpenDramaItemAdminVoService {
	
	ResultCode<OpenDramaItemVo> getOpenDramaItemByid(Long id);
	
	ResultCode<OpenDramaItemVo> getOpenDramaItemBydpid(Long dpid);
	
	ResultCode<List<OpenDramaItemVo>> getOpenDramaItemListByDpid(Collection<Long> dpidList);
	
	ResultCode<OpenDramaItemVo> saveOpenDramaItem(RequestParamVo paramVo);
	
	ResultCode<List<OpenDramaItemVo>> getOpenDramaItemListByTheatreid(Long theatreid, Long dramaid);
	
	ResultCode<OpenDramaItemVo> updateProperties(Long dpid, String properties, Serializable... values);
	
	ResultCode<OpenDramaItemVo> saveOdiOther(RequestParamVo paramVo);
	
	ResultCode<List<OpenDramaItemVo>> getOpenDramaItemExpireListByTheatreid(Long theatreid, Long dramaid);
	
	ResultCode<OpenDramaItemExtVo> getOdiExtbyDpid(Long dpid);
	
	ResultCode<OpenDramaItemExtVo> saveOdiExt(RequestParamVo paramVo);
	
	ResultCode<List<OpenDramaItemVo>> getOpenDramaItemListByDramaid(Long dramaid);
	
}

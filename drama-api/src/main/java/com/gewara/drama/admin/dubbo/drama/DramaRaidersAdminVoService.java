package com.gewara.drama.admin.dubbo.drama;

import java.util.List;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaRaidersVo;

public interface DramaRaidersAdminVoService {
	
	ResultCode<DramaRaidersVo> getDramaRaidersById(Long id);
	
	ResultCode<List<DramaRaidersVo>> getDramaRaidersListByDramaid(Long id);
	
	ResultCode<DramaRaidersVo> saveDramaRaiders(RequestParamVo paramVo);
	
	ResultCode delDramaRaiders(Long id);


}

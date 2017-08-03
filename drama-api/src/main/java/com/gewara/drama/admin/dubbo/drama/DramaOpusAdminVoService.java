package com.gewara.drama.admin.dubbo.drama;

import java.util.List;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.cmd.DramaOpusVo;

public interface DramaOpusAdminVoService {
	
	ResultCode<DramaOpusVo> getDramaOpusById(Long id);
	
	ResultCode<List<DramaOpusVo>> getDramaOpusListByDramaid(Long id);
	
	ResultCode<DramaOpusVo> saveDramaOpus(RequestParamVo paramVo);
	
	ResultCode delDramaOpus(Long id);


}

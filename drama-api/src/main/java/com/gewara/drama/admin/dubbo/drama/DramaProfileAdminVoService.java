package com.gewara.drama.admin.dubbo.drama;

import java.util.List;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaProfileVo;

public interface DramaProfileAdminVoService {
	
	ResultCode<DramaProfileVo> getDramaProfileByDramaid(Long id);
	
	ResultCode<List<DramaProfileVo>> getDramaProfileList();
	
	ResultCode<DramaProfileVo> saveDramaProfile(RequestParamVo paramVo);
	
	ResultCode<DramaProfileVo> saveDramaMobileInfo(RequestParamVo paramVo);
}

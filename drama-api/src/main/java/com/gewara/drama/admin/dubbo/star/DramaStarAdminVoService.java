package com.gewara.drama.admin.dubbo.star;

import java.util.List;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaStarVo;

public interface DramaStarAdminVoService {
	
	ResultCode<DramaStarVo> getDramaStarById(Long id);
	
	ResultCode<List<DramaStarVo>> getDramaStarList(Long ... ids);
	
	ResultCode<List<DramaStarVo>> getStarListByStateAndName(RequestParamVo paramVo);

	ResultCode<List<DramaStarVo>> getDramaStarListByDramaid(RequestParamVo paramVo);
	
	ResultCode setStarHotValue(RequestParamVo paramVo);
	
	ResultCode<Integer> getStarCountByName(RequestParamVo paramVo);
	
	ResultCode<List<DramaStarVo>> getStarListByName(RequestParamVo paramVo);
	
	ResultCode<DramaStarVo> saveStar(RequestParamVo paramVo);
	
	ResultCode<List<DramaStarVo>> saveAttachTroupe(RequestParamVo paramVo);
	
	ResultCode<List<DramaStarVo>> getTroupeStarList();

}

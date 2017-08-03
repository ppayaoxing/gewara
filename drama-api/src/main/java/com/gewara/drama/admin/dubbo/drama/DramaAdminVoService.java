package com.gewara.drama.admin.dubbo.drama;

import java.util.Collection;
import java.util.List;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaVo;

public interface DramaAdminVoService {
	
	ResultCode saveDramaProperty(RequestParamVo paramVo);
	
	ResultCode setDramaHotValue(RequestParamVo paramVo);
	
	ResultCode delDramaProperty(RequestParamVo paramVo);
	
	ResultCode<DramaVo> saveDrama(RequestParamVo paramVo);
	
	ResultCode<DramaVo> refreshDramaOtherinfo(Long dramaid);
	
	ResultCode refreshDramaList(String status);
	
	/**
	 * 刷新项目价格
	 * @param dramaid
	 */
	ResultCode refreshDramaPrice(Long dramaid);
	
	ResultCode<List<DramaVo>> getDramaListByIdList(Collection<Long> idList);
	
	ResultCode<DramaVo> getDramaById(Long id);
	
	ResultCode<List<DramaVo>> getDramaListByName(String name);
	
	ResultCode<List<DramaVo>> getDramaListByCitycode(RequestParamVo paramVo);
	
	ResultCode<List<DramaVo>> getDramaListByPlace(Long placeid);
	
	ResultCode<List<Long>> getDramaIdListByReserve();
	
	ResultCode<DramaVo> getDramaByName(String dramaname);
	
	ResultCode<List<Long>> getDramaIdExpireListByTheatreidCache(Long theatreid);
	

}

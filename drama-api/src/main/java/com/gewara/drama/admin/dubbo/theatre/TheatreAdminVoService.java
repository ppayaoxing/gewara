package com.gewara.drama.admin.dubbo.theatre;

import java.util.Collection;
import java.util.List;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreProfileVo;
import com.gewara.drama.vo.TheatreToDramaVo;
import com.gewara.drama.vo.TheatreVo;

public interface TheatreAdminVoService {
	
	ResultCode setTheatreHotValue(RequestParamVo params);
	
	ResultCode<TheatreVo> saveOrUpdateTheatre(RequestParamVo params);
	
	ResultCode<TheatreVo> getTheatreById(Long id);
	
	ResultCode<List<TheatreVo>> getTheatreListByCitycode(RequestParamVo paramVo);
	
	ResultCode<Integer> getTheatreToDramaCountByTheatreid(Long theatreid);
	
	ResultCode<List<TheatreToDramaVo>> getTheatreToDramaListByTheatreid(RequestParamVo paramVo);
	
	ResultCode<List<TheatreVo>> getTheatreList(Collection<Long> tidList);
	
	ResultCode<TheatreProfileVo> getTheatreProfileById(Long tid);
	
	ResultCode<List<TheatreProfileVo>> getTheatreProfileList(Collection<Long> tidList);
	
	ResultCode<TheatreProfileVo> saveOrUpdateTheatreProfile(RequestParamVo params);
	
	ResultCode<List<Long>> getRermoteTheatreProfileIdList(String citycode);
	
	ResultCode<List<TheatreVo>> getTheatreListOrderByDramaNum(String citycode, int from, int maxnum);
	
	ResultCode<List<TheatreVo>> getTheatreList(String order, boolean asc, int from, int maxnum);
}

package com.gewara.drama.admin.dubbo.schedule;

import java.io.Serializable;
import java.util.List;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreToDramaVo;

public interface TheatreToDramaAdminVoService {
	
	ResultCode<TheatreToDramaVo> getTheatreToDramaById(Long id);
	
	ResultCode delTheatreToDrama(Long id);
	
	ResultCode changeSortnum(Long id, Integer sortnum);
	
	ResultCode<TheatreToDramaVo> saveTheatreToDrama(RequestParamVo paramVo);
	
	ResultCode<List<TheatreToDramaVo>> getTheatreToDramaByField(String fieldname, Serializable fieldvalue);
	
	ResultCode<List<TheatreToDramaVo>> getTheatreToDramaListByTheatreid(Long theatreid, Integer from, Integer maxnum);

}

package com.gewara.drama.admin.dubbo.schedule;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreSeatAreaVo;

public interface TheatreSeatAreaAdminVoService {
	
	ResultCode<TheatreSeatAreaVo> getTheatreSeatAreaById(Long id);
	
	ResultCode<List<TheatreSeatAreaVo>> getTheatreSeatAreaList(Long dpid);
	
	ResultCode<List<Long>> getTheatreSeatAreaIdList(Collection<Long> dpidList);
	
	ResultCode<Map<Long, List<TheatreSeatAreaVo>>> getTheatreSeatAreaMap(Collection<Long> dpidList);
	
	ResultCode<List<String>> refreshHotzone(Long dpid);
	
	ResultCode<TheatreSeatAreaVo> updateTheatreSeatAreaMapStr(Long areaid);
	
	ResultCode<List<String>> batchTheatreSeatAreaMapStr();
	
	ResultCode copyAreaHotzone(Long areaid);
	
	ResultCode copyArea(Long itemid, Long areaid);
	
	ResultCode setAreaStatus(Long id, String status);
	
	ResultCode<String> setHotzone(Long dpid, String hotzone);
	
	ResultCode<List<String>> copyHotzoneByDpid(Long dpid,List<Long> dpiList);
	
	ResultCode<String> setSvgData(Long dpid, String svgData);

}

/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.schedule;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreSeatAreaVo;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface TheatreSeatAreaAdminVoService {
	ResultCode<TheatreSeatAreaVo> getTheatreSeatAreaById(Long arg0);

	ResultCode<List<TheatreSeatAreaVo>> getTheatreSeatAreaList(Long arg0);

	ResultCode<List<Long>> getTheatreSeatAreaIdList(Collection<Long> arg0);

	ResultCode<Map<Long, List<TheatreSeatAreaVo>>> getTheatreSeatAreaMap(Collection<Long> arg0);

	ResultCode<List<String>> refreshHotzone(Long arg0);

	ResultCode<TheatreSeatAreaVo> updateTheatreSeatAreaMapStr(Long arg0);

	ResultCode<List<String>> batchTheatreSeatAreaMapStr();

	ResultCode copyAreaHotzone(Long arg0);

	ResultCode copyArea(Long arg0, Long arg1);

	ResultCode setAreaStatus(Long arg0, String arg1);

	ResultCode<String> setHotzone(Long arg0, String arg1);

	ResultCode<List<String>> copyHotzoneByDpid(Long arg0, List<Long> arg1);

	ResultCode<String> setSvgData(Long arg0, String arg1);
}
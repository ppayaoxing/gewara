/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.schedule;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaPlayItemVo;
import com.gewara.drama.vo.TheatreVo;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DramaPlayItemAdminVoService {
	ResultCode<DramaPlayItemVo> getDramaPlayItemById(Long arg0);

	ResultCode<List<DramaPlayItemVo>> getDramaPlayItemList(Collection<Long> arg0);

	ResultCode<List<DramaPlayItemVo>> getDramaPlayItemListByTheatreid(Long arg0, Long arg1);

	ResultCode<List<DramaPlayItemVo>> getDramaPlayItemListOrderbyPlaytime(Long arg0, Timestamp arg1, String arg2);

	ResultCode<DramaPlayItemVo> saveDramaPlayItem(RequestParamVo arg0);

	ResultCode<List<Long>> saveDramaPlayItemForCopy(RequestParamVo arg0);

	ResultCode removieDramaPlayItem(Long arg0);

	ResultCode<List<TheatreVo>> getTheatreListOrderByDramaNum(String arg0, int arg1, int arg2);

	ResultCode<List<Long>> getDramaIdListByTheatreId(Long arg0);

	ResultCode<Integer> verifySeatAreaSeatLocked(Long arg0);

	ResultCode updateSeatAreaStats(Long arg0, Long arg1, List<String> arg2, boolean arg3);

	ResultCode<List<String>> saveRecord(String arg0, List<String> arg1, List<String> arg2, List<String> arg3,
			List<Map> arg4, List<Integer> arg5);

	ResultCode<DramaPlayItemVo> updateProperties(Long arg0, String arg1, Serializable... arg2);

	ResultCode<List<DramaPlayItemVo>> getUnOpenDramaPlayItemList(Long arg0, Long arg1);

	ResultCode<List<DramaPlayItemVo>> getDramaPlayItemListByDramaid(Long arg0);
}
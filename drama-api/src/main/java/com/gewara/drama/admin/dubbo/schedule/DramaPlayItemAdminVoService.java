package com.gewara.drama.admin.dubbo.schedule;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaPlayItemVo;
import com.gewara.drama.vo.TheatreVo;

public interface DramaPlayItemAdminVoService {
	
	ResultCode<DramaPlayItemVo> getDramaPlayItemById(Long dpid);
	
	ResultCode<List<DramaPlayItemVo>> getDramaPlayItemList(Collection<Long> dpidList);
	
	ResultCode<List<DramaPlayItemVo>> getDramaPlayItemListByTheatreid(Long theatreid, Long dramaid);
	
	ResultCode<List<DramaPlayItemVo>> getDramaPlayItemListOrderbyPlaytime(Long theatreid, Timestamp endtime, String status);
	
	ResultCode<DramaPlayItemVo> saveDramaPlayItem(RequestParamVo paramVo);
	
	ResultCode<List<Long>> saveDramaPlayItemForCopy(RequestParamVo paramVo);
	
	ResultCode removieDramaPlayItem(Long dpid);
	
	ResultCode<List<TheatreVo>> getTheatreListOrderByDramaNum(String citycode, int from, int maxnum);
	
	ResultCode<List<Long>> getDramaIdListByTheatreId(Long theatreid);
	
	ResultCode<Integer> verifySeatAreaSeatLocked(Long areaid);
	
	ResultCode updateSeatAreaStats(Long dpid, Long seatArea, List<String> remoteLockList, boolean isFinished);
	
	ResultCode<List<String>> saveRecord(String citycode, List<String> dramaNameList, List<String> theatreNameList, List<String> dramaStarNameList,
			List<Map> playItemList, List<Integer> rowNumberList);
	
	ResultCode<DramaPlayItemVo> updateProperties(Long id, String properties, Serializable... values);
	
	ResultCode<List<DramaPlayItemVo>> getUnOpenDramaPlayItemList(Long theatreid, Long dramaid);
	
	ResultCode<List<DramaPlayItemVo>> getDramaPlayItemListByDramaid(Long dramaid);
	
}

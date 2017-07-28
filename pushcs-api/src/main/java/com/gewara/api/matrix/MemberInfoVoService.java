/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.matrix;

import com.gewara.api.vo.MemberViewHistoryVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.model.TrackVO;
import java.util.List;
import java.util.Map;

public interface MemberInfoVoService {
	ResultCode<Integer> getTrackCount(long arg0);

	ResultCode<Map<Long, Integer>> getTrackCountList(List<Long> arg0);

	ResultCode<List<TrackVO>> getTrackListByStartkey(long arg0, String arg2, Integer arg3);

	ResultCode<List<TrackVO>> getTrackDetail(long arg0);

	ResultCode<MemberViewHistoryVo> getViewHistoryByMemberid(Long arg0);

	ResultCode<MemberViewHistoryVo> getViewHistoryByMemberid(Long arg0, Long arg1, int arg2);
}
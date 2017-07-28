/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api.sns;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.sns.TreasureVo;
import java.util.List;
import java.util.Map;

public interface TreasureVoService {
	ResultCode<TreasureVo> getTreasureByTagMemberidRelatedid(String arg0, Long arg1, Long arg2, String arg3);

	ResultCode<List<Long>> getTreasureIdList(Long arg0, String arg1, String arg2, int arg3, int arg4);

	ResultCode addTreasure(Long arg0, String arg1, Long arg2, String arg3);

	ResultCode addTreasure(Long arg0, String arg1, List<Long> arg2, String arg3);

	ResultCode delTreasure(Long arg0, Long arg1);

	ResultCode delTreasureById(Long arg0);

	ResultCode<List<Long>> getTreasureCinemaidList(Long arg0);

	ResultCode<List<Long>> getTreasureIdListNoPage(Long arg0, String arg1, String arg2);

	ResultCode addCollectedtimes(Long arg0);

	ResultCode addRelatedClickedtimes(String arg0, Long arg1);

	ResultCode<Map<String, String>> getIsLikeMovieMusic(Long arg0, List<String> arg1);
}
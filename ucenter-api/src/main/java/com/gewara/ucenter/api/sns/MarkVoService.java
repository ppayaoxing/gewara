/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api.sns;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.sns.MarkChartsDataVo;
import com.gewara.ucenter.vo.sns.MarkCountDataVo;
import com.gewara.ucenter.vo.sns.MarkCountVo;
import com.gewara.ucenter.vo.sns.MemberMarkVo;
import com.gewara.ucenter.vo.sns.MovieGeneralmarkDetailVo;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface MarkVoService {
	ResultCode<Map> getMarkData(String arg0);

	ResultCode<MarkCountDataVo> getMarkCountByTagRelatedid(String arg0, Long arg1);

	ResultCode<MemberMarkVo> saveOrUpdateMemberMark(String arg0, Long arg1, String arg2, Integer arg3, Long arg4,
			String arg5);

	ResultCode<MemberMarkVo> getLastMemberMark(String arg0, Long arg1, String arg2, Long arg3);

	ResultCode<Integer> getMemberMarkCount(String arg0, Long arg1, String arg2);

	ResultCode<Integer> getMarkValueCount(String arg0, Long arg1, String arg2, int arg3, int arg4);

	ResultCode<Integer> getMarkListByMarkValue(String arg0, Long arg1, String arg2, int arg3);

	ResultCode<Integer> getMarkRanking(String arg0, Long arg1, String arg2, Long arg3);

	ResultCode<Integer> computeMarkValue(Long arg0, String arg1, MarkCountVo arg2);

	ResultCode<List<MarkChartsDataVo>> getMarkChartsData(Long arg0, Date arg1);

	ResultCode<List<MovieGeneralmarkDetailVo>> getMovieGeneralmarkDetail(Long arg0);

	ResultCode<List<Map>> getMovieGeneralmarkMap(Long arg0);

	ResultCode<Map> getGradeCount(String arg0, Long arg1);

	ResultCode<Map> getNewGradeDetail(String arg0, Long arg1);

	ResultCode<List<Long>> getOurPlayHaveScore(List<Long> arg0);
}
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.PlayKindVo;
import com.gewara.movie.vo.PlayMovieVo;
import com.gewara.movie.vo.json.ourplay.ApplyVo;
import com.gewara.movie.vo.json.ourplay.CompensateLogVo;
import com.gewara.movie.vo.json.ourplay.MemberPraiseVo;
import com.gewara.movie.vo.json.ourplay.NiuRenVo;
import com.gewara.movie.vo.json.ourplay.OurPlayConfigVo;
import com.gewara.movie.vo.json.ourplay.OurPlayMovieVo;
import com.gewara.movie.vo.json.ourplay.PlayActivityVo;
import com.gewara.movie.vo.json.ourplay.PlayMovieGradeVo;
import java.util.List;
import java.util.Map;

public interface OurPlayVoService {
	ResultCode<Integer> getPlayKindVoCount();

	ResultCode<Integer> getCompensateLogVoCount(Long arg0, String arg1);

	ResultCode<Integer> getCompensateLogVoCountByMidKindIsCompensated(Long arg0, String arg1, Integer arg2);

	ResultCode<Integer> getApplyVoCount(String arg0, String arg1);

	ResultCode<Integer> getPlayKindVoCountByIsCur(String arg0, String arg1);

	ResultCode<Integer> getPlayKindVoCountByIsRecommend(String arg0);

	ResultCode<Integer> getPlayMovieVoCountByKindIdMovieId(Long arg0, Long arg1);

	ResultCode<List<PlayKindVo>> getPlayKindVoList(Integer arg0, Integer arg1);

	ResultCode<List<PlayMovieVo>> getPlayMovieVoList(Long arg0, Integer arg1, Integer arg2);

	ResultCode<PlayKindVo> savePlayKindVo(RequestParamVo arg0);

	ResultCode<PlayMovieVo> savePlayMovieVo(RequestParamVo arg0);

	ResultCode<ApplyVo> updateIsOkOfApplyVo(RequestParamVo arg0);

	ResultCode<CompensateLogVo> updateIsCompensatedOfCompensateLogVo(RequestParamVo arg0);

	ResultCode<List<ApplyVo>> getApplyVoList(String arg0, String arg1, Integer arg2, Integer arg3);

	ResultCode<List<ApplyVo>> getApplyVoListByAidIsOkType(String arg0, String arg1, String arg2, Integer arg3,
			Integer arg4);

	ResultCode<List<CompensateLogVo>> getCompensateLogVoList(Long arg0, String arg1, Integer arg2, Integer arg3);

	ResultCode<List<CompensateLogVo>> getCompensateLogVoListByMidIsCompensatedKind(Long arg0, Integer arg1, String arg2,
			Integer arg3, Integer arg4);

	ResultCode<PlayKindVo> getPlayKindVo(Long arg0);

	ResultCode<PlayMovieVo> getPlayMovieVo(Long arg0);

	ResultCode<Map<Long, PlayMovieVo>> getPlayMovieVoList(List<Long> arg0);

	ResultCode<PlayActivityVo> getPlayActivityVo(String arg0);

	ResultCode<Boolean> delPlayKindVo(Long arg0);

	ResultCode<Boolean> delPlayMovieVo(Long arg0);

	ResultCode<List<MemberPraiseVo>> getMemberOrderMovieList(Long arg0, String arg1, Integer arg2, Integer arg3);

	ResultCode<Boolean> saveMemberPraiseByMemberid(MemberPraiseVo arg0);

	ResultCode<PlayActivityVo> getPlayActivityVoByPlayMovieId(Long arg0);

	ResultCode<PlayActivityVo> savePlayActivityVo(RequestParamVo arg0);

	ResultCode<List<PlayMovieVo>> getPlayMovieVoByMovieid(Long arg0, String arg1);

	ResultCode<List<Map<String, Object>>> getMovieIdAndKindNameByCityCode(String arg0, String arg1, Integer arg2,
			Integer arg3, String arg4);

	ResultCode<Integer> getMemberPraiseCountByMemberId(Long arg0);

	ResultCode<Integer> getCompensateLogCountVoById(Long arg0, Long arg1);

	ResultCode<PlayKindVo> getPlayKindVoByIsCur(String arg0, String arg1);

	ResultCode<Integer> getMemberPraiseCount(Long arg0, Boolean arg1, Integer arg2);

	ResultCode<OurPlayMovieVo> addOurPlayMovieVo(OurPlayMovieVo arg0);

	ResultCode<Boolean> delOurPlayMovieVo(Long arg0);

	ResultCode<Boolean> isOurPlayMovieId(Long arg0);

	ResultCode<Boolean> initOurPlayMovieVoData();

	ResultCode<Integer> getPlayMovieGradeVoCount(String arg0);

	ResultCode<List<PlayMovieGradeVo>> getPlayMovieGradeVoList(String arg0, Integer arg1, Integer arg2);

	ResultCode<PlayMovieGradeVo> addPlayMovieGradeVo(PlayMovieGradeVo arg0);

	ResultCode<List<Long>> getActivitePlayMovieIdList();

	ResultCode<Boolean> delMemberPraiseByMemberidAndMovieid(Long arg0, Long arg1);

	ResultCode<PlayMovieGradeVo> getPlayMovieGradeVoByMovieid(Long arg0);

	ResultCode<Boolean> isOurPlayApply(Long arg0, Long arg1);

	ResultCode<Boolean> isOurPlayMovie(Long arg0);

	ResultCode<Boolean> isOurPlayMovie2(Long arg0);

	ResultCode<String> setMemberidByPlayActivity(String arg0, Long arg1);

	ResultCode<String> hasRedEnvelope(String arg0, Long arg1);

	ResultCode<ApplyVo> setIsReturnPoint(RequestParamVo arg0);

	ResultCode<List<PlayMovieVo>> getPlayMovieVoListByCityCode(String arg0, Integer arg1, Integer arg2);

	ResultCode<List<PlayMovieVo>> getPlayMovieVoListForPage(String arg0, Integer arg1, Integer arg2);

	ResultCode<Integer> getApplyCount(Long arg0, String arg1);

	ResultCode<List<NiuRenVo>> getNiuRenVoList(Long arg0);

	ResultCode<List<NiuRenVo>> getNiuRenVoList(String arg0);

	ResultCode<Map<Long, Integer>> getNiuRenVoCountMap(List<Long> arg0);

	ResultCode<Map<Long, Long>> getWalaIdMap(Long arg0, List<Long> arg1);

	ResultCode<Boolean> saveNiuRen(NiuRenVo arg0);

	ResultCode<Integer> getWalaByPlayMovie(Long arg0, Long arg1);

	ResultCode<Map<String, Integer>> getNiuRenByCity(Long arg0);

	ResultCode<Map<Long, Integer>> getNiuRenRanking(List<Long> arg0);

	ResultCode<List<ApplyVo>> getApplyVoList(Long arg0);

	ResultCode<Map<Long, String>> getJoinTime(List<Long> arg0);

	ResultCode<Map<Long, Integer>> getWalaCountByMemberids(List<Long> arg0);

	ResultCode<Boolean> updateNiuRenRanking(Long arg0, Long arg1, Integer arg2);

	ResultCode<List<NiuRenVo>> getAllNiuRenList();

	ResultCode<List<NiuRenVo>> getNiuRenListByMovieId(Long arg0, Integer arg1, Integer arg2);

	ResultCode<List<PlayMovieVo>> getCurPlayMovieList(String arg0, Integer arg1, Integer arg2);

	ResultCode<List<PlayMovieVo>> getHisPlayMovieList(String arg0, Integer arg1, Integer arg2);

	ResultCode<Integer> getPlayMovieVoCountByCityCode(String arg0);

	ResultCode<OurPlayConfigVo> getOurPlayConfig(String arg0);

	ResultCode<OurPlayConfigVo> saveOurPlayConfig(String arg0, String arg1);

	ResultCode<Boolean> removeNiuRen(Long arg0, Long arg1);

	ResultCode freshNiuRenRanking();

	ResultCode addNewPlayCollectedtimes(String arg0, Long arg1, String arg2);

	ResultCode<Integer> getNewPlayCollectedtimes(Long arg0, String arg1);
}
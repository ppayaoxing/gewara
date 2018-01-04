package com.gewara.movie.api.service;

import java.util.List;
import java.util.Map;

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

public interface OurPlayVoService {
	/**
	 * 为删除状态的PlayKind条数
	 * @return
	 */
	ResultCode<Integer> getPlayKindVoCount();
	ResultCode<Integer> getCompensateLogVoCount(Long playMovieId,String kind);
	//ResultCode<Integer> getCompensateLogVoCount(Long playMovieId,String kind,Integer isCompensated);
	ResultCode<Integer> getCompensateLogVoCountByMidKindIsCompensated(Long playMovieId,String kind,Integer isCompensated);
	ResultCode<Integer> getApplyVoCount(String activityId,String isOk);
	ResultCode<Integer> getPlayKindVoCountByIsCur(String isCur,String belongToKind);
	ResultCode<Integer> getPlayKindVoCountByIsRecommend(String isRecommend);
	ResultCode<Integer> getPlayMovieVoCountByKindIdMovieId(Long kindId,Long movieId);
	/**
	 * 返回未删除状态的PlayKindVo数据
	 * @param fromIndex
	 * @param toIndex
	 * @return
	 */
	ResultCode<List<PlayKindVo>> getPlayKindVoList(Integer fromIndex,Integer maxnum);
	
	ResultCode<List<PlayMovieVo>> getPlayMovieVoList(Long kindId,Integer fromIndex,Integer maxnum);
	
	ResultCode<PlayKindVo> savePlayKindVo(RequestParamVo requestParamVo);
	ResultCode<PlayMovieVo> savePlayMovieVo(RequestParamVo requestParamVo);
	ResultCode<ApplyVo> updateIsOkOfApplyVo(RequestParamVo requestParamVo);
	ResultCode<CompensateLogVo> updateIsCompensatedOfCompensateLogVo(RequestParamVo requestParamVo);
	ResultCode<List<ApplyVo>> getApplyVoList(String activityId,String isOk,Integer fromIndex,Integer maxnum);
	//ResultCode<List<ApplyVo>> getApplyVoList(String activityId,String isOk,String type,Integer fromIndex,Integer maxnum);
	ResultCode<List<ApplyVo>> getApplyVoListByAidIsOkType(String activityId,String isOk,String type,Integer fromIndex,Integer maxnum);
	ResultCode<List<CompensateLogVo>> getCompensateLogVoList(Long playMovieId,String kind,Integer fromIndex,Integer maxnum);
	//ResultCode<List<CompensateLogVo>> getCompensateLogVoList(Long playMovieId,Integer isCompensated,String kind,Integer fromIndex,Integer maxnum);	
	ResultCode<List<CompensateLogVo>> getCompensateLogVoListByMidIsCompensatedKind(Long playMovieId,Integer isCompensated,String kind,Integer fromIndex,Integer maxnum);
	
	ResultCode<PlayKindVo> getPlayKindVo(Long id);
	ResultCode<PlayMovieVo> getPlayMovieVo(Long id);
	ResultCode<Map<Long,PlayMovieVo>> getPlayMovieVoList(List<Long> idList);
	ResultCode<PlayActivityVo> getPlayActivityVo(String activityId);
	ResultCode<Boolean> delPlayKindVo(Long id);
	ResultCode<Boolean> delPlayMovieVo(Long id);
	ResultCode<List<MemberPraiseVo>> getMemberOrderMovieList(Long memberid,String citycode,Integer from ,Integer maxnum);
	ResultCode<Boolean> saveMemberPraiseByMemberid(MemberPraiseVo vo);
	ResultCode<PlayActivityVo> getPlayActivityVoByPlayMovieId(Long playMovieId);
	ResultCode<PlayActivityVo> savePlayActivityVo(RequestParamVo requestParamVo);
	ResultCode<List<PlayMovieVo>> getPlayMovieVoByMovieid(Long movieid,String citycode);
	ResultCode<List<Map<String,Object>>> getMovieIdAndKindNameByCityCode(String citycode,String isCur,Integer from ,Integer maxnum,String direction);
	ResultCode<Integer> getMemberPraiseCountByMemberId(Long memberid);
	ResultCode<Integer> getCompensateLogCountVoById(Long memberid,Long playMovieId);
	ResultCode<PlayKindVo> getPlayKindVoByIsCur(String isCur,String belongToKind);
	ResultCode<Integer> getMemberPraiseCount(Long movieid,Boolean hasWala,Integer packetstatus);
	ResultCode<OurPlayMovieVo> addOurPlayMovieVo(OurPlayMovieVo ourPlayMovieVo);
	ResultCode<Boolean> delOurPlayMovieVo(Long movieId);
	ResultCode<Boolean> isOurPlayMovieId(Long movieId);
	ResultCode<Boolean> initOurPlayMovieVoData();
	ResultCode<Integer> getPlayMovieGradeVoCount(String status);
	ResultCode<List<PlayMovieGradeVo>> getPlayMovieGradeVoList(String status,Integer from ,Integer maxnum);
	ResultCode<PlayMovieGradeVo> addPlayMovieGradeVo(PlayMovieGradeVo playMovieGradeVo);
	ResultCode<List<Long>> getActivitePlayMovieIdList();
	ResultCode<Boolean> delMemberPraiseByMemberidAndMovieid(Long memberid,Long movieid);
	ResultCode<PlayMovieGradeVo> getPlayMovieGradeVoByMovieid(Long movieid);
	ResultCode<Boolean> isOurPlayApply(Long memberId,Long movieId);
	ResultCode<Boolean> isOurPlayMovie(Long movieId);
	ResultCode<Boolean> isOurPlayMovie2(Long movieId);//带影展的判断
	/** 
	 * 新放映中同步未绑定的账号和红包
	 * @author 彭迪
	 * @param activityId 试片活动的id
	 * @param playMovieId 试片活动的电影
	 * @return SUCCESS表示成功 
	 */
	ResultCode<String> setMemberidByPlayActivity(String activityId,Long playMovieId);
	/**
	 * 是否有红包
	 */
	ResultCode<String> hasRedEnvelope(String movieid,Long memberid);
	ResultCode<ApplyVo> setIsReturnPoint(RequestParamVo createRequestParamVo);
	
	//新放映新增版本
	ResultCode<List<PlayMovieVo>> getPlayMovieVoListByCityCode(String cityCode, Integer fromIndex, Integer maxnum);
	ResultCode<List<PlayMovieVo>> getPlayMovieVoListForPage(String cityCode, Integer fromIndex, Integer maxnum);
	ResultCode<Integer> getApplyCount(Long movieid,String tag);	
	ResultCode<List<NiuRenVo>> getNiuRenVoList(Long movieid);//按照电影id查找牛人	
	ResultCode<List<NiuRenVo>> getNiuRenVoList(String activityId);//按照活动查找牛人	
	ResultCode<Map<Long,Integer>> getNiuRenVoCountMap(List<Long>memberids);//按照活动查找牛人	
	ResultCode<Map<Long,Long>> getWalaIdMap(Long movieid,List<Long>memberids);//查找试片员写的哇啦
	ResultCode<Boolean>saveNiuRen(NiuRenVo vo);	
	ResultCode<Integer> getWalaByPlayMovie(Long movieid,Long	 playMovieId);
	ResultCode<Map<String,Integer>>getNiuRenByCity(Long movieid);//按城市查询牛人分布	
	ResultCode<Map<Long,Integer>> getNiuRenRanking(List<Long>memberids);//查找牛人排名
	ResultCode<List<ApplyVo>> getApplyVoList(Long movieid);
	ResultCode<Map<Long,String>>getJoinTime(List<Long>memberids);
	ResultCode<Map<Long,Integer>>getWalaCountByMemberids(List<Long>memberids);

	ResultCode<Boolean>updateNiuRenRanking(Long movieid,Long memberid,Integer ranking);	

	
	//牛人
	ResultCode<List<NiuRenVo>> getAllNiuRenList();
	ResultCode<List<NiuRenVo>> getNiuRenListByMovieId(Long movieId, Integer from, Integer maxNum);
	
	ResultCode<List<PlayMovieVo>> getCurPlayMovieList(String cityCode, Integer fromIndex, Integer maxnum);
	ResultCode<List<PlayMovieVo>> getHisPlayMovieList(String cityCode, Integer fromIndex, Integer maxnum);
	ResultCode<Integer> getPlayMovieVoCountByCityCode(String cityCode);
	
	ResultCode<OurPlayConfigVo> getOurPlayConfig(String tag);
	ResultCode<OurPlayConfigVo> saveOurPlayConfig(String tag, String context);
	ResultCode<Boolean> removeNiuRen(Long movieid, Long memberid);
	
	ResultCode freshNiuRenRanking();
	ResultCode addNewPlayCollectedtimes(String tag, Long playMovieId, String citycode);
	ResultCode<Integer> getNewPlayCollectedtimes(Long playMovieId, String citycode);

}

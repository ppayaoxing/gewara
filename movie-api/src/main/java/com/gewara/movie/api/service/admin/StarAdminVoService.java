/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.admin;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.star.CastBaseRelationVo;
import com.gewara.movie.vo.star.CastPictureVo;
import com.gewara.movie.vo.star.CastProfileVo;
import com.gewara.movie.vo.star.CastWorksVo;
import com.gewara.movie.vo.star.GlossaryBaseInfoVo;
import com.gewara.movie.vo.star.MovieBaseRelationVo;
import com.gewara.movie.vo.star.WorksStaffVo;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface StarAdminVoService {
	ResultCode<CastProfileVo> saveCastProfileVoAndRelated(RequestParamVo arg0);

	ResultCode<CastProfileVo> removeCastProfileById(Long arg0);

	ResultCode<List<WorksStaffVo>> getWorksStaffList(String arg0, Long arg1, Long arg2, Long arg3, Boolean arg4);

	ResultCode<List<Long>> getWorksStaffIdList(String arg0, Long arg1, Long arg2, Long arg3, Boolean arg4);

	ResultCode saveWorksStaff(RequestParamVo arg0);

	ResultCode removeProfileAffiliated(List<Long> arg0);

	ResultCode<List<CastProfileVo>> getCastProfileListByIdList(List<Long> arg0);

	ResultCode<List<CastProfileVo>> getCastProfileListFromMtime();

	ResultCode<List<CastProfileVo>> getCastProfileListByMtimeID(String arg0);

	ResultCode<List<CastWorksVo>> getCastWorksVoList(Long arg0, Long arg1, String arg2, String arg3);

	ResultCode saveCastBaseRelation(Long arg0, Long arg1, String arg2);

	ResultCode<List<CastBaseRelationVo>> getBaseRelationList(Long arg0, Long arg1, String arg2);

	ResultCode<List<GlossaryBaseInfoVo>> getGlossaryBaseInfoList(String arg0, String arg1);

	ResultCode<List<GlossaryBaseInfoVo>> getGlossaryBaseInfoListByStarId(Long arg0, String arg1);

	ResultCode batchAddCastBaseRelation(String arg0, Long arg1, String arg2);

	ResultCode<Integer> getCastProfileCount(String arg0);

	ResultCode<List<CastProfileVo>> getCastProfileList(String arg0, int arg1, int arg2);

	ResultCode<Long> getGlossaryBaseInfoByTypeAndName(String arg0, String arg1);

	ResultCode<Integer> getGlossaryBaseInfoCount(String arg0);

	ResultCode<List<GlossaryBaseInfoVo>> getGlossaryBaseInfoListByPage(String arg0, int arg1, int arg2);

	ResultCode deleteGlossaryBaseInfo(Long arg0);

	ResultCode<List<MovieBaseRelationVo>> getMovieBaseRelation(Long arg0, String arg1);

	ResultCode<List<Map>> getMovieEditionList(Long arg0, String arg1);

	ResultCode associateMovie(String arg0);

	ResultCode associateMovieBatch(String arg0, String arg1);

	ResultCode<CastProfileVo> syncProfile(String arg0, String arg1) throws Exception;

	ResultCode syncPicture(Long arg0, Long arg1);

	ResultCode<String> getStarInfonameByCastId(Long arg0);

	ResultCode<List<String>> removeRedutantProfiles();

	ResultCode<List<CastPictureVo>> getCastPictureList(int arg0, int arg1);

	ResultCode saveOrUpdateCastPicture(RequestParamVo arg0);

	ResultCode removeCastPictureById(Long arg0);

	ResultCode<List<CastPictureVo>> getCastPictureListByCastid(Long arg0);

	ResultCode batchInsertBaseInfo(String[] arg0, String[] arg1, String[] arg2);

	ResultCode saveGlossaryBaseInfo(Long arg0, String arg1, String arg2);

	ResultCode<Map<Long, String>> getGlossaryBaseInfoByBaseInfoIdSet(Set<Long> arg0);

	ResultCode<GlossaryBaseInfoVo> getGlossaryBaseInfoById(Long arg0);

	ResultCode updateCastProfileIntro(Long arg0, String arg1);

	ResultCode<CastProfileVo> saveCastProfile(RequestParamVo arg0);
}
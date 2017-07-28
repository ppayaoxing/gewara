/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.star;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.MovieVo;
import com.gewara.movie.vo.star.CastPictureVo;
import com.gewara.movie.vo.star.CastProfileVo;
import com.gewara.movie.vo.star.GlossaryBaseInfoVo;
import com.gewara.movie.vo.star.WorksStaffVo;
import java.util.List;
import java.util.Map;

public interface StarVoService {
	ResultCode<List<WorksStaffVo>> getWorksStaffList(String arg0, Long arg1, int arg2, int arg3);

	ResultCode<List<GlossaryBaseInfoVo>> getGlossaryBaseInfoListByCastIdInfoType(Long arg0, String arg1);

	ResultCode<CastProfileVo> getCastProfileById(Long arg0);

	ResultCode<List<CastPictureVo>> getCastPictureListByRelatedid(Long arg0, int arg1, int arg2);

	ResultCode<List<GlossaryBaseInfoVo>> getPersonTypeById(Long arg0);

	ResultCode<List<MovieVo>> getMovieListByCastProfileId(Long arg0, String arg1);

	ResultCode<Long> getPersonCollectCountsById(Long arg0);

	ResultCode addPersonCollectCountsById(Long arg0, Long arg1);

	ResultCode<Map<Long, CastProfileVo>> getStardetail(List<Long> arg0);

	ResultCode<Map<Long, List<CastProfileVo>>> getStarByIdList(List<Long> arg0);

	ResultCode<List<CastPictureVo>> getCastPictureList(int arg0, int arg1);

	ResultCode<List<WorksStaffVo>> getWorksStaffListByMovieId(Long arg0);

	ResultCode saveOrUpdateCastPicture(RequestParamVo arg0);
}
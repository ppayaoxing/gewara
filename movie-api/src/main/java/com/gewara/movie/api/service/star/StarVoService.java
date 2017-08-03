package com.gewara.movie.api.service.star;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.MovieVo;
import com.gewara.movie.vo.star.CastPictureVo;
import com.gewara.movie.vo.star.CastProfileVo;
import com.gewara.movie.vo.star.GlossaryBaseInfoVo;
import com.gewara.movie.vo.star.WorksStaffVo;

/**
 * 影人相关操作dubbo
 * @author Administrator
 *
 */
public interface StarVoService {
	
	ResultCode<List<WorksStaffVo>> getWorksStaffList(String tag,Long mid,int from ,int maxnum);
	ResultCode<List<GlossaryBaseInfoVo>> getGlossaryBaseInfoListByCastIdInfoType(final Long castid, final String infotype);
	/**
	 * 根据人物ID获得人物详情
	 * @return CastProfileVo
	 */
	ResultCode<CastProfileVo> getCastProfileById(Long pid);
	ResultCode<List<CastPictureVo>> getCastPictureListByRelatedid( Long relatedid, int from, int maxnum);
	/**
	 * 根据人物对应的类型列表
	 */
	ResultCode<List<GlossaryBaseInfoVo>> getPersonTypeById(Long pid);
	
	/**
	 * 获取正在上影的电影（影人参演）
	 */
	ResultCode<List<MovieVo>> getMovieListByCastProfileId(Long pid, String citycode);
	
	/**
	 * 获取影人的喜欢数
	 */
	ResultCode<Long> getPersonCollectCountsById(Long pid);
	
	/**
	 * 操作影人的喜欢数
	 */
	ResultCode addPersonCollectCountsById(Long pid, Long num);
	/**
	 * @param staridList
	 * @return
	 */
	ResultCode<Map<Long, CastProfileVo>> getStardetail(List<Long> staridList);
	/**
	 * @param movieidList
	 * @return
	 */
	ResultCode<Map<Long,List<CastProfileVo>>> getStarByIdList(List<Long> movieidList);
	/**
	 * 获取picwidth is null影人图片列表
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<CastPictureVo>> getCastPictureList(int from, int maxnum);
	/**
	 * 通过movieid 获取WorksStaffVo列表
	 * @param workstype 作品类型
	 * @return
	 */
	ResultCode<List<WorksStaffVo>> getWorksStaffListByMovieId(Long movieId);
	/**
	 * 保存或影人图片
	 * @param paramVo
	 */
	ResultCode saveOrUpdateCastPicture(RequestParamVo paramVo);
}

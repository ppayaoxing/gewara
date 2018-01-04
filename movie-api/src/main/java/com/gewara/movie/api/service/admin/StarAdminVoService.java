package com.gewara.movie.api.service.admin;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.star.CastBaseRelationVo;
import com.gewara.movie.vo.star.CastPictureVo;
import com.gewara.movie.vo.star.CastProfileVo;
import com.gewara.movie.vo.star.CastWorksVo;
import com.gewara.movie.vo.star.GlossaryBaseInfoVo;
import com.gewara.movie.vo.star.MovieBaseRelationVo;
import com.gewara.movie.vo.star.WorksStaffVo;

public interface StarAdminVoService {
	
	ResultCode<CastProfileVo> saveCastProfileVoAndRelated(RequestParamVo paramVo);
	ResultCode<CastProfileVo> removeCastProfileById(Long castid);
	/**
	 * 根据作品类型和作品id获取WorksStaffVo列表
	 * @param workstype 作品类型
	 * @param worksid 项目ID
	 * @param castid 人物ID
	 * @param stafllrole 人物在作品中的角色
	 * @param sortbyAsc 是否按照sortby排序
	 * @return
	 */
	ResultCode<List<WorksStaffVo>> getWorksStaffList(String workstype,Long worksid,Long castid,Long stafllrole,Boolean sortbyAsc);
	
	/**
	 * 根据作品类型和作品id获取WorksStaffVo列表
	 * @param workstype 作品类型
	 * @param worksid 项目ID
	 * @param castid 人物ID
	 * @param stafllrole 人物在作品中的角色
	 * @param sortbyAsc 是否按照sortby排序
	 * @return
	 */
	ResultCode<List<Long>> getWorksStaffIdList(String workstype,Long worksid,Long castid,Long stafllrole,Boolean sortbyAsc);
	/** 
	 * 保存
	 */
	ResultCode saveWorksStaff(RequestParamVo paramVo);
	/**
	 * 根据人物id列表删除人物信息关联数据
	 * @return
	 */
	ResultCode removeProfileAffiliated(List<Long> castidList);
	/**
	 * 根据作品类型和作品id获取WorksStaffVo列表
	 * @param castidList 人物ID列表
	 * @return
	 */
	ResultCode<List<CastProfileVo>> getCastProfileListByIdList(List<Long> castidList);
	/**
	 * 时光人物汇总
	 */
	ResultCode<List<CastProfileVo>> getCastProfileListFromMtime();
	
	/**
	 * 根据时光id
	 * @param mtimeid
	 */
	ResultCode<List<CastProfileVo>> getCastProfileListByMtimeID(String mtimeid);
	/**
	 * 查询castWorks 列表
	 * @param workstype 作品类型
	 * @param worksid 项目ID
	 * @param castid 人物ID
	 * @param achievement 是否成就作品 
	 * @return
	 */
	ResultCode<List<CastWorksVo>> getCastWorksVoList(Long castid,Long worksid,String workstype,String achievement);
	/**
	 * 新增CastBaseRelation
	 * @param castid 人物ID
	 * @param baseinfoid 基本信息ID
	 * @param infotype 信息类型
	 * @return
	 */
	ResultCode saveCastBaseRelation(Long castid,Long baseinfoid,String infotype);
	/**
	 * 查询CastBaseRelation
	 * @param castid 人物ID
	 * @param baseinfoid 基本信息ID
	 * @param infotype 信息类型
	 * @return
	 */
	ResultCode<List<CastBaseRelationVo>> getBaseRelationList(Long castid,Long baseinfoid,String infotype);
	
	//avatar starService 
	
	/**
	 * 查询基础信息列表
	 * @param infotype
	 * @return
	 */
	ResultCode<List<GlossaryBaseInfoVo>> getGlossaryBaseInfoList(String infoname, String infotype);
	
	/**
	 * 根据用户类型查询基础信息列表
	 * @param starid
	 * @param infotype
	 * @return
	 */
	ResultCode<List<GlossaryBaseInfoVo>> getGlossaryBaseInfoListByStarId(Long castid, String infotype);
	/**
	 * 添加人物/类型关系表
	 * @param starTypes
	 * @param starid
	 */
	ResultCode batchAddCastBaseRelation(String starTypes, Long starid, String infotype);
	/**
	 * 查询人物列表(数量) 模糊查询
	 * @param starname
	 */
	ResultCode<Integer> getCastProfileCount(String starname);
	/**
	 * 模糊查询人物列表(分页)
	 * @param starname
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<CastProfileVo>> getCastProfileList(String starname,int from, int maxnum);
	/**
	 * 根据类型和名称查询演员基本信息
	 * @param infoname
	 * @param infotype
	 * @return
	 */
	ResultCode<Long> getGlossaryBaseInfoByTypeAndName(String infoname, String infotype);
	/**
	 * 查询基本信息数量
	 * @param infotype
	 * @return
	 */
	ResultCode<Integer> getGlossaryBaseInfoCount(String infotype);
	/**
	 * 查询基本信息翻页
	 * @param infotype
	 * @return
	 */
	ResultCode<List<GlossaryBaseInfoVo>> getGlossaryBaseInfoListByPage(String infotype, int from, int maxnum);
	/**
	 * 删除基本信息
	 * @param id
	 */
	ResultCode deleteGlossaryBaseInfo(Long id);
	/**
	 * 查询电影基本信息
	 * @param movieid
	 * @param infotype
	 * @return
	 */
	ResultCode<List<MovieBaseRelationVo>> getMovieBaseRelation(Long movieid,String infotype);
	/**
	 * 查询电影版本的Map={id:value,name:value}
	 * @param movieid
	 * @param infotype
	 * @return
	 */
	ResultCode<List<Map>> getMovieEditionList(Long movieid,String infotype);
	
	// avatar CastBatchService
	ResultCode associateMovie(String batchid);
	ResultCode associateMovieBatch(String batchid, String recordIds);
	/**
	 * 将人物信息从临时表同步到正式表
	 * @param profileTmpJson 临时表信息json
	 */
	ResultCode<CastProfileVo> syncProfile(String profileTmpJson, String batchId) throws Exception;
	/**
	 * 将人物图片从临时表同步到正式表
	 * @param castId	临时表对应的人物标识
	 * @param castIdPerm	正式表的人物标识
	 */	
	ResultCode syncPicture(Long castId, Long castIdPerm);
	/**
	 * 根据 castProfileId获取明星infoname，多个以逗号，分隔
	 * @param castId
	 */
	ResultCode<String> getStarInfonameByCastId(Long castId);
	/**
	 * 剔除冗余的人物信息、关联数据
	 * @return msgList 消息信息
	 */
	ResultCode<List<String>> removeRedutantProfiles();
	/**
	 * 获取picwidth is null影人图片列表
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<CastPictureVo>> getCastPictureList(int from, int maxnum);
	/**
	 * 保存或影人图片
	 * @param paramVo
	 */
	ResultCode saveOrUpdateCastPicture(RequestParamVo paramVo);
	/**
	 * 删除影人图片信息
	 * @param picid
	 */
	ResultCode removeCastPictureById(Long picid);
	/**
	 * 根据影人id获取影人图片列表
	 * @param castid
	 */
	ResultCode<List<CastPictureVo>> getCastPictureListByCastid(Long castid);
	/**
	 * 批量操作batchInsertBaseInfo
	 * @param state 地区
	 * @param nation 民族
	 * @param sign 星座
	 * @return
	 */
	ResultCode batchInsertBaseInfo(String[] state,String[] nation,String[] sign);
	/**
	 * @param baseinfoid
	 * @param infoname
	 * @param infotype
	 * @return
	 */
	ResultCode saveGlossaryBaseInfo(Long baseinfoid, String infoname, String infotype);
	/**
	 * @param baseInfoIdSet
	 * @return
	 */
	ResultCode<Map<Long, String>> getGlossaryBaseInfoByBaseInfoIdSet(Set<Long> baseInfoIdSet);
	/**
	 * @param baseinfoid
	 * @return
	 */
	ResultCode<GlossaryBaseInfoVo> getGlossaryBaseInfoById(Long baseinfoid);
	ResultCode updateCastProfileIntro(Long id,String mtimeid);
	ResultCode<CastProfileVo> saveCastProfile(RequestParamVo paramVo);
}

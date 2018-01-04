package com.gewara.content.api;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.content.vo.GewaCommendVo;
import com.gewara.content.vo.HeadInfoVo;

public interface GewaCommendVoService {

	ResultCode<List<Map>> getGewaCommendList(String citycode, String signname, int from, int maxnum);
	/**
	 * 查询推荐内容
	 * @param citycode城市代码
	 * @param signname 名称
	 * @param parentid 
	 * @param tag	标记
	 * @param isGtZero 是否包含0
	 * @param from	开始
	 * @param maxnum	条数
	 * @param isActivity 是否判断在有效期内 starttime>=curtime<=stoptime
	 * @return
	 */
	ResultCode<List<GewaCommendVo>> getGewaCommendListByWithActive(String citycode, String signname, Long parentid, String tag, boolean isGtZero, boolean isActivity, int from, int maxnum);
	/**
	 * 查询推荐内容
	 * @param citycode城市代码
	 * @param signname 名称
	 * @param parentid 
	 * @param tag	标记
	 * @param isGtZero 是否包含0
	 * @param from	开始
	 * @param maxnum	条数
	 * @param isActivity 是否判断在有效期内 starttime>=curtime<=stoptime
	 * @param relatedid 关联ID
	 * @return
	 */
	ResultCode<List<GewaCommendVo>> getGewaCommendListByActiveRealtedid(String citycode, String signname, Long relatedid, Long parentid, String tag, boolean isGtZero, boolean isActivity, int from, int maxnum);
	/**
	 * 查询推荐内容
	 * @param citycode
	 * @param signname
	 * @param parentid
	 * @param tag
	 * @param isGtZero
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<GewaCommendVo>> getGewaCommendListByTag(String citycode, String signname, Long parentid,String tag, boolean isGtZero, int from, int maxnum);
	ResultCode<List<Map>> getGewaCurCommendList(String citycode, String signname, int from, int maxnum);
	/**
	 * 获取所有推荐
	 * @param citycode
	 * @param signname
	 * @param parentid
	 * @param tag
	 * @param isGtZero
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<GewaCommendVo>> getAllGewaCommendList(String citycode, String signname, Long parentid, String tag, boolean isGtZero, int from, int maxnum);
	/**
	 * key=relatedid+tag value=videoCount
	 */
	ResultCode<Map<String, Integer>> getVideoCount();
	/**
	 * key=relatedid+tag value=commentCount
	 */
	ResultCode<Map<String, Integer>> getCommentCount();
	/**
	 * key=relatedid+tag value=commentCount
	 */
	ResultCode<Map<String, Integer>> getPictureCount();
	/**
	 * 获取首页套头
	 * @param gewaCity
	 * @return
	 */
	ResultCode<HeadInfoVo> getIndexHeadInfo(String citycode);
	/**
	 * 根据Id获得套头信息
	 * @param id
	 * @return
	 */
	ResultCode<HeadInfoVo> getHeadInfoById(Long id);
	/**
	 * 获得walaCommend信息
	 * @param citycode
	 * @return
	 */
	ResultCode<GewaCommendVo> getMovieWalaGewaCommend(String citycode);
}

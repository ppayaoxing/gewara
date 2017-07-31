package com.gewara.ucenter.api.sns;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.sns.MarkChartsDataVo;
import com.gewara.ucenter.vo.sns.MarkCountDataVo;
import com.gewara.ucenter.vo.sns.MarkCountVo;
import com.gewara.ucenter.vo.sns.MemberMarkVo;
import com.gewara.ucenter.vo.sns.MovieGeneralmarkDetailVo;

public interface MarkVoService {

	/**
	 * 某类评分聚合数据:TODO：注释Map中的内容
	 * @param tag
	 * @return
	 */
	ResultCode<Map> getMarkData(String tag);
	
	ResultCode<MarkCountDataVo> getMarkCountByTagRelatedid(String tag, Long relatedid);
	/**
	 * 用户评分
	 * @param tag
	 * @param relatedid
	 * @param markname
	 * @param markvalue
	 * @param memberid
	 * @return
	 */
	ResultCode<MemberMarkVo> saveOrUpdateMemberMark(String tag, Long relatedid, String markname, Integer markvalue, Long memberid, String cityCode);
	/**
	 * 用户最后一次评分记录
	 * @param tag
	 * @param relatedid
	 * @param markname
	 * @param memberId
	 * @return
	 */
	ResultCode<MemberMarkVo> getLastMemberMark(String tag, Long relatedid, String markname, Long memberId);
	/**
	 * 获得评分人数
	 * @param tag
	 * @param relatedid
	 * @param markname
	 * @return
	 */
	ResultCode<Integer> getMemberMarkCount(String tag, Long relatedid, String markname);
	ResultCode<Integer> getMarkValueCount(String tag, Long relatedid, String markname, int fromValue, int maxValue);
	ResultCode<Integer> getMarkListByMarkValue(String tag, Long relatedid, String markname, int markValue);
	ResultCode<Integer> getMarkRanking(String tag, Long relatedid, String markname, Long memberId);
	/**
	 * 计算评分
	 * @param movieId
	 * @param markname
	 * @param markCountVo
	 * @return
	 */
	ResultCode<Integer> computeMarkValue(Long movieId, String markname, MarkCountVo markCountVo);
	ResultCode<List<MarkChartsDataVo>> getMarkChartsData(Long movieId, Date statisticDate);
	/**
	 * 查询电影评分详细 
	 * @param movieId
	 * @return
	 */
	ResultCode<List<MovieGeneralmarkDetailVo>> getMovieGeneralmarkDetail(Long movieId);
	/**
	 * 查询电影评分详细 
	 * @param movieId
	 * @return
	 */
	ResultCode<List<Map>> getMovieGeneralmarkMap(Long movieId);
	
	/**
	 * 评分统计
	 * @param tag
	 * @param relatedid
	 * @return
	 */
	ResultCode<Map> getGradeCount(String tag, Long relatedid);
	/**
	 * 评分分级统计
	 * 例如：画面：5.6  、  剧情：7.2、音效、3.1、演员：6.6
	 * @param tag
	 * @param relatedid
	 * @return
	 */
	ResultCode<Map> getNewGradeDetail(String tag, Long relatedid);
	/**
	 * 获取新放映的电影是否有购票用户评分
	 * @param idList
	 * @return
	 */
	ResultCode<List<Long>>getOurPlayHaveScore(List<Long> idList);
}

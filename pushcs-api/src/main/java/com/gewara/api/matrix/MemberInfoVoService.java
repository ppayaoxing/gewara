package com.gewara.api.matrix;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.MemberViewHistoryVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.model.TrackVO;

public interface MemberInfoVoService  {
	/**
	 * 根据会员ID，查询影迹数
	 * @param memberId 会员id	 
	 */
	ResultCode<Integer> getTrackCount(long memberId);
	
	/**
	 * 根据会员ID列表，查询影迹数列表
	 * @param memberId 会员id列表。	 
	 */
	 ResultCode<Map<Long, Integer>> getTrackCountList(List<Long> memberIdList); 
	
	/**
	 * 根据会员ID和起始影迹key，查询下一页的影迹详情列表
	 * @param memberId 会员id	
	 * @param startkey 起始影迹key，默认最后一条
	 * @param pageSize 每页记录的条数，默认10条	 
	 */
	ResultCode<List<TrackVO>> getTrackListByStartkey(long memberId,String startKey,Integer pageSize);
	
	/**
	 * 根据会员ID，查询影迹详情列表（弃用）
	 * @param memberId 会员id		 
	 * 
	 */
	ResultCode<List<TrackVO>> getTrackDetail(long memberId);
	
	
	/**
	 * 根据用户id获取用户的观影记录,MemberViewInfo 按 playtime 从近到远排序
	 * 
	 * @param memberid
	 * @return
	 */
	ResultCode<MemberViewHistoryVo> getViewHistoryByMemberid(Long memberid);
	
	/**
	 * 根据用户id获取用户的观影记录,MemberViewInfo 按 playtime 从近到远排序
	 * @param memberid
	 * @param fromPlaytime
	 * @param maxnum
	 * @return
	 */
	ResultCode<MemberViewHistoryVo> getViewHistoryByMemberid(Long memberid, Long fromPlaytime, int maxnum);
}